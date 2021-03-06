package com.brest.ericpol.blog.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BlogEntryLocalService}.
 *
 * @author Viktor Kolbik
 * @see BlogEntryLocalService
 * @generated
 */
public class BlogEntryLocalServiceWrapper implements BlogEntryLocalService,
    ServiceWrapper<BlogEntryLocalService> {
    private BlogEntryLocalService _blogEntryLocalService;

    public BlogEntryLocalServiceWrapper(
        BlogEntryLocalService blogEntryLocalService) {
        _blogEntryLocalService = blogEntryLocalService;
    }

    /**
    * Adds the blog entry to the database. Also notifies the appropriate model listeners.
    *
    * @param blogEntry the blog entry
    * @return the blog entry that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.brest.ericpol.blog.service.model.BlogEntry addBlogEntry(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.addBlogEntry(blogEntry);
    }

    /**
    * Creates a new blog entry with the primary key. Does not add the blog entry to the database.
    *
    * @param entryId the primary key for the new blog entry
    * @return the new blog entry
    */
    @Override
    public com.brest.ericpol.blog.service.model.BlogEntry createBlogEntry(
        long entryId) {
        return _blogEntryLocalService.createBlogEntry(entryId);
    }

    /**
    * Deletes the blog entry with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryId the primary key of the blog entry
    * @return the blog entry that was removed
    * @throws PortalException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.brest.ericpol.blog.service.model.BlogEntry deleteBlogEntry(
        long entryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.deleteBlogEntry(entryId);
    }

    /**
    * Deletes the blog entry from the database. Also notifies the appropriate model listeners.
    *
    * @param blogEntry the blog entry
    * @return the blog entry that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.brest.ericpol.blog.service.model.BlogEntry deleteBlogEntry(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.deleteBlogEntry(blogEntry);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _blogEntryLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.dynamicQuery(dynamicQuery);
    }

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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.dynamicQuery(dynamicQuery, start, end);
    }

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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.brest.ericpol.blog.service.model.BlogEntry fetchBlogEntry(
        long entryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.fetchBlogEntry(entryId);
    }

    /**
    * Returns the blog entry with the primary key.
    *
    * @param entryId the primary key of the blog entry
    * @return the blog entry
    * @throws PortalException if a blog entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.brest.ericpol.blog.service.model.BlogEntry getBlogEntry(
        long entryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.getBlogEntry(entryId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> getBlogEntries(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.getBlogEntries(start, end);
    }

    /**
    * Returns the number of blog entries.
    *
    * @return the number of blog entries
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getBlogEntriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.getBlogEntriesCount();
    }

    /**
    * Updates the blog entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param blogEntry the blog entry
    * @return the blog entry that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.brest.ericpol.blog.service.model.BlogEntry updateBlogEntry(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.updateBlogEntry(blogEntry);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _blogEntryLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _blogEntryLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _blogEntryLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.brest.ericpol.blog.service.model.BlogEntry addBlogEntry(
        java.lang.Long userId, java.lang.Long groupId,
        java.lang.Long companyId, java.lang.String title,
        java.lang.String entryText, java.sql.Date entryDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.addBlogEntry(userId, groupId, companyId,
            title, entryText, entryDate);
    }

    @Override
    public com.brest.ericpol.blog.service.model.BlogEntry updateBlogEntry(
        java.lang.Long entryId, java.lang.Long userId, java.lang.Long groupId,
        java.lang.Long companyId, java.lang.String title,
        java.lang.String entryText, java.sql.Date entryDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.updateBlogEntry(entryId, userId, groupId,
            companyId, title, entryText, entryDate);
    }

    @Override
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByUserGroupCompanyId(
        java.lang.Long userId, java.lang.Long groupId, java.lang.Long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.findByUserGroupCompanyId(userId, groupId,
            companyId);
    }

    @Override
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findAllEntries()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.findAllEntries();
    }

    @Override
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.findByGroupId(groupId);
    }

    @Override
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateLaterThan(
        java.lang.Long userId, java.lang.Long groupId,
        java.lang.Long companyId, java.sql.Date date)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.findByDateLaterThan(userId, groupId,
            companyId, date);
    }

    @Override
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByDateEarlierThan(
        java.lang.Long userId, java.lang.Long groupId,
        java.lang.Long companyId, java.sql.Date date)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.findByDateEarlierThan(userId, groupId,
            companyId, date);
    }

    @Override
    public java.util.List<com.brest.ericpol.blog.service.model.BlogEntry> findByTimePeriod(
        java.lang.Long userId, java.lang.Long groupId,
        java.lang.Long companyId, java.sql.Date lowBorder,
        java.sql.Date topBorder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _blogEntryLocalService.findByTimePeriod(userId, groupId,
            companyId, lowBorder, topBorder);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BlogEntryLocalService getWrappedBlogEntryLocalService() {
        return _blogEntryLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBlogEntryLocalService(
        BlogEntryLocalService blogEntryLocalService) {
        _blogEntryLocalService = blogEntryLocalService;
    }

    @Override
    public BlogEntryLocalService getWrappedService() {
        return _blogEntryLocalService;
    }

    @Override
    public void setWrappedService(BlogEntryLocalService blogEntryLocalService) {
        _blogEntryLocalService = blogEntryLocalService;
    }
}
