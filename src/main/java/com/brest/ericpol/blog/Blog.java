package com.brest.ericpol.blog;

import com.brest.ericpol.blog.service.model.BlogEntry;
import com.brest.ericpol.blog.service.service.BlogEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
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

      //  System.out.println(user.getUserId() + " " + themeDisplay.getScopeGroupId() + " " + user.getCompanyId());

        //List<BlogEntry> list = BlogEntryLocalServiceUtil.findAllEntries();
        //List<BlogEntry> list = BlogEntryLocalServiceUtil.findByUserGroupCompanyId(user.getUserId(), user.getGroupId(), user.getCompanyId());
        List<BlogEntry> list = null;
        String flag = ParamUtil.getString(resourceRequest, "flag");

        if (flag.equals("allNames")) {
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

    public void addEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {

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
    }

    public void deleteEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {
        long entryId = ParamUtil.getLong(actionRequest, "entryId");

        BlogEntry deletedEntry = BlogEntryLocalServiceUtil.deleteBlogEntry(entryId);
        Long userId = deletedEntry.getUserId();
        actionRequest.setAttribute("flagOfUserId", userId);
    }

    public void updateEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, ParseException {
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

    }

    public void showAll(ActionRequest actionRequest, ActionResponse actionResponse){
        Long entryId = ParamUtil.getLong(actionRequest, "userId");
        actionResponse.setRenderParameter("jspPage", "/view.jsp");
        actionRequest.setAttribute("flagOfUserId", entryId);
    }

    public void test(ActionRequest actionRequest, ActionResponse actionResponse) {
        actionRequest.setAttribute("flagOfUserId", 1059);
        actionResponse.setRenderParameter("jspPage", "/test.jsp");
    }
}