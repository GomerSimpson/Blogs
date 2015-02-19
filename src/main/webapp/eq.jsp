<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects/>
<portlet:actionURL var="addEquipmentURL" windowState="maximized" name="addEquipment">
    <portlet:param name="mvcPath" value="/eq.jsp"/>
</portlet:actionURL>

<portlet:actionURL var="updateEquipmentURL" windowState="maximized" name="updateEquipment">
    <portlet:param name="mvcPath" value="/eq.jsp"/>
</portlet:actionURL>

<portlet:resourceURL var="res" >
    <portlet:param name="getEntities" value="equipment" />
</portlet:resourceURL>

<!DOCTYPE html>

<html>
    <head>
            <title>Equipment Page</title>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>

        <div class="mainDiv" id="mainDiv">
            <div class="addTankFormDiv" id="addEquipmentFormDiv">
                <aui:form action="<%=addEquipmentURL%>" name="addEquipmentForm" method="POST">
                    <table>
                        <tbody>
                            <tr>
                                <td><aui:input type="text" id="addEquipmentModification" name="addEquipmentModification" value="" label="Equipment Modification"/></td>
                            </tr>
                            <tr>
                                <td><aui:input type="number" id="addEquipmentPrice" name="addEquipmentPrice" value="" label="Equipment Price"/></td>
                            </tr>
                            <tr>
                                <td><aui:input type="number" id="addTankId" name="addTankId" value="" label="Tank id"/></td>
                            </tr>
                            <tr>
                                <td>
                                	<aui:input type="submit" name="submit" value="Add Equipment" label=""/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </aui:form>
            </div>
            </div class="updateTankFormDiv" id="updateEquipmentFormDiv">
                <aui:form action="<%=updateEquipmentURL%>" name="updateEquipmentForm" method="POST">
                    <table>
                        <tbody>
                            <tr>
                                <td><aui:input type="hidden" id="updateEquipmentId" name="updateEquipmentId" value=""/></td>
                            </tr>
                            <tr>
                                <td><aui:input type="text" id="updateEquipmentModification" name="updateEquipmentModification" value="" label="Equipment Modification"/></td>
                            </tr>
                            <tr>
                                <td><aui:input type="number" id="updateEquipmentPrice" name="updateEquipmentPrice" value="" label="Equipment Price"/></td>
                            </tr>
                            <tr>
                                <td><aui:input type="number" id="updateTankId" name="updateTankId" value="" label="TankId"/></td>
                            </tr>
                            <tr>
                                <td>
                                	<aui:input type="submit" name="submit" value="Update Equipment" label=""/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </aui:form>

            </div>
            <div id="mainTableDiv" class="mainTableDiv">
                <table class="features-table" id="mainTable" summary="List of equipment.">
                            <caption>Tanks</caption>
                                <tr>
                                    <td><h2>Modification</h2></td>
                                    <td><h2>Price</h2></td>
                                    <td><h2>Tank Id</h2></td>
                                </tr>
                                <tbody>

                                </tbody>
                </table>
        </div>
        <script>

            function fillInUpdateForm(equipmentId, modification, price, tankId){
                A.one('#<portlet:namespace/>updateEquipmentId').set('value', equipmentId);
                A.one('#<portlet:namespace/>updateEquipmentModification').set('value', modification);
                A.one('#<portlet:namespace/>updateEquipmentPrice').set('value', price);
                A.one('#<portlet:namespace/>updateTankId').set('value', tankId);
            }

            var A = AUI();
            var stringHtml = "";
            var data;

            AUI().ready(
                function() {

                 AUI().use('aui-base','aui-io-request', function(A){
                        A.io.request('<%=res%>',{
                            dataType: 'json',
                            method: 'GET',
                            on: {
                            success: function() {
                                data = this.get('responseData');

                                A.Array.each(data, function(obj, idx){

                                    stringHtml += "<td class=\"green\">"  + obj.modification;
                                    stringHtml += "<td class=\"green\">" + obj.price;
                                    stringHtml += "<td class=\"green\">" + obj.tankId;

                                    var strNumber = "\'" + obj.number + "\'";
                                    var strMod = "\'" + obj.modification + "\'";
                                    stringHtml += "<td class=\"grey\">" + "<input type=\"button\" value=\"Update\" onClick=" + "\"fillInUpdateForm(" + obj.equipmentId + ", " + strMod + ", " + obj.price + ", " + obj.tankId + ")\"" + ">";
                                    document.getElementById('mainTable').innerHTML += stringHtml;
                                    stringHtml = "";
                                });



                            }

                            }
                        });
                 });

                }
            );

        </script>

    </body>
</html>
