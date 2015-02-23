package com.brest.ericpol.blog.service.service.persistence;

import com.brest.ericpol.blog.service.model.BlogEntry;
import com.brest.ericpol.blog.service.service.BlogEntryLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Viktor Kolbik
 * @generated
 */
public abstract class BlogEntryActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public BlogEntryActionableDynamicQuery() throws SystemException {
        setBaseLocalService(BlogEntryLocalServiceUtil.getService());
        setClass(BlogEntry.class);

        setClassLoader(com.brest.ericpol.blog.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("entryId");
    }
}
