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

<liferay-theme:defineObjects />

<table width="100%" border="0">
	<col width="50%">
	<col width="50%">
  <tr class="results-header">
    <th>Tag</th>
    <th>Preview</th>
  </tr>


  
  <!-- 
  	liferay-ui:icon
   -->
  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:icon 
	srcHover="/html/themes/classic/images/common/feed.png" 
	src="/html/themes/classic/images/common/rss.png" 
	label="true"
	message="Custom message"
/&gt;
&lt;br/&gt;
&lt;liferay-ui:icon image="edit" url="#" label="true" /&gt;
&lt;br/&gt;
&lt;liferay-ui:icon image="close" message="Custom message" /&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:icon 
		 	srcHover="/html/themes/classic/images/common/feed.png" 
			src="/html/themes/classic/images/common/rss.png" 
			label="true"
			message="Custom message"
			/>
		<br/>	
		<liferay-ui:icon image="edit" url="#" label="true" />
		<br/>
		<liferay-ui:icon image="close" message="Custom message"/>
	</td>
  </tr>

  <!-- 
  	liferay-ui:icon-list
   -->
  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:icon-list/&gt;
	&lt;liferay-ui:icon image="edit" url="#" &gt;
	&lt;liferay-ui:icon image="permissions" url="#" /&gt;
	&lt;liferay-ui:icon-delete url="#" /&gt;
	&lt;liferay-ui:icon-deactivate url="#" /&gt;
	&lt;liferay-ui:icon-help message="Help message" /&gt;
&lt;/liferay-ui:icon-list&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:icon-list >
			<liferay-ui:icon image="edit" url="#" />
			<liferay-ui:icon image="permissions" url="#" />
			<liferay-ui:icon-delete url="#" />
			<liferay-ui:icon-deactivate url="#" />
			<liferay-ui:icon-help message="Help message" />
		</liferay-ui:icon-list>
	</td>
  </tr>

  <!-- 
  	liferay-ui:icon-menu
   -->
  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:icon-menu message="My icon menu" align="left" &gt;
	&lt;liferay-ui:icon image="edit" url="#" /&gt;
	&lt;liferay-ui:icon image="permissions" url="#" /&gt;
	&lt;liferay-ui:icon-delete url="#" /&gt;
	&lt;liferay-ui:icon-deactivate url="#" /&gt;
	&lt;liferay-ui:icon-help message="Help message" /&gt;
&lt;/liferay-ui:icon-menu&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:icon-menu message="My icon menu" align="left" >
			<liferay-ui:icon image="edit" url="#" />
			<liferay-ui:icon image="permissions" url="#" />
			<liferay-ui:icon-delete url="#" />
			<liferay-ui:icon-deactivate url="#" />
			<liferay-ui:icon-help message="Help message" />
		</liferay-ui:icon-menu>
	</td>
  </tr>
</table>


