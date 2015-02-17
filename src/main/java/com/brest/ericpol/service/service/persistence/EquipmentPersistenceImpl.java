package com.brest.ericpol.service.service.persistence;

import com.brest.ericpol.service.NoSuchEquipmentException;
import com.brest.ericpol.service.model.Equipment;
import com.brest.ericpol.service.model.impl.EquipmentImpl;
import com.brest.ericpol.service.model.impl.EquipmentModelImpl;
import com.brest.ericpol.service.service.persistence.EquipmentPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the equipment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Viktor Kolbik
 * @see EquipmentPersistence
 * @see EquipmentUtil
 * @generated
 */
public class EquipmentPersistenceImpl extends BasePersistenceImpl<Equipment>
    implements EquipmentPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EquipmentUtil} to access the equipment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EquipmentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODIFICATION =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModification",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFICATION =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModification",
            new String[] { String.class.getName() },
            EquipmentModelImpl.MODIFICATION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MODIFICATION = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModification",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_MODIFICATION_MODIFICATION_1 = "equipment.modification IS NULL";
    private static final String _FINDER_COLUMN_MODIFICATION_MODIFICATION_2 = "equipment.modification = ?";
    private static final String _FINDER_COLUMN_MODIFICATION_MODIFICATION_3 = "(equipment.modification IS NULL OR equipment.modification = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HIGHERPRICE =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByhigherPrice",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_HIGHERPRICE =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByhigherPrice",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_HIGHERPRICE_PRICE_2 = "equipment.price < ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOWERPRICE =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylowerPrice",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_LOWERPRICE =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBylowerPrice",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_LOWERPRICE_PRICE_2 = "equipment.price > ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TANKID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTankId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TANKID =
        new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, EquipmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTankId",
            new String[] { Long.class.getName() },
            EquipmentModelImpl.TANKID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TANKID = new FinderPath(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTankId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_TANKID_TANKID_2 = "equipment.tankId = ?";
    private static final String _SQL_SELECT_EQUIPMENT = "SELECT equipment FROM Equipment equipment";
    private static final String _SQL_SELECT_EQUIPMENT_WHERE = "SELECT equipment FROM Equipment equipment WHERE ";
    private static final String _SQL_COUNT_EQUIPMENT = "SELECT COUNT(equipment) FROM Equipment equipment";
    private static final String _SQL_COUNT_EQUIPMENT_WHERE = "SELECT COUNT(equipment) FROM Equipment equipment WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "equipment.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Equipment exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Equipment exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EquipmentPersistenceImpl.class);
    private static Equipment _nullEquipment = new EquipmentImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Equipment> toCacheModel() {
                return _nullEquipmentCacheModel;
            }
        };

    private static CacheModel<Equipment> _nullEquipmentCacheModel = new CacheModel<Equipment>() {
            @Override
            public Equipment toEntityModel() {
                return _nullEquipment;
            }
        };

    public EquipmentPersistenceImpl() {
        setModelClass(Equipment.class);
    }

    /**
     * Returns all the equipments where modification = &#63;.
     *
     * @param modification the modification
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByModification(String modification)
        throws SystemException {
        return findByModification(modification, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Equipment> findByModification(String modification, int start,
        int end) throws SystemException {
        return findByModification(modification, start, end, null);
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
    @Override
    public List<Equipment> findByModification(String modification, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFICATION;
            finderArgs = new Object[] { modification };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MODIFICATION;
            finderArgs = new Object[] {
                    modification,
                    
                    start, end, orderByComparator
                };
        }

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if (!Validator.equals(modification, equipment.getModification())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

            boolean bindModification = false;

            if (modification == null) {
                query.append(_FINDER_COLUMN_MODIFICATION_MODIFICATION_1);
            } else if (modification.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MODIFICATION_MODIFICATION_3);
            } else {
                bindModification = true;

                query.append(_FINDER_COLUMN_MODIFICATION_MODIFICATION_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindModification) {
                    qPos.add(modification);
                }

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Equipment findByModification_First(String modification,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByModification_First(modification,
                orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modification=");
        msg.append(modification);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where modification = &#63;.
     *
     * @param modification the modification
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByModification_First(String modification,
        OrderByComparator orderByComparator) throws SystemException {
        List<Equipment> list = findByModification(modification, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Equipment findByModification_Last(String modification,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByModification_Last(modification,
                orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modification=");
        msg.append(modification);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where modification = &#63;.
     *
     * @param modification the modification
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByModification_Last(String modification,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByModification(modification);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByModification(modification, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Equipment[] findByModification_PrevAndNext(long equipmentId,
        String modification, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByModification_PrevAndNext(session, equipment,
                    modification, orderByComparator, true);

            array[1] = equipment;

            array[2] = getByModification_PrevAndNext(session, equipment,
                    modification, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByModification_PrevAndNext(Session session,
        Equipment equipment, String modification,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

        boolean bindModification = false;

        if (modification == null) {
            query.append(_FINDER_COLUMN_MODIFICATION_MODIFICATION_1);
        } else if (modification.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_MODIFICATION_MODIFICATION_3);
        } else {
            bindModification = true;

            query.append(_FINDER_COLUMN_MODIFICATION_MODIFICATION_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindModification) {
            qPos.add(modification);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where modification = &#63; from the database.
     *
     * @param modification the modification
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByModification(String modification)
        throws SystemException {
        for (Equipment equipment : findByModification(modification,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where modification = &#63;.
     *
     * @param modification the modification
     * @return the number of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByModification(String modification)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MODIFICATION;

        Object[] finderArgs = new Object[] { modification };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

            boolean bindModification = false;

            if (modification == null) {
                query.append(_FINDER_COLUMN_MODIFICATION_MODIFICATION_1);
            } else if (modification.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_MODIFICATION_MODIFICATION_3);
            } else {
                bindModification = true;

                query.append(_FINDER_COLUMN_MODIFICATION_MODIFICATION_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindModification) {
                    qPos.add(modification);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the equipments where price &lt; &#63;.
     *
     * @param price the price
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByhigherPrice(long price)
        throws SystemException {
        return findByhigherPrice(price, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Equipment> findByhigherPrice(long price, int start, int end)
        throws SystemException {
        return findByhigherPrice(price, start, end, null);
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
    @Override
    public List<Equipment> findByhigherPrice(long price, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HIGHERPRICE;
        finderArgs = new Object[] { price, start, end, orderByComparator };

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if ((price <= equipment.getPrice())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_HIGHERPRICE_PRICE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(price);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Equipment findByhigherPrice_First(long price,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByhigherPrice_First(price, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("price=");
        msg.append(price);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where price &lt; &#63;.
     *
     * @param price the price
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByhigherPrice_First(long price,
        OrderByComparator orderByComparator) throws SystemException {
        List<Equipment> list = findByhigherPrice(price, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Equipment findByhigherPrice_Last(long price,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByhigherPrice_Last(price, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("price=");
        msg.append(price);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where price &lt; &#63;.
     *
     * @param price the price
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByhigherPrice_Last(long price,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByhigherPrice(price);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByhigherPrice(price, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Equipment[] findByhigherPrice_PrevAndNext(long equipmentId,
        long price, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByhigherPrice_PrevAndNext(session, equipment, price,
                    orderByComparator, true);

            array[1] = equipment;

            array[2] = getByhigherPrice_PrevAndNext(session, equipment, price,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByhigherPrice_PrevAndNext(Session session,
        Equipment equipment, long price, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_HIGHERPRICE_PRICE_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(price);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where price &lt; &#63; from the database.
     *
     * @param price the price
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByhigherPrice(long price) throws SystemException {
        for (Equipment equipment : findByhigherPrice(price, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where price &lt; &#63;.
     *
     * @param price the price
     * @return the number of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByhigherPrice(long price) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_HIGHERPRICE;

        Object[] finderArgs = new Object[] { price };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_HIGHERPRICE_PRICE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(price);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the equipments where price &gt; &#63;.
     *
     * @param price the price
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findBylowerPrice(long price)
        throws SystemException {
        return findBylowerPrice(price, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Equipment> findBylowerPrice(long price, int start, int end)
        throws SystemException {
        return findBylowerPrice(price, start, end, null);
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
    @Override
    public List<Equipment> findBylowerPrice(long price, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOWERPRICE;
        finderArgs = new Object[] { price, start, end, orderByComparator };

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if ((price >= equipment.getPrice())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_LOWERPRICE_PRICE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(price);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Equipment findBylowerPrice_First(long price,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchBylowerPrice_First(price, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("price=");
        msg.append(price);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where price &gt; &#63;.
     *
     * @param price the price
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchBylowerPrice_First(long price,
        OrderByComparator orderByComparator) throws SystemException {
        List<Equipment> list = findBylowerPrice(price, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Equipment findBylowerPrice_Last(long price,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchBylowerPrice_Last(price, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("price=");
        msg.append(price);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where price &gt; &#63;.
     *
     * @param price the price
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchBylowerPrice_Last(long price,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBylowerPrice(price);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findBylowerPrice(price, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Equipment[] findBylowerPrice_PrevAndNext(long equipmentId,
        long price, OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getBylowerPrice_PrevAndNext(session, equipment, price,
                    orderByComparator, true);

            array[1] = equipment;

            array[2] = getBylowerPrice_PrevAndNext(session, equipment, price,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getBylowerPrice_PrevAndNext(Session session,
        Equipment equipment, long price, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_LOWERPRICE_PRICE_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(price);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where price &gt; &#63; from the database.
     *
     * @param price the price
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBylowerPrice(long price) throws SystemException {
        for (Equipment equipment : findBylowerPrice(price, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where price &gt; &#63;.
     *
     * @param price the price
     * @return the number of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBylowerPrice(long price) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_LOWERPRICE;

        Object[] finderArgs = new Object[] { price };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_LOWERPRICE_PRICE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(price);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the equipments where tankId = &#63;.
     *
     * @param tankId the tank ID
     * @return the matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findByTankId(long tankId) throws SystemException {
        return findByTankId(tankId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Equipment> findByTankId(long tankId, int start, int end)
        throws SystemException {
        return findByTankId(tankId, start, end, null);
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
    @Override
    public List<Equipment> findByTankId(long tankId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TANKID;
            finderArgs = new Object[] { tankId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TANKID;
            finderArgs = new Object[] { tankId, start, end, orderByComparator };
        }

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Equipment equipment : list) {
                if ((tankId != equipment.getTankId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_TANKID_TANKID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EquipmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(tankId);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Equipment findByTankId_First(long tankId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByTankId_First(tankId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("tankId=");
        msg.append(tankId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the first equipment in the ordered set where tankId = &#63;.
     *
     * @param tankId the tank ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByTankId_First(long tankId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Equipment> list = findByTankId(tankId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Equipment findByTankId_Last(long tankId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByTankId_Last(tankId, orderByComparator);

        if (equipment != null) {
            return equipment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("tankId=");
        msg.append(tankId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEquipmentException(msg.toString());
    }

    /**
     * Returns the last equipment in the ordered set where tankId = &#63;.
     *
     * @param tankId the tank ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching equipment, or <code>null</code> if a matching equipment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByTankId_Last(long tankId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByTankId(tankId);

        if (count == 0) {
            return null;
        }

        List<Equipment> list = findByTankId(tankId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Equipment[] findByTankId_PrevAndNext(long equipmentId, long tankId,
        OrderByComparator orderByComparator)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = findByPrimaryKey(equipmentId);

        Session session = null;

        try {
            session = openSession();

            Equipment[] array = new EquipmentImpl[3];

            array[0] = getByTankId_PrevAndNext(session, equipment, tankId,
                    orderByComparator, true);

            array[1] = equipment;

            array[2] = getByTankId_PrevAndNext(session, equipment, tankId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Equipment getByTankId_PrevAndNext(Session session,
        Equipment equipment, long tankId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EQUIPMENT_WHERE);

        query.append(_FINDER_COLUMN_TANKID_TANKID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(EquipmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(tankId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(equipment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Equipment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the equipments where tankId = &#63; from the database.
     *
     * @param tankId the tank ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByTankId(long tankId) throws SystemException {
        for (Equipment equipment : findByTankId(tankId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments where tankId = &#63;.
     *
     * @param tankId the tank ID
     * @return the number of matching equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTankId(long tankId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TANKID;

        Object[] finderArgs = new Object[] { tankId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EQUIPMENT_WHERE);

            query.append(_FINDER_COLUMN_TANKID_TANKID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(tankId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the equipment in the entity cache if it is enabled.
     *
     * @param equipment the equipment
     */
    @Override
    public void cacheResult(Equipment equipment) {
        EntityCacheUtil.putResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentImpl.class, equipment.getPrimaryKey(), equipment);

        equipment.resetOriginalValues();
    }

    /**
     * Caches the equipments in the entity cache if it is enabled.
     *
     * @param equipments the equipments
     */
    @Override
    public void cacheResult(List<Equipment> equipments) {
        for (Equipment equipment : equipments) {
            if (EntityCacheUtil.getResult(
                        EquipmentModelImpl.ENTITY_CACHE_ENABLED,
                        EquipmentImpl.class, equipment.getPrimaryKey()) == null) {
                cacheResult(equipment);
            } else {
                equipment.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all equipments.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EquipmentImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EquipmentImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the equipment.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Equipment equipment) {
        EntityCacheUtil.removeResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentImpl.class, equipment.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Equipment> equipments) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Equipment equipment : equipments) {
            EntityCacheUtil.removeResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
                EquipmentImpl.class, equipment.getPrimaryKey());
        }
    }

    /**
     * Creates a new equipment with the primary key. Does not add the equipment to the database.
     *
     * @param equipmentId the primary key for the new equipment
     * @return the new equipment
     */
    @Override
    public Equipment create(long equipmentId) {
        Equipment equipment = new EquipmentImpl();

        equipment.setNew(true);
        equipment.setPrimaryKey(equipmentId);

        return equipment;
    }

    /**
     * Removes the equipment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param equipmentId the primary key of the equipment
     * @return the equipment that was removed
     * @throws com.brest.ericpol.service.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment remove(long equipmentId)
        throws NoSuchEquipmentException, SystemException {
        return remove((Serializable) equipmentId);
    }

    /**
     * Removes the equipment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the equipment
     * @return the equipment that was removed
     * @throws com.brest.ericpol.service.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment remove(Serializable primaryKey)
        throws NoSuchEquipmentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Equipment equipment = (Equipment) session.get(EquipmentImpl.class,
                    primaryKey);

            if (equipment == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEquipmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(equipment);
        } catch (NoSuchEquipmentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Equipment removeImpl(Equipment equipment)
        throws SystemException {
        equipment = toUnwrappedModel(equipment);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(equipment)) {
                equipment = (Equipment) session.get(EquipmentImpl.class,
                        equipment.getPrimaryKeyObj());
            }

            if (equipment != null) {
                session.delete(equipment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (equipment != null) {
            clearCache(equipment);
        }

        return equipment;
    }

    @Override
    public Equipment updateImpl(
        com.brest.ericpol.service.model.Equipment equipment)
        throws SystemException {
        equipment = toUnwrappedModel(equipment);

        boolean isNew = equipment.isNew();

        EquipmentModelImpl equipmentModelImpl = (EquipmentModelImpl) equipment;

        Session session = null;

        try {
            session = openSession();

            if (equipment.isNew()) {
                session.save(equipment);

                equipment.setNew(false);
            } else {
                session.merge(equipment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !EquipmentModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFICATION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentModelImpl.getOriginalModification()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODIFICATION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFICATION,
                    args);

                args = new Object[] { equipmentModelImpl.getModification() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODIFICATION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFICATION,
                    args);
            }

            if ((equipmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TANKID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        equipmentModelImpl.getOriginalTankId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TANKID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TANKID,
                    args);

                args = new Object[] { equipmentModelImpl.getTankId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TANKID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TANKID,
                    args);
            }
        }

        EntityCacheUtil.putResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
            EquipmentImpl.class, equipment.getPrimaryKey(), equipment);

        return equipment;
    }

    protected Equipment toUnwrappedModel(Equipment equipment) {
        if (equipment instanceof EquipmentImpl) {
            return equipment;
        }

        EquipmentImpl equipmentImpl = new EquipmentImpl();

        equipmentImpl.setNew(equipment.isNew());
        equipmentImpl.setPrimaryKey(equipment.getPrimaryKey());

        equipmentImpl.setEquipmentId(equipment.getEquipmentId());
        equipmentImpl.setModification(equipment.getModification());
        equipmentImpl.setPrice(equipment.getPrice());
        equipmentImpl.setTankId(equipment.getTankId());

        return equipmentImpl;
    }

    /**
     * Returns the equipment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the equipment
     * @return the equipment
     * @throws com.brest.ericpol.service.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByPrimaryKey(Serializable primaryKey)
        throws NoSuchEquipmentException, SystemException {
        Equipment equipment = fetchByPrimaryKey(primaryKey);

        if (equipment == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchEquipmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return equipment;
    }

    /**
     * Returns the equipment with the primary key or throws a {@link com.brest.ericpol.service.NoSuchEquipmentException} if it could not be found.
     *
     * @param equipmentId the primary key of the equipment
     * @return the equipment
     * @throws com.brest.ericpol.service.NoSuchEquipmentException if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment findByPrimaryKey(long equipmentId)
        throws NoSuchEquipmentException, SystemException {
        return findByPrimaryKey((Serializable) equipmentId);
    }

    /**
     * Returns the equipment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the equipment
     * @return the equipment, or <code>null</code> if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Equipment equipment = (Equipment) EntityCacheUtil.getResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
                EquipmentImpl.class, primaryKey);

        if (equipment == _nullEquipment) {
            return null;
        }

        if (equipment == null) {
            Session session = null;

            try {
                session = openSession();

                equipment = (Equipment) session.get(EquipmentImpl.class,
                        primaryKey);

                if (equipment != null) {
                    cacheResult(equipment);
                } else {
                    EntityCacheUtil.putResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
                        EquipmentImpl.class, primaryKey, _nullEquipment);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(EquipmentModelImpl.ENTITY_CACHE_ENABLED,
                    EquipmentImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return equipment;
    }

    /**
     * Returns the equipment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param equipmentId the primary key of the equipment
     * @return the equipment, or <code>null</code> if a equipment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Equipment fetchByPrimaryKey(long equipmentId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) equipmentId);
    }

    /**
     * Returns all the equipments.
     *
     * @return the equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Equipment> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Equipment> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Equipment> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Equipment> list = (List<Equipment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EQUIPMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EQUIPMENT;

                if (pagination) {
                    sql = sql.concat(EquipmentModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Equipment>(list);
                } else {
                    list = (List<Equipment>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the equipments from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Equipment equipment : findAll()) {
            remove(equipment);
        }
    }

    /**
     * Returns the number of equipments.
     *
     * @return the number of equipments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_EQUIPMENT);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the equipment persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.brest.ericpol.service.model.Equipment")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Equipment>> listenersList = new ArrayList<ModelListener<Equipment>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Equipment>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EquipmentImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
