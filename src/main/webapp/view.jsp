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

<portlet:resourceURL var="resourceURL">
</portlet:resourceURL>

<portlet:actionURL var="updateEntry" name="updateEntry">
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

<portlet:renderURL var="testURL">
    <portlet:param name="mvcPath" value="/test.jsp"/>
    <liferay-portlet:param name="add_flag" value="true"/>
</portlet:renderURL>

<a href="<%=testURL%>">Test</a>

<c:if test="true">
	<aui:nav-bar>
		<c:if test="true">
		                <div class="spacer"></div>
			<aui:nav>
                <button class="aui-button aui-button-subtle" id="popup__toggle"  >
                 Add entry</button>
			</aui:nav>
		</c:if>

		<c:if test="true">
			<aui:nav-bar-search cssClass="pull-right">
				<div class="form-search">
					  <input class="text" type="text" id="tags" name="d-fname" title="Choose a user"><!--<button class="aui-button" onClick="resetData()">Button</button>-->
				</div>
			</aui:nav-bar-search>
		</c:if>
	</aui:nav-bar>
</c:if>

<div id="anchor">
</div>
<div id="pager"></div>

  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<aui:script use="liferay-portlet-url, liferay-search-container, aui-node, liferay-service, aui-pagination">

	var stringHtml = "";
	var entryAmount = 0;
	var pageAmount = 0;
	var entryCounter = 0;
	var currentPage = 0;
	var data;
	var searchPartOfData = [];
	var tempArray;

     AUI().ready(
                    function() {
                         AUI().use('aui-base','aui-io-request', function(A){
                                A.io.request('<%=resourceURL%>',{
                                    dataType: 'json',
                                    method: 'GET',
                                    on: {
                                        success: function() {
                                            data=this.get('responseData');

                                            entryAmount = data.length;
                                            if(entryAmount % 2 != 0){
                                               pageAmount = Math.ceil(entryAmount/ 2);
                                            } else {
                                                pageAmount = Math.floor(entryAmount / 2);
                                            }

                                            A.Array.each(data, function(obj, idx){
                                                  document.getElementById('anchor').innerHTML += addEntry(obj.entryId, obj.userId, obj.groupId,
                                                        obj.companyId, obj.userName, obj.title, obj.entryText, obj.entryDate, idx);

                                            });


                                        }
                                    }
                                });
                         });
                        }
                );

$(setTimeout(fillSearch, 2000));

function unique(arr) {
  var obj = {};

  for(var i=0; i<arr.length; i++) {
    var str = arr[i];
    obj[str] = true;
  }

  return Object.keys(obj);
}

    function fillSearch() {
        var availableTags=[];

        for (var idx in data) {
            availableTags.push(data[idx].userName);
        }

        availableTags = unique(availableTags);

        $( "#tags" ).autocomplete({
          source: availableTags
        });
      }

        $( "#tags" ).autocomplete({
          select: function( event, ui ) {

          for(var idx in data){
            if(data[idx].userName == ui.item.value){
                searchPartOfData.push(data[idx]);
            }

          }

            $('#anchor').empty();

       for(var idx in searchPartOfData){

            document.getElementById('anchor').innerHTML += addEntry(searchPartOfData[idx].entryId, searchPartOfData[idx].userId, searchPartOfData[idx].groupId,
                                                        searchPartOfData[idx].companyId, searchPartOfData[idx].userName, searchPartOfData[idx].title, searchPartOfData[idx].entryText, searchPartOfData[idx].entryDate);

       }

        searchPartOfData = [];
           // alert( ui.item.value);
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

			stringHtml += '<div class="entry">';
			stringHtml += '<div class="separator"><!-- --></div>';
			stringHtml += '<div class="entry-content">';
			stringHtml += '<div class="entry-date">';
			stringHtml += '<ul class="edit-actions entry icons-container lfr-meta-actions"><li class="date-entry"><span class="aui-icon aui-icon-small aui-iconfont-time"></span>';
            stringHtml += ' ' + entryDate.getDate() + '-' + (entryDate.getMonth() + 1) + '-' + (entryDate.getYear() + 1900) + '</li>';
            stringHtml += '<li class="edit-entry">';
            stringHtml += '<a href="' + editUrl + '"><span class="aui-icon aui-icon-small aui-iconfont-edit"></span>Edit</a></li>';
            stringHtml += '<li class="delete-entry">';
            stringHtml += '<a href="' + deleteUrl + '"><span class="aui-icon aui-icon-small aui-iconfont-remove"></span>Delete</a></li>';
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

     function resetData(){
            //alert(document.getElementById('tags').value);
        }




        p = $('.popup__overlay');
        $('#popup__toggle').click(function() {
            p.css('display', 'block');
        });
        p.click(function(event) {
            e = event || window.event;
            if (e.target == this) {
                $(p).css('display', 'none');
            }
        });
        $('.popup__close').click(function() {
            p.css('display', 'none');
        });

    </script>