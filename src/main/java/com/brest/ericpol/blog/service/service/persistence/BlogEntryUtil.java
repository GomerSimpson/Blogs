package com.brest.ericpol.blog.service.service.persistence;

import com.brest.ericpol.blog.service.model.BlogEntry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the blog entry service. This utility wraps {@link BlogEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Viktor Kolbik
 * @see BlogEntryPersistence
 * @see BlogEntryPersistenceImpl
 * @generated
 */
public class BlogEntryUtil {
    private static BlogEntryPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(BlogEntry blogEntry) {
        getPersistence().clearCache(blogEntry);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<BlogEntry> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<BlogEntry> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<BlogEntry> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static BlogEntry update(BlogEntry blogEntry)
        throws SystemException {
        return getPersistence().update(blogEntry);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static BlogEntry update(BlogEntry blogEntry,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(blogEntry, serviceContext);
    }

    /**
    * Returns all the blog entries where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

    /**
    * Returns a range of all the blog entries where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @return the range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    /**
    * Returns an ordered range of all the blog entries where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the blog entries before and after the current blog entry in the ordered set where userId = &#63;.
    *
    * @param entryId the primary key of the current blog entry
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry[] findByUserId_PrevAndNext(
        long entryId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId_PrevAndNext(entryId, userId, orderByComparator);
    }

    /**
    * Removes all the blog entries where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of blog entries where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Returns all the blog entries where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the blog entries where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @return the range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the blog entries where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the blog entries before and after the current blog entry in the ordered set where groupId = &#63;.
    *
    * @param entryId the primary key of the current blog entry
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry[] findByGroupId_PrevAndNext(
        long entryId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(entryId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the blog entries where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of blog entries where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns all the blog entries where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the blog entries where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @return the range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the blog entries where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the blog entries before and after the current blog entry in the ordered set where companyId = &#63;.
    *
    * @param entryId the primary key of the current blog entry
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry[] findByCompanyId_PrevAndNext(
        long entryId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(entryId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the blog entries where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of blog entries where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns all the blog entries where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @return the matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserGroupCompanyId(
        long userId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserGroupCompanyId(userId, groupId, companyId);
    }

    /**
    * Returns a range of all the blog entries where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @return the range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserGroupCompanyId(
        long userId, long groupId, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserGroupCompanyId(userId, groupId, companyId, start,
            end);
    }

    /**
    * Returns an ordered range of all the blog entries where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserGroupCompanyId(
        long userId, long groupId, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserGroupCompanyId(userId, groupId, companyId, start,
            end, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByUserGroupCompanyId_First(
        long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserGroupCompanyId_First(userId, groupId, companyId,
            orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByUserGroupCompanyId_First(
        long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserGroupCompanyId_First(userId, groupId, companyId,
            orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByUserGroupCompanyId_Last(
        long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserGroupCompanyId_Last(userId, groupId, companyId,
            orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByUserGroupCompanyId_Last(
        long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserGroupCompanyId_Last(userId, groupId, companyId,
            orderByComparator);
    }

    /**
    * Returns the blog entries before and after the current blog entry in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryId the primary key of the current blog entry
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry[] findByUserGroupCompanyId_PrevAndNext(
        long entryId, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserGroupCompanyId_PrevAndNext(entryId, userId,
            groupId, companyId, orderByComparator);
    }

    /**
    * Removes all the blog entries where userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserGroupCompanyId(long userId, long groupId,
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserGroupCompanyId(userId, groupId, companyId);
    }

    /**
    * Returns the number of blog entries where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @return the number of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserGroupCompanyId(long userId, long groupId,
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByUserGroupCompanyId(userId, groupId, companyId);
    }

    /**
    * Returns all the blog entries where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @return the matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateLaterThan(
        java.util.Date entryDate, long userId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateLaterThan(entryDate, userId, groupId, companyId);
    }

    /**
    * Returns a range of all the blog entries where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @return the range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateLaterThan(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateLaterThan(entryDate, userId, groupId, companyId,
            start, end);
    }

    /**
    * Returns an ordered range of all the blog entries where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateLaterThan(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateLaterThan(entryDate, userId, groupId, companyId,
            start, end, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByDateLaterThan_First(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateLaterThan_First(entryDate, userId, groupId,
            companyId, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByDateLaterThan_First(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDateLaterThan_First(entryDate, userId, groupId,
            companyId, orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByDateLaterThan_Last(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateLaterThan_Last(entryDate, userId, groupId,
            companyId, orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByDateLaterThan_Last(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDateLaterThan_Last(entryDate, userId, groupId,
            companyId, orderByComparator);
    }

    /**
    * Returns the blog entries before and after the current blog entry in the ordered set where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryId the primary key of the current blog entry
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry[] findByDateLaterThan_PrevAndNext(
        long entryId, java.util.Date entryDate, long userId, long groupId,
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateLaterThan_PrevAndNext(entryId, entryDate, userId,
            groupId, companyId, orderByComparator);
    }

    /**
    * Removes all the blog entries where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByDateLaterThan(java.util.Date entryDate,
        long userId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByDateLaterThan(entryDate, userId, groupId, companyId);
    }

    /**
    * Returns the number of blog entries where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @return the number of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static int countByDateLaterThan(java.util.Date entryDate,
        long userId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByDateLaterThan(entryDate, userId, groupId, companyId);
    }

    /**
    * Returns all the blog entries where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @return the matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateEarlierThan(
        java.util.Date entryDate, long userId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateEarlierThan(entryDate, userId, groupId, companyId);
    }

    /**
    * Returns a range of all the blog entries where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @return the range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateEarlierThan(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateEarlierThan(entryDate, userId, groupId,
            companyId, start, end);
    }

    /**
    * Returns an ordered range of all the blog entries where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateEarlierThan(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateEarlierThan(entryDate, userId, groupId,
            companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByDateEarlierThan_First(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateEarlierThan_First(entryDate, userId, groupId,
            companyId, orderByComparator);
    }

    /**
    * Returns the first blog entry in the ordered set where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByDateEarlierThan_First(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDateEarlierThan_First(entryDate, userId, groupId,
            companyId, orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByDateEarlierThan_Last(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateEarlierThan_Last(entryDate, userId, groupId,
            companyId, orderByComparator);
    }

    /**
    * Returns the last blog entry in the ordered set where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByDateEarlierThan_Last(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDateEarlierThan_Last(entryDate, userId, groupId,
            companyId, orderByComparator);
    }

    /**
    * Returns the blog entries before and after the current blog entry in the ordered set where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryId the primary key of the current blog entry
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry[] findByDateEarlierThan_PrevAndNext(
        long entryId, java.util.Date entryDate, long userId, long groupId,
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDateEarlierThan_PrevAndNext(entryId, entryDate,
            userId, groupId, companyId, orderByComparator);
    }

    /**
    * Removes all the blog entries where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByDateEarlierThan(java.util.Date entryDate,
        long userId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByDateEarlierThan(entryDate, userId, groupId, companyId);
    }

    /**
    * Returns the number of blog entries where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @return the number of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public static int countByDateEarlierThan(java.util.Date entryDate,
        long userId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByDateEarlierThan(entryDate, userId, groupId, companyId);
    }

    /**
    * Caches the blog entry in the entity cache if it is enabled.
    *
    * @param blogEntry the blog entry
    */
    public static void cacheResult(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry) {
        getPersistence().cacheResult(blogEntry);
    }

    /**
    * Caches the blog entries in the entity cache if it is enabled.
    *
    * @param blogEntries the blog entries
    */
    public static void cacheResult(
        java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> blogEntries) {
        getPersistence().cacheResult(blogEntries);
    }

    /**
    * Creates a new blog entry with the primary key. Does not add the blog entry to the database.
    *
    * @param entryId the primary key for the new blog entry
    * @return the new blog entry
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry create(
        long entryId) {
        return getPersistence().create(entryId);
    }

    /**
    * Removes the blog entry with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryId the primary key of the blog entry
    * @return the blog entry that was removed
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry remove(
        long entryId)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(entryId);
    }

    public static com.brest.ericpol.blog.service.model.BlogEntry updateImpl(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(blogEntry);
    }

    /**
    * Returns the blog entry with the primary key or throws a {@link com.brest.ericpol.blog.service.NoSuchBlogEntryException} if it could not be found.
    *
    * @param entryId the primary key of the blog entry
    * @return the blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry findByPrimaryKey(
        long entryId)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(entryId);
    }

    /**
    * Returns the blog entry with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param entryId the primary key of the blog entry
    * @return the blog entry, or <code>null</code> if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.blog.service.model.BlogEntry fetchByPrimaryKey(
        long entryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(entryId);
    }

    /**
    * Returns all the blog entries.
    *
    * @return the blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the blog entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @return the range of blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the blog entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of blog entries
    * @param end the upper bound of the range of blog entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of blog entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the blog entries from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of blog entries.
    *
    * @return the number of blog entries
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static BlogEntryPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (BlogEntryPersistence) PortletBeanLocatorUtil.locate(com.brest.ericpol.blog.service.service.ClpSerializer.getServletContextName(),
                    BlogEntryPersistence.class.getName());

            ReferenceRegistry.registerReference(BlogEntryUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(BlogEntryPersistence persistence) {
    }
}
