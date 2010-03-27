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


<table width="100%" border="1">
	<col width="50%">
	<col width="50%">
  <tr>
    <th>Tag</th>
    <th>Preview</th>
  </tr>


  <!-- 
  	liferay-ui:panel
   -->

  <tr>
  	<td>
    	<code><pre>
&lt;liferay-ui:panel id="panel1" title="Test panel 1" collapsible="true" extended="true" &gt;
	Test panel
&lt;/liferay-ui:panel&gt;
		</pre></code>
  	</td>
  	<td>
		<liferay-ui:panel id="panel1" title="Test panel 1" collapsible="true" extended="true" >
			Test panel
		</liferay-ui:panel>
  	</td>
  </tr>
  <tr>
  	<td>
    	<code><pre>
&lt;liferay-ui:panel id="panel2" title="Test panel 2" collapsible="false" extended="true" &gt;
	Test panel
&lt;/liferay-ui:panel&gt;
		</pre></code>
  	</td>
  	<td>
		<liferay-ui:panel id="panel2" title="Test panel 2" collapsible="false" extended="true" >
			Test panel
		</liferay-ui:panel>
  	</td>
  </tr>
  <tr>
  	<td>
    	<code><pre>
&lt;liferay-ui:panel id="panel3" title="Test panel 3" collapsible="true" extended="false" &gt;
	Test panel
&lt;/liferay-ui:panel&gt;
		</pre></code>
  	</td>
  	<td>
		<liferay-ui:panel id="panel3" title="Test panel 3" collapsible="true" extended="false" >
			Test panel
		</liferay-ui:panel>
  	</td>
  </tr>
  <tr>
  	<td>
    	<code><pre>
&lt;liferay-ui:panel id="panel4" title="Test panel 4" collapsible="false" extended="false" &gt;
	Test panel
&lt;/liferay-ui:panel&gt;
		</pre></code>
  	</td>
  	<td>
		<liferay-ui:panel id="panel4" title="Test panel 4" collapsible="false" extended="false" >
			Test panel
		</liferay-ui:panel>
  	</td>
  </tr>
  
  
  <!-- 
  	liferay-ui:panel
   -->
  
  <tr>
  	<td>
    	<code><pre>
&lt;liferay-ui:panel-container id="panel-container-1" extended="true" accordion="true" &gt;
	&lt;liferay-ui:panel id="panel-c1" title="Panel 1" collapsible="true" extended="true" &gt;
	Test panel
	&lt;/liferay-ui:panel&gt;
	&lt;liferay-ui:panel id="panel-c2" title="Panel 2" collapsible="true" extended="false" &gt;
	Test panel
	&lt;/liferay-ui:panel>
	&lt;liferay-ui:panel id="panel-c3" title="Panel 3" collapsible="false" extended="true" &gt;
	Test panel
	&lt;/liferay-ui:panel&gt;
	&lt;liferay-ui:panel id="panel-c4" title="Panel 4" collapsible="false" extended="false" &gt;
	Test panel
	&lt;/liferay-ui:panel&gt;
&lt;/liferay-ui:panel-container&gt;
		</pre></code>
  	</td>
  	<td>
		<liferay-ui:panel-container id="panel-container-1" extended="true" accordion="true" >
			<liferay-ui:panel id="panel-c1" title="Panel 1" collapsible="true" extended="true" >
			Test panel
			</liferay-ui:panel>
			<liferay-ui:panel id="panel-c2" title="Panel 2" collapsible="true" extended="false" >
			Test panel
			</liferay-ui:panel>
			<liferay-ui:panel id="panel-c3" title="Panel 3" collapsible="false" extended="true" >
			Test panel
			</liferay-ui:panel>
			<liferay-ui:panel id="panel-c4" title="Panel 4" collapsible="false" extended="false" >
			Test panel
			</liferay-ui:panel>
		</liferay-ui:panel-container>
  	</td>
  </tr>

</table>



