package com.brest.ericpol.blog.service.service.impl;

import com.brest.ericpol.blog.Blog;
import com.brest.ericpol.blog.service.model.BlogEntry;
import com.brest.ericpol.blog.service.service.base.BlogEntryLocalServiceBaseImpl;
import com.brest.ericpol.blog.service.service.persistence.BlogEntryPersistence;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the blog entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.brest.ericpol.blog.service.service.BlogEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Viktor Kolbik
 * @see com.brest.ericpol.blog.service.service.base.BlogEntryLocalServiceBaseImpl
 * @see com.brest.ericpol.blog.service.service.BlogEntryLocalServiceUtil
 */
public class BlogEntryLocalServiceImpl extends BlogEntryLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.brest.ericpol.blog.service.service.BlogEntryLocalServiceUtil} to access the blog entry local service.
     */

    public BlogEntry addBlogEntry(Long userId, Long groupId, Long companyId,
                                  String entryText, Date entryDate) throws SystemException {
        long newEntryId = CounterLocalServiceUtil.increment(BlogEntry.class.getName());

        BlogEntry blogEntry = blogEntryPersistence.create(newEntryId);
        blogEntry.setUserId(userId);
        blogEntry.setGroupId(groupId);
        blogEntry.setCompanyId(companyId);
        blogEntry.setEntryText(entryText);
        blogEntry.setEntryDate(entryDate);

        return blogEntryPersistence.update(blogEntry);
    }

    public BlogEntry updateBlogEntry(Long entryId, Long userId, Long groupId, Long companyId,
                                     String entryText, Date entryDate) throws SystemException {
        BlogEntry blogEntry = blogEntryPersistence.create(entryId);
        blogEntry.setNew(false);
        blogEntry.setUserId(userId);
        blogEntry.setGroupId(groupId);
        blogEntry.setCompanyId(companyId);
        blogEntry.setEntryText(entryText);
        blogEntry.setEntryDate(entryDate);

        return blogEntryPersistence.update(blogEntry);
    }

    public List<BlogEntry> findByUserGroupCompanyId(Long userId, Long groupId, Long companyId) throws SystemException {
        return blogEntryPersistence.findByUserGroupCompanyId(userId, groupId, companyId);
    }

    public List<BlogEntry> findByDateLaterThan(Long userId, Long groupId, Long companyId, Date date) throws SystemException {
        return blogEntryPersistence.findByDateLaterThan(date, userId, groupId, companyId);
    }

    public List<BlogEntry> findByDateEarlierThan(Long userId, Long groupId, Long companyId, Date date) throws SystemException {
        return blogEntryPersistence.findByDateEarlierThan(date, userId, groupId, companyId);
    }

    public List<BlogEntry> findByTimePeriod(Long userId, Long groupId, Long companyId, Date lowBorder, Date topBorder) throws SystemException {
        List<BlogEntry> lowBorderList = blogEntryPersistence.findByDateLaterThan(lowBorder, userId, groupId, companyId);
        List<BlogEntry> topBorderList = blogEntryPersistence.findByDateEarlierThan(topBorder, userId, groupId, companyId);
        List<BlogEntry> periodList = new ArrayList<BlogEntry>();

        for(BlogEntry be : lowBorderList){
            if(topBorderList.contains(be)){
                periodList.add(be);
            }
        }

        return periodList;
    }

}
