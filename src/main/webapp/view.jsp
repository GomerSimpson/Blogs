<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects/>
<portlet:actionURL var="addTankURL" windowState="maximized" name="addTank">
</portlet:actionURL>

<portlet:actionURL var="getAllTanksURL" windowState="normal" name="getAllTanks">
</portlet:actionURL>

<portlet:resourceURL var="res" >
</portlet:resourceURL>

<!DOCTYPE html>

<html>
    <head>
            <title>Tanks Page</title>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>

        <div class="mainDiv" id="mainDiv">
            <div class="addTankFormDiv" id="addTankFormDiv">
                <aui:form action="<%=addTankURL%>" name="addTankForm" method="POST">
                    <table>
                        <tbody>
                            <tr>
                                <td><aui:input type="text" id="addTankNumber" name="addTankNumber" value="i" label="Tank Number"/></td>
                            </tr>
                            <tr>
                                <td><aui:input type="text" id="addTankModification" name="addTankModification" value="" label="Tank Modification"/></td>
                            </tr>
                            <tr>
                                <td><aui:input type="number" id="addTankPrice" name="addTankPrice" value="" label="Tank Price"/></td>
                            </tr>
                            <tr>
                                <td>
                                	<aui:input type="submit" name="submit" value="Add Tank" label=""/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </aui:form>
            </div>
            <div id="mainTableDiv" class="mainTableDiv">
                <table class="features-table" id="mainTable" summary="List of tanks.">
                            <caption>Tanks</caption>
                                <tr>
                                    <td><h2>Number</h2></td>
                                    <td><h2>Modification</h2></td>
                                    <td><h2>Price</h2></td>
                                    <td><h2>Equipment</h2></td>
                                </tr>
                                <tbody>

                                </tbody>
                </table>
        </div>
        <script>
            var stringHtml = "";
            var localStringHtml = "";
            var data;

            AUI().ready(
                function() {


                 AUI().use('aui-base','aui-io-request', function(A){
                        A.io.request('<%=res%>',{
                            dataType: 'json',
                            method: 'GET',
                            on: {
                            success: function() {
                                data=this.get('responseData');
                                A.Array.each(data, function(obj, idx){

                                    stringHtml += "<tr><td class=\"grey\">" + obj.number;
                                    stringHtml += "<td class=\"green\">"  + obj.modification;
                                    stringHtml += "<td class=\"green\">" + obj.price;

                                    localStringHtml += "<td class=\"green\">";
                                    A.Array.each(obj.equipment, function(eq, idx){
                                        localStringHtml += eq.modification + "<br/>";
                                    });

                                    stringHtml += localStringHtml;
                                    document.getElementById('mainTable').innerHTML += stringHtml;
                                    localStringHtml = "";
                                    stringHtml = "";
                                });

                            }

                            }
                        });
                 });

                }
            );

            function setRowHtml(obj){

                    var localStringHtml = "";
                    localStringHtml += "<tr><td class=\"grey\">" + obj.number;
                    localStringHtml += "<td class=\"green\">"  + obj.modification;
                    localStringHtml += "<td class=\"green\">" + obj.price;

                return localStringHtml;
            }

        </script>

    </body>
</html>
