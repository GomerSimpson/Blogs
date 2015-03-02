
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

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

        <script src="//aui-cdn.atlassian.com/aui-adg/5.8.7/js/aui.js"></script>
        <script src="//aui-cdn.atlassian.com/aui-adg/5.8.7/js/aui-experimental.js"></script>
        <script src="//aui-cdn.atlassian.com/aui-adg/5.8.7/js/aui-datepicker.js"></script>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui.css"/>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui-experimental.css"/>
<script type="text/javascript" src="/html/ckeditor/ckeditor.js"></script>

        <div id="myAlert" class="alert alert-info">
            Please, fill in this form to add an entry.
        </div>
		<aui:form action="<%=addEntry%>" name="addEntry" method="POST">

		<label name="label" for="demo-range-always">Date</label>
		<input class="aui-date-picker" name="<portlet:namespace/>date" id="<portlet:namespace/>date" type="date" max="2019-01-05" min="2011-12-25" />
		<aui:input type="text" id="title" name="title" value="" label="Title"/>
		<label name="editorLabel" for="entryText">Text</label>
		<textarea id="<portlet:namespace/>entryText" name="<portlet:namespace/>entryText"></textarea>
		<aui:button name="addButton" type="submit" value="Add" />


	</aui:form>

<aui:script>

		$(setDate);


            function setDate(){

					date = new Date();

					var values = [ date.getDate(), date.getMonth() + 1 ];

					for( var id in values ) {
						values[ id ] = values[ id ].toString().replace( /^([0-9])$/, '0$1' );
					}

					var element = document.getElementById('<portlet:namespace/>date');
					element.setAttribute("value", date.getFullYear()+'-'+values[ 1 ]+'-'+values[ 0 ]);

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


	AUI().ready(
          function() {
          	var editor_data = CKEDITOR.instances.editor1.getData();
			alert(editor_data);
          }
    );

</aui:script>