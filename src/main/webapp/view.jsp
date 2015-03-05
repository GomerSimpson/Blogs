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

<portlet:renderURL var="redirectThisPageURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<portlet:resourceURL var="getNamesOfUsersURL">
    <portlet:param name="flag" value="allNames" />
</portlet:resourceURL>

<portlet:resourceURL var="currentUsersEntriesURL">
    <portlet:param name="flag" value="currentUsersEntries" />
</portlet:resourceURL>

<portlet:actionURL var="testURL" name="test">
</portlet:actionURL>

<liferay-theme:defineObjects />

    <!---------------------------start of Pop up------------------------------------>
    <div class="popup__overlay">
        <div class="popup">
            <a href="#" class="popup__close">X</a>
               <%@ include file="/add.jsp" %>
        </div>
    </div>
   <!---------------------------end of Pop up-------------------------------------->
<div id="main" name="main" style="text-align: center;">
<!--<a href="<%=redirectThisPageURL%>">Back</a>-->
<a href="<%=testURL%>">Back</a>
<portlet:renderURL var="testURL">
    <portlet:param name="mvcPath" value="/test.jsp"/>
    <liferay-portlet:param name="add_flag" value="true"/>
</portlet:renderURL>
<div class="topContainer">
    <button class="btn btn-primary" id="popup__toggle"  ><liferay-ui:message key="add_entry" /></button>
    <div id="datePicker">
        <label for="fromDate">From</label>
        <input type="text" id="fromDate">
        <label for="toDate">To</label>
        <input type="text" id="toDate">
    </div>

	<div class="form-search">
	    <input class="text" type="text" id="tags" name="d-fname" title="Choose a user">
	</div>
	    <button class="btn btn-primary" id="find_an_entry"  >Find an entry</button>

</div>

