<%
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
 * along with CustomGlobalMarkup Liferay plug-in. If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */
%>

<%@include file="init.jsp" %>

<liferay-ui:success key="tailgate-message:config-saved" message="config.saved" />
<form id = "<portlet:namespace />form" action="<portlet:actionURL name="saveConfig"/>" method="post">
	<table>
		<tr>
			<td><label for="fileName"><liferay-ui:message key="file.name" />:</label></td>
			<td><input id="fileName" type="text" name="fileName" value="<%=prefs.getValue("fileName","")%>"></td>
		</tr>
		<tr>
			<td><label for="lines"><liferay-ui:message key="lines.to.show" />:</label></td>
			<td><input id="lines" type="text" name="lines" maxlength="10" value="<%=prefs.getValue("lines","")%>"></td>
		</tr>
	</table>
	
	<input type="submit" id="saveButton" title="<liferay-ui:message key="save" />" value="<liferay-ui:message key="save" />">
</form>