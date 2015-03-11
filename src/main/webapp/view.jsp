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

<portlet:renderURL var="chooseAnUserURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<portlet:resourceURL var="getNamesOfUsersURL">
    <portlet:param name="flag" value="allNames" />
</portlet:resourceURL>

<portlet:resourceURL var="getFilesURL">
    <portlet:param name="flag" value="fileNames" />
</portlet:resourceURL>

<portlet:resourceURL var="currentUsersEntriesURL">
    <portlet:param name="flag" value="currentUsersEntries" />
</portlet:resourceURL>

<portlet:actionURL var="testURL" name="test">
</portlet:actionURL>

<liferay-theme:defineObjects />

    <!---------------------------start of add Pop up------------------------------------>
    <div id="addPopupOverlay" class="popup__overlay">
        <div id="addPopup" class="popup">
            <a href="#" id="addPopupClose" class="popup__close">X</a>
               <%@ include file="/add.jsp" %>
        </div>
    </div>
   <!---------------------------end of add Pop up-------------------------------------->

    <!---------------------------start of report Pop up------------------------------------>
    <div id="reportPopupOverlay" class="popup__overlay">
        <div id="reportPopup" class="popup">
            <a href="#" id="reportPopupClose" class="popup__close">X</a>
               <%@ include file="/report.jsp" %>
        </div>
    </div>
   <!---------------------------end of report Pop up-------------------------------------->

  <%
    Long flagOfUserId = null;
    Boolean flag = false;
    flagOfUserId = (Long)request.getAttribute("flagOfUserId");
    String strUserId = null;

        if(flagOfUserId != null && flagOfUserId != 0){

            if(flagOfUserId != null){
                flag = true;
                strUserId = flagOfUserId.toString();
            }
        }
  %>

  <portlet:actionURL var="allEntriesURL" name="showAll">
      <portlet:param name="userId" value='<%=strUserId%>'/>
  </portlet:actionURL>

<div id="main" class="main" name="main" >
<div class="topContainer" class="aui">

        <a href="<%=chooseAnUserURL%>" id="chooseAnUserHref">
            <button class="btn btn-primary" id="chooseAnUser"><liferay-ui:message key="choose_an_user" /></button>
        </a>
        <button class="btn btn-primary" id="popup__toggle"  ><liferay-ui:message key="add_entry" /></button>
        <button class="btn btn-primary" id="reportPopupToggle"><liferay-ui:message key="create_report" /></button>
        <a href="<%=allEntriesURL%>" id="showAllHref">
            <button class="btn btn-primary" id="showAll"><liferay-ui:message key="show_all"/></button>
        </a>
        <div id="datePicker">
            <ul class="edit-actions entry icons-container lfr-meta-actions">
                <li>
                    <label for="fromDate" id="fromDateLabel"><liferay-ui:message key="from_date" /><span class="aui-icon icon-required"></span></label>
                </li>
                <li>
                    <input class="text short-field" type="text" id="fromDate" name="d-fromDate" title='<liferay-ui:message key="from_date" />'>
                </li>
            </ul>
            <ul  class="edit-actions entry icons-container lfr-meta-actions">
                <li>
                    <label for="toDate" id="toDateLabel"><liferay-ui:message key="to_date" /><span class="aui-icon icon-required"></span></label>
                </li>
                <li>
                    <input class="text short-field" type="text" id="toDate" name="toDate" title='<liferay-ui:message key="to_date" />'>
                </li>
                <li>
                     <label for="tags" id="labelForTags1"><liferay-ui:message key="by_content"/></label>
                     <label for="tags" id="labelForTags2"><liferay-ui:message key="by_name"/></label>
                </li>
                <li>
                    <input class="text" type="text" id="tags" name="d-fname"/>
                </li>
            </ul>
        </div>

            <button class="btn btn-primary" id="find_an_entry"  ><liferay-ui:message key="find_an_entry"/></button>
        </div>

    <div id="anchor">
    </div>
</div>

<div id="filesField" class="filesField">
    <div class="alert alert-info">
        <liferay-ui:message key="list_of_reports"/>
    </div>
</div>
  <link rel="stylesheet" href="/mine/css/jquery-ui.css">
  <script src="/mine/js/jquery-1.10.2.js"></script>
  <script src="/mine/js/jquery-ui.js"></script>

<aui:script use="liferay-portlet-url, liferay-search-container, aui-node, liferay-service, aui-pagination">
    var flagOfUserId = 0;
	var stringHtml = "";
	var entryAmount = 0;
	var pageAmount = 0;
	var entryCounter = 0;
	var currentPage = 0;
	var data;
	var searchPartOfData = [];
	var arrayOfNamesAndIdOfUsers = [];
	var arrayOfNamesOfUsers = [];
	var tempArray;
	var flagOfStateOfSearch = "byUser";
	var arrayOfIdForReport = [];
	var arrayOfFileNames = [];

     AUI().ready(
                    function() {
                        setFiles();
                        if(0){
                           //if an user is an administrator
                           //to get names of users from server

                            $('#popup__toggle').hide();
                            $('#showAllHref').hide();


                            if(<%=flag == false%>){
                                AUI().use('aui-base','aui-io-request', function(A){

                                    $('#note_content').hide();

                                    $('#fromDate').hide();
                                    $('#toDate').hide();
                                    $('#fromDateLabel').hide();
                                    $('#toDateLabel').hide();
                                    $('#labelForTags1').hide();
                                    $('#find_an_entry').hide();
                                    $('#reportPopupToggle').hide();
                                    A.io.request('<%=getNamesOfUsersURL%>',{
                                        dataType: 'json',
                                        method: 'POST',
                                        on: {
                                            success: function() {
                                                arrayOfNamesAndIdOfUsers = this.get('responseData');

                                                A.Array.each(arrayOfNamesAndIdOfUsers, function(obj, idx){
                                                    arrayOfNamesOfUsers.push(obj.userName);
                                                });

                                                $( "#tags" ).autocomplete({
                                                    source: arrayOfNamesOfUsers
                                                });
                                            }
                                        }
                                    });
                                });
                            } else {

                                $('#fromDate').show();
                                $('#toDate').show();
                                $('#fromDateLabel').show();
                                $('#toDateLabel').show();
                                $('#labelForTags1').show();
                                $('#labelForTags2').hide();

                                $('#find_an_entry').show();
                                $('#popup__toggle').hide();
                                $('#showAllHref').hide();
                                $('#reportPopupToggle').show();
                                $('#note_content').show();
                                var resURL = Liferay.PortletURL.createResourceURL();
                                resURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId()%>');

                                resURL.setParameter("userId", <%=flagOfUserId%>);
                                resURL.setParameter("flag", "userEntries");

                                getEntriesByAjax(resURL);
                            }

                        } else{
                            //если зашёл не админ  то показываем записи юзера, который авторизовался
                            $('#showAllHref').hide();
                            $('#chooseAnUserHref').hide();
                            $('#labelForTags2').hide();

                            var resURL = Liferay.PortletURL.createResourceURL();
                            resURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId()%>');

                            resURL.setParameter("userId", '<%= com.liferay.portal.util.PortalUtil.getUserId(request)%>');
                            resURL.setParameter("flag", "userEntries");



                            getEntriesByAjax(resURL);
                        }
                    }
     );

    $( "#fromDate" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
    $( "#fromDate" ).datepicker( "setDate", getCurrentFormattedDate());
    $( "#toDate" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
    $( "#toDate" ).datepicker( "setDate", getCurrentFormattedDate());

     function setFiles(){
        AUI().use('aui-base','aui-io-request', function(A){
            A.io.request('<%=getFilesURL%>',{
                dataType: 'json',
                    method: 'POST',
                        on: {
                            success: function() {
                                arrayOfFileNames = this.get('responseData');

                                stringHtml = "";

                                A.Array.each(arrayOfFileNames, function(obj, idx){

                                    var resFileURL = Liferay.PortletURL.createResourceURL();
                                    resFileURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId()%>');
                                    resFileURL.setParameter("fileNameToDownload", obj);

                                    stringHtml += "<span><a href='" + resFileURL + "'><button class='btn btn-lg btn-block btn-primary' type='button'><b>" + trimFileName(obj) + "</b></button>" + "</a><br></span>";
                                });

                                document.getElementById('filesField').innerHTML += stringHtml;
                                stringHtml = "";
                            }
                        }
            });
        });
     }


        function getEntriesByAjax(url){
            AUI().use('aui-base','aui-io-request', function(A){
                A.io.request(url.toString(),{
                    dataType: 'json',
                    method: 'POST',
                    on: {
                        success: function() {
                            data = this.get('responseData');

                            arrayOfIdForReport = [];

                            A.Array.each(data, function(obj, idx){
                                document.getElementById('anchor').innerHTML += addEntry(obj.entryId, obj.userId, obj.groupId,
                                    obj.companyId, obj.userName, obj.title, obj.entryText, obj.entryDate);

                                arrayOfIdForReport[idx] = obj.entryId;
                            });
                        }
                    }
                });
            });
        }

        $('#find_an_entry').click(function(){
            $('#showAllHref').show();
            $('#anchor').empty();

            var fromDate = formatDate($( "#fromDate" ).datepicker( "getDate" ));
            var toDate = formatDate($('#toDate').datepicker("getDate"));
            var filteredArray = [];
            var i = 0;
            var entryDate;

            arrayOfIdForReport = [];

            for(var idx in data){

                entryDate = formatDate(new Date(data[idx].entryDate));

                if((entryDate >= fromDate && entryDate <= toDate) && ((data[idx].title.indexOf($( "#tags" ).val()) + 1) || (data[idx].entryText.indexOf($( "#tags" ).val()) + 1))){
                    document.getElementById('anchor').innerHTML += addEntry(data[idx].entryId, data[idx].userId, data[idx].groupId,
                                            data[idx].companyId, data[idx].userName, data[idx].title, data[idx].entryText, data[idx].entryDate);

                    arrayOfIdForReport[i] = data[idx].entryId;
                    i++;
                }
            }
        });

    $( "#tags" ).autocomplete({
        select:
            function( event, ui ) {

                $('#anchor').empty();

                var showAllURL = Liferay.PortletURL.createActionURL();
                showAllURL.setParameter('p_auth', Liferay.authToken);

                showAllURL.setPortletId('${themeDisplay.portletDisplay.rootPortletId}');
                showAllURL.setWindowState('normal');
                showAllURL.setName('showAll');

                var resURL = Liferay.PortletURL.createResourceURL();
                resURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId()%>');

                for(var idx in arrayOfNamesAndIdOfUsers){
                    if(ui.item.value == arrayOfNamesAndIdOfUsers[idx].userName){
                        resURL.setParameter("userId", arrayOfNamesAndIdOfUsers[idx].userId);
                        showAllURL.setParameter('userId', arrayOfNamesAndIdOfUsers[idx].userId);
                        resURL.setParameter("flag", "userEntries");
                    }
                }

                getEntriesByAjax(resURL);

                flagOfStateOfSearch = "byContent";
                $('#showAllHref').attr('href', showAllURL.toString());
                $( "#tags" ).autocomplete({
                    disabled: true
                });

                $('#note_content').show();
                $('#showAllHref').hide();

                $('#fromDate').show();
                $('#toDate').show();
                $('#fromDateLabel').show();
                $('#toDateLabel').show();

                $('#reportPopupToggle').show();

                $('#find_an_entry').show();
                $('#labelForTags1').show();
                $('#labelForTags2').hide();

            }
    });

    $('#reportPopupToggle').click(function(){
        $('#<portlet:namespace/>entriesIds').val(arrayOfIdForReport.toString());
    });

     function addEntry(entryId, userId, groupId, companyId, userName1, title1, entryText1, entryDate1){
            stringHtml = "";
			var entryDate = new Date(entryDate1);
			var title = new String(title1);
			var userName = new String(userName1);
			var entryText = new String(entryText1);
			var showEntryUrl = createShowEntryURL(entryId, userId, groupId, companyId, userName, title, entryText, entryDate);
            var editUrl = createEditEntryURL(entryId, userId, groupId, companyId, userName, title, entryText, entryDate);
            var deleteUrl = createDeleteURL(entryId);

			stringHtml += '<div class="entry">';
			stringHtml += '<div class="separator"><!-- --></div>';
			stringHtml += '<div  class="entry-content">';
			stringHtml += '<div class="entry-date">';
			stringHtml += '<ul class="edit-actions entry icons-container lfr-meta-actions"><li class="date-entry"><span class="aui-icon aui-icon-small aui-iconfont-teamcals"></span>';
            stringHtml += ' ' + entryDate.getDate() + '-' + (entryDate.getMonth() + 1) + '-' + (entryDate.getYear() + 1900) + '</li>';
            stringHtml += '<li class="edit-entry">';
            stringHtml += '<a href="' + editUrl + '"><span class="aui-icon aui-icon-small aui-iconfont-edit"></span><liferay-ui:message key="edit" /></a></li>';
            stringHtml += '<li class="delete-entry">';
            stringHtml += '<a href="' + deleteUrl + '"><span class="aui-icon aui-icon-small aui-iconfont-remove"></span><liferay-ui:message key="delete" /></a></li>';
            stringHtml += '<li><div class="entry-author"><span class="aui-icon aui-icon-small aui-iconfont-group"></span> by' + userName + '</div></li></ul>';
            stringHtml += '<br clear="all"><div class="entry-title"><a href="' + showEntryUrl + '"><h3>' + title + '</h3></a></div>';
            stringHtml += '<div class="entry-body"><h4>' + entryText + '</h4></div></div></div>';
            stringHtml += '</div>';
            return stringHtml;
     }

    function createEditEntryURL(entryId, userId, groupId, companyId, userName1, title, entryText, entryDate){
			var editEntryURL = new Liferay.PortletURL.createRenderURL();
			var userName = new String(userName1);
            editEntryURL.setParameter('jspPage', '/edit.jsp');
            editEntryURL.setParameter('entryId', entryId);
            editEntryURL.setParameter('userId', userId);
            editEntryURL.setParameter('groupId', groupId);
            editEntryURL.setParameter('companyId', companyId);
            editEntryURL.setParameter('userName', new String(userName).toString());
            editEntryURL.setParameter('title', new String(title).toString());
            editEntryURL.setParameter('entryText', new String(entryText).toString());
            editEntryURL.setParameter('entryDate', new Date(entryDate).toString());
            editEntryURL.setParameter('add_flag', new String("false").toString());
            editEntryURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId()%>');
            return editEntryURL.toString();
    }

    function createShowEntryURL(entryId, userId, groupId, companyId, userName, title, entryText, entryDate){
			var showEntryURL = new Liferay.PortletURL.createRenderURL();
            showEntryURL.setParameter('jspPage', '/showEntry.jsp');
            showEntryURL.setParameter('entryId', entryId);
            showEntryURL.setParameter('userId', userId);
            showEntryURL.setParameter('groupId', groupId);
            showEntryURL.setParameter('companyId', companyId);
            showEntryURL.setParameter('userName', new String(userName).toString());
            showEntryURL.setParameter('title', new String(title).toString());
            showEntryURL.setParameter('entryText', new String(entryText).toString());
            showEntryURL.setParameter('entryDate', new Date(entryDate).toString());
            showEntryURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId()%>');
            return showEntryURL.toString();
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
