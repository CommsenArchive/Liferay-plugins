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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;
import com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.ModelHintsUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * @author Milen Dyankov
 * 
 */
public class CustomGlobalMarkupConfigurationPortlet extends GenericPortlet {

	public static final String KEY = CustomGlobalMarkupConfigurationPortlet.class.getName();


	public void init() throws PortletException {
		viewJSP = getInitParameter("view-jsp");
	}


	@SuppressWarnings("unchecked")
	@Override
	protected void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		List<Markup> markups = Collections.emptyList();
		try {
			markups = MarkupLocalServiceUtil.getMarkups(PortalUtil.getScopeGroupId(renderRequest));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PortletSession session = renderRequest.getPortletSession();
		Map<Long, Markup> inMemoryMarkups = (Map<Long, Markup>) session.getAttribute(KEY);
		if (inMemoryMarkups == null || inMemoryMarkups.isEmpty()) {
			renderRequest.setAttribute("markups", markups);
		} else {
			List<Markup> unsavedMarkups = new ArrayList<Markup>();
			for (Markup markup : markups) {
				if (inMemoryMarkups.containsKey(markup.getId())) {
					unsavedMarkups.add(inMemoryMarkups.get(markup.getId()));
				} else {
					unsavedMarkups.add(markup);
				}
			}
			renderRequest.setAttribute("markups", unsavedMarkups);
			session.removeAttribute(KEY);
		}
		include(viewJSP, renderRequest, renderResponse);

	}


	@ProcessAction(name = "add")
	public void addMarkup(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
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

		long max_markup_length = 2000;
		Map<String, String> markup_hints = ModelHintsUtil.getHints(Markup.class.getName(), "markup");
		if (markup_hints.containsKey("max-length")) {
			try {
				max_markup_length = Long.parseLong(markup_hints.get("max-length"));
			} catch (NumberFormatException e) {
				_log.warn("Failed to parse max-length!", e);
			}
		}

		for (String key : paramNames) {
			if (key.startsWith("markup_")) {
				long id = Long.parseLong(key.substring(7));
				Markup markup = MarkupLocalServiceUtil.getMarkup(id);
				if (markup != null) {
					if (ParamUtil.getBoolean(request, "delete_" + id)) {
						MarkupLocalServiceUtil.deleteMarkup(markup);
					} else {
						boolean changed = false;
						boolean error = false;
						// process text
						String markupText = ParamUtil.getString(request, key, "");
						if (markupText.length() > max_markup_length) {
							error = true;
							SessionErrors.add(request, "custom-global-markup-error-too-long-" + id);
						}
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
						if (error) {
							rememberMarkupInSession(request, markup);
						} else if (changed) {
							SessionMessages.add(request, "custom-global-markup-save-ok-" + id);
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


	@SuppressWarnings("unchecked")
	private void rememberMarkupInSession(PortletRequest request, Markup markup) {
		PortletSession session = request.getPortletSession();
		Map<Long, Markup> inMemoryMarkups = (Map<Long, Markup>) session.getAttribute(KEY);
		if (inMemoryMarkups == null) {
			inMemoryMarkups = new HashMap<Long, Markup>();
			session.setAttribute(KEY, inMemoryMarkups);
		}

		inMemoryMarkups.put(markup.getId(), markup);
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
