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

<portlet:renderURL var="testRender">
    <portlet:param name="mvcPath" value="/eq.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="deleteEntryURL" name="deleteEntry">
</portlet:actionURL>

<aui:form action="#" method="get" name="fm1">
	<liferay-portlet:renderURLParams varImpl="adsfg" />
	<aui:input name="redirect" type="hidden" value="ag" />
</aui:form>


<liferay-theme:defineObjects />

<c:if test="true">
	<aui:nav-bar>
		<c:if test="true">
			<aui:nav>
					<aui:nav-item href="#" label="add-blog-entry" name="addEntryButton" />
			</aui:nav>
		</c:if>

		<c:if test="true">
			<aui:nav-bar-search cssClass="pull-right">
				<div class="form-search">
					<liferay-ui:input-search autoFocus="" id="keywords1" name="keywords" placeholder='' />
				</div>
			</aui:nav-bar-search>
		</c:if>
	</aui:nav-bar>
</c:if>

<div id="anchor">

</div>
<%--

			<div class="entry-body" id="test">
				<c:choose>
					<c:when test='true'>
						<aui:a href="#"><h4>read more (title)</h4></aui:a>
					</c:when>
				</c:choose>
			</div>

			<div class="entry-footer">
				<div class="entry-author">
					<liferay-ui:message key="written-by" /><h6>get username</h6>
				</div>
			</div>
		</div>
		<div class="separator"><!-- --></div>
--%>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/require.js/2.1.15/require.min.js"></script>
        <script src="//aui-cdn.atlassian.com/aui-adg/5.8.7/js/aui.js"></script>
        <script src="//aui-cdn.atlassian.com/aui-adg/5.8.7/js/aui-experimental.js"></script>
        <script src="//aui-cdn.atlassian.com/aui-adg/5.8.7/js/aui-datepicker.js"></script>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui.css"/>
        <link rel="stylesheet" type="text/css" href="//aui-cdn.atlassian.com/aui-adg/5.8.7/css/aui-experimental.css"/>
<aui:script use="liferay-portlet-url, liferay-search-container, aui-node">
	var stringHtml = "";

     AUI().ready(
                    function() {
                         AUI().use('aui-base','aui-io-request', function(A){
                                A.io.request('<%=resourceURL%>',{
                                    dataType: 'json',
                                    method: 'GET',
                                    on: {
                                        success: function() {
                                            data=this.get('responseData');
                                            A.Array.each(data, function(obj, idx){
                                                  document.getElementById('anchor').innerHTML += addEntry(obj.entryId, obj.userId, obj.groupId,
                                                        obj.companyId, obj.title, obj.entryText, obj.entryDate);

                                            });
                                        }
                                    }
                                });
                         });
                        }
                );

     function addEntry(entryId, userId, groupId, companyId, title1, entryText1, entryDate1){
            stringHtml = "";
			var entryDate = new Date(entryDate1);
			var title = new String(title1);
			var entryText = new String(entryText1);
            var editUrl = createEditEntryURL(entryId, userId, groupId, companyId, title, entryText, entryDate);


            var deleteUrl = createDeleteURL(entryId);;

			stringHtml += '<div class="entry">';
			stringHtml += '<div class="entry-content">';
			stringHtml += '<div class="entry-date">';
			stringHtml += '<ul class="edit-actions entry icons-container lfr-meta-actions"><li class="date-entry"><span class="aui-icon aui-icon-small aui-iconfont-time"></span>';
            stringHtml += ' ' + entryDate.getDate() + '-' + (entryDate.getMonth() + 1) + '-' + (entryDate.getYear() + 1900) + '</li>';
            stringHtml += '<li class="edit-entry">';
            stringHtml += '<a href="' + editUrl + '"><span class="aui-icon aui-icon-small aui-iconfont-edit"></span>Edit</a></li>';
            stringHtml += '<li class="delete-entry">';
            stringHtml += '<a href="' + deleteUrl + '"><span class="aui-icon aui-icon-small aui-iconfont-remove"></span>Delete</a></li></ul></div></div>';
            return stringHtml;
     }

    function createEditEntryURL(entryId, userId, groupId, companyId, title, entryText, entryDate){
			var editEntryURL = new Liferay.PortletURL.createRenderURL();
            editEntryURL.setParameter('jspPage', '/eq.jsp');
            editEntryURL.setParameter('entryId', entryId);
            editEntryURL.setParameter('userId', userId);
            editEntryURL.setParameter('groupId', groupId);
            editEntryURL.setParameter('companyId', companyId);
            editEntryURL.setParameter('title', title);
            editEntryURL.setParameter('entryText', entryText);
            editEntryURL.setParameter('entryDate', new Date(entryDate).toString());
            editEntryURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId()%>');
            return editEntryURL.toString();
    }

    function createDeleteURL(entryId){
            var deleteEntryURL = Liferay.PortletURL.createActionURL();
            deleteEntryURL.setParameter('p_auth', Liferay.authToken);
            deleteEntryURL.setParameter('entryId', entryId);
            deleteEntryURL.setPortletId('${themeDisplay.portletDisplay.rootPortletId}');
            deleteEntryURL.setWindowState('normal');
            deleteEntryURL.setName('deleteEntry');

            return deleteEntryURL.toString();
    }


</aui:script>