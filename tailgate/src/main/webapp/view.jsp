<%
/**
 *	This file is part of Tailgate Liferay plug-in.
 *	
 * Tailgate Liferay plug-in is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Tailgate Liferay plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Tailgate Liferay plug-in.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */
%>

<%@include file="init.jsp" %>

<div>
<button id="<portlet:namespace />_start">Start</button>
<button id="<portlet:namespace />_stop">Stop</button>
listing file <strong><%=prefs.getValue("fileName","")%></strong>. <small>(Showing only last <%=prefs.getValue("lines","100")%> lines)</small>
</div>

	<ul id="<portlet:namespace />list" class="tailgate"> 
		<%=request.getAttribute("lines") %>
	</ul> 
	 

	<script type="text/javascript">
		<!-- 
		jQuery("#<portlet:namespace />_stop").hide();
		tailgateInstances["<portlet:namespace />"] = new Tailgate(<%=prefs.getValue("lines","100")%>, "<liferay-portlet:resourceURL />"); 
		jQuery("#<portlet:namespace />_start").click(function(){
			startReading("<portlet:namespace />");
			jQuery("#<portlet:namespace />_start").hide();
			jQuery("#<portlet:namespace />_stop").show();
		})
		jQuery("#<portlet:namespace />_stop").click(function(){
			stopReading("<portlet:namespace />");
			jQuery("#<portlet:namespace />_start").show();
			jQuery("#<portlet:namespace />_stop").hide();
		})

		-->
	</script> 