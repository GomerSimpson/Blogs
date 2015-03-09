<%@page import="java.util.Map"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="createReportURL" name="createReport">
</portlet:actionURL>

<form class="aui" name="createReport" action="<%=createReportURL%>" method="POST">
    <aui:field-wrapper name="fileType" label="">
        <aui:input class="radio" type="radio" checked="<%= true %>" name="radio" id="pdfRadioButton" value="PDF" label="PDF"/>
        <aui:input class="radio" type="radio" name="radio" id="xlsRadioButton" value="XLS" label="XLS"/>
        <aui:input class="radio" type="radio" name="radio" id="bothRadioButton" value="PDF and XLS" label="PDF and XLS"/>
    </aui:field-wrapper>
    <aui:input type="text" class="text short-field" name="reportFileName" id="reportFileName" label="File Name"/>
    <aui:input type="hidden" name="entriesIds" id="entriesIds" value=""/>
    <aui:button type="submit" name="report" value="Report"/>

</form>
