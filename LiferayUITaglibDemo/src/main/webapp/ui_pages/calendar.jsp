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

<%@page import="java.util.HashSet"%>

<liferay-theme:defineObjects />

<table width="100%" border="0">
	<col width="50%">
	<col width="50%">
  <tr class="results-header">
    <th>Tag</th>
    <th>Preview</th>
  </tr>

  <!-- 
  	liferay-ui:calendar
   -->
  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:calendar day="16" year="2009" month="11" /&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:calendar day="16" year="2009" month="11" />
	</td>
  </tr>
  <tr class="results-row">
    <td>
    	<code><pre>
&lsaquo;%
	HashSet data = new HashSet();
	data.add(new Integer(1));
	data.add(new Integer(7));
	data.add(new Integer(21));
%&rsaquo;
&lt;liferay-ui:calendar day="1" year="2009" month="1" headerPattern="MMMM" data="&lsaquo;%=data %&rsaquo;" showAllPotentialWeeks="true"/&gt;
		</pre></code>
	</td>
    <td>
    	<%
    		HashSet data = new HashSet();
			data.add(new Integer(1));
			data.add(new Integer(7));
			data.add(new Integer(21));
    	%>
		<liferay-ui:calendar day="1" year="2009" month="8" headerPattern="MMMM" data="<%=data %>" showAllPotentialWeeks="true"/>
	</td>
  </tr>

</table>



