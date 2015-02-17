package com.brest.ericpol;

import com.brest.ericpol.service.service.EquipmentLocalServiceUtil;
import com.brest.ericpol.service.service.impl.EquipmentLocalServiceImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10.02.2015.
 */
public class Shower extends MVCPortlet {

    private String showerJSP;

    @ProcessEvent(qname="{http://liferay.com/events}ipc.mine")
    public void add(EventRequest eventRequest, EventResponse eventResponse) throws IOException, PortletException, SQLException, SystemException, PortalException {
        Event event = eventRequest.getEvent();
        @SuppressWarnings("unchecked")
        List<String> listOfParameters = (ArrayList<String>) event.getValue();
      //  MyUserLocalServiceUtil.addMyUser(listOfParameters.get(0), listOfParameters.get(1));
       // List<MyUser> list = MyUserLocalServiceUtil.getMyUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
/*1
        JasperReportBuilder report = DynamicReports.report();//a new report
        report
                .columns(
                        Columns.column("Id", "userId", DataTypes.longType()),
                        Columns.column("First Name", "firstName", DataTypes.stringType()),
                        Columns.column("Last Name", "lastName", DataTypes.stringType()))
                .title(Components.text("SimpleReportExample")
                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource(list);
*//*
        try {
            //show the report
            //report.show();

            //export the report to a pdf file
            //report.toPdf(new FileOutputStream("/home/simpson/report.pdf"));
        } catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws  IOException, PortletException {
        try {
            /*JSONObject jsonUser=null;
            JSONArray usersJsonArray= JSONFactoryUtil.createJSONArray();
            List<MyUser> list = MyUserLocalServiceUtil.getMyUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

            for(MyUser userObj: list){
                jsonUser=JSONFactoryUtil.createJSONObject();
                jsonUser.put("userId", userObj.getUserId());
                jsonUser.put("firstName",userObj.getFirstName());
                jsonUser.put("lastName",userObj.getLastName());
                usersJsonArray.put(jsonUser);
            }

            PrintWriter out=resourceResponse.getWriter();
            System.out.println(usersJsonArray.toString());
            out.print(usersJsonArray.toString());*/
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    public void get(ActionRequest actionRequest,
                    ActionResponse actionResponse) throws IOException, PortletException, SQLException, SystemException {

        List<MyUser> list = MyUserLocalServiceUtil.getMyUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

        actionRequest.setAttribute("list", list);
        actionResponse.setRenderParameter("jspPage", "/shower.jsp");
    }*/
}
