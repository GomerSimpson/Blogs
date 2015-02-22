package com.brest.ericpol;

import com.brest.ericpol.service.model.Equipment;
import com.brest.ericpol.service.service.EquipmentLocalServiceUtil;
import com.brest.ericpol.service.service.TankLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class Mine extends MVCPortlet {

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

        JSONObject jsonUser = null;
        JSONObject equipmentJSON = null;
        JSONArray usersJsonArray = JSONFactoryUtil.createJSONArray();
        JSONArray jsonArray = null;

        String param = ParamUtil.getString(resourceRequest, "getEntities");

        if (param.equals("tanks")) {
            List<MyBean> list = null;

            try {
                list = TankLocalServiceUtil.getFullEntity(TankLocalServiceUtil.getTanks(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
            } catch (SystemException e) {
                e.printStackTrace();
            }

            for (MyBean userObj : list) {
                jsonUser = JSONFactoryUtil.createJSONObject();
                jsonUser.put("tankId", userObj.getTankId());
                jsonUser.put("number", userObj.getTankNumber());
                jsonUser.put("modification", userObj.getTankModification());
                jsonUser.put("price", userObj.getTankPrice());
                jsonArray = JSONFactoryUtil.createJSONArray();

                for (Equipment e : userObj.getTankEquipment()) {
                    equipmentJSON = JSONFactoryUtil.createJSONObject();
                    equipmentJSON.put("equipmentId", e.getEquipmentId());
                    equipmentJSON.put("modification", e.getModification());
                    equipmentJSON.put("price", e.getPrice());
                    equipmentJSON.put("tankId", e.getTankId());

                    jsonArray.put(equipmentJSON);
                }

                jsonUser.put("equipment", jsonArray);
                usersJsonArray.put(jsonUser);
            }


            PrintWriter out = resourceResponse.getWriter();
            //   System.out.println(usersJsonArray.toString());
            out.print(usersJsonArray.toString());

        } else{
            List<Equipment> list = null;

            try {
                list = EquipmentLocalServiceUtil.getAllEquipment();
            } catch (SystemException e) {
                e.printStackTrace();
            }

            for (Equipment userObj : list) {
                jsonUser = JSONFactoryUtil.createJSONObject();
                jsonUser.put("equipmentId", userObj.getEquipmentId());
                jsonUser.put("modification", userObj.getModification());
                jsonUser.put("price", userObj.getPrice());
                jsonUser.put("tankId", userObj.getTankId());

                usersJsonArray.put(jsonUser);

            }

            PrintWriter out = resourceResponse.getWriter();
            System.out.println("for equipment page" + usersJsonArray.toString());
            out.print(usersJsonArray.toString());
        }
    }

    public void addTank(ActionRequest actionRequest,
                        ActionResponse actionResponse) throws IOException, PortletException, SQLException, SystemException, PortalException {

        String tankNumber = ParamUtil.getString(actionRequest, "addTankNumber");
        String tankModification = ParamUtil.getString(actionRequest, "addTankModification");
        Long tankPrice = ParamUtil.getLong(actionRequest, "addTankPrice");
        //System.out.println(tankModification + " " + tankModification + " " + tankPrice);
        TankLocalServiceUtil.addTank(tankModification, tankNumber, tankPrice);

//
////        System.out.println(TankLocalServiceUtil.addTank("T-72Б", "i2567", 100000L));
////        System.out.println(TankLocalServiceUtil.addTank("Т-72БА", "i6209", 3000000L));
////        System.out.println(TankLocalServiceUtil.addTank("Т-90А", "i6349", 4500000L));
//        System.out.println(EquipmentLocalServiceUtil.addEquipment("ДЗ Контакт-1", 45000L, 501L));
//        System.out.println(EquipmentLocalServiceUtil.addEquipment("ДЗ Контакт-5", 75000L, 502L));
//        System.out.println(EquipmentLocalServiceUtil.addEquipment("ДЗ Реликт", 100000L, 301L));
//        System.out.println(EquipmentLocalServiceUtil.addEquipment("ДЗ Контакт-5", 75000L, 503L));
        //   System.out.println(TankLocalServiceUtil.findByModification("T-80УД").get(0));

        //   list.add(firstName);
        //  list.add(lastName);
        ///    QName qName = new QName("http://liferay.com/events", "ipc.mine");
        //actionResponse.setEvent(qName, new ArrayList<String>(list));
    }

    public void updateTank(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {
        Long tankId = ParamUtil.getLong(actionRequest, "updateTankId");
        String tankNumber = ParamUtil.getString(actionRequest, "updateTankNumber");
        String tankModification = ParamUtil.getString(actionRequest, "updateTankModification");
        Long tankPrice = ParamUtil.getLong(actionRequest, "updateTankPrice");

        System.out.println(tankId + " " + tankNumber + " " + tankModification + " " + tankPrice);

        TankLocalServiceUtil.updateTank(tankId, tankNumber, tankModification, tankPrice);
    }

    public void addEquipment(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {
        String modification = ParamUtil.getString(actionRequest, "addEquipmentModification");
        Long price = ParamUtil.getLong(actionRequest, "addEquipmentPrice");
        Long tankId = ParamUtil.getLong(actionRequest, "addTankId");
       // System.out.println(modification + " " + price + " " + tankId);
        EquipmentLocalServiceUtil.addEquipment(modification, price, tankId);
        String pageName=ParamUtil.getString(actionRequest,"mvcPath");
        actionResponse.setRenderParameter("mvcPath", pageName);
    }

    public void updateEquipment(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
        Long equipmentId = ParamUtil.getLong(actionRequest, "updateEquipmentId");
        String modification = ParamUtil.getString(actionRequest, "updateEquipmentModification");
        Long price = ParamUtil.getLong(actionRequest, "updateEquipmentPrice");
        Long tankId = ParamUtil.getLong(actionRequest, "updateTankId");
        EquipmentLocalServiceUtil.updateEquipment(equipmentId, modification, price, tankId);

        String pageName=ParamUtil.getString(actionRequest,"mvcPath");
        actionResponse.setRenderParameter("mvcPath", pageName);
    }

    public void deleteTank(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, NoSuchModelException {
        Long tankId = ParamUtil.getLong(actionRequest, "tankId");
        TankLocalServiceUtil.deleteTank(tankId);
    }

    public void deleteEquipment(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {
        Long equipmentId = ParamUtil.getLong(actionRequest, "equipmentId");
        EquipmentLocalServiceUtil.deleteEquipment(equipmentId);

        String pageName=ParamUtil.getString(actionRequest,"mvcPath");
        actionResponse.setRenderParameter("mvcPath", pageName);
    }

    public void generateTankReport(ActionRequest actionRequest, ActionResponse actionResponse){
        boolean tankNumber = ParamUtil.getBoolean(actionRequest, "tankNumber");
        boolean tankModification = ParamUtil.getBoolean(actionRequest, "tankModification");
        boolean tankPrice = ParamUtil.getBoolean(actionRequest, "tankPrice");
        boolean equipmentModification = ParamUtil.getBoolean(actionRequest, "equipmentModification");
        boolean equipmentPrice = ParamUtil.getBoolean(actionRequest, "equipmentPrice");

        Long lowBorder = ParamUtil.getLong(actionRequest, "lowBorder");
        Long topBorder = ParamUtil.getLong(actionRequest, "topBorder");

        List<MyBean> list = null;

        try {
            if(lowBorder == 0) {
                list = TankLocalServiceUtil.getFullEntity(TankLocalServiceUtil.getTanks(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
            } else{
                list = TankLocalServiceUtil.getFullEntity(TankLocalServiceUtil.findByPrice(lowBorder, topBorder));
            }
        } catch (SystemException e) {
            e.printStackTrace();
        }

        new FullReport(tankNumber, tankModification, tankPrice, equipmentModification, equipmentModification, list);
/*
        List <MyBean> list = new ArrayList<MyBean>();

        JasperReportBuilder report = DynamicReports.report();
        report
                .columns(
                        Columns.column("mod", "modification", DataTypes.stringType()),
                        Columns.column("First Name", "firstName", DataTypes.stringType()),
                        Columns.column("Last Name", "lastName", DataTypes.stringType()))
                .title(Components.text("SimpleReportExample")
                        .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource(list);*/
        System.out.println(tankNumber + " " + tankModification + " " + tankPrice + " " + equipmentModification + " " + equipmentPrice + " " + lowBorder + " " + topBorder);

    }

}