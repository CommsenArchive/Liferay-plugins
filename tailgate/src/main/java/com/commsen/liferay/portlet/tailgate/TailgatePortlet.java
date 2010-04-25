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

	private static final String SESSION_KEY_FILE_TAIL = FileTail.class.getName();
	private static final String SESSION_KEY_LAST_LINES = "com.commsen.liferay.portlet.tailgate.LINES";
	private static final int DEFAULT_NUMBER_OF_LINES = 100;


	public void init() throws PortletException {
		editJSP = getInitParameter("edit-jsp");
		helpJSP = getInitParameter("help-jsp");
		viewJSP = getInitParameter("view-jsp");
	}


	public void doDispatch(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		String jspPage = renderRequest.getParameter("jspPage");

		if (jspPage != null) {
			include(jspPage, renderRequest, renderResponse);
		} else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}


	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		if (renderRequest.getPreferences() == null) {
			super.doEdit(renderRequest, renderResponse);
		} else {
			include(editJSP, renderRequest, renderResponse);
		}
	}


	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		Queue<String> lastLines = (Queue) request.getPortletSession().getAttribute(SESSION_KEY_LAST_LINES);
		StringBuilder sb = new StringBuilder();
		if (lastLines != null) {
			for (String line : lastLines) {
				sb.append("<li>").append(line).append("</li>");
			}
		}
		request.setAttribute("lines", sb.toString());
		include(viewJSP, request, response);
	}


	@ProcessAction(name = "saveConfig")
	public void saveConfig(ActionRequest request, ActionResponse response) throws SystemException, PortletException, IOException {

		String filename = ParamUtil.getString(request, "fileName", null);
		int lines = ParamUtil.getInteger(request, "lines", 100);

		PortletPreferences prefs = request.getPreferences();
		prefs.setValue("fileName", filename);
		prefs.setValue("lines", "" + lines);
		prefs.store();

		SessionMessages.add(request, "tailgate-message:config-saved");

		FileTail fileTail = (FileTail) request.getPortletSession().getAttribute(SESSION_KEY_FILE_TAIL);
		if (fileTail != null) {
			if (fileTail.getFileName().equals(new File(filename).getCanonicalPath())) {
				return;
			}
		}

		initFileTail(request);
	}


	/*
	 * (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest,
	 * javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
		FileTail fileTail = (FileTail) request.getPortletSession().getAttribute(SESSION_KEY_FILE_TAIL);
		if (fileTail == null) {
			if (initFileTail(request)) {
				fileTail = (FileTail) request.getPortletSession().getAttribute(SESSION_KEY_FILE_TAIL);
			}
		}

		Queue<String> lastLines = (Queue) request.getPortletSession().getAttribute(SESSION_KEY_LAST_LINES);
		if (lastLines == null) {
			lastLines = new LinkedList<String>();
			request.getPortletSession().setAttribute(SESSION_KEY_LAST_LINES, lastLines);
		}

		if (fileTail != null) {
			if (!fileTail.isRunnig()) fileTail.start();
			String line;
			PrintWriter writer = response.getWriter();
			while ((line = fileTail.readLine()) != null) {
				lastLines.add(line);
				if (lastLines.size() > fileTail.getLines()) lastLines.remove();
				writer.println("<li>" + line + "</li>");
			}
		}
	}


	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}


	private boolean initFileTail(PortletRequest request) throws IOException {
		PortletPreferences prefs = request.getPreferences();
		String fileName = prefs.getValue("fileName", null);

		if (fileName == null) {
			return false;
		}

		int lines = DEFAULT_NUMBER_OF_LINES;
		try {
			lines = Integer.parseInt(prefs.getValue("lines", "" + DEFAULT_NUMBER_OF_LINES));
		} catch (NumberFormatException e) {
			return false;
		}

		FileTail fileTail = new FileTail(new File(fileName), lines);
		request.getPortletSession().setAttribute(SESSION_KEY_FILE_TAIL, fileTail);
		return true;
	}

	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;

	private static Log _log = LogFactoryUtil.getLog(TailgatePortlet.class);

}