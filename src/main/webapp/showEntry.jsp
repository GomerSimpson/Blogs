<%@page import="java.util.Map"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>

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
  <link rel="stylesheet" href="/mine/css/portlet.css">
			<div class="entry_block">
			    <div class="entry-content">
			        <div class="entry-date">
			            <ul class="edit-actions entry icons-container lfr-meta-actions">
			                <li class="mineLi">
                                <div id="arrow"><a href="<%=allEntriesURL%>"><img src="/mine/img/arrow_right_blue.png"></a></div>
                            </li>
			                <li class="mineLi">
			                    <div id="foo"><span class="aui-icon aui-icon-small aui-iconfont-time"></span></div>
			                </li>
			                <%    String resource_name = "com.brest.ericpol.blog";
			                    if(permissionChecker.hasPermission(themeDisplay.getScopeGroupId(), resource_name, themeDisplay.getScopeGroupId(), ActionKeys.UPDATE)){
			                %>
                                <li class="mineLi">
                                    <a href="<%=editEntryURL%>"><span class="aui-icon aui-icon-small aui-iconfont-edit"></span><liferay-ui:message key="edit" /></a>
                                </li>
                                <li class="mineLi">
                                    <a href="<%=deleteEntryURL%>"><span class="aui-icon aui-icon-small aui-iconfont-remove"></span><liferay-ui:message key="delete" /></a>
                                </li>
                            <%}
                            %>
                            <li class="mineLi">
                                <div class="entry-author"><span class="aui-icon aui-icon-small aui-iconfont-group"></span> by<%=request.getParameter("userName")%></div>
                            </li>
                        </ul><br clear="all">
                        <div class="entry-title"><h3><%=request.getParameter("title")%></h3></div>
                        <div class="entry-body"><h4><%=request.getParameter("entryText")%></h4></div></div></div>
                    </div>
                </div>
                <div class="separator"><!-- --></div>
            </div>

<script src="/mine/js/jquery.min.js"></script>
        <script src="/mine/js/aui.js"></script>
        <script src="/mine/js/aui-experimental.js"></script>
        <script src="/mine/js/aui-datepicker.js"></script>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui.css"/>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui-experimental.css"/>
<script type="text/javascript" src="/mine/ckeditor/ckeditor.js"></script>

<aui:script use="liferay-portlet-url, liferay-search-container">
    var date = new Date('<%=request.getParameter("entryDate")%>');
    var strDate = " " + date.getDate() + "-" + (date.getMonth() + 1) + "-" + (date.getYear() + 1900);

        document.getElementById('foo').innerHTML += strDate;

    //alert("ShowEntry.jsp" + '<%=request.getParameter("userId")%>');
</aui:script>