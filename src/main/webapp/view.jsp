<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects/>
<portlet:actionURL var="addTankURL" windowState="maximized" name="addTank">
</portlet:actionURL>

<portlet:actionURL var="updateTankURL" windowState="maximized" name="updateTank">
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
            </div class="updateTankFormDiv" id="updateTankFormDiv">
                <aui:form action="<%=updateTankURL%>" name="updateTankForm" method="PUT">
                    <table>
                        <tbody>
                            <tr>
                                <td><aui:input type="hidden" id="updateTankId" name="updateTankId" value=""/></td>
                            </tr>
                            <tr>
                                <td><aui:input type="text" id="updateTankNumber" name="updateTankNumber" value="i" label="Tank Number"/></td>
                            </tr>
                            <tr>
                                <td><aui:input type="text" id="updateTankModification" name="updateTankModification" value="" label="Tank Modification"/></td>
                            </tr>
                            <tr>
                                <td><aui:input type="number" id="updateTankPrice" name="updateTankPrice" value="" label="Tank Price"/></td>
                            </tr>
                            <tr>
                                <td>
                                	<aui:input type="submit" name="submit" value="Update tank" label=""/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </aui:form>

            </div>
            <input type="button" value="Update" name="di" id="<portlet:namespace />update" onClick="<portlet:namespace />fillInUpdateForm(10, 'work', 'why', 6547);" />
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
        <aui:script use="aui-base">
                                    function <portlet:namespace />fillInUpdateForm(tankId, number, modification, price){
                                                alert("work");
                                                    alert(tankId + " " + number + " " + modification + " " + price);
                                                    A.one('#updateTankId').set(tankId);
                                                    A.one('#updateTankNumber').set(number);
                                                    A.one('#updateTankModification').set(modification);
                                                    A.one('#updateTankPrice').set(price);
                                                }

            var A = AUI();
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
                                    var strNumber = "\'" + obj.number + "\'";
                                    var strMod = "\'" + obj.modification + "\'";
                                //    stringHtml += "<td class=\"grey\">" + "<input type=\"button\" value=\"Update\" onClick=" + "\"fillInUpdateForm(" + obj.tankId + ", " + strNumber + ", " + strMod + ", " + obj.price + ")\"" + ">";
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

        </aui:script>

    </body>
</html>
