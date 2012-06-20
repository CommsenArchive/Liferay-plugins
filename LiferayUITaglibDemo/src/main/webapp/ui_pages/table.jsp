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

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<liferay-theme:defineObjects />

<table width="100%" border="0">
	<col width="50%">
	<col width="50%">
  <tr class="results-header">
    <th>Tag</th>
    <th>Preview</th>
  </tr>

  <tr class="results-row">
  	<td>
    	<code><pre>
&lsaquo;%
	List l = new ArrayList();
	l.add("Spring");
	l.add("Summer");
	l.add("Autumn");
	l.add("Winter");
%&rsaquo;
&lt;liferay-ui:table-iterator rowLength="2" list="&lsaquo;%=l %&rsaquo;" listType="java.lang.String" rowValign="top" rowPadding="2" width="100%"&gt;
	&lsaquo;%=tableIteratorObj %&rsaquo;
&lt;/liferay-ui:table-iterator&gt;
     	
		</pre></code>
  	</td>
  	<td>
  		<%
  			List l = new ArrayList();
			l.add("Spring");
  			l.add("Summer");
  			l.add("Autumn");
  			l.add("Winter");
  		%>
		<liferay-ui:table-iterator rowLength="2" list="<%=l %>" listType="java.lang.String" rowValign="top" rowPadding="2" width="100%">
			<%=tableIteratorObj %>
		</liferay-ui:table-iterator>
  	</td>
  </tr>

</table>



