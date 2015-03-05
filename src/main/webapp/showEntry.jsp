<%@page import="java.util.Map"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<portlet:defineObjects />

<portlet:resourceURL var="resourceURL">
</portlet:resourceURL>

<portlet:actionURL var="deleteEntryURL" name="deleteEntry">
    <portlet:param name="entryId" value='<%=request.getParameter("entryId")%>'/>
</portlet:actionURL>

<portlet:renderURL var="editEntryURL" copyCurrentRenderParameters="true">
    <portlet:param name="mvcPath" value="/edit.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="allEntriesURL" name="showAll">
    <portlet:param name="userId" value='<%=request.getParameter("userId")%>'/>
</portlet:actionURL>

<liferay-theme:defineObjects />
<a href="<%=allEntriesURL%>">Go back</a>
			<div class="entry">
			    <div class="entry-content">
			        <div class="entry-date">
			            <ul class="edit-actions entry icons-container lfr-meta-actions">
			                <li class="date-entry">
			                    <div id="foo"><span class="aui-icon aui-icon-small aui-iconfont-time"></span></div>
			                </li>
                            <li class="edit-entry">
                                <a href="<%=editEntryURL%>"><span class="aui-icon aui-icon-small aui-iconfont-edit"></span>Edit</a>
                            </li>
                            <li class="delete-entry">
                                <a href="<%=deleteEntryURL%>"><span class="aui-icon aui-icon-small aui-iconfont-remove"></span>Delete</a>
                            </li>
                            <li>
                                <div class="entry-author"><span class="aui-icon aui-icon-small aui-iconfont-group"></span> by<%=request.getParameter("userName")%></div>
                            </li>
                        </ul>
                        <div class="entry-title"><h3><%=request.getParameter("title")%></h3></div>
                        <div class="entry-body"><%=request.getParameter("entryText")%></div></div></div>
                    </div>
                </div>
            </div>
            <div class="separator"><!-- --></div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="//aui-cdn.atlassian.com/aui-adg/5.8.7/js/aui.js"></script>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui.css"/>
<link href="http://cdn.alloyui.com/2.5.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>
<aui:script use="liferay-portlet-url, liferay-search-container">
    var date = new Date('<%=request.getParameter("entryDate")%>');
    var strDate = " " + date.getDate() + "-" + (date.getMonth() + 1) + "-" + (date.getYear() + 1900);

        document.getElementById('foo').innerHTML += strDate;

    //alert("ShowEntry.jsp" + '<%=request.getParameter("userId")%>');
</aui:script>