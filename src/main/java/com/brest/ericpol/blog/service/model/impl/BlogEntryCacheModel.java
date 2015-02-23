package com.brest.ericpol.blog.service.model.impl;

import com.brest.ericpol.blog.service.model.BlogEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BlogEntry in entity cache.
 *
 * @author Viktor Kolbik
 * @see BlogEntry
 * @generated
 */
public class BlogEntryCacheModel implements CacheModel<BlogEntry>,
    Externalizable {
    public long entryId;
    public long userId;
    public long groupId;
    public long companyId;
    public String entryText;
    public long entryDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{entryId=");
        sb.append(entryId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", entryText=");
        sb.append(entryText);
        sb.append(", entryDate=");
        sb.append(entryDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public BlogEntry toEntityModel() {
        BlogEntryImpl blogEntryImpl = new BlogEntryImpl();

        blogEntryImpl.setEntryId(entryId);
        blogEntryImpl.setUserId(userId);
        blogEntryImpl.setGroupId(groupId);
        blogEntryImpl.setCompanyId(companyId);

        if (entryText == null) {
            blogEntryImpl.setEntryText(StringPool.BLANK);
        } else {
            blogEntryImpl.setEntryText(entryText);
        }

        if (entryDate == Long.MIN_VALUE) {
            blogEntryImpl.setEntryDate(null);
        } else {
            blogEntryImpl.setEntryDate(new Date(entryDate));
        }

        blogEntryImpl.resetOriginalValues();

        return blogEntryImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        entryId = objectInput.readLong();
        userId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        entryText = objectInput.readUTF();
        entryDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(entryId);
        objectOutput.writeLong(userId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);

        if (entryText == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(entryText);
        }

        objectOutput.writeLong(entryDate);
    }
}
