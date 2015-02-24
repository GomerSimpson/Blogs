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

<portlet:actionURL var="testURL" windowState="maximized" name="addEquipment">
    <portlet:param name="mvcPath" value="/eq.jsp"/>
</portlet:actionURL>

<aui:form action="<%=testURL%>" method="get" name="fm1">
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

		<div class="entry">

			<div class="entry-content">

				<div class="entry-date">
					<span class="hide-accessible"></span>
							<liferay-ui:icon
								image="date"
								label="true"
							/>					<h6>Date is here</h6>
				</div>
			</div>

			<c:if test="true ">
				<ul class="edit-actions entry icons-container lfr-meta-actions">
					<c:if test="true">
						<li class="edit-entry">
							<liferay-ui:icon
								image="edit"
								label="<%= true %>"
								url="<%= testURL %>"
							/>
						</li>
					</c:if>

					<c:if test="true">
						<li class="delete-entry">

							<liferay-ui:icon-delete
								label="<%= true %>"

								url="<%= testURL %>"
							/>
						</li>
					</c:if>
				</ul>
			</c:if>

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

<aui:script>
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
                                              var stringHtml = obj.entryText;
                                              document.getElementById('test').innerHTML += stringHtml;
                                              var deleteTankURL = new Liferay.PortletURL.createActionURL();
                                        });
                                    }
                                }
                            });
                     });
                    }
                );
</aui:script>