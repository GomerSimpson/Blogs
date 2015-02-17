package com.brest.ericpol.service.service.persistence;

import com.brest.ericpol.service.model.Tank;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the tank service. This utility wraps {@link TankPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Viktor Kolbik
 * @see TankPersistence
 * @see TankPersistenceImpl
 * @generated
 */
public class TankUtil {
    private static TankPersistence _persistence;

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
    public static void clearCache(Tank tank) {
        getPersistence().clearCache(tank);
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
    public static List<Tank> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Tank> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Tank> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Tank update(Tank tank) throws SystemException {
        return getPersistence().update(tank);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Tank update(Tank tank, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(tank, serviceContext);
    }

    /**
    * Returns all the tanks where modification = &#63;.
    *
    * @param modification the modification
    * @return the matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findByModification(
        java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByModification(modification);
    }

    /**
    * Returns a range of all the tanks where modification = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.TankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param modification the modification
    * @param start the lower bound of the range of tanks
    * @param end the upper bound of the range of tanks (not inclusive)
    * @return the range of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findByModification(
        java.lang.String modification, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByModification(modification, start, end);
    }

    /**
    * Returns an ordered range of all the tanks where modification = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.TankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param modification the modification
    * @param start the lower bound of the range of tanks
    * @param end the upper bound of the range of tanks (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findByModification(
        java.lang.String modification, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByModification(modification, start, end,
            orderByComparator);
    }

    /**
    * Returns the first tank in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank findByModification_First(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByModification_First(modification, orderByComparator);
    }

    /**
    * Returns the first tank in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank fetchByModification_First(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByModification_First(modification, orderByComparator);
    }

    /**
    * Returns the last tank in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank findByModification_Last(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByModification_Last(modification, orderByComparator);
    }

    /**
    * Returns the last tank in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank fetchByModification_Last(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByModification_Last(modification, orderByComparator);
    }

    /**
    * Returns the tanks before and after the current tank in the ordered set where modification = &#63;.
    *
    * @param tankId the primary key of the current tank
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank[] findByModification_PrevAndNext(
        long tankId, java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByModification_PrevAndNext(tankId, modification,
            orderByComparator);
    }

    /**
    * Removes all the tanks where modification = &#63; from the database.
    *
    * @param modification the modification
    * @throws SystemException if a system exception occurred
    */
    public static void removeByModification(java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByModification(modification);
    }

    /**
    * Returns the number of tanks where modification = &#63;.
    *
    * @param modification the modification
    * @return the number of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static int countByModification(java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByModification(modification);
    }

    /**
    * Returns the tank where number = &#63; or throws a {@link com.brest.ericpol.service.NoSuchTankException} if it could not be found.
    *
    * @param number the number
    * @return the matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank findByNumber(
        java.lang.String number)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByNumber(number);
    }

    /**
    * Returns the tank where number = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param number the number
    * @return the matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank fetchByNumber(
        java.lang.String number)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNumber(number);
    }

    /**
    * Returns the tank where number = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param number the number
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank fetchByNumber(
        java.lang.String number, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNumber(number, retrieveFromCache);
    }

    /**
    * Removes the tank where number = &#63; from the database.
    *
    * @param number the number
    * @return the tank that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank removeByNumber(
        java.lang.String number)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByNumber(number);
    }

    /**
    * Returns the number of tanks where number = &#63;.
    *
    * @param number the number
    * @return the number of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static int countByNumber(java.lang.String number)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByNumber(number);
    }

    /**
    * Returns all the tanks where price &lt; &#63;.
    *
    * @param price the price
    * @return the matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findByhigherPrice(
        long price) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByhigherPrice(price);
    }

    /**
    * Returns a range of all the tanks where price &lt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.TankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param price the price
    * @param start the lower bound of the range of tanks
    * @param end the upper bound of the range of tanks (not inclusive)
    * @return the range of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findByhigherPrice(
        long price, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByhigherPrice(price, start, end);
    }

    /**
    * Returns an ordered range of all the tanks where price &lt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.TankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param price the price
    * @param start the lower bound of the range of tanks
    * @param end the upper bound of the range of tanks (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findByhigherPrice(
        long price, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByhigherPrice(price, start, end, orderByComparator);
    }

    /**
    * Returns the first tank in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank findByhigherPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByhigherPrice_First(price, orderByComparator);
    }

    /**
    * Returns the first tank in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank fetchByhigherPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByhigherPrice_First(price, orderByComparator);
    }

    /**
    * Returns the last tank in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank findByhigherPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByhigherPrice_Last(price, orderByComparator);
    }

    /**
    * Returns the last tank in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank fetchByhigherPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByhigherPrice_Last(price, orderByComparator);
    }

    /**
    * Returns the tanks before and after the current tank in the ordered set where price &lt; &#63;.
    *
    * @param tankId the primary key of the current tank
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank[] findByhigherPrice_PrevAndNext(
        long tankId, long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByhigherPrice_PrevAndNext(tankId, price,
            orderByComparator);
    }

    /**
    * Removes all the tanks where price &lt; &#63; from the database.
    *
    * @param price the price
    * @throws SystemException if a system exception occurred
    */
    public static void removeByhigherPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByhigherPrice(price);
    }

    /**
    * Returns the number of tanks where price &lt; &#63;.
    *
    * @param price the price
    * @return the number of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static int countByhigherPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByhigherPrice(price);
    }

    /**
    * Returns all the tanks where price &gt; &#63;.
    *
    * @param price the price
    * @return the matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findBylowerPrice(
        long price) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBylowerPrice(price);
    }

    /**
    * Returns a range of all the tanks where price &gt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.TankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param price the price
    * @param start the lower bound of the range of tanks
    * @param end the upper bound of the range of tanks (not inclusive)
    * @return the range of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findBylowerPrice(
        long price, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBylowerPrice(price, start, end);
    }

    /**
    * Returns an ordered range of all the tanks where price &gt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.TankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param price the price
    * @param start the lower bound of the range of tanks
    * @param end the upper bound of the range of tanks (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findBylowerPrice(
        long price, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBylowerPrice(price, start, end, orderByComparator);
    }

    /**
    * Returns the first tank in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank findBylowerPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBylowerPrice_First(price, orderByComparator);
    }

    /**
    * Returns the first tank in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank fetchBylowerPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBylowerPrice_First(price, orderByComparator);
    }

    /**
    * Returns the last tank in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank findBylowerPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBylowerPrice_Last(price, orderByComparator);
    }

    /**
    * Returns the last tank in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank fetchBylowerPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBylowerPrice_Last(price, orderByComparator);
    }

    /**
    * Returns the tanks before and after the current tank in the ordered set where price &gt; &#63;.
    *
    * @param tankId the primary key of the current tank
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank[] findBylowerPrice_PrevAndNext(
        long tankId, long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBylowerPrice_PrevAndNext(tankId, price,
            orderByComparator);
    }

    /**
    * Removes all the tanks where price &gt; &#63; from the database.
    *
    * @param price the price
    * @throws SystemException if a system exception occurred
    */
    public static void removeBylowerPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBylowerPrice(price);
    }

    /**
    * Returns the number of tanks where price &gt; &#63;.
    *
    * @param price the price
    * @return the number of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public static int countBylowerPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBylowerPrice(price);
    }

    /**
    * Caches the tank in the entity cache if it is enabled.
    *
    * @param tank the tank
    */
    public static void cacheResult(com.brest.ericpol.service.model.Tank tank) {
        getPersistence().cacheResult(tank);
    }

    /**
    * Caches the tanks in the entity cache if it is enabled.
    *
    * @param tanks the tanks
    */
    public static void cacheResult(
        java.util.List<com.brest.ericpol.service.model.Tank> tanks) {
        getPersistence().cacheResult(tanks);
    }

    /**
    * Creates a new tank with the primary key. Does not add the tank to the database.
    *
    * @param tankId the primary key for the new tank
    * @return the new tank
    */
    public static com.brest.ericpol.service.model.Tank create(long tankId) {
        return getPersistence().create(tankId);
    }

    /**
    * Removes the tank with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tankId the primary key of the tank
    * @return the tank that was removed
    * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank remove(long tankId)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(tankId);
    }

    public static com.brest.ericpol.service.model.Tank updateImpl(
        com.brest.ericpol.service.model.Tank tank)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(tank);
    }

    /**
    * Returns the tank with the primary key or throws a {@link com.brest.ericpol.service.NoSuchTankException} if it could not be found.
    *
    * @param tankId the primary key of the tank
    * @return the tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank findByPrimaryKey(
        long tankId)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(tankId);
    }

    /**
    * Returns the tank with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param tankId the primary key of the tank
    * @return the tank, or <code>null</code> if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Tank fetchByPrimaryKey(
        long tankId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(tankId);
    }

    /**
    * Returns all the tanks.
    *
    * @return the tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.brest.ericpol.service.model.Tank> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the tanks.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.TankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of tanks
    * @param end the upper bound of the range of tanks (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of tanks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Tank> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the tanks from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of tanks.
    *
    * @return the number of tanks
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static TankPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (TankPersistence) PortletBeanLocatorUtil.locate(com.brest.ericpol.service.service.ClpSerializer.getServletContextName(),
                    TankPersistence.class.getName());

            ReferenceRegistry.registerReference(TankUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(TankPersistence persistence) {
    }
}
