package com.brest.ericpol.blog.service.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for BlogEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Viktor Kolbik
 * @see BlogEntryLocalServiceUtil
 * @see com.brest.ericpol.blog.service.service.base.BlogEntryLocalServiceBaseImpl
 * @see com.brest.ericpol.blog.service.service.impl.BlogEntryLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface BlogEntryLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BlogEntryLocalServiceUtil} to access the blog entry local service. Add custom service methods to {@link com.brest.ericpol.blog.service.service.impl.BlogEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the blog entry to the database. Also notifies the appropriate model listeners.
    *
    * @param blogEntry the blog entry
    * @return the blog entry that was added
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.brest.ericpol.blog.service.model.BlogEntry addBlogEntry(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new blog entry with the primary key. Does not add the blog entry to the database.
    *
    * @param entryId the primary key for the new blog entry
    * @return the new blog entry
    */
    public com.brest.ericpol.blog.service.model.BlogEntry createBlogEntry(
        long entryId);

    /**
    * Deletes the blog entry with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryId the primary key of the blog entry
    * @return the blog entry that was removed
    * @throws PortalException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.brest.ericpol.blog.service.model.BlogEntry deleteBlogEntry(
        long entryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the blog entry from the database. Also notifies the appropriate model listeners.
    *
    * @param blogEntry the blog entry
    * @return the blog entry that was removed
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.brest.ericpol.blog.service.model.BlogEntry deleteBlogEntry(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.brest.ericpol.blog.service.model.BlogEntry fetchBlogEntry(
        long entryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the blog entry with the primary key.
    *
    * @param entryId the primary key of the blog entry
    * @return the blog entry
    * @throws PortalException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.brest.ericpol.blog.service.model.BlogEntry getBlogEntry(
        long entryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> getBlogEntries(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of blog entries.
    *
    * @return the number of blog entries
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getBlogEntriesCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the blog entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param blogEntry the blog entry
    * @return the blog entry that was updated
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.brest.ericpol.blog.service.model.BlogEntry updateBlogEntry(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public com.brest.ericpol.blog.service.model.BlogEntry addBlogEntry(
        java.lang.Long userId, java.lang.Long groupId,
        java.lang.Long companyId, java.lang.String title,
        java.lang.String entryText, java.sql.Date entryDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.brest.ericpol.blog.service.model.BlogEntry updateBlogEntry(
        java.lang.Long entryId, java.lang.Long userId, java.lang.Long groupId,
        java.lang.Long companyId, java.lang.String title,
        java.lang.String entryText, java.sql.Date entryDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserGroupCompanyId(
        java.lang.Long userId, java.lang.Long groupId, java.lang.Long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findAllEntries()
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateLaterThan(
        java.lang.Long userId, java.lang.Long groupId,
        java.lang.Long companyId, java.sql.Date date)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateEarlierThan(
        java.lang.Long userId, java.lang.Long groupId,
        java.lang.Long companyId, java.sql.Date date)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByTimePeriod(
        java.lang.Long userId, java.lang.Long groupId,
        java.lang.Long companyId, java.sql.Date lowBorder,
        java.sql.Date topBorder)
        throws com.liferay.portal.kernel.exception.SystemException;
}
