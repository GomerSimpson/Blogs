
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

<portlet:actionURL var="addEntry" name="addEntry">
</portlet:actionURL>


<portlet:defineObjects />

<script src="/mine/js/jquery.min.js"></script>
        <script src="/mine/js/aui.js"></script>
        <script src="/mine/js/aui-experimental.js"></script>
        <script src="/mine/js/aui-datepicker.js"></script>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui.css"/>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui-experimental.css"/>
<script type="text/javascript" src="/mine/ckeditor/ckeditor.js"></script>

        <div id="myAlert" class="alert alert-info">
            <liferay-ui:message key="add_entry_note"/>
        </div>
		<aui:form action="<%=addEntry%>" name="addEntry" method="POST">

		<label name="label" for="demo-range-always"><h4><liferay-ui:message key="date"/></h4></label>
		<input class="aui-date-picker" name="<portlet:namespace/>date" id="<portlet:namespace/>date" type="date" max="2019-01-05" min="2011-12-25" />
		<label name="titleLabel" for="title"><h4><liferay-ui:message key="title"/></h4></label>
		<input type="text" id="<portlet:namespace/>title" name="<portlet:namespace/>title" value=""/>
		<label name="editorLabel" for="entryText"><h4><liferay-ui:message key="content"/></h4></label>
		<textarea id="<portlet:namespace/>entryText" name="<portlet:namespace/>entryText"></textarea>
		<c:set var="add_entry_button"><liferay-ui:message key="add_entry_button" /></c:set>
		<aui:button name="addButton" type="submit" value="${add_entry_button}" />

	</aui:form>

<aui:script>

		$(setDate);

            function setDate(){

					var element = document.getElementById('<portlet:namespace/>date');
					element.setAttribute("value", getCurrentFormattedDate());

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