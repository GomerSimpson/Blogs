package com.brest.ericpol.blog.service.service.persistence;

import com.brest.ericpol.blog.service.model.BlogEntry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the blog entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Viktor Kolbik
 * @see BlogEntryPersistenceImpl
 * @see BlogEntryUtil
 * @generated
 */
public interface BlogEntryPersistence extends BasePersistence<BlogEntry> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BlogEntryUtil} to access the blog entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the blog entries where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first blog entry in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first blog entry in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last blog entry in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last blog entry in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry[] findByUserId_PrevAndNext(
        long entryId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the blog entries where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of blog entries where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the blog entries where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first blog entry in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first blog entry in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last blog entry in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last blog entry in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry[] findByGroupId_PrevAndNext(
        long entryId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the blog entries where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of blog entries where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the blog entries where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first blog entry in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first blog entry in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last blog entry in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last blog entry in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry[] findByCompanyId_PrevAndNext(
        long entryId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the blog entries where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of blog entries where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the blog entries where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @return the matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserGroupCompanyId(
        long userId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserGroupCompanyId(
        long userId, long groupId, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserGroupCompanyId(
        long userId, long groupId, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry findByUserGroupCompanyId_First(
        long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByUserGroupCompanyId_First(
        long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry findByUserGroupCompanyId_Last(
        long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByUserGroupCompanyId_Last(
        long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry[] findByUserGroupCompanyId_PrevAndNext(
        long entryId, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the blog entries where userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserGroupCompanyId(long userId, long groupId,
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of blog entries where userId = &#63; and groupId = &#63; and companyId = &#63;.
    *
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @return the number of matching blog entries
    * @throws SystemException if a system exception occurred
    */
    public int countByUserGroupCompanyId(long userId, long groupId,
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateLaterThan(
        java.util.Date entryDate, long userId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateLaterThan(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateLaterThan(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry findByDateLaterThan_First(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByDateLaterThan_First(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry findByDateLaterThan_Last(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByDateLaterThan_Last(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry[] findByDateLaterThan_PrevAndNext(
        long entryId, java.util.Date entryDate, long userId, long groupId,
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the blog entries where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByDateLaterThan(java.util.Date entryDate, long userId,
        long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public int countByDateLaterThan(java.util.Date entryDate, long userId,
        long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateEarlierThan(
        java.util.Date entryDate, long userId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateEarlierThan(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateEarlierThan(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry findByDateEarlierThan_First(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByDateEarlierThan_First(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry findByDateEarlierThan_Last(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByDateEarlierThan_Last(
        java.util.Date entryDate, long userId, long groupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.blog.service.model.BlogEntry[] findByDateEarlierThan_PrevAndNext(
        long entryId, java.util.Date entryDate, long userId, long groupId,
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the blog entries where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
    *
    * @param entryDate the entry date
    * @param userId the user ID
    * @param groupId the group ID
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByDateEarlierThan(java.util.Date entryDate, long userId,
        long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public int countByDateEarlierThan(java.util.Date entryDate, long userId,
        long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the blog entry in the entity cache if it is enabled.
    *
    * @param blogEntry the blog entry
    */
    public void cacheResult(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry);

    /**
    * Caches the blog entries in the entity cache if it is enabled.
    *
    * @param blogEntries the blog entries
    */
    public void cacheResult(
        java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> blogEntries);

    /**
    * Creates a new blog entry with the primary key. Does not add the blog entry to the database.
    *
    * @param entryId the primary key for the new blog entry
    * @return the new blog entry
    */
    public com.brest.ericpol.blog.service.model.BlogEntry create(long entryId);

    /**
    * Removes the blog entry with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryId the primary key of the blog entry
    * @return the blog entry that was removed
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry remove(long entryId)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.brest.ericpol.blog.service.model.BlogEntry updateImpl(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the blog entry with the primary key or throws a {@link com.brest.ericpol.blog.service.NoSuchBlogEntryException} if it could not be found.
    *
    * @param entryId the primary key of the blog entry
    * @return the blog entry
    * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry findByPrimaryKey(
        long entryId)
        throws com.brest.ericpol.blog.service.NoSuchBlogEntryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the blog entry with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param entryId the primary key of the blog entry
    * @return the blog entry, or <code>null</code> if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.blog.service.model.BlogEntry fetchByPrimaryKey(
        long entryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the blog entries.
    *
    * @return the blog entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the blog entries from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of blog entries.
    *
    * @return the number of blog entries
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
