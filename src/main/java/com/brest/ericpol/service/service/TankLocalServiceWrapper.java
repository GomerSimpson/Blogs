package com.brest.ericpol.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TankLocalService}.
 *
 * @author Viktor Kolbik
 * @see TankLocalService
 * @generated
 */
public class TankLocalServiceWrapper implements TankLocalService,
    ServiceWrapper<TankLocalService> {
    private TankLocalService _tankLocalService;

    public TankLocalServiceWrapper(TankLocalService tankLocalService) {
        _tankLocalService = tankLocalService;
    }

    /**
    * Adds the tank to the database. Also notifies the appropriate model listeners.
    *
    * @param tank the tank
    * @return the tank that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.brest.ericpol.service.model.Tank addTank(
        com.brest.ericpol.service.model.Tank tank)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.addTank(tank);
    }

    /**
    * Creates a new tank with the primary key. Does not add the tank to the database.
    *
    * @param tankId the primary key for the new tank
    * @return the new tank
    */
    @Override
    public com.brest.ericpol.service.model.Tank createTank(long tankId) {
        return _tankLocalService.createTank(tankId);
    }

    /**
    * Deletes the tank with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tankId the primary key of the tank
    * @return the tank that was removed
    * @throws PortalException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.brest.ericpol.service.model.Tank deleteTank(long tankId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.deleteTank(tankId);
    }

    /**
    * Deletes the tank from the database. Also notifies the appropriate model listeners.
    *
    * @param tank the tank
    * @return the tank that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.brest.ericpol.service.model.Tank deleteTank(
        com.brest.ericpol.service.model.Tank tank)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.deleteTank(tank);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _tankLocalService.dynamicQuery();
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
        return _tankLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.TankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _tankLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.TankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _tankLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _tankLocalService.dynamicQueryCount(dynamicQuery);
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
        return _tankLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.brest.ericpol.service.model.Tank fetchTank(long tankId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.fetchTank(tankId);
    }

    /**
    * Returns the tank with the primary key.
    *
    * @param tankId the primary key of the tank
    * @return the tank
    * @throws PortalException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.brest.ericpol.service.model.Tank getTank(long tankId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.getTank(tankId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the tanks.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.TankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of tanks
    * @param end the upper bound of the range of tanks (not inclusive)
    * @return the range of tanks
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.brest.ericpol.service.model.Tank> getTanks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.getTanks(start, end);
    }

    /**
    * Returns the number of tanks.
    *
    * @return the number of tanks
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getTanksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.getTanksCount();
    }

    /**
    * Updates the tank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param tank the tank
    * @return the tank that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.brest.ericpol.service.model.Tank updateTank(
        com.brest.ericpol.service.model.Tank tank)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.updateTank(tank);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _tankLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _tankLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _tankLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.brest.ericpol.MyBean> getFullEntity(
        java.util.List<com.brest.ericpol.service.model.Tank> list)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.getFullEntity(list);
    }

    @Override
    public com.brest.ericpol.service.model.Tank addTank(
        java.lang.String number, java.lang.String modification,
        java.lang.Long price)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.addTank(number, modification, price);
    }

    @Override
    public void updateTank(java.lang.Long tankId, java.lang.String number,
        java.lang.String modification, java.lang.Long price)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _tankLocalService.updateTank(tankId, number, modification, price);
    }

    @Override
    public java.util.List<com.brest.ericpol.service.model.Tank> findByModification(
        java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.findByModification(modification);
    }

    @Override
    public java.util.List<com.brest.ericpol.service.model.Tank> findByPrice(
        java.lang.Long lowBorder, java.lang.Long topBorder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.findByPrice(lowBorder, topBorder);
    }

    @Override
    public com.brest.ericpol.service.model.Tank findByNumber(
        java.lang.String number)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.findByNumber(number);
    }

    @Override
    public java.util.List<com.brest.ericpol.service.model.Tank> getAllTanks()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tankLocalService.getAllTanks();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TankLocalService getWrappedTankLocalService() {
        return _tankLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTankLocalService(TankLocalService tankLocalService) {
        _tankLocalService = tankLocalService;
    }

    @Override
    public TankLocalService getWrappedService() {
        return _tankLocalService;
    }

    @Override
    public void setWrappedService(TankLocalService tankLocalService) {
        _tankLocalService = tankLocalService;
    }
}
