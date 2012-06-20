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

<liferay-theme:defineObjects />

<table width="100%" border="0">
	<col width="50%">
	<col width="50%">
  <tr>
    <th>Tag</th>
    <th>Preview</th>
  </tr>

  <!-- 
  	liferay-ui:captcha
   -->
  <tr>
    <td>
    	<code><pre>
&lt;liferay-ui:captcha url="http://upload.wikimedia.org/wikipedia/commons/6/69/Captcha.jpg"/&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:captcha url="http://upload.wikimedia.org/wikipedia/commons/6/69/Captcha.jpg"/>
	</td>
  </tr>
</table>



