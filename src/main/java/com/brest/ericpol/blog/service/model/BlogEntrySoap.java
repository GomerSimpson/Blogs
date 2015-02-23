package com.brest.ericpol.blog.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Viktor Kolbik
 * @generated
 */
public class BlogEntrySoap implements Serializable {
    private long _entryId;
    private long _userId;
    private long _groupId;
    private long _companyId;
    private String _entryText;
    private Date _entryDate;

    public BlogEntrySoap() {
    }

    public static BlogEntrySoap toSoapModel(BlogEntry model) {
        BlogEntrySoap soapModel = new BlogEntrySoap();

        soapModel.setEntryId(model.getEntryId());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setEntryText(model.getEntryText());
        soapModel.setEntryDate(model.getEntryDate());

        return soapModel;
    }

    public static BlogEntrySoap[] toSoapModels(BlogEntry[] models) {
        BlogEntrySoap[] soapModels = new BlogEntrySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static BlogEntrySoap[][] toSoapModels(BlogEntry[][] models) {
        BlogEntrySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new BlogEntrySoap[models.length][models[0].length];
        } else {
            soapModels = new BlogEntrySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static BlogEntrySoap[] toSoapModels(List<BlogEntry> models) {
        List<BlogEntrySoap> soapModels = new ArrayList<BlogEntrySoap>(models.size());

        for (BlogEntry model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new BlogEntrySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _entryId;
    }

    public void setPrimaryKey(long pk) {
        setEntryId(pk);
    }

    public long getEntryId() {
        return _entryId;
    }

    public void setEntryId(long entryId) {
        _entryId = entryId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public String getEntryText() {
        return _entryText;
    }

    public void setEntryText(String entryText) {
        _entryText = entryText;
    }

    public Date getEntryDate() {
        return _entryDate;
    }

    public void setEntryDate(Date entryDate) {
        _entryDate = entryDate;
    }
}
