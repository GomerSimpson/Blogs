package com.brest.ericpol.blog.service.model.impl;

import com.brest.ericpol.blog.service.model.BlogEntry;
import com.brest.ericpol.blog.service.model.BlogEntryModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the BlogEntry service. Represents a row in the &quot;blog_BlogEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.brest.ericpol.blog.service.model.BlogEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BlogEntryImpl}.
 * </p>
 *
 * @author Viktor Kolbik
 * @see BlogEntryImpl
 * @see com.brest.ericpol.blog.service.model.BlogEntry
 * @see com.brest.ericpol.blog.service.model.BlogEntryModel
 * @generated
 */
public class BlogEntryModelImpl extends BaseModelImpl<BlogEntry>
    implements BlogEntryModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a blog entry model instance should use the {@link com.brest.ericpol.blog.service.model.BlogEntry} interface instead.
     */
    public static final String TABLE_NAME = "blog_BlogEntry";
    public static final Object[][] TABLE_COLUMNS = {
            { "entryId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "entryText", Types.VARCHAR },
            { "entryDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table blog_BlogEntry (entryId LONG not null primary key,userId LONG,groupId LONG,companyId LONG,entryText VARCHAR(75) null,entryDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table blog_BlogEntry";
    public static final String ORDER_BY_JPQL = " ORDER BY blogEntry.entryId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY blog_BlogEntry.entryId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.brest.ericpol.blog.service.model.BlogEntry"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.brest.ericpol.blog.service.model.BlogEntry"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.brest.ericpol.blog.service.model.BlogEntry"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long ENTRYDATE_COLUMN_BITMASK = 2L;
    public static long GROUPID_COLUMN_BITMASK = 4L;
    public static long USERID_COLUMN_BITMASK = 8L;
    public static long ENTRYID_COLUMN_BITMASK = 16L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.brest.ericpol.blog.service.model.BlogEntry"));
    private static ClassLoader _classLoader = BlogEntry.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            BlogEntry.class
        };
    private long _entryId;
    private long _userId;
    private String _userUuid;
    private long _originalUserId;
    private boolean _setOriginalUserId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private String _entryText;
    private Date _entryDate;
    private Date _originalEntryDate;
    private long _columnBitmask;
    private BlogEntry _escapedModel;

    public BlogEntryModelImpl() {
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

    @Override
    public long getEntryId() {
        return _entryId;
    }

    @Override
    public void setEntryId(long entryId) {
        _entryId = entryId;
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _columnBitmask |= USERID_COLUMN_BITMASK;

        if (!_setOriginalUserId) {
            _setOriginalUserId = true;

            _originalUserId = _userId;
        }

        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public long getOriginalUserId() {
        return _originalUserId;
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @Override
    public String getEntryText() {
        if (_entryText == null) {
            return StringPool.BLANK;
        } else {
            return _entryText;
        }
    }

    @Override
    public void setEntryText(String entryText) {
        _entryText = entryText;
    }

    @Override
    public Date getEntryDate() {
        return _entryDate;
    }

    @Override
    public void setEntryDate(Date entryDate) {
        _columnBitmask |= ENTRYDATE_COLUMN_BITMASK;

        if (_originalEntryDate == null) {
            _originalEntryDate = _entryDate;
        }

        _entryDate = entryDate;
    }

    public Date getOriginalEntryDate() {
        return _originalEntryDate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            BlogEntry.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public BlogEntry toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (BlogEntry) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        BlogEntryImpl blogEntryImpl = new BlogEntryImpl();

        blogEntryImpl.setEntryId(getEntryId());
        blogEntryImpl.setUserId(getUserId());
        blogEntryImpl.setGroupId(getGroupId());
        blogEntryImpl.setCompanyId(getCompanyId());
        blogEntryImpl.setEntryText(getEntryText());
        blogEntryImpl.setEntryDate(getEntryDate());

        blogEntryImpl.resetOriginalValues();

        return blogEntryImpl;
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

        if (!(obj instanceof BlogEntry)) {
            return false;
        }

        BlogEntry blogEntry = (BlogEntry) obj;

        long primaryKey = blogEntry.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        BlogEntryModelImpl blogEntryModelImpl = this;

        blogEntryModelImpl._originalUserId = blogEntryModelImpl._userId;

        blogEntryModelImpl._setOriginalUserId = false;

        blogEntryModelImpl._originalGroupId = blogEntryModelImpl._groupId;

        blogEntryModelImpl._setOriginalGroupId = false;

        blogEntryModelImpl._originalCompanyId = blogEntryModelImpl._companyId;

        blogEntryModelImpl._setOriginalCompanyId = false;

        blogEntryModelImpl._originalEntryDate = blogEntryModelImpl._entryDate;

        blogEntryModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<BlogEntry> toCacheModel() {
        BlogEntryCacheModel blogEntryCacheModel = new BlogEntryCacheModel();

        blogEntryCacheModel.entryId = getEntryId();

        blogEntryCacheModel.userId = getUserId();

        blogEntryCacheModel.groupId = getGroupId();

        blogEntryCacheModel.companyId = getCompanyId();

        blogEntryCacheModel.entryText = getEntryText();

        String entryText = blogEntryCacheModel.entryText;

        if ((entryText != null) && (entryText.length() == 0)) {
            blogEntryCacheModel.entryText = null;
        }

        Date entryDate = getEntryDate();

        if (entryDate != null) {
            blogEntryCacheModel.entryDate = entryDate.getTime();
        } else {
            blogEntryCacheModel.entryDate = Long.MIN_VALUE;
        }

        return blogEntryCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{entryId=");
        sb.append(getEntryId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", entryText=");
        sb.append(getEntryText());
        sb.append(", entryDate=");
        sb.append(getEntryDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

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
