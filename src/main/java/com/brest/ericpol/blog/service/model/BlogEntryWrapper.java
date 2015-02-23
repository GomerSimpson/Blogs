package com.brest.ericpol.blog.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BlogEntry}.
 * </p>
 *
 * @author Viktor Kolbik
 * @see BlogEntry
 * @generated
 */
public class BlogEntryWrapper implements BlogEntry, ModelWrapper<BlogEntry> {
    private BlogEntry _blogEntry;

    public BlogEntryWrapper(BlogEntry blogEntry) {
        _blogEntry = blogEntry;
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
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("entryId", getEntryId());
        attributes.put("userId", getUserId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
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

        String entryText = (String) attributes.get("entryText");

        if (entryText != null) {
            setEntryText(entryText);
        }

        Date entryDate = (Date) attributes.get("entryDate");

        if (entryDate != null) {
            setEntryDate(entryDate);
        }
    }

    /**
    * Returns the primary key of this blog entry.
    *
    * @return the primary key of this blog entry
    */
    @Override
    public long getPrimaryKey() {
        return _blogEntry.getPrimaryKey();
    }

    /**
    * Sets the primary key of this blog entry.
    *
    * @param primaryKey the primary key of this blog entry
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _blogEntry.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the entry ID of this blog entry.
    *
    * @return the entry ID of this blog entry
    */
    @Override
    public long getEntryId() {
        return _blogEntry.getEntryId();
    }

    /**
    * Sets the entry ID of this blog entry.
    *
    * @param entryId the entry ID of this blog entry
    */
    @Override
    public void setEntryId(long entryId) {
        _blogEntry.setEntryId(entryId);
    }

    /**
    * Returns the user ID of this blog entry.
    *
    * @return the user ID of this blog entry
    */
    @Override
    public long getUserId() {
        return _blogEntry.getUserId();
    }

    /**
    * Sets the user ID of this blog entry.
    *
    * @param userId the user ID of this blog entry
    */
    @Override
    public void setUserId(long userId) {
        _blogEntry.setUserId(userId);
    }

    /**
    * Returns the user uuid of this blog entry.
    *
    * @return the user uuid of this blog entry
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntry.getUserUuid();
    }

    /**
    * Sets the user uuid of this blog entry.
    *
    * @param userUuid the user uuid of this blog entry
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _blogEntry.setUserUuid(userUuid);
    }

    /**
    * Returns the group ID of this blog entry.
    *
    * @return the group ID of this blog entry
    */
    @Override
    public long getGroupId() {
        return _blogEntry.getGroupId();
    }

    /**
    * Sets the group ID of this blog entry.
    *
    * @param groupId the group ID of this blog entry
    */
    @Override
    public void setGroupId(long groupId) {
        _blogEntry.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this blog entry.
    *
    * @return the company ID of this blog entry
    */
    @Override
    public long getCompanyId() {
        return _blogEntry.getCompanyId();
    }

    /**
    * Sets the company ID of this blog entry.
    *
    * @param companyId the company ID of this blog entry
    */
    @Override
    public void setCompanyId(long companyId) {
        _blogEntry.setCompanyId(companyId);
    }

    /**
    * Returns the entry text of this blog entry.
    *
    * @return the entry text of this blog entry
    */
    @Override
    public java.lang.String getEntryText() {
        return _blogEntry.getEntryText();
    }

    /**
    * Sets the entry text of this blog entry.
    *
    * @param entryText the entry text of this blog entry
    */
    @Override
    public void setEntryText(java.lang.String entryText) {
        _blogEntry.setEntryText(entryText);
    }

    /**
    * Returns the entry date of this blog entry.
    *
    * @return the entry date of this blog entry
    */
    @Override
    public java.util.Date getEntryDate() {
        return _blogEntry.getEntryDate();
    }

    /**
    * Sets the entry date of this blog entry.
    *
    * @param entryDate the entry date of this blog entry
    */
    @Override
    public void setEntryDate(java.util.Date entryDate) {
        _blogEntry.setEntryDate(entryDate);
    }

    @Override
    public boolean isNew() {
        return _blogEntry.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _blogEntry.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _blogEntry.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _blogEntry.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _blogEntry.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _blogEntry.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _blogEntry.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _blogEntry.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _blogEntry.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _blogEntry.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _blogEntry.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new BlogEntryWrapper((BlogEntry) _blogEntry.clone());
    }

    @Override
    public int compareTo(BlogEntry blogEntry) {
        return _blogEntry.compareTo(blogEntry);
    }

    @Override
    public int hashCode() {
        return _blogEntry.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<BlogEntry> toCacheModel() {
        return _blogEntry.toCacheModel();
    }

    @Override
    public BlogEntry toEscapedModel() {
        return new BlogEntryWrapper(_blogEntry.toEscapedModel());
    }

    @Override
    public BlogEntry toUnescapedModel() {
        return new BlogEntryWrapper(_blogEntry.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _blogEntry.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _blogEntry.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _blogEntry.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BlogEntryWrapper)) {
            return false;
        }

        BlogEntryWrapper blogEntryWrapper = (BlogEntryWrapper) obj;

        if (Validator.equals(_blogEntry, blogEntryWrapper._blogEntry)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public BlogEntry getWrappedBlogEntry() {
        return _blogEntry;
    }

    @Override
    public BlogEntry getWrappedModel() {
        return _blogEntry;
    }

    @Override
    public void resetOriginalValues() {
        _blogEntry.resetOriginalValues();
    }
}
