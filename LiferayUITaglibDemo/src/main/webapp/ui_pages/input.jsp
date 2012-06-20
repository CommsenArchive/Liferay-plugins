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
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleModel"%>


<liferay-theme:defineObjects />

<span class="portlet-msg-alert">
	Note: <code>liferay-ui:input-permissions</code> requires logged in user with appropriate permissions.
</span>




<form action="<liferay-portlet:actionURL />" method="post" name="<portlet:namespace />boo">	

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
&lt;liferay-ui:input-checkbox formName="boo" param="cb" /&gt; checkbox 
&lt;liferay-ui:input-checkbox formName="boo" param="dcb" disabled="true" /&gt; disabled checkbox

		</pre></code>
	</td>
    <td>
		<liferay-ui:input-checkbox formName="boo" param="cb" /> checkbox <br/>
		<liferay-ui:input-checkbox formName="boo" param="dcb" disabled="true"/> disabled checkbox <br/>
	</td>
  </tr>


  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-date 
	formName="boo"
	yearRangeStart="1970"
	yearRangeEnd="2100"  
	yearValue="2010"
	monthValue="3"
	dayValue="21"
	dayParam="d1"
	monthParam="m1"
	yearParam="y1"
/&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:input-date 
			formName="boo"
			yearRangeStart="1970"
			yearRangeEnd="2100"  
			yearValue="2010"
			monthValue="3"
			dayValue="21"
			dayParam="d1"
			monthParam="m1"
			yearParam="y1"
		/>
	</td>
  </tr>


  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-date 
	formName="boo"
	yearRangeStart="1970" 
	yearRangeEnd="2100" 
	monthAndYearParam="my"
	dayNullable="true"
	dayParam="d2"
/&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:input-date 
			formName="boo"
			yearRangeStart="1970" 
			yearRangeEnd="2100" 
			monthAndYearParam="my"
			dayNullable="true"
			dayParam="d2"
			/>
	</td>
  </tr>



  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-editor /&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:input-editor />
	</td>
  </tr>



  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-permissions  formName="boo" modelName="<%=JournalArticle.class.getName() %>" /&gt;
&lt;%
List left = new ArrayList(), right = new ArrayList();
left.add(new KeyValuePair("item1key", "item1value"));
left.add(new KeyValuePair("item4key", "item4value"));
left.add(new KeyValuePair("item3key", "item3value"));
right.add(new KeyValuePair("item2key", "item2value"));
%&gt;
&lt;liferay-ui:input-move-boxes 
	leftBoxName="left_box"
	leftTitle="Left box"
	leftList="&lt;%=left %&gt;"
	rightBoxName="right_box"
	rightTitle="Right box"
	rightList="&lt;%=right %&gt;"		
/&gt;
		</pre></code>
	</td>
    <td>
		<%
		List left = new ArrayList(), right = new ArrayList();
		left.add(new KeyValuePair("item1key", "item1value"));
		left.add(new KeyValuePair("item4key", "item4value"));
		left.add(new KeyValuePair("item3key", "item3value"));
		right.add(new KeyValuePair("item2key", "item2value"));
		%>
		<liferay-ui:input-move-boxes 
			leftBoxName="left_box"
			leftTitle="Left box"
			leftList="<%=left %>"
			rightBoxName="right_box"
			rightTitle="Right box"
			rightList="<%=right %>"		
		/>
	</td>
  </tr>


  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-permissions  formName="boo" modelName="<%=JournalArticle.class.getName() %>" /&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:input-permissions  formName="boo" modelName="<%=JournalArticle.class.getName() %>" />
	</td>
  </tr>


  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-resource url="http://google.com" /&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:input-resource url="http://google.com" />
	</td>
  </tr>

	
  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-scheduler /&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:input-scheduler />
	</td>
  </tr>

  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-select formName="boo" param="s" /&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:input-select formName="boo" param="s" />
	</td>
  </tr>



  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-textarea param="tf" defaultValue="test" /&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:input-textarea param="tf" defaultValue="test" />
	</td>
  </tr>


  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-time 
	amPmParam="ampm"
	hourParam="hour"
	minuteParam="min"
	minuteInterval="10" 
/&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:input-time 
			amPmParam="ampm"
			hourParam="hour"
			minuteParam="min"
			minuteInterval="10" 
			/>
	</td>
  </tr>


  <tr class="results-row">
    <td>
    	<code><pre>
&lt;liferay-ui:input-time-zone name="GMT+1"/&gt;
		</pre></code>
	</td>
    <td>
		<liferay-ui:input-time-zone name="GMT+1"/>
	</td>
  </tr>
</table>

</form>


