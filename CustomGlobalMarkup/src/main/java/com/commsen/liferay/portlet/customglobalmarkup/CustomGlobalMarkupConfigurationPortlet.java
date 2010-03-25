/**
 *	This file is part of CustomGlobalMarkup Liferay plug-in.
 *	
 * CustomGlobalMarkup Liferay plug-in is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * CustomGlobalMarkup Liferay plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with CustomGlobalMarkup Liferay plug-in.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */

package com.commsen.liferay.portlet.customglobalmarkup;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;
import com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * @author Milen Dyankov
 * 
 */
public class CustomGlobalMarkupConfigurationPortlet extends GenericPortlet {

	public void init() throws PortletException {
		viewJSP = getInitParameter("view-jsp");
	}


	@Override
	protected void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		List<Markup> markups = MarkupLocalServiceUtil.getMarkups(PortalUtil.getScopeGroupId(renderRequest));
		renderRequest.setAttribute("markups", markups);
		include(viewJSP, renderRequest, renderResponse);

	}


	@ProcessAction(name = "add")
	public void addMarkup(ActionRequest request, ActionResponse response) throws SystemException {
		Markup markup = MarkupLocalServiceUtil.createMarkup(CounterLocalServiceUtil.increment(Markup.class.getName()));
		markup.setActive(false);
		markup.setCompanyId(PortalUtil.getCompanyId(request));
		markup.setGroupId(PortalUtil.getScopeGroupId(request));
		markup.setLocation(CustomGlobalMarkupLocation.BOTTOM);
		markup.setMarkup("<!-- Raplace me with your custom markup -->");
		MarkupLocalServiceUtil.updateMarkup(markup);
		redirect(request, response);
	}


	@ProcessAction(name = "save")
	public void saveMarkups(ActionRequest request, ActionResponse response) throws SystemException, PortalException {

		List<String> paramNames = Collections.list(request.getParameterNames());

		for (String key : paramNames) {
			if (key.startsWith("markup_")) {
				long id = Long.parseLong(key.substring(7));
				Markup markup = MarkupLocalServiceUtil.getMarkup(id);
				if (markup != null) {
					if (ParamUtil.getBoolean(request, "delete_" + id)) {
						MarkupLocalServiceUtil.deleteMarkup(markup);
					} else {
						boolean changed = false;
						// process text
						String markupText = ParamUtil.getString(request, key, "");
						if (!markup.getMarkup().equals(markupText)) {
							changed = true;
							markup.setMarkup(markupText);
						}
						// process status
						boolean markupStatus = ParamUtil.getBoolean(request, "active_" + id);
						if (markup.getActive() != markupStatus) {
							changed = true;
							markup.setActive(markupStatus);
						}
						// process location
						short location = ParamUtil.getShort(request, "location_" + id, (short) -1);
						if (CustomGlobalMarkupLocation.isValid(location) && markup.getLocation() != location) {
							changed = true;
							markup.setLocation(location);
						}

						// finally if there are any changes update database
						if (changed) {
							MarkupLocalServiceUtil.updateMarkup(markup);
						}
					}
				} else {
					_log.warn("Markup with id " + id + " not found!");
				}
			}
		}

		redirect(request, response);

	}


	/**
	 * @param request
	 * @param response
	 */
	private void redirect(ActionRequest request, ActionResponse response) {
		String redirectUrl = ParamUtil.getString(request, "redirect");
		if (redirectUrl != null && redirectUrl.trim().length() > 0) {
			try {
				response.sendRedirect(redirectUrl);
			} catch (IOException e) {
				_log.error("Failed to redirect to " + redirectUrl, e);
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

	protected String viewJSP;

	private static Log _log = LogFactoryUtil.getLog(CustomGlobalMarkupPortlet.class);

}
