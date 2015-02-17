package com.brest.ericpol.service.service.persistence;

import com.brest.ericpol.service.model.Equipment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the equipment service. This utility wraps {@link EquipmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Viktor Kolbik
 * @see EquipmentPersistence
 * @see EquipmentPersistenceImpl
 * @generated
 */
public class EquipmentUtil {
    private static EquipmentPersistence _persistence;

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
    public static void clearCache(Equipment equipment) {
        getPersistence().clearCache(equipment);
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
    public static List<Equipment> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Equipment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Equipment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Equipment update(Equipment equipment)
        throws SystemException {
        return getPersistence().update(equipment);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Equipment update(Equipment equipment,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(equipment, serviceContext);
    }

    /**
    * Returns all the equipments where modification = &#63;.
    *
    * @param modification the modification
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findByModification(
        java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByModification(modification);
    }

    /**
    * Returns a range of all the equipments where modification = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param modification the modification
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @return the range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findByModification(
        java.lang.String modification, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByModification(modification, start, end);
    }

    /**
    * Returns an ordered range of all the equipments where modification = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param modification the modification
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findByModification(
        java.lang.String modification, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByModification(modification, start, end,
            orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment findByModification_First(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByModification_First(modification, orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment fetchByModification_First(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByModification_First(modification, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment findByModification_Last(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByModification_Last(modification, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment fetchByModification_Last(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByModification_Last(modification, orderByComparator);
    }

    /**
    * Returns the equipments before and after the current equipment in the ordered set where modification = &#63;.
    *
    * @param equipmentId the primary key of the current equipment
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment[] findByModification_PrevAndNext(
        long equipmentId, java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByModification_PrevAndNext(equipmentId, modification,
            orderByComparator);
    }

    /**
    * Removes all the equipments where modification = &#63; from the database.
    *
    * @param modification the modification
    * @throws SystemException if a system exception occurred
    */
    public static void removeByModification(java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByModification(modification);
    }

    /**
    * Returns the number of equipments where modification = &#63;.
    *
    * @param modification the modification
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByModification(java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByModification(modification);
    }

    /**
    * Returns all the equipments where price &lt; &#63;.
    *
    * @param price the price
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findByhigherPrice(
        long price) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByhigherPrice(price);
    }

    /**
    * Returns a range of all the equipments where price &lt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param price the price
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @return the range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findByhigherPrice(
        long price, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByhigherPrice(price, start, end);
    }

    /**
    * Returns an ordered range of all the equipments where price &lt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param price the price
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findByhigherPrice(
        long price, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByhigherPrice(price, start, end, orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment findByhigherPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByhigherPrice_First(price, orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment fetchByhigherPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByhigherPrice_First(price, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment findByhigherPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByhigherPrice_Last(price, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment fetchByhigherPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByhigherPrice_Last(price, orderByComparator);
    }

    /**
    * Returns the equipments before and after the current equipment in the ordered set where price &lt; &#63;.
    *
    * @param equipmentId the primary key of the current equipment
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment[] findByhigherPrice_PrevAndNext(
        long equipmentId, long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByhigherPrice_PrevAndNext(equipmentId, price,
            orderByComparator);
    }

    /**
    * Removes all the equipments where price &lt; &#63; from the database.
    *
    * @param price the price
    * @throws SystemException if a system exception occurred
    */
    public static void removeByhigherPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByhigherPrice(price);
    }

    /**
    * Returns the number of equipments where price &lt; &#63;.
    *
    * @param price the price
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByhigherPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByhigherPrice(price);
    }

    /**
    * Returns all the equipments where price &gt; &#63;.
    *
    * @param price the price
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findBylowerPrice(
        long price) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBylowerPrice(price);
    }

    /**
    * Returns a range of all the equipments where price &gt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param price the price
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @return the range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findBylowerPrice(
        long price, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBylowerPrice(price, start, end);
    }

    /**
    * Returns an ordered range of all the equipments where price &gt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param price the price
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findBylowerPrice(
        long price, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBylowerPrice(price, start, end, orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment findBylowerPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBylowerPrice_First(price, orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment fetchBylowerPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBylowerPrice_First(price, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment findBylowerPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBylowerPrice_Last(price, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment fetchBylowerPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBylowerPrice_Last(price, orderByComparator);
    }

    /**
    * Returns the equipments before and after the current equipment in the ordered set where price &gt; &#63;.
    *
    * @param equipmentId the primary key of the current equipment
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment[] findBylowerPrice_PrevAndNext(
        long equipmentId, long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBylowerPrice_PrevAndNext(equipmentId, price,
            orderByComparator);
    }

    /**
    * Removes all the equipments where price &gt; &#63; from the database.
    *
    * @param price the price
    * @throws SystemException if a system exception occurred
    */
    public static void removeBylowerPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBylowerPrice(price);
    }

    /**
    * Returns the number of equipments where price &gt; &#63;.
    *
    * @param price the price
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countBylowerPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBylowerPrice(price);
    }

    /**
    * Returns all the equipments where tankId = &#63;.
    *
    * @param tankId the tank ID
    * @return the matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findByTankId(
        long tankId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTankId(tankId);
    }

    /**
    * Returns a range of all the equipments where tankId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param tankId the tank ID
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @return the range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findByTankId(
        long tankId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTankId(tankId, start, end);
    }

    /**
    * Returns an ordered range of all the equipments where tankId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param tankId the tank ID
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findByTankId(
        long tankId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTankId(tankId, start, end, orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where tankId = &#63;.
    *
    * @param tankId the tank ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment findByTankId_First(
        long tankId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTankId_First(tankId, orderByComparator);
    }

    /**
    * Returns the first equipment in the ordered set where tankId = &#63;.
    *
    * @param tankId the tank ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment fetchByTankId_First(
        long tankId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTankId_First(tankId, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where tankId = &#63;.
    *
    * @param tankId the tank ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment findByTankId_Last(
        long tankId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTankId_Last(tankId, orderByComparator);
    }

    /**
    * Returns the last equipment in the ordered set where tankId = &#63;.
    *
    * @param tankId the tank ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment fetchByTankId_Last(
        long tankId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTankId_Last(tankId, orderByComparator);
    }

    /**
    * Returns the equipments before and after the current equipment in the ordered set where tankId = &#63;.
    *
    * @param equipmentId the primary key of the current equipment
    * @param tankId the tank ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment[] findByTankId_PrevAndNext(
        long equipmentId, long tankId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTankId_PrevAndNext(equipmentId, tankId,
            orderByComparator);
    }

    /**
    * Removes all the equipments where tankId = &#63; from the database.
    *
    * @param tankId the tank ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByTankId(long tankId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByTankId(tankId);
    }

    /**
    * Returns the number of equipments where tankId = &#63;.
    *
    * @param tankId the tank ID
    * @return the number of matching equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countByTankId(long tankId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTankId(tankId);
    }

    /**
    * Caches the equipment in the entity cache if it is enabled.
    *
    * @param equipment the equipment
    */
    public static void cacheResult(
        com.brest.ericpol.service.model.Equipment equipment) {
        getPersistence().cacheResult(equipment);
    }

    /**
    * Caches the equipments in the entity cache if it is enabled.
    *
    * @param equipments the equipments
    */
    public static void cacheResult(
        java.util.List<com.brest.ericpol.service.model.Equipment> equipments) {
        getPersistence().cacheResult(equipments);
    }

    /**
    * Creates a new equipment with the primary key. Does not add the equipment to the database.
    *
    * @param equipmentId the primary key for the new equipment
    * @return the new equipment
    */
    public static com.brest.ericpol.service.model.Equipment create(
        long equipmentId) {
        return getPersistence().create(equipmentId);
    }

    /**
    * Removes the equipment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment that was removed
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment remove(
        long equipmentId)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(equipmentId);
    }

    public static com.brest.ericpol.service.model.Equipment updateImpl(
        com.brest.ericpol.service.model.Equipment equipment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(equipment);
    }

    /**
    * Returns the equipment with the primary key or throws a {@link com.brest.ericpol.service.NoSuchEquipmentException} if it could not be found.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment
    * @throws com.brest.ericpol.service.NoSuchEquipmentException if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment findByPrimaryKey(
        long equipmentId)
        throws com.brest.ericpol.service.NoSuchEquipmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(equipmentId);
    }

    /**
    * Returns the equipment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param equipmentId the primary key of the equipment
    * @return the equipment, or <code>null</code> if a equipment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.brest.ericpol.service.model.Equipment fetchByPrimaryKey(
        long equipmentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(equipmentId);
    }

    /**
    * Returns all the equipments.
    *
    * @return the equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the equipments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @return the range of equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the equipments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.brest.ericpol.service.model.impl.EquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of equipments
    * @param end the upper bound of the range of equipments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of equipments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.brest.ericpol.service.model.Equipment> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the equipments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of equipments.
    *
    * @return the number of equipments
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EquipmentPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EquipmentPersistence) PortletBeanLocatorUtil.locate(com.brest.ericpol.service.service.ClpSerializer.getServletContextName(),
                    EquipmentPersistence.class.getName());

            ReferenceRegistry.registerReference(EquipmentUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(EquipmentPersistence persistence) {
    }
}
