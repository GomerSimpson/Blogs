package com.brest.ericpol.blog.service.model.impl;

import com.brest.ericpol.blog.service.model.BlogEntry;
import com.brest.ericpol.blog.service.service.BlogEntryLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the BlogEntry service. Represents a row in the &quot;blog_BlogEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BlogEntryImpl}.
 * </p>
 *
 * @author Viktor Kolbik
 * @see BlogEntryImpl
 * @see com.brest.ericpol.blog.service.model.BlogEntry
 * @generated
 */
public abstract class BlogEntryBaseImpl extends BlogEntryModelImpl
    implements BlogEntry {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a blog entry model instance should use the {@link BlogEntry} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            BlogEntryLocalServiceUtil.addBlogEntry(this);
        } else {
            BlogEntryLocalServiceUtil.updateBlogEntry(this);
        }
    }
}