package com.brest.ericpol.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Tank. This utility wraps
 * {@link com.brest.ericpol.service.service.impl.TankLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Viktor Kolbik
 * @see TankLocalService
 * @see com.brest.ericpol.service.service.base.TankLocalServiceBaseImpl
 * @see com.brest.ericpol.service.service.impl.TankLocalServiceImpl
 * @generated
 */
public class TankLocalServiceUtil {
    private static TankLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.brest.ericpol.service.service.impl.TankLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the tank to the database. Also notifies the appropriate model listeners.
    *
    * @param tank the tank
    * @return the tank that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank addTank(
        com.brest.ericpol.service.model.Tank tank)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addTank(tank);
    }

    /**
    * Creates a new tank with the primary key. Does not add the tank to the database.
    *
    * @param tankId the primary key for the new tank
    * @return the new tank
    */
    public static com.brest.ericpol.service.model.Tank createTank(long tankId) {
        return getService().createTank(tankId);
    }

    /**
    * Deletes the tank with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tankId the primary key of the tank
    * @return the tank that was removed
    * @throws PortalException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank deleteTank(long tankId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteTank(tankId);
    }

    /**
    * Deletes the tank from the database. Also notifies the appropriate model listeners.
    *
    * @param tank the tank
    * @return the tank that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank deleteTank(
        com.brest.ericpol.service.model.Tank tank)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteTank(tank);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.brest.ericpol.service.model.Tank fetchTank(long tankId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchTank(tankId);
    }

    /**
    * Returns the tank with the primary key.
    *
    * @param tankId the primary key of the tank
    * @return the tank
    * @throws PortalException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank getTank(long tankId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getTank(tankId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.brest.ericpol.service.model.Tank> getTanks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTanks(start, end);
    }

    /**
    * Returns the number of tanks.
    *
    * @return the number of tanks
    * @throws SystemException if a system exception occurred
    */
    public static int getTanksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTanksCount();
    }

    /**
    * Updates the tank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param tank the tank
    * @return the tank that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank updateTank(
        com.brest.ericpol.service.model.Tank tank)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateTank(tank);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static java.util.List<com.brest.ericpol.MyBean> getFullEntity(
        java.util.List<com.brest.ericpol.service.model.Tank> list)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFullEntity(list);
    }

    public static com.brest.ericpol.service.model.Tank addTank(
        java.lang.String modification, java.lang.String number,
        java.lang.Long price)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addTank(modification, number, price);
    }

    public static java.util.List<com.brest.ericpol.service.model.Tank> findByModification(
        java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByModification(modification);
    }

    public static java.util.List<com.brest.ericpol.service.model.Tank> findByPrice(
        java.lang.Long lowBorder, java.lang.Long topBorder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPrice(lowBorder, topBorder);
    }

    public static com.brest.ericpol.service.model.Tank findByNumber(
        java.lang.String number)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByNumber(number);
    }

    public static java.util.List<com.brest.ericpol.service.model.Tank> getAllTanks()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllTanks();
    }

    public static void clearService() {
        _service = null;
    }

    public static TankLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    TankLocalService.class.getName());

            if (invokableLocalService instanceof TankLocalService) {
                _service = (TankLocalService) invokableLocalService;
            } else {
                _service = new TankLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(TankLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(TankLocalService service) {
    }
}
