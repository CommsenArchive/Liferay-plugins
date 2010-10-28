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
import java.util.List;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;
import com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PortalUtil;

/**
 * @author Milen Dyankov
 * 
 */
public class CustomGlobalMarkupPortlet extends GenericPortlet {

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		// get and prepare code to be added to header section
		List<Markup> topMarkups = null;
		try {
			topMarkups = MarkupLocalServiceUtil.getActiveTopMarkups(PortalUtil.getScopeGroupId(renderRequest));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (topMarkups != null && !topMarkups.isEmpty()) {
			StringBundler sb = (StringBundler) renderRequest.getAttribute(WebKeys.PAGE_TOP);
			if (sb == null) sb = new StringBundler();
			for (Markup markup : topMarkups) {
				sb.append(markup.getMarkup()).append("\n");
			}
			renderRequest.setAttribute(WebKeys.PAGE_TOP, sb);
		}

		// get and prepare code to be added to the bottom of the page
		List<Markup> bottomMarkups = null;
		try {
			bottomMarkups = MarkupLocalServiceUtil.getActiveBottomMarkups(PortalUtil.getScopeGroupId(renderRequest));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (bottomMarkups != null && !bottomMarkups.isEmpty()) {
			StringBundler sb = (StringBundler) renderRequest.getAttribute(WebKeys.PAGE_BOTTOM);
			if (sb == null) sb = new StringBundler();
			for (Markup markup : bottomMarkups) {
				sb.append(markup.getMarkup()).append("\n");
			}
			renderRequest.setAttribute(WebKeys.PAGE_BOTTOM, sb);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CustomGlobalMarkupPortlet.class);

}