<div id="anchor" style="text-align: center;">
</div>
<div id="pager"></div>
</div>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>

  <%
    Long str = request.getAttribute("flagOfUserId");
    out.println(str instance of Long);

    Boolean flag = null;

    if(str != null){
    out.println("str " + str);
        Long flagOfUserId = Long.parseLong(str);

        if(flagOfUserId != null){
            flag = true;
        }
    }
  %>

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

     AUI().ready(
                    function() {

                        if(1){
                           //if an user is an administrator
                           //to get names of users from server

                            $('#datePicker').hide();
                            $('#find_an_entry').hide();
                                alert(<%=flag%>);
                                alert('quotted ' + '<%=flag%>');

                            if(<%=flag%>){
                                alert("work");
                            } else{
                                alert('doesnt work');
                            }

                            if(flagOfUserId == 0)
                                AUI().use('aui-base','aui-io-request', function(A){
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

                        } else{
                            //если зашёл не админ  то показываем записи юзера, который авторизовался
                            getEntriesByAjax('<%=currentUsersEntriesURL%>');
                        }
                    }
        );

        //$(setTimeout(prepareSearch, 2000));

        function getEntriesByAjax(url){
            AUI().use('aui-base','aui-io-request', function(A){
                A.io.request(url.toString(),{
                    dataType: 'json',
                    method: 'POST',
                    on: {
                        success: function() {
                            data = this.get('responseData');

                            A.Array.each(data, function(obj, idx){
                                document.getElementById('anchor').innerHTML += addEntry(obj.entryId, obj.userId, obj.groupId,
                                    obj.companyId, obj.userName, obj.title, obj.entryText, obj.entryDate);
                            });
                        }
                    }
                });
            });
        }

        $(function() {
            $( "#fromDate" ).datepicker({
              showOtherMonths: true,
              numberOfMonths: 1,
              onClose: function( selectedDate ) {
                $( "#toDate" ).datepicker( "option", "minDate", selectedDate );
              }
            });
            $( "#toDate" ).datepicker({
              showOtherMonths: true,
              numberOfMonths: 1,
              onClose: function( selectedDate ) {
                $( "#fromDate" ).datepicker( "option", "maxDate", selectedDate );
              }
            });
          });

        $( "#fromDate" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
        $( "#fromDate" ).datepicker( "setDate", getCurrentFormattedDate() );
        $( "#toDate" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
        $( "#toDate" ).datepicker( "setDate", getCurrentFormattedDate() );

        $('#find_an_entry').click(function(){

            $('#anchor').empty();

            var fromDate = formatDate($( "#fromDate" ).datepicker( "getDate" ));
            var toDate = formatDate($('#toDate').datepicker("getDate"));
            var filteredArray = [];
            var i = 0;
            var entryDate;

            for(var idx in data){

                entryDate = formatDate(new Date(data[idx].entryDate));

                if((entryDate >= fromDate && entryDate <= toDate) && ((data[idx].title.indexOf($( "#tags" ).val()) + 1) || (data[idx].entryText.indexOf($( "#tags" ).val()) + 1))){
                    document.getElementById('anchor').innerHTML += addEntry(data[idx].entryId, data[idx].userId, data[idx].groupId,
                                            data[idx].companyId, data[idx].userName, data[idx].title, data[idx].entryText, data[idx].entryDate);
                }
            }
        });

    $( "#tags" ).autocomplete({
        select:
            function( event, ui ) {

                $('#anchor').empty();

                var resURL = Liferay.PortletURL.createResourceURL();
                resURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId()%>');

                for(var idx in arrayOfNamesAndIdOfUsers){
                    if(ui.item.value == arrayOfNamesAndIdOfUsers[idx].userName){
                        resURL.setParameter("userId", arrayOfNamesAndIdOfUsers[idx].userId);
                        resURL.setParameter("flag", "userEntries");
                    }
                }

                getEntriesByAjax(resURL);

                flagOfStateOfSearch = "byContent";

                $( "#tags" ).autocomplete({
                    disabled: true
                });

                $('#datePicker').show();
                $('#find_an_entry').show();

            }
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

			stringHtml += '<div class="entry" style="text-align: center;">';
			stringHtml += '<div class="separator"><!-- --></div>';
			stringHtml += '<div class="entry-content" style="text-align: center;">';
			stringHtml += '<div class="entry-date">';
			stringHtml += '<ul class="edit-actions entry icons-container lfr-meta-actions"><li class="date-entry"><span class="aui-icon aui-icon-small aui-iconfont-time"></span>';
            stringHtml += ' ' + entryDate.getDate() + '-' + (entryDate.getMonth() + 1) + '-' + (entryDate.getYear() + 1900) + '</li>';
            stringHtml += '<li class="edit-entry">';
            stringHtml += '<a href="' + editUrl + '"><span class="aui-icon aui-icon-small aui-iconfont-edit"></span><liferay-ui:message key="edit" /></a></li>';
            stringHtml += '<li class="delete-entry">';
            stringHtml += '<a href="' + deleteUrl + '"><span class="aui-icon aui-icon-small aui-iconfont-remove"></span><liferay-ui:message key="delete" /></a></li>';
            stringHtml += '<li><div class="entry-author"><span class="aui-icon aui-icon-small aui-iconfont-group"></span> by' + userName + '</div></li></ul>';
            stringHtml += '<div class="entry-title"><a href="' + showEntryUrl + '"><h3>' + title + '</h3></a></div>';
            stringHtml += '<div class="entry-body">' + entryText + '</div></div></div>';
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
        var string = "";

</aui:script>

    <script type="text/javascript">

        p = $('.popup__overlay');
        $('#popup__toggle').click(function() {
                $('#main').hide();
            p.css('display', 'block');
        });

        p.click(function(event) {
            e = event || window.event;
            if (e.target == this) {
                $('#main').show();
                $(p).css('display', 'none');
            }
        });

        $('.popup__close').click(function() {
            $('#main').show();
            p.css('display', 'none');
        });

    </script>