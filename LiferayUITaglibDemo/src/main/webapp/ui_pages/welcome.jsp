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



<h3>
This portlet demonstrates how to use some of the tags from liferay-ui tag library. 
</h3>



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
&lt;liferay-ui:user-display  
	displayStyle="0" 
	userId="&lt;%= themeDisplay.getUser().getUserId() %&gt;" 
	/&gt;
&lt;hr/&gt;  
&lt;liferay-ui:user-display  
	displayStyle="1" 
	userId="&lt;%= themeDisplay.getUser().getUserId() %&gt;" 
	/&gt;
		</pre></code>
	</td>
    <td>
	<liferay-ui:user-display  
		displayStyle="0" 
		userId="<%= themeDisplay.getUser().getUserId() %>" 
		/>
	<hr/>
	<liferay-ui:user-display  
		displayStyle="1" 
		userId="<%= themeDisplay.getUser().getUserId() %>" 
		/>
  </tr>
  
  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:language displayStyle="0" /&gt;
&lt;hr/&gt;  
&lt;liferay-ui:language displayStyle="1" languageIds='&lt;%= new String[]{"en_US","en_GB","en_AU"} %&gt;'/&gt;
&lt;hr/&gt;  
&lt;liferay-ui:language displayStyle="2" languageIds='&lt;%= new String[]{"bg","en","es","pl"} %&gt;'/&gt;
&lt;hr/&gt;  
&lt;liferay-ui:language displayStyle="3"/&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:language displayStyle="0" />
		<hr/>
		<liferay-ui:language displayStyle="1" languageIds='<%= new String[]{"en_US","en_GB","en_AU"} %>'/>
		<hr/>
		<liferay-ui:language displayStyle="2" languageIds='<%= new String[]{"bg","en","es","pl"} %>'/>
		<hr/>
		<liferay-ui:language displayStyle="3"/>
	</td>
  </tr>

  <tr class="results-row">
    <td>
    	<code><pre>
&lt;div id="toggle_div" style="background-color: yellow; float: right; width: 200px" &gt;
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer facilisis faucibus lectus, 
		a imperdiet lectus ornare ac. Etiam vehicula mauris in quam volutpat sed fermentum enim mollis. 
		Donec sit amet felis erat, sed egestas nisi.
&lt;/div&gt;
&lt;liferay-ui:toggle-area id="toggle_area"&gt;
	&lt;div class="toggle_area"&gt;
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer facilisis faucibus lectus, 
		a imperdiet lectus ornare ac. Etiam vehicula mauris in quam volutpat sed fermentum enim mollis. 
		Donec sit amet felis erat, sed egestas nisi. Sed ante sapien, ornare in pulvinar nec, fermentum 
		in ipsum. Etiam scelerisque nibh a nibh condimentum interdum fringilla tortor condimentum. 
		Quisque leo ligula, scelerisque sed dapibus eu, volutpat eget velit. Donec quis mi turpis. Morbi 
		consequat vulputate nulla, ut ullamcorper augue varius eget. Quisque pharetra interdum quam sed 
		dictum. Integer malesuada nisl at augue sollicitudin vel hendrerit leo rhoncus. Fusce elementum 
		urna ut orci accumsan ut mollis nunc rhoncus. Pellentesque nisl odio, pulvinar non congue nec, 
		hendrerit ut sapien.
	&lt;/div&gt;
&lt;/liferay-ui:toggle-area&gt;
&lt;hr/&gt;
&lt;liferay-ui:toggle id="toggle_div" showMessage="Show yellow box" hideMessage="Hide yellow box" /&gt;
		</pre></code>
	</td>
    <td>
		<div id="toggle_div" style="background-color: yellow; float: right; width: 200px;" >
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer facilisis faucibus lectus, 
				a imperdiet lectus ornare ac. Etiam vehicula mauris in quam volutpat sed fermentum enim mollis. 
				Donec sit amet felis erat, sed egestas nisi.
		</div>
		<liferay-ui:toggle-area id="toggle_area">
			<div class="toggle_area">
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer facilisis faucibus lectus, 
				a imperdiet lectus ornare ac. Etiam vehicula mauris in quam volutpat sed fermentum enim mollis. 
				Donec sit amet felis erat, sed egestas nisi. Sed ante sapien, ornare in pulvinar nec, fermentum 
				in ipsum. Etiam scelerisque nibh a nibh condimentum interdum fringilla tortor condimentum. 
				Quisque leo ligula, scelerisque sed dapibus eu, volutpat eget velit. Donec quis mi turpis. Morbi 
				consequat vulputate nulla, ut ullamcorper augue varius eget. Quisque pharetra interdum quam sed 
				dictum. Integer malesuada nisl at augue sollicitudin vel hendrerit leo rhoncus. Fusce elementum 
				urna ut orci accumsan ut mollis nunc rhoncus. Pellentesque nisl odio, pulvinar non congue nec, 
				hendrerit ut sapien.
			</div>
		</liferay-ui:toggle-area>
		<hr/>
		<liferay-ui:toggle id="toggle_div" showMessage="Show yellow box" hideMessage="Hide yellow box" />
	</td>
  </tr>   
</table>


