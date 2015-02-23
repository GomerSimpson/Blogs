package com.brest.ericpol.blog.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the BlogEntry service. Represents a row in the &quot;blog_BlogEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.brest.ericpol.blog.service.model.impl.BlogEntryImpl}.
 * </p>
 *
 * @author Viktor Kolbik
 * @see BlogEntry
 * @see com.brest.ericpol.blog.service.model.impl.BlogEntryImpl
 * @see com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl
 * @generated
 */
public interface BlogEntryModel extends BaseModel<BlogEntry> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a blog entry model instance should use the {@link BlogEntry} interface instead.
     */

    /**
     * Returns the primary key of this blog entry.
     *
     * @return the primary key of this blog entry
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this blog entry.
     *
     * @param primaryKey the primary key of this blog entry
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the entry ID of this blog entry.
     *
     * @return the entry ID of this blog entry
     */
    public long getEntryId();

    /**
     * Sets the entry ID of this blog entry.
     *
     * @param entryId the entry ID of this blog entry
     */
    public void setEntryId(long entryId);

    /**
     * Returns the user ID of this blog entry.
     *
     * @return the user ID of this blog entry
     */
    public long getUserId();

    /**
     * Sets the user ID of this blog entry.
     *
     * @param userId the user ID of this blog entry
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this blog entry.
     *
     * @return the user uuid of this blog entry
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this blog entry.
     *
     * @param userUuid the user uuid of this blog entry
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the group ID of this blog entry.
     *
     * @return the group ID of this blog entry
     */
    public long getGroupId();

    /**
     * Sets the group ID of this blog entry.
     *
     * @param groupId the group ID of this blog entry
     */
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this blog entry.
     *
     * @return the company ID of this blog entry
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this blog entry.
     *
     * @param companyId the company ID of this blog entry
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the entry text of this blog entry.
     *
     * @return the entry text of this blog entry
     */
    @AutoEscape
    public String getEntryText();

    /**
     * Sets the entry text of this blog entry.
     *
     * @param entryText the entry text of this blog entry
     */
    public void setEntryText(String entryText);

    /**
     * Returns the entry date of this blog entry.
     *
     * @return the entry date of this blog entry
     */
    public Date getEntryDate();

    /**
     * Sets the entry date of this blog entry.
     *
     * @param entryDate the entry date of this blog entry
     */
    public void setEntryDate(Date entryDate);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(BlogEntry blogEntry);

    @Override
    public int hashCode();

    @Override
    public CacheModel<BlogEntry> toCacheModel();

    @Override
    public BlogEntry toEscapedModel();

    @Override
    public BlogEntry toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
