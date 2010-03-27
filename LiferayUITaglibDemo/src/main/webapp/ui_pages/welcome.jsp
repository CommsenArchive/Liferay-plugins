<%
/**
 *	This file is part of LiferayUITaglibDemo Liferay plug-in.
 *	
 * LiferayUITaglibDemo Liferay plug-in is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * LiferayUITaglibDemo Liferay plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with LiferayUITaglibDemo Liferay plug-in. If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */
%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>



<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.service.ThemeServiceUtil"%>
<%@page import="com.liferay.portal.service.ThemeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<% 
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
%>



<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<p>
WELCOME PAGE 
</p>



<table width="100%" border="1">
	<col width="50%">
	<col width="50%">
  <tr>
    <th>Tag</th>
    <th>Preview</th>
  </tr>


  <tr>
    <td>
    	<code><pre>
&lt;liferay-ui:user-display  
	displayStyle="2" 
	userId="&lt;%= themeDisplay.getUser().getUserId() %&gt;" 
		/&gt;
		</pre></code>
	</td>
    <td>
	<liferay-ui:user-display  
		displayStyle="2" 
		userId="<%= themeDisplay.getUser().getUserId() %>" 
		/>
	</td>
  </tr>
</table>


