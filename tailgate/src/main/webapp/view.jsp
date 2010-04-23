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

<%@include file="../init.jsp" %>

<div>
Showing the last <%=prefs.getValue("lines","100")%> lines of file <%=prefs.getValue("fileName","")%>
</div>

	<input id="<portlet:namespace />addButton" type="button" value="add" > 
	<ul id="<portlet:namespace />list"> 
		<li>line 1</li> 
	</ul> 
	
	<div id="responsecontainer"> 
	</div> 

 

	<script type="text/javascript"> 
		var counter = 0;
		jQuery('#<portlet:namespace />list').append('<li>Test</li>')
	
		jQuery('#<portlet:namespace />addButton').click(function() {
			// append new elements 				
			jQuery('#<portlet:namespace />list').append('<li>Test_' + counter + '</li>');
			counter++;
			jQuery('#<portlet:namespace />list').append('<li>Test_' + counter + '</li>');
			counter++;
			jQuery('#<portlet:namespace />list').append('<li>Test_' + counter + '</li>');
			counter++;

			// delete first if too long 				
			var maxLines = <%=prefs.getValue("lines","100")%>;
			var lines = jQuery('#<portlet:namespace />list li').length;
			if (lines > maxLines) {
				jQuery('#<portlet:namespace />list li').slice(0, lines- maxLines).remove();
			}
			
		})
	</script> 