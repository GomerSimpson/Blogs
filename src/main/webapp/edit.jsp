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

<b>Page of editing of an entry</b>

<div class="content">
  <div id="1">
    <h3>Page 1</h3>
    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
  </div>
  <div id="2">
    <h3>Page 2</h3>
    Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
  </div>
  <div id="3">
    <h3>Page 3</h3>
    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
  </div>
</div>

<div id="pagination">
  <ul class="pagination pagination-content">
    <li><a href="#">Prev</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">Next</a></li>
  </ul>
</div>

<link href="http://cdn.alloyui.com/2.5.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>


<aui:script>
 //   alert("edit.jsp" + '<%= request.getParameter("userId") %>, <%= request.getParameter("entryDate") %>');

                                                    var e = document.getElementById(2);
                                                        e.style.display = 'none';
                                                        var e = document.getElementById(3);
                                                                                                                e.style.display = 'none';

    YUI().use(
      'aui-pagination',
      function(Y) {
        var pages = Y.all('.content div');

        new Y.Pagination(
          {
            boundingBox: '#pagination',
            circular: false,
            contentBox: '#pagination .pagination-content',
            on: {
              changeRequest: function(event) {
                var instance = this,
                    state = event.state,
                    lastState = event.lastState;

                if (lastState) {
                    pages.item(lastState.page - 1).setStyle('display', 'none');
                }

                pages.item(state.page - 1).setStyle('display', 'block');
              }
            },
            page: 1
          }
        ).render();
      }
    );
</aui:script>