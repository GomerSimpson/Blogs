package com.brest.ericpol.blog;

import com.brest.ericpol.blog.service.model.BlogEntry;
import com.brest.ericpol.blog.service.service.BlogEntryLocalServiceUtil;
import com.ckeditor.CKEditorConfig;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import org.exolab.castor.mapping.xml.Param;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class Blog extends MVCPortlet{

    @Override
    public void serveResource(ResourceRequest resourceRequest,
                        ResourceResponse resourceResponse) throws IOException, PortletException {
        JSONObject entryJSON = null;
        JSONArray entriesJSONArray = JSONFactoryUtil.createJSONArray();
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();

        System.out.println(user.getUserId() + " " + themeDisplay.getScopeGroupId() + " " + user.getCompanyId());

        try {
            //List<BlogEntry> list = BlogEntryLocalServiceUtil.findAllEntries();
            //List<BlogEntry> list = BlogEntryLocalServiceUtil.findByUserGroupCompanyId(user.getUserId(), user.getGroupId(), user.getCompanyId());
            List<BlogEntry> list = null;
            boolean flag = ParamUtil.getBoolean(resourceRequest, "amount");

            if(flag) {
                list = BlogEntryLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
            } else{
                list = BlogEntryLocalServiceUtil.findByUserGroupCompanyId(user.getUserId(), themeDisplay.getScopeGroupId(), user.getCompanyId());
            }

            for(BlogEntry be : list){
                entryJSON = JSONFactoryUtil.createJSONObject();
                String userName = UserLocalServiceUtil.getUserById(be.getUserId()).getFullName();
                entryJSON.put("entryId",  be.getEntryId());
                entryJSON.put("userId", be.getUserId());
                entryJSON.put("groupId",  be.getGroupId());
                entryJSON.put("companyId",  be.getCompanyId());
                entryJSON.put("userName", userName);
                entryJSON.put("title", be.getTitle());
                entryJSON.put("entryText",  be.getEntryText());
                entryJSON.put("entryDate", be.getEntryDate());

                entriesJSONArray.put(entryJSON);
            }

            PrintWriter out = resourceResponse.getWriter();
            out.print(entriesJSONArray.toString());
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }

    public void addEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();

        //List<User> gg= UserLocalServiceUtil.getGroupUsers(user.getGroupId());

        long userId = user.getUserId();
        long groupId = themeDisplay.getScopeGroupId();
        long companyId = user.getCompanyId();
        System.out.println("UserId: " + userId);

        System.out.println("GroupId: " + groupId);

        System.out.println("companyId: " + companyId);

        String entryText = ParamUtil.getString(actionRequest, "entryText");
        System.out.println("Text: " + entryText);
        String title = ParamUtil.getString(actionRequest, "title");
        System.out.println("title:  " + title);
        String strDate  = ParamUtil.getString(actionRequest, "date");
        Date date = Date.valueOf(strDate);
        System.out.println("Date: " + date);

        BlogEntryLocalServiceUtil.addBlogEntry(userId, groupId, companyId, title, entryText, date);
    }

    public void deleteEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {
        long entryId = ParamUtil.getLong(actionRequest, "entryId");
        BlogEntryLocalServiceUtil.deleteBlogEntry(entryId);

    }

    public void updateEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, ParseException {
        long entryId = ParamUtil.getLong(actionRequest, "entryId");
        System.out.println("Entry Id: " + entryId);
        long userId = ParamUtil.getLong(actionRequest, "userId");
        System.out.println("User Id: " + userId);
        long groupId = ParamUtil.getLong(actionRequest, "groupId");
        System.out.println("Group Id: " + groupId);
        long companyId = ParamUtil.getLong(actionRequest, "companyId");
        System.out.println("Company Id: " + companyId);
        String entryText = ParamUtil.getString(actionRequest, "entryText");
        System.out.println("Text: " + entryText);
        String title = ParamUtil.getString(actionRequest, "updateTitle");
        System.out.println("title:  " + title);
        String strDate  = ParamUtil.getString(actionRequest, "date");
        Date date = Date.valueOf(strDate);
        System.out.println("Date: " + date);

        BlogEntryLocalServiceUtil.addBlogEntry(userId, groupId, companyId, title, entryText, date);
    }

}