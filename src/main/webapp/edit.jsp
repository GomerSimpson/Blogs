
<%@ page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<portlet:actionURL var="updateEntry" name="updateEntry">
</portlet:actionURL>

<portlet:actionURL var="allEntriesURL" name="showAll">
    <portlet:param name="userId" value='<%=request.getParameter("userId")%>'/>
</portlet:actionURL>

<portlet:defineObjects />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/require.js/2.1.15/require.min.js"></script>
        <script src="//aui-cdn.atlassian.com/aui-adg/5.8.7/js/aui.js"></script>
        <script src="//aui-cdn.atlassian.com/aui-adg/5.8.7/js/aui-experimental.js"></script>
        <script src="//aui-cdn.atlassian.com/aui-adg/5.8.7/js/aui-datepicker.js"></script>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui.css"/>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui-experimental.css"/>
<script type="text/javascript" src="/html/ckeditor/ckeditor.js"></script>



		<a href="<%=allEntriesURL%>">back</a>

		<aui:form action="<%=updateEntry%>" name="updateEntry" method="POST">
		<label name="label" for="demo-range-always">Date</label>
		<input class="aui-date-picker" name="<portlet:namespace/>date" id="<portlet:namespace/>date" type="date" max="2019-01-05" min="2011-12-25" />
		<aui:input type="text" id="title" name="title" value="" label="Title"/>
		<label name="editorLabel" for="entryText">Text</label>
		<textarea id="<portlet:namespace/>entryText" name="<portlet:namespace/>entryText"><%=request.getParameter("entryText")%></textarea>
			<aui:input type="hidden" id="entryId" name="entryId" value='<%=request.getParameter("entryId")%>'/>
			<aui:input type="hidden" id="userId" name="userId" value='<%=request.getParameter("userId")%>'/>
			<aui:input type="hidden" id="groupId" name="groupId" value='<%=request.getParameter("groupId")%>'/>
			<aui:input type="hidden" id="companyId" name="companyId" value='<%=request.getParameter("companyId")%>'/>
			<aui:button name="updateButton" type="submit" value="Update" />
	</aui:form>
<aui:script>

		$(setDateAndTitle);


            function setDateAndTitle(){
				var date;

				var formattedDate = formatDate(new Date('<%=request.getParameter("entryDate")%>'));
				var element = document.getElementById('<portlet:namespace/>date');

				element.setAttribute("value", formattedDate);
				document.getElementById('<portlet:namespace/>title').setAttribute("value", '<%=request.getParameter("title")%>');
            }

	AJS.$(document).ready(function() {
	   AJS.$('#<portlet:namespace/>date').datePicker({'overrideBrowserDefault': true});
	});

	window.onload = function()
	{
		CKEDITOR.replace( '<portlet:namespace/>entryText',
    {
        toolbar : 'Base',
        uiColor : '#009ae5'
    });
	};



</aui:script>