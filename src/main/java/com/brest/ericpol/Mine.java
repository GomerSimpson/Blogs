package com.brest.ericpol;

import com.brest.ericpol.service.model.Equipment;
import com.brest.ericpol.service.service.EquipmentLocalServiceUtil;
import com.brest.ericpol.service.service.TankLocalService;
import com.brest.ericpol.service.service.TankLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mine extends MVCPortlet {

    @Override
    public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws  IOException, PortletException {
        try {
            JSONObject jsonUser = null;
            JSONObject equipmentJSON = null;
            JSONArray usersJsonArray= JSONFactoryUtil.createJSONArray();
            JSONArray tankJSONArray = null;
            List<MyBean> list = TankLocalServiceUtil.getFullEntity(TankLocalServiceUtil.getTanks(QueryUtil.ALL_POS, QueryUtil.ALL_POS));

            for(MyBean userObj : list){
                jsonUser=JSONFactoryUtil.createJSONObject();
                jsonUser.put("tankId", userObj.getTankId());
                jsonUser.put("number", userObj.getTankNumber());
                jsonUser.put("modification", userObj.getTankModification());
                jsonUser.put("price", userObj.getTankPrice());
                tankJSONArray = JSONFactoryUtil.createJSONArray();

                for(Equipment e : userObj.getTankEquipment()){
                    equipmentJSON = JSONFactoryUtil.createJSONObject();
                    equipmentJSON.put("equipmentId", e.getEquipmentId());
                    equipmentJSON.put("modification", e.getModification());
                    equipmentJSON.put("price", e.getPrice());
                    equipmentJSON.put("tankId", e.getTankId());

                    tankJSONArray.put(equipmentJSON);
                }

                jsonUser.put("equipment", tankJSONArray);
                usersJsonArray.put(jsonUser);
            }


            PrintWriter out=resourceResponse.getWriter();
         //   System.out.println(usersJsonArray.toString());
            out.print(usersJsonArray.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void addTank(ActionRequest actionRequest,
					ActionResponse actionResponse) throws IOException, PortletException, SQLException, SystemException, PortalException {

        String tankNumber = ParamUtil.getString(actionRequest, "addTankNumber");
        String tankModification = ParamUtil.getString(actionRequest, "addTankModification");
        Long tankPrice = ParamUtil.getLong(actionRequest, "addTankPrice");
        //System.out.println(tankModification + " " + tankModification + " " + tankPrice);
        TankLocalServiceUtil.addTank(tankModification, tankNumber, tankPrice);



//        boolean tankNumber = ParamUtil.getBoolean(actionRequest, "tankNumber");
//        boolean tankModification = ParamUtil.getBoolean(actionRequest, "tankModification");
//        boolean tankPrice = ParamUtil.getBoolean(actionRequest, "tankPrice");
//        boolean equipmentModification = ParamUtil.getBoolean(actionRequest, "equipmentModification");
//        boolean equipmentPrice = ParamUtil.getBoolean(actionRequest, "equipmentPrice");
        /*JasperReportBuilder report = DynamicReports.report();
        report
                .columns(
                Columns.column("mod", "modification", DataTypes.stringType()),
                Columns.column("First Name", "firstName", DataTypes.stringType()),
                Columns.column("Last Name", "lastName", DataTypes.stringType()))
                .title(Components.text("SimpleReportExample")
                        .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource(list);*/

//        System.out.println(tankNumber);
//        System.out.println(tankModification);
//        System.out.println(tankPrice);
//        System.out.println(equipmentModification);
//        System.out.println(equipmentPrice);

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


}