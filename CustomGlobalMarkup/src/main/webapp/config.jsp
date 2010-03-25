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

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.commsen.liferay.portlet.customglobalmarkup.model.Markup"%>
<%@page import="com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@page import="com.liferay.portal.kernel.util.JavaConstants" %>

<%@ page import="javax.portlet.PortletURL" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
PortletURL portletURL = renderResponse.createRenderURL();
List<Markup> markups = MarkupLocalServiceUtil.getMarkups(PortalUtil.getScopeGroupId(renderRequest));
%>

<liferay-portlet:renderURL var="renderURL"/>

<liferay-portlet:actionURL name="save" var="saveURL">
	<liferay-portlet:param name="redirect" value="<%=renderURL %>" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL name="add" var="addURL">
	<liferay-portlet:param name="redirect" value="<%=renderURL %>" />
</liferay-portlet:actionURL>

<form name="<portlet:namespace />customMarkupForm" action="<%=saveURL %>" method="POST">


<liferay-ui:search-container
	emptyResultsMessage="no-custom-markups" 
	curParam="cur1"
	iteratorURL="<%= portletURL %>"
	>
	
	<input type="button" name="addMarkup" value="<liferay-ui:message key="add-markup" />" onClick="self.location = '<%=addURL %>';">
	<input type="submit" name="save" value="<liferay-ui:message key="save-changes" />" >
	
	<%-- 
		Define result list and count 
	--%>
	<liferay-ui:search-container-results 
		results="<%=markups %>"
		total="<%=markups.size() %>"
		/>
		
	<%-- 
		Configure table row  
	--%>
	<liferay-ui:search-container-row
		className="com.commsen.liferay.portlet.customglobalmarkup.model.Markup"
		keyProperty="id"
		modelVar="markup"
	>
		
		<%-- 
			First column contains text area  
		--%>
		<liferay-ui:search-container-column-text>
			<liferay-ui:input-textarea 
				param="<%=\"markup_\" + markup.getId() %>" 
				defaultValue="<%=HtmlUtil.escape(markup.getMarkup())%>"/>
		</liferay-ui:search-container-column-text>


		<%-- 
			Second column contains fields to specify location, status and mark for deletion    
		--%>
		<liferay-ui:search-container-column-text>

			<div>
				<% String locationFieldName = "location_" + markup.getId(); %>
				<label for="<portlet:namespace /><%=locationFieldName %>"><liferay-ui:message key="location" /></label>
				<select name="<portlet:namespace /><%=locationFieldName %>" >
					<option value="1" <%=markup.getLocation() == 1 ? "selected='selected'" : "" %> >TOP</option>
					<option value="2" <%=markup.getLocation() == 2 ? "selected='selected'" : "" %> >BOTTOM</option>
				</select>
			</div>
			<div>
				<% String activeFieldName = "active_" + markup.getId(); %>
				<label for="<portlet:namespace /><%=activeFieldName %>"><liferay-ui:message key="active" /></label>
				<liferay-ui:input-select  
					param="<%=activeFieldName %>" 
					defaultValue="<%=markup.isActive() %>" 
					/>
			</div>
			<div>
				<% String deleteFieldName = "delete_" + markup.getId(); %>
				<label for="<portlet:namespace /><%=deleteFieldName %>Checkbox"><liferay-ui:message key="delete-on-save" /></label>
				<liferay-ui:input-checkbox  
					param="<%=deleteFieldName %>" 
					/>
			<div>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<%-- 
		Configuration done. Iterate over results and display    
	--%>
	<liferay-ui:search-iterator />


</liferay-ui:search-container>


</form>
