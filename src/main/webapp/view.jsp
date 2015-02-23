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

<portlet:actionURL var="generateTankReportURL" windowState="maximized" name="generateTankReport">
</portlet:actionURL>

<portlet:renderURL var="toEquipmentPageURL">
    <portlet:param name="mvcPath" value="/eq.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="deleteTankURL" windowState="maximized" name="deleteTank">
</portlet:actionURL>

<portlet:resourceURL var="res" >
    <portlet:param name="getEntities" value="tanks" />
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
            <div class="updateTankFormDiv" id="updateTankFormDiv">
                <aui:form action="<%=updateTankURL%>" name="updateTankForm" method="POST">
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
            <div class="box" id="selectRowsTankDiv">
                <aui:form action="<%=generateTankReportURL%>" name="generateTankReport" method="POST">
                    <table>
                        <tbody>
                            <tr>
                               <td><aui:input type="checkbox" name="tankNumber"/></td>
                               <td><aui:input type="checkbox" name="tankModification"/></td>
                               <td><aui:input type="checkbox" name="tankPrice"/></td>
                               <td><aui:input type="checkbox" name="equipmentModification"/></td>
                               <td><aui:input type="checkbox" name="equipmentPrice"/></td>
                            </tr>
                            <tr>
                                <td><b>more expensive than</b></td>
                                <td><aui:input type="number" name="lowBorder"/></td>
                                <td><b>and cheaper than</b></td>
                                <td><aui:input type="number" name="topBorder"/></td>
                            </tr>
                            <tr>
                               <td><aui:input type="submit" name="" value="Create Report"/></td>
                            </tr>
                        </tbody>
                    </table>
                </aui:form>
            </div>

            <a href="<%=toEquipmentPageURL%>">Reference to page with equipment</a>
<!--
            <aui:button cssClass="btn-primary" name="btn0" value="btn0" id="btn0"/>
            <aui:button cssClass="btn-info" name="btn1" value="btn1" id="btn1"/>
            <aui:button cssClass="btn-success" name="btn2" value="btn2" id="btn2"/>
-->
            <div class="box" id="mainTableDiv" class="mainTableDiv">
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
        <!--<link href="http://cdn.alloyui.com/3.0.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>-->
        <aui:script use="aui-base">
            var A = AUI();
            var stringHtml = "";
            var localStringHtml = "";
            var data;
/*
            A.one("#<portlet:namespace/>btn").onClick('click', function(){
                alert("work");
            });
*/
            function fillInUpdateForm(tankId, number, modification, price){
                A.one('#<portlet:namespace/>updateTankId').set('value', tankId);
                A.one('#<portlet:namespace/>updateTankNumber').set('value', number);
                A.one('#<portlet:namespace/>updateTankModification').set('value', modification);
                A.one('#<portlet:namespace/>updateTankPrice').set('value', price);
            }

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

                                    var deleteTankURL = new Liferay.PortletURL.createActionURL();


                                    stringHtml += localStringHtml;
                                    var strNumber = "\'" + obj.number + "\'";
                                    var strMod = "\'" + obj.modification + "\'";
                                    stringHtml += "<td class=\"grey\">" + "<input type=\"button\" value=\"Update\" onClick=" + "\"fillInUpdateForm(" + obj.tankId + ", " + strNumber + ", " + strMod + ", " + obj.price + ")\"" + ">";
                                    stringHtml += "<form action=\"<%=deleteTankURL%>\" name=\"deleteTankForm\" method=\"POST\">" +
                                                                                                                   "<input type=\"hidden\" id=\"<portlet:namespace/>tankId\" name=\"<portlet:namespace/>tankId\" value=\"" + obj.tankId + "\" />" +
                                                                                                                   "<input type=\"submit\" value=\"Remove\" /><form>";
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


        </aui:script>

    </body>
</html>
