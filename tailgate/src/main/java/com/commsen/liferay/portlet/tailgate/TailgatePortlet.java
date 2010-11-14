/**
 *	This file is part of Tailgate Liferay plug-in.
 *	
 * Tailgate Liferay plug-in is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Tailgate Liferay plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Tailgate Liferay plug-in.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */

package com.commsen.liferay.portlet.tailgate;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.commsen.file.monitor.FileBuffer;
import com.commsen.file.monitor.FileMonitoringEngine;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author Milen Dyankov
 * 
 */
public class TailgatePortlet extends GenericPortlet {

	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;

	private static final Log LOG = LogFactoryUtil.getLog(TailgatePortlet.class);

	private static final String FILE_NAME = "fileName";
	private static final String LINES = "lines";
	private static final String WINDOW_HEIGHT = "height";
	private static final String SESSION_KEY_FILE_BUFFER = FileBuffer.class.getName();
	private static final String SESSION_KEY_LAST_LINES = "com.commsen.liferay.portlet.tailgate.LINES";
	private static final int DEFAULT_NUMBER_OF_LINES = 100;


	public void init() throws PortletException {
		editJSP = getInitParameter("edit-jsp");
		helpJSP = getInitParameter("help-jsp");
		viewJSP = getInitParameter("view-jsp");
	}


	public void doDispatch(final RenderRequest renderRequest, final RenderResponse renderResponse) throws IOException, PortletException {

		final String jspPage = renderRequest.getParameter("jspPage");

		if (jspPage == null) {
			super.doDispatch(renderRequest, renderResponse);
		} else {
			include(jspPage, renderRequest, renderResponse);
		}
	}


	public void doEdit(final RenderRequest renderRequest, final RenderResponse renderResponse) throws IOException, PortletException {

		if (renderRequest.getPreferences() == null) {
			super.doEdit(renderRequest, renderResponse);
		} else {
			include(editJSP, renderRequest, renderResponse);
		}
	}


	public void doView(final RenderRequest request, final RenderResponse response) throws IOException, PortletException {
		@SuppressWarnings("unchecked")
		final Queue<String> lastLines = (Queue) request.getPortletSession().getAttribute(SESSION_KEY_LAST_LINES);
		final StringBuilder result = new StringBuilder();
		if (lastLines != null) {
			for (String line : lastLines) {
				result.append("<li>").append(line).append("</li>");
			}
		}
		request.setAttribute(LINES, result.toString());
		include(viewJSP, request, response);
	}


	@ProcessAction(name = "saveConfig")
	public void saveConfig(final ActionRequest request, final ActionResponse response) throws SystemException, PortletException, IOException {

		final String filename = ParamUtil.getString(request, FILE_NAME, null);
		final int lines = ParamUtil.getInteger(request, LINES, 100);
		final String height = ParamUtil.getString(request, WINDOW_HEIGHT, "300px");

		final PortletPreferences prefs = request.getPreferences();
		prefs.setValue(FILE_NAME, filename);
		prefs.setValue(LINES, Integer.toString(lines));
		prefs.setValue(WINDOW_HEIGHT, height);
		prefs.store();

		SessionMessages.add(request, "tailgate-message:config-saved");

		initFileBuffer(request);
	}


	/*
	 * (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest,
	 * javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(final ResourceRequest request, final ResourceResponse response) throws PortletException, IOException {
		FileBuffer fileBuffer = (FileBuffer) request.getPortletSession().getAttribute(SESSION_KEY_FILE_BUFFER);
		if (fileBuffer == null && initFileBuffer(request)) {
			fileBuffer = (FileBuffer) request.getPortletSession().getAttribute(SESSION_KEY_FILE_BUFFER);
		}
		@SuppressWarnings("unchecked")
		Queue<String> lastLines = (Queue) request.getPortletSession().getAttribute(SESSION_KEY_LAST_LINES);
		if (lastLines == null) {
			lastLines = new LinkedList<String>();
			request.getPortletSession().setAttribute(SESSION_KEY_LAST_LINES, lastLines);
		}

		if (fileBuffer != null) {
			if (!fileBuffer.isEnabled()) {
				fileBuffer.setEnabled(true);
			}
			String line;
			final PrintWriter writer = response.getWriter();
			while ((line = fileBuffer.readLine()) != null) {
				lastLines.add(line);
				if (lastLines.size() > fileBuffer.getMaxSize()) {
					lastLines.remove();
				}
				writer.println("<li>" + line + "</li>");
			}
		}
	}


	protected void include(final String path, final RenderRequest renderRequest, final RenderResponse renderResponse) throws IOException, PortletException {

		final PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			LOG.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}


	private boolean initFileBuffer(final PortletRequest request) throws IOException {
		final PortletPreferences prefs = request.getPreferences();
		final String fileName = prefs.getValue(FILE_NAME, null);

		if (fileName == null) {
			return false;
		}

		int lines;
		try {
			lines = Integer.parseInt(prefs.getValue(LINES, Integer.toString(DEFAULT_NUMBER_OF_LINES)));
		} catch (NumberFormatException e) {
			return false;
		}

		FileBuffer fileBuffer = (FileBuffer) request.getPortletSession().getAttribute(SESSION_KEY_FILE_BUFFER);
		if (fileBuffer != null && fileBuffer.getFileName().equals(new File(fileName).getCanonicalPath())) {
			return true;
		}

		fileBuffer = FileMonitoringEngine.newFileBuffer(fileName, lines);
		request.getPortletSession().setAttribute(SESSION_KEY_FILE_BUFFER, fileBuffer);
		return true;
	}

}