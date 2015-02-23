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
<portlet:actionURL var="testURL" windowState="maximized" name="addEquipment">
    <portlet:param name="mvcPath" value="/eq.jsp"/>
</portlet:actionURL>

<aui:form action="<%=testURL%>" method="get" name="fm1">
	<liferay-portlet:renderURLParams varImpl="adsfg" />
	<aui:input name="redirect" type="hidden" value="ag" />
</aui:form>



<c:if test="true">
	<aui:nav-bar>
		<c:if test="true">
			<aui:nav>
				<c:if test="true">
					<portlet:renderURL var="testURL">
						<portlet:param name="struts_action" value="/blogs/edit_entry" />
						<portlet:param name="redirect" value="<%= testURL %>" />
						<portlet:param name="testURL" value="<%= testURL %>" />
					</portlet:renderURL>

					<aui:nav-item href="<%= testURL %>" label="add-blog-entry" name="addEntryButton" />
				</c:if>

				<c:if test="<%= testURL %>">

					<aui:nav-item href="<%= testURL %>" label="permissions" title="edit-permissions" useDialog="<%= true %>" />
				</c:if>
			</aui:nav>
		</c:if>

		<c:if test="<%= testURL %>">
			<aui:nav-bar-search cssClass="pull-right">
				<div class="form-search">
					<liferay-ui:input-search autoFocus="" id="keywords1" name="keywords" placeholder='' />
				</div>
			</aui:nav-bar-search>
		</c:if>
	</aui:nav-bar>
</c:if>

<liferay-ui:categorization-filter
	assetType="entries"
	portletURL="<%= renderResponse.createRenderURL() %>"
/>

<c:choose>
	<c:when test="true">
		<div class="entry" id="<portlet:namespace />5">
			<div class="entry-content">
				start of entry
				<portlet:renderURL var="testURL">
					<portlet:param name="struts_action" value="/blogs/view_entry" />
					<portlet:param name="redirect" value="<%= testURL %>" />
					<portlet:param name="urlTitle" value="entry.getUrlTitle()" />
				</portlet:renderURL>

				<c:if test='true'>
					<div class="entry-title">
						<h2><aui:a href="<%= testURL %>"></aui:a></h2>
					</div>
				</c:if>

				<div class="entry-date">
					<span class="hide-accessible"></span>
							<liferay-ui:icon
								image="date"
								label="<%= true %>"
							/>
					<h5>Date is here</h5>
				</div>
			</div>

			<c:if test="true ">
				<ul class="edit-actions entry icons-container lfr-meta-actions">
					<c:if test="true">
						<li class="edit-entry">
							<portlet:renderURL var="testURL">
								<portlet:param name="struts_action" value="/blogs/edit_entry" />
								<portlet:param name="redirect" value="sfgh" />
								<portlet:param name="testURL" value="currentURL" />
								<portlet:param name="entryId" value="entry_getEntryId" />
							</portlet:renderURL>

							<liferay-ui:icon
								image="edit"
								label="<%= true %>"
								url="<%= testURL %>"
							/>
						</li>
					</c:if>

					<c:if test="true">
						<li class="edit-entry-permissions">
							<h6>Edit permision was here</h6>
						</li>
					</c:if>

					<c:if test="true">
						<li class="delete-entry">
							<portlet:renderURL var="testURL">
								<portlet:param name="struts_action" value="/blogs/view" />
							</portlet:renderURL>

							<portlet:actionURL var="testURL">
								<portlet:param name="struts_action" value="/blogs/edit_entry" />
								<portlet:param name="Constants" value="TrashUtil" />
								<portlet:param name="redirect" value="testURL" />
								<portlet:param name="entryId" value="tring" />
							</portlet:actionURL>

							<liferay-ui:icon-delete
								label="<%= true %>"

								url="<%= testURL %>"
							/>
						</li>
					</c:if>
				</ul>
			</c:if>

			<div class="entry-body">
				<c:choose>
					<c:when test='true'>
						<aui:a href="<%= testURL %>"><h2>read more (title)</h2></aui:a>
					</c:when>
					<c:when test='true'>

						<liferay-ui:custom-attributes-available className="class name">
							<liferay-ui:custom-attribute-list
								className="class name"
								classPK="4"
								editable="<%= false %>"
								label="<%= true %>"
							/>
						</liferay-ui:custom-attributes-available>

						<c:if test="<%= true %>">
							<portlet:actionURL var="updateEntryContent">
								<portlet:param name="struts_action" value="/blogs/edit_entry" />
								<portlet:param name="CMD" value="UPDATE_CONTENT" />
								<portlet:param name="entryId" value="entryId" />
							</portlet:actionURL>

							<liferay-ui:input-editor
								editorImpl="ckeditor"
								inlineEdit="<%= true %>"
								inlineEditSaveURL="<%= testURL %>"
								name=" entryContentId"
							/>
						</c:if>
					</c:when>
					<c:when test='true'>
						<aui:a href="<%= testURL %>"><h6>view entry url</h6></aui:a>
					</c:when>
				</c:choose>
			</div>

			<div class="entry-footer">
				<div class="entry-author">
					<liferay-ui:message key="written-by" /><h6>get username</h6>
				</div>

				<div class="stats">
					<c:if test="true">
						<span class="view-count">
							<c:choose>
								<c:when test="true">
									<h2>show info</h2>
								</c:when>
								<c:when test="true">
									<h2>show info2</h2>
								</c:when>
							</c:choose>
						</span>
					</c:if>
				</div>

				<span class="entry-categories">
					<liferay-ui:asset-categories-summary
						className="class name"
						classPK="110"
						portletURL="<%= renderResponse.createRenderURL() %>"
					/>
				</span>

				<span class="entry-tags">
					<liferay-ui:asset-tags-summary
						className="classname"
						classPK="12"
						portletURL="<%= renderResponse.createRenderURL() %>"
					/>
				</span>

				<c:if test='true'>
					<c:if test="true">
						<div class="entry-links">
							<liferay-ui:asset-links
								assetEntryId="13"
								className="className"
								classPK="14"
							/>
						</div>
					</c:if>

				</c:if>
			</div>
		</div>

		<div class="separator"><!-- --></div>
	</c:when>
</c:choose>