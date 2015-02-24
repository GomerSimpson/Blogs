package com.brest.ericpol.blog.service.model;

import com.brest.ericpol.blog.service.service.BlogEntryLocalServiceUtil;
import com.brest.ericpol.blog.service.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BlogEntryClp extends BaseModelImpl<BlogEntry> implements BlogEntry {
    private long _entryId;
    private long _userId;
    private String _userUuid;
    private long _groupId;
    private long _companyId;
    private String _title;
    private String _entryText;
    private Date _entryDate;
    private BaseModel<?> _blogEntryRemoteModel;
    private Class<?> _clpSerializerClass = com.brest.ericpol.blog.service.service.ClpSerializer.class;

    public BlogEntryClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return BlogEntry.class;
    }

    @Override
    public String getModelClassName() {
        return BlogEntry.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _entryId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setEntryId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _entryId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("entryId", getEntryId());
        attributes.put("userId", getUserId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("title", getTitle());
        attributes.put("entryText", getEntryText());
        attributes.put("entryDate", getEntryDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long entryId = (Long) attributes.get("entryId");

        if (entryId != null) {
            setEntryId(entryId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String entryText = (String) attributes.get("entryText");

        if (entryText != null) {
            setEntryText(entryText);
        }

        Date entryDate = (Date) attributes.get("entryDate");

        if (entryDate != null) {
            setEntryDate(entryDate);
        }
    }

    @Override
    public long getEntryId() {
        return _entryId;
    }

    @Override
    public void setEntryId(long entryId) {
        _entryId = entryId;

        if (_blogEntryRemoteModel != null) {
            try {
                Class<?> clazz = _blogEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setEntryId", long.class);

                method.invoke(_blogEntryRemoteModel, entryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_blogEntryRemoteModel != null) {
            try {
                Class<?> clazz = _blogEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_blogEntryRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_blogEntryRemoteModel != null) {
            try {
                Class<?> clazz = _blogEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_blogEntryRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_blogEntryRemoteModel != null) {
            try {
                Class<?> clazz = _blogEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_blogEntryRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_blogEntryRemoteModel != null) {
            try {
                Class<?> clazz = _blogEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_blogEntryRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEntryText() {
        return _entryText;
    }

    @Override
    public void setEntryText(String entryText) {
        _entryText = entryText;

        if (_blogEntryRemoteModel != null) {
            try {
                Class<?> clazz = _blogEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setEntryText", String.class);

                method.invoke(_blogEntryRemoteModel, entryText);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getEntryDate() {
        return _entryDate;
    }

    @Override
    public void setEntryDate(Date entryDate) {
        _entryDate = entryDate;

        if (_blogEntryRemoteModel != null) {
            try {
                Class<?> clazz = _blogEntryRemoteModel.getClass();

                Method method = clazz.getMethod("setEntryDate", Date.class);

                method.invoke(_blogEntryRemoteModel, entryDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getBlogEntryRemoteModel() {
        return _blogEntryRemoteModel;
    }

    public void setBlogEntryRemoteModel(BaseModel<?> blogEntryRemoteModel) {
        _blogEntryRemoteModel = blogEntryRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _blogEntryRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_blogEntryRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            BlogEntryLocalServiceUtil.addBlogEntry(this);
        } else {
            BlogEntryLocalServiceUtil.updateBlogEntry(this);
        }
    }

    @Override
    public BlogEntry toEscapedModel() {
        return (BlogEntry) ProxyUtil.newProxyInstance(BlogEntry.class.getClassLoader(),
            new Class[] { BlogEntry.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        BlogEntryClp clone = new BlogEntryClp();

        clone.setEntryId(getEntryId());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setTitle(getTitle());
        clone.setEntryText(getEntryText());
        clone.setEntryDate(getEntryDate());

        return clone;
    }

    @Override
    public int compareTo(BlogEntry blogEntry) {
        long primaryKey = blogEntry.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BlogEntryClp)) {
            return false;
        }

        BlogEntryClp blogEntry = (BlogEntryClp) obj;

        long primaryKey = blogEntry.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{entryId=");
        sb.append(getEntryId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", entryText=");
        sb.append(getEntryText());
        sb.append(", entryDate=");
        sb.append(getEntryDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.brest.ericpol.blog.service.model.BlogEntry");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>entryId</column-name><column-value><![CDATA[");
        sb.append(getEntryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entryText</column-name><column-value><![CDATA[");
        sb.append(getEntryText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entryDate</column-name><column-value><![CDATA[");
        sb.append(getEntryDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
