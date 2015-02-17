package com.brest.ericpol.service.service.persistence;

import com.brest.ericpol.service.model.Tank;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the tank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Viktor Kolbik
 * @see TankPersistenceImpl
 * @see TankUtil
 * @generated
 */
public interface TankPersistence extends BasePersistence<Tank> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link TankUtil} to access the tank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the tanks where modification = &#63;.
    *
    * @param modification the modification
    * @return the matching tanks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.brest.ericpol.service.model.Tank> findByModification(
        java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.service.model.Tank> findByModification(
        java.lang.String modification, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.service.model.Tank> findByModification(
        java.lang.String modification, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first tank in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank findByModification_First(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first tank in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank fetchByModification_First(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last tank in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank findByModification_Last(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last tank in the ordered set where modification = &#63;.
    *
    * @param modification the modification
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank fetchByModification_Last(
        java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.service.model.Tank[] findByModification_PrevAndNext(
        long tankId, java.lang.String modification,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tanks where modification = &#63; from the database.
    *
    * @param modification the modification
    * @throws SystemException if a system exception occurred
    */
    public void removeByModification(java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tanks where modification = &#63;.
    *
    * @param modification the modification
    * @return the number of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public int countByModification(java.lang.String modification)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the tank where number = &#63; or throws a {@link com.brest.ericpol.service.NoSuchTankException} if it could not be found.
    *
    * @param number the number
    * @return the matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank findByNumber(
        java.lang.String number)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the tank where number = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param number the number
    * @return the matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank fetchByNumber(
        java.lang.String number)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the tank where number = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param number the number
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank fetchByNumber(
        java.lang.String number, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the tank where number = &#63; from the database.
    *
    * @param number the number
    * @return the tank that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank removeByNumber(
        java.lang.String number)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tanks where number = &#63;.
    *
    * @param number the number
    * @return the number of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public int countByNumber(java.lang.String number)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the tanks where price &lt; &#63;.
    *
    * @param price the price
    * @return the matching tanks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.brest.ericpol.service.model.Tank> findByhigherPrice(
        long price) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.service.model.Tank> findByhigherPrice(
        long price, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.service.model.Tank> findByhigherPrice(
        long price, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first tank in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank findByhigherPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first tank in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank fetchByhigherPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last tank in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank findByhigherPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last tank in the ordered set where price &lt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank fetchByhigherPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.service.model.Tank[] findByhigherPrice_PrevAndNext(
        long tankId, long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tanks where price &lt; &#63; from the database.
    *
    * @param price the price
    * @throws SystemException if a system exception occurred
    */
    public void removeByhigherPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tanks where price &lt; &#63;.
    *
    * @param price the price
    * @return the number of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public int countByhigherPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the tanks where price &gt; &#63;.
    *
    * @param price the price
    * @return the matching tanks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.brest.ericpol.service.model.Tank> findBylowerPrice(
        long price) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.service.model.Tank> findBylowerPrice(
        long price, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.service.model.Tank> findBylowerPrice(
        long price, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first tank in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank findBylowerPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first tank in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank fetchBylowerPrice_First(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last tank in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank findBylowerPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last tank in the ordered set where price &gt; &#63;.
    *
    * @param price the price
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tank, or <code>null</code> if a matching tank could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank fetchBylowerPrice_Last(
        long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.brest.ericpol.service.model.Tank[] findBylowerPrice_PrevAndNext(
        long tankId, long price,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tanks where price &gt; &#63; from the database.
    *
    * @param price the price
    * @throws SystemException if a system exception occurred
    */
    public void removeBylowerPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tanks where price &gt; &#63;.
    *
    * @param price the price
    * @return the number of matching tanks
    * @throws SystemException if a system exception occurred
    */
    public int countBylowerPrice(long price)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the tank in the entity cache if it is enabled.
    *
    * @param tank the tank
    */
    public void cacheResult(com.brest.ericpol.service.model.Tank tank);

    /**
    * Caches the tanks in the entity cache if it is enabled.
    *
    * @param tanks the tanks
    */
    public void cacheResult(
        java.util.List<com.brest.ericpol.service.model.Tank> tanks);

    /**
    * Creates a new tank with the primary key. Does not add the tank to the database.
    *
    * @param tankId the primary key for the new tank
    * @return the new tank
    */
    public com.brest.ericpol.service.model.Tank create(long tankId);

    /**
    * Removes the tank with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tankId the primary key of the tank
    * @return the tank that was removed
    * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank remove(long tankId)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.brest.ericpol.service.model.Tank updateImpl(
        com.brest.ericpol.service.model.Tank tank)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the tank with the primary key or throws a {@link com.brest.ericpol.service.NoSuchTankException} if it could not be found.
    *
    * @param tankId the primary key of the tank
    * @return the tank
    * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank findByPrimaryKey(long tankId)
        throws com.brest.ericpol.service.NoSuchTankException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the tank with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param tankId the primary key of the tank
    * @return the tank, or <code>null</code> if a tank with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.brest.ericpol.service.model.Tank fetchByPrimaryKey(long tankId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the tanks.
    *
    * @return the tanks
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.brest.ericpol.service.model.Tank> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.service.model.Tank> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.brest.ericpol.service.model.Tank> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tanks from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tanks.
    *
    * @return the number of tanks
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
