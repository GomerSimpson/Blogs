package com.brest.ericpol.blog;

import com.brest.ericpol.blog.service.model.BlogEntry;
import com.brest.ericpol.blog.service.service.BlogEntryLocalServiceUtil;
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
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Blog extends MVCPortlet {

    @Override
    public void serveResource(ResourceRequest resourceRequest,
                        ResourceResponse resourceResponse) throws IOException, PortletException {

        JSONObject entryJSON = null;
        JSONArray entriesJSONArray = JSONFactoryUtil.createJSONArray();

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        User user = themeDisplay.getUser();
        try {
            System.out.println(user.getUserId() + " " + user.getGroupId() + " " + user.getCompanyId());
        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }
        try {
            List<BlogEntry> list = BlogEntryLocalServiceUtil.findByUserGroupCompanyId(user.getUserId(), user.getGroupId(), user.getCompanyId());

            for(BlogEntry be : list){
                entryJSON = JSONFactoryUtil.createJSONObject();
                entryJSON.put("entryId",  be.getEntryId());
                entryJSON.put("userId", be.getUserId());
                entryJSON.put("groupId",  be.getGroupId());
                entryJSON.put("companyId",  be.getCompanyId());
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



}