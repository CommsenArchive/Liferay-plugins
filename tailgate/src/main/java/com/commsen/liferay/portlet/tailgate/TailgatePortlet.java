/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * <a href="JSPPortlet.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class TailgatePortlet extends GenericPortlet {

	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;

	private static final Log _log = LogFactoryUtil.getLog(TailgatePortlet.class);

	private static final String FILE_NAME = "fileName";
	private static final String LINES = "lines";
	private static final String SESSION_KEY_FILE_TAIL = FileTail.class.getName();
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

		final PortletPreferences prefs = request.getPreferences();
		prefs.setValue(FILE_NAME, filename);
		prefs.setValue(LINES, Integer.toString(lines));
		prefs.store();

		SessionMessages.add(request, "tailgate-message:config-saved");

		final FileTail fileTail = (FileTail) request.getPortletSession().getAttribute(SESSION_KEY_FILE_TAIL);
		if (fileTail != null && fileTail.getFileName().equals(new File(filename).getCanonicalPath())) {
			return;
		}

		initFileTail(request);
	}


	/*
	 * (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest,
	 * javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(final ResourceRequest request, final ResourceResponse response) throws PortletException, IOException {
		FileTail fileTail = (FileTail) request.getPortletSession().getAttribute(SESSION_KEY_FILE_TAIL);
		if (fileTail == null && initFileTail(request)) {
			fileTail = (FileTail) request.getPortletSession().getAttribute(SESSION_KEY_FILE_TAIL);
		}
		@SuppressWarnings("unchecked")
		Queue<String> lastLines = (Queue) request.getPortletSession().getAttribute(SESSION_KEY_LAST_LINES);
		if (lastLines == null) {
			lastLines = new LinkedList<String>();
			request.getPortletSession().setAttribute(SESSION_KEY_LAST_LINES, lastLines);
		}

		if (fileTail != null) {
			if (!fileTail.isRunnig()) {
				fileTail.start();
			}
			String line;
			final PrintWriter writer = response.getWriter();
			while ((line = fileTail.readLine()) != null) {
				lastLines.add(line);
				if (lastLines.size() > fileTail.getLines()) {
					lastLines.remove();
				}
				writer.println("<li>" + line + "</li>");
			}
		}
	}


	protected void include(final String path, final RenderRequest renderRequest, final RenderResponse renderResponse) throws IOException, PortletException {

		final PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}


	private boolean initFileTail(final PortletRequest request) throws IOException {
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

		final FileTail fileTail = new FileTail(new File(fileName), lines);
		request.getPortletSession().setAttribute(SESSION_KEY_FILE_TAIL, fileTail);
		return true;
	}

}