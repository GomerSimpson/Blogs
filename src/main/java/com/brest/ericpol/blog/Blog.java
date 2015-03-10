package com.brest.ericpol.blog;

import com.brest.ericpol.blog.service.model.BlogEntry;
import com.brest.ericpol.blog.service.service.BlogEntryLocalServiceUtil;
import com.itextpdf.text.DocumentException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import org.apache.commons.io.IOUtils;


import javax.portlet.*;
import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blog extends MVCPortlet {

    @Override
    public void serveResource(ResourceRequest resourceRequest,
                              ResourceResponse resourceResponse) throws IOException, PortletException {
        JSONObject objectJSON = null;
        Long userId = null;
        JSONArray arrayJSON = JSONFactoryUtil.createJSONArray();
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();

        List<BlogEntry> list = null;
        String flag = ParamUtil.getString(resourceRequest, "flag");
        String fileNameToDownload = ParamUtil.getString(resourceRequest, "fileNameToDownload");
        System.out.println("File: " + fileNameToDownload);
        if (!fileNameToDownload.equals("")) {
            if (fileNameToDownload.contains(".pdf")) {

                File outputFile = new File("/home/simpson/reports/" + fileNameToDownload);
                resourceResponse.setContentType("application/pdf");
                resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileNameToDownload + "\"");
                OutputStream out = resourceResponse.getPortletOutputStream();
                InputStream in = new FileInputStream(outputFile);
                IOUtils.copy(in, out);
                out.flush();
            } else if (fileNameToDownload.contains(".xls")) {
                System.out.println(fileNameToDownload);
                File outputFile = new File("/home/simpson/reports/" + fileNameToDownload);
                resourceResponse.setContentType("application/vnd.ms-excel");
                resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileNameToDownload + "\"");
                OutputStream out = resourceResponse.getPortletOutputStream();
                InputStream in = new FileInputStream(outputFile);
                IOUtils.copy(in, out);
                out.flush();
            }
            return;
        }



        if (flag.equals("fileNames")) {
            List<String> files = getFiles(user.getUserId());

            for (String str : files) {
                arrayJSON.put(str);
            }

            PrintWriter out = resourceResponse.getWriter();
            out.print(arrayJSON.toString());
        } else if (flag.equals("allNames")) {
            try {
                list = BlogEntryLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
            } catch (SystemException e) {
                e.printStackTrace();
            }

            Map<Long, String> map = new HashMap<Long, String>();

            String userName = null;

            for (BlogEntry be : list) {
                userId = be.getUserId();
                try {
                    userName = UserLocalServiceUtil.getUserById(userId).getFullName();
                } catch (PortalException e) {
                    e.printStackTrace();
                } catch (SystemException e) {
                    e.printStackTrace();
                }

                map.put(userId, userName);
            }

            for (Map.Entry<Long, String> entry : map.entrySet()) {
                objectJSON = JSONFactoryUtil.createJSONObject();
                objectJSON.put("userId", entry.getKey());
                objectJSON.put("userName", entry.getValue());
                arrayJSON.put(objectJSON);
            }

            PrintWriter out = resourceResponse.getWriter();
            out.print(arrayJSON.toString());

        } else {
            if (flag.equals("userEntries")) {
                userId = ParamUtil.getLong(resourceRequest, "userId");
            }

            try {
                System.out.println("User id" + userId);
                list = BlogEntryLocalServiceUtil.findByUserGroupCompanyId(userId, themeDisplay.getScopeGroupId(), user.getCompanyId());
            } catch (SystemException e) {
                e.printStackTrace();
            }

            for (BlogEntry be : list) {
                objectJSON = JSONFactoryUtil.createJSONObject();
                String userName = null;
                try {
                    userName = UserLocalServiceUtil.getUserById(be.getUserId()).getFullName();
                } catch (PortalException e) {
                    e.printStackTrace();
                } catch (SystemException e) {
                    e.printStackTrace();
                }

                objectJSON.put("entryId", be.getEntryId());
                objectJSON.put("userId", be.getUserId());
                objectJSON.put("groupId", be.getGroupId());
                objectJSON.put("companyId", be.getCompanyId());
                objectJSON.put("userName", userName);
                objectJSON.put("title", be.getTitle());
                objectJSON.put("entryText", be.getEntryText());
                objectJSON.put("entryDate", be.getEntryDate());

                arrayJSON.put(objectJSON);
            }

            PrintWriter out = resourceResponse.getWriter();
            out.print(arrayJSON.toString());
        }
    }

    public void addEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, WindowStateException {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();

        //List<User> gg= UserLocalServiceUtil.getGroupUsers(user.getGroupId());

        Long userId = user.getUserId();
        long groupId = themeDisplay.getScopeGroupId();
        long companyId = user.getCompanyId();
        //  System.out.println("UserId: " + userId);

        //  System.out.println("GroupId: " + groupId);

        // System.out.println("companyId: " + companyId);
        actionResponse.setProperty("flagOfUserId", userId.toString());
        String entryText = ParamUtil.getString(actionRequest, "entryText");
        //  System.out.println("Text: " + entryText);
        String title = ParamUtil.getString(actionRequest, "title");
        //  System.out.println("title:  " + title);
        String strDate = ParamUtil.getString(actionRequest, "date");
        Date date = Date.valueOf(strDate);
        //   System.out.println("Date: " + date);

        BlogEntryLocalServiceUtil.addBlogEntry(userId, groupId, companyId, title, entryText, date);
        actionRequest.setAttribute("flagOfUserId", userId);
        actionResponse.setWindowState(WindowState.MAXIMIZED);
    }

    public void deleteEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {
        long entryId = ParamUtil.getLong(actionRequest, "entryId");

        BlogEntry deletedEntry = BlogEntryLocalServiceUtil.deleteBlogEntry(entryId);
        Long userId = deletedEntry.getUserId();
        actionRequest.setAttribute("flagOfUserId", userId);
    }

    public void updateEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, ParseException, WindowStateException {
        Long entryId = ParamUtil.getLong(actionRequest, "entryId");
        // System.out.println("Entry Id: " + entryId);
        Long userId = ParamUtil.getLong(actionRequest, "userId");
        //   System.out.println("User Id: " + userId);
        Long groupId = ParamUtil.getLong(actionRequest, "groupId");
        //   System.out.println("Group Id: " + groupId);
        Long companyId = ParamUtil.getLong(actionRequest, "companyId");
        //  System.out.println("Company Id: " + companyId);
        String entryText = ParamUtil.getString(actionRequest, "entryText");
        //   System.out.println("Text: " + entryText);
        String title = ParamUtil.getString(actionRequest, "title");
        // System.out.println("title:  " + title);
        String strDate = ParamUtil.getString(actionRequest, "date");
        Date date = Date.valueOf(strDate);
        //  System.out.println("Date: " + date);
        actionRequest.setAttribute("flagOfUserId", userId);
        BlogEntryLocalServiceUtil.updateBlogEntry(entryId, userId, groupId, companyId, title, entryText, date);
        actionResponse.setWindowState(WindowState.MAXIMIZED);

    }

    public void showAll(ActionRequest actionRequest, ActionResponse actionResponse) throws WindowStateException {
        Long entryId = ParamUtil.getLong(actionRequest, "userId");
        actionResponse.setRenderParameter("jspPage", "/view.jsp");
        actionRequest.setAttribute("flagOfUserId", entryId);
        actionResponse.setWindowState(WindowState.MAXIMIZED);
    }

    public void test(ActionRequest actionRequest, ActionResponse actionResponse) {
        actionRequest.setAttribute("flagOfUserId", 1059);
        actionResponse.setRenderParameter("jspPage", "/test.jsp");
    }

    public void createReport(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, IOException, DocumentException {
        String radio = ParamUtil.getString(actionRequest, "radio");
        String reportFileName = ParamUtil.getString(actionRequest, "reportFileName");
        String entriesIds = ParamUtil.getString(actionRequest, "entriesIds");
        String[] strIds = entriesIds.split(",");

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();

        Long[] ids = new Long[strIds.length];
        int i = 0;
        List<BlogEntry> list = new ArrayList<BlogEntry>();

        for (String str : strIds) {
            ids[i] = Long.parseLong(str);
            list.add(BlogEntryLocalServiceUtil.getBlogEntry(ids[i]));
            System.out.println(BlogEntryLocalServiceUtil.getBlogEntry(ids[i]).toString());
            i++;
        }

        new ReportCreator(radio, createFileName(Long.toString(user.getUserId()),
                reportFileName), list, UserLocalServiceUtil.getUserById(list.get(0).getUserId()).getFullName());

        System.out.println("radio -> " + radio);
        actionRequest.setAttribute("flagOfUserId", list.get(0).getUserId());
    }

    private String createFileName(String userId, String fileName) {
        String name = userId + "_";
/*
        if (true) {          //если юзер админ
            name += "admin_";
        }
*/
        name += fileName;

        return name;
    }

    private List<String> getFiles(Long currentUserId) {
        File folder = new File("/home/simpson/reports/");

        File[] listOfFiles = folder.listFiles();
        List<String> listOfUsersFiles = new ArrayList<String>();


        for (File file : listOfFiles) {
            if (file.isFile()) {
                String fileUserIdStr = file.getName().substring(0, 5);

                if (Long.parseLong(fileUserIdStr) == currentUserId) {
                    listOfUsersFiles.add(file.getName());

                }
                System.out.println(file.getName() + " : " + Long.parseLong(fileUserIdStr));
            }
        }


        return listOfUsersFiles;
    }

    private String trimFileName(String str){
        return str.substring(6);
    }
}