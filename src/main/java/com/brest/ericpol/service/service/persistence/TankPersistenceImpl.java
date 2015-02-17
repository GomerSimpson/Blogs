package com.brest.ericpol.service.service.persistence;

import com.brest.ericpol.service.NoSuchTankException;
import com.brest.ericpol.service.model.Tank;
import com.brest.ericpol.service.model.impl.TankImpl;
import com.brest.ericpol.service.model.impl.TankModelImpl;
import com.brest.ericpol.service.service.persistence.TankPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the tank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Viktor Kolbik
 * @see TankPersistence
 * @see TankUtil
 * @generated
 */
public class TankPersistenceImpl extends BasePersistenceImpl<Tank>
    implements TankPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link TankUtil} to access the tank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = TankImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, TankImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, TankImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODIFICATION =
        new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, TankImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModification",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFICATION =
        new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, TankImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModification",
            new String[] { String.class.getName() },
            TankModelImpl.MODIFICATION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MODIFICATION = new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModification",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_MODIFICATION_MODIFICATION_1 = "tank.modification IS NULL";
    private static final String _FINDER_COLUMN_MODIFICATION_MODIFICATION_2 = "tank.modification = ?";
    private static final String _FINDER_COLUMN_MODIFICATION_MODIFICATION_3 = "(tank.modification IS NULL OR tank.modification = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_NUMBER = new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, TankImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByNumber",
            new String[] { String.class.getName() },
            TankModelImpl.NUMBER_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NUMBER = new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumber",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NUMBER_NUMBER_1 = "tank.number IS NULL";
    private static final String _FINDER_COLUMN_NUMBER_NUMBER_2 = "tank.number = ?";
    private static final String _FINDER_COLUMN_NUMBER_NUMBER_3 = "(tank.number IS NULL OR tank.number = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HIGHERPRICE =
        new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, TankImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByhigherPrice",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_HIGHERPRICE =
        new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByhigherPrice",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_HIGHERPRICE_PRICE_2 = "tank.price < ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOWERPRICE =
        new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, TankImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylowerPrice",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_LOWERPRICE =
        new FinderPath(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBylowerPrice",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_LOWERPRICE_PRICE_2 = "tank.price > ?";
    private static final String _SQL_SELECT_TANK = "SELECT tank FROM Tank tank";
    private static final String _SQL_SELECT_TANK_WHERE = "SELECT tank FROM Tank tank WHERE ";
    private static final String _SQL_COUNT_TANK = "SELECT COUNT(tank) FROM Tank tank";
    private static final String _SQL_COUNT_TANK_WHERE = "SELECT COUNT(tank) FROM Tank tank WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "tank.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Tank exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Tank exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(TankPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "number"
            });
    private static Tank _nullTank = new TankImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Tank> toCacheModel() {
                return _nullTankCacheModel;
            }
        };

    private static CacheModel<Tank> _nullTankCacheModel = new CacheModel<Tank>() {
            @Override
            public Tank toEntityModel() {
                return _nullTank;
            }
        };

    public TankPersistenceImpl() {
        setModelClass(Tank.class);
    }

    /**
     * Returns all the tanks where modification = &#63;.
     *
     * @param modification the modification
     * @return the matching tanks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tank> findByModification(String modification)
        throws SystemException {
        return findByModification(modification, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Tank> findByModification(String modification, int start, int end)
        throws SystemException {
        return findByModification(modification, start, end, null);
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
    @Override
    public List<Tank> findByModification(String modification, int start,
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

        List<Tank> list = (List<Tank>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Tank tank : list) {
                if (!Validator.equals(modification, tank.getModification())) {
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

            query.append(_SQL_SELECT_TANK_WHERE);

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
                query.append(TankModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Tank>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Tank>(list);
                } else {
                    list = (List<Tank>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first tank in the ordered set where modification = &#63;.
     *
     * @param modification the modification
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching tank
     * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank findByModification_First(String modification,
        OrderByComparator orderByComparator)
        throws NoSuchTankException, SystemException {
        Tank tank = fetchByModification_First(modification, orderByComparator);

        if (tank != null) {
            return tank;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modification=");
        msg.append(modification);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTankException(msg.toString());
    }

    /**
     * Returns the first tank in the ordered set where modification = &#63;.
     *
     * @param modification the modification
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching tank, or <code>null</code> if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank fetchByModification_First(String modification,
        OrderByComparator orderByComparator) throws SystemException {
        List<Tank> list = findByModification(modification, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Tank findByModification_Last(String modification,
        OrderByComparator orderByComparator)
        throws NoSuchTankException, SystemException {
        Tank tank = fetchByModification_Last(modification, orderByComparator);

        if (tank != null) {
            return tank;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("modification=");
        msg.append(modification);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTankException(msg.toString());
    }

    /**
     * Returns the last tank in the ordered set where modification = &#63;.
     *
     * @param modification the modification
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching tank, or <code>null</code> if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank fetchByModification_Last(String modification,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByModification(modification);

        if (count == 0) {
            return null;
        }

        List<Tank> list = findByModification(modification, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Tank[] findByModification_PrevAndNext(long tankId,
        String modification, OrderByComparator orderByComparator)
        throws NoSuchTankException, SystemException {
        Tank tank = findByPrimaryKey(tankId);

        Session session = null;

        try {
            session = openSession();

            Tank[] array = new TankImpl[3];

            array[0] = getByModification_PrevAndNext(session, tank,
                    modification, orderByComparator, true);

            array[1] = tank;

            array[2] = getByModification_PrevAndNext(session, tank,
                    modification, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Tank getByModification_PrevAndNext(Session session, Tank tank,
        String modification, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TANK_WHERE);

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
            query.append(TankModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(tank);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Tank> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the tanks where modification = &#63; from the database.
     *
     * @param modification the modification
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByModification(String modification)
        throws SystemException {
        for (Tank tank : findByModification(modification, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(tank);
        }
    }

    /**
     * Returns the number of tanks where modification = &#63;.
     *
     * @param modification the modification
     * @return the number of matching tanks
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

            query.append(_SQL_COUNT_TANK_WHERE);

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
     * Returns the tank where number = &#63; or throws a {@link com.brest.ericpol.service.NoSuchTankException} if it could not be found.
     *
     * @param number the number
     * @return the matching tank
     * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank findByNumber(String number)
        throws NoSuchTankException, SystemException {
        Tank tank = fetchByNumber(number);

        if (tank == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("number=");
            msg.append(number);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchTankException(msg.toString());
        }

        return tank;
    }

    /**
     * Returns the tank where number = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param number the number
     * @return the matching tank, or <code>null</code> if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank fetchByNumber(String number) throws SystemException {
        return fetchByNumber(number, true);
    }

    /**
     * Returns the tank where number = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param number the number
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching tank, or <code>null</code> if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank fetchByNumber(String number, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { number };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NUMBER,
                    finderArgs, this);
        }

        if (result instanceof Tank) {
            Tank tank = (Tank) result;

            if (!Validator.equals(number, tank.getNumber())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_TANK_WHERE);

            boolean bindNumber = false;

            if (number == null) {
                query.append(_FINDER_COLUMN_NUMBER_NUMBER_1);
            } else if (number.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NUMBER_NUMBER_3);
            } else {
                bindNumber = true;

                query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindNumber) {
                    qPos.add(number);
                }

                List<Tank> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBER,
                        finderArgs, list);
                } else {
                    Tank tank = list.get(0);

                    result = tank;

                    cacheResult(tank);

                    if ((tank.getNumber() == null) ||
                            !tank.getNumber().equals(number)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBER,
                            finderArgs, tank);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBER,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Tank) result;
        }
    }

    /**
     * Removes the tank where number = &#63; from the database.
     *
     * @param number the number
     * @return the tank that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank removeByNumber(String number)
        throws NoSuchTankException, SystemException {
        Tank tank = findByNumber(number);

        return remove(tank);
    }

    /**
     * Returns the number of tanks where number = &#63;.
     *
     * @param number the number
     * @return the number of matching tanks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByNumber(String number) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NUMBER;

        Object[] finderArgs = new Object[] { number };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TANK_WHERE);

            boolean bindNumber = false;

            if (number == null) {
                query.append(_FINDER_COLUMN_NUMBER_NUMBER_1);
            } else if (number.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NUMBER_NUMBER_3);
            } else {
                bindNumber = true;

                query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindNumber) {
                    qPos.add(number);
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
     * Returns all the tanks where price &lt; &#63;.
     *
     * @param price the price
     * @return the matching tanks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tank> findByhigherPrice(long price) throws SystemException {
        return findByhigherPrice(price, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Tank> findByhigherPrice(long price, int start, int end)
        throws SystemException {
        return findByhigherPrice(price, start, end, null);
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
    @Override
    public List<Tank> findByhigherPrice(long price, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HIGHERPRICE;
        finderArgs = new Object[] { price, start, end, orderByComparator };

        List<Tank> list = (List<Tank>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Tank tank : list) {
                if ((price <= tank.getPrice())) {
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

            query.append(_SQL_SELECT_TANK_WHERE);

            query.append(_FINDER_COLUMN_HIGHERPRICE_PRICE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TankModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(price);

                if (!pagination) {
                    list = (List<Tank>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Tank>(list);
                } else {
                    list = (List<Tank>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first tank in the ordered set where price &lt; &#63;.
     *
     * @param price the price
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching tank
     * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank findByhigherPrice_First(long price,
        OrderByComparator orderByComparator)
        throws NoSuchTankException, SystemException {
        Tank tank = fetchByhigherPrice_First(price, orderByComparator);

        if (tank != null) {
            return tank;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("price=");
        msg.append(price);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTankException(msg.toString());
    }

    /**
     * Returns the first tank in the ordered set where price &lt; &#63;.
     *
     * @param price the price
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching tank, or <code>null</code> if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank fetchByhigherPrice_First(long price,
        OrderByComparator orderByComparator) throws SystemException {
        List<Tank> list = findByhigherPrice(price, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Tank findByhigherPrice_Last(long price,
        OrderByComparator orderByComparator)
        throws NoSuchTankException, SystemException {
        Tank tank = fetchByhigherPrice_Last(price, orderByComparator);

        if (tank != null) {
            return tank;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("price=");
        msg.append(price);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTankException(msg.toString());
    }

    /**
     * Returns the last tank in the ordered set where price &lt; &#63;.
     *
     * @param price the price
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching tank, or <code>null</code> if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank fetchByhigherPrice_Last(long price,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByhigherPrice(price);

        if (count == 0) {
            return null;
        }

        List<Tank> list = findByhigherPrice(price, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Tank[] findByhigherPrice_PrevAndNext(long tankId, long price,
        OrderByComparator orderByComparator)
        throws NoSuchTankException, SystemException {
        Tank tank = findByPrimaryKey(tankId);

        Session session = null;

        try {
            session = openSession();

            Tank[] array = new TankImpl[3];

            array[0] = getByhigherPrice_PrevAndNext(session, tank, price,
                    orderByComparator, true);

            array[1] = tank;

            array[2] = getByhigherPrice_PrevAndNext(session, tank, price,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Tank getByhigherPrice_PrevAndNext(Session session, Tank tank,
        long price, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TANK_WHERE);

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
            query.append(TankModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(price);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(tank);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Tank> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the tanks where price &lt; &#63; from the database.
     *
     * @param price the price
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByhigherPrice(long price) throws SystemException {
        for (Tank tank : findByhigherPrice(price, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(tank);
        }
    }

    /**
     * Returns the number of tanks where price &lt; &#63;.
     *
     * @param price the price
     * @return the number of matching tanks
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

            query.append(_SQL_COUNT_TANK_WHERE);

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
     * Returns all the tanks where price &gt; &#63;.
     *
     * @param price the price
     * @return the matching tanks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tank> findBylowerPrice(long price) throws SystemException {
        return findBylowerPrice(price, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Tank> findBylowerPrice(long price, int start, int end)
        throws SystemException {
        return findBylowerPrice(price, start, end, null);
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
    @Override
    public List<Tank> findBylowerPrice(long price, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOWERPRICE;
        finderArgs = new Object[] { price, start, end, orderByComparator };

        List<Tank> list = (List<Tank>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Tank tank : list) {
                if ((price >= tank.getPrice())) {
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

            query.append(_SQL_SELECT_TANK_WHERE);

            query.append(_FINDER_COLUMN_LOWERPRICE_PRICE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TankModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(price);

                if (!pagination) {
                    list = (List<Tank>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Tank>(list);
                } else {
                    list = (List<Tank>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first tank in the ordered set where price &gt; &#63;.
     *
     * @param price the price
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching tank
     * @throws com.brest.ericpol.service.NoSuchTankException if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank findBylowerPrice_First(long price,
        OrderByComparator orderByComparator)
        throws NoSuchTankException, SystemException {
        Tank tank = fetchBylowerPrice_First(price, orderByComparator);

        if (tank != null) {
            return tank;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("price=");
        msg.append(price);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTankException(msg.toString());
    }

    /**
     * Returns the first tank in the ordered set where price &gt; &#63;.
     *
     * @param price the price
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching tank, or <code>null</code> if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank fetchBylowerPrice_First(long price,
        OrderByComparator orderByComparator) throws SystemException {
        List<Tank> list = findBylowerPrice(price, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Tank findBylowerPrice_Last(long price,
        OrderByComparator orderByComparator)
        throws NoSuchTankException, SystemException {
        Tank tank = fetchBylowerPrice_Last(price, orderByComparator);

        if (tank != null) {
            return tank;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("price=");
        msg.append(price);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTankException(msg.toString());
    }

    /**
     * Returns the last tank in the ordered set where price &gt; &#63;.
     *
     * @param price the price
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching tank, or <code>null</code> if a matching tank could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank fetchBylowerPrice_Last(long price,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBylowerPrice(price);

        if (count == 0) {
            return null;
        }

        List<Tank> list = findBylowerPrice(price, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Tank[] findBylowerPrice_PrevAndNext(long tankId, long price,
        OrderByComparator orderByComparator)
        throws NoSuchTankException, SystemException {
        Tank tank = findByPrimaryKey(tankId);

        Session session = null;

        try {
            session = openSession();

            Tank[] array = new TankImpl[3];

            array[0] = getBylowerPrice_PrevAndNext(session, tank, price,
                    orderByComparator, true);

            array[1] = tank;

            array[2] = getBylowerPrice_PrevAndNext(session, tank, price,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Tank getBylowerPrice_PrevAndNext(Session session, Tank tank,
        long price, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TANK_WHERE);

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
            query.append(TankModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(price);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(tank);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Tank> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the tanks where price &gt; &#63; from the database.
     *
     * @param price the price
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBylowerPrice(long price) throws SystemException {
        for (Tank tank : findBylowerPrice(price, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(tank);
        }
    }

    /**
     * Returns the number of tanks where price &gt; &#63;.
     *
     * @param price the price
     * @return the number of matching tanks
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

            query.append(_SQL_COUNT_TANK_WHERE);

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
     * Caches the tank in the entity cache if it is enabled.
     *
     * @param tank the tank
     */
    @Override
    public void cacheResult(Tank tank) {
        EntityCacheUtil.putResult(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankImpl.class, tank.getPrimaryKey(), tank);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBER,
            new Object[] { tank.getNumber() }, tank);

        tank.resetOriginalValues();
    }

    /**
     * Caches the tanks in the entity cache if it is enabled.
     *
     * @param tanks the tanks
     */
    @Override
    public void cacheResult(List<Tank> tanks) {
        for (Tank tank : tanks) {
            if (EntityCacheUtil.getResult(TankModelImpl.ENTITY_CACHE_ENABLED,
                        TankImpl.class, tank.getPrimaryKey()) == null) {
                cacheResult(tank);
            } else {
                tank.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all tanks.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(TankImpl.class.getName());
        }

        EntityCacheUtil.clearCache(TankImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the tank.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Tank tank) {
        EntityCacheUtil.removeResult(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankImpl.class, tank.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(tank);
    }

    @Override
    public void clearCache(List<Tank> tanks) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Tank tank : tanks) {
            EntityCacheUtil.removeResult(TankModelImpl.ENTITY_CACHE_ENABLED,
                TankImpl.class, tank.getPrimaryKey());

            clearUniqueFindersCache(tank);
        }
    }

    protected void cacheUniqueFindersCache(Tank tank) {
        if (tank.isNew()) {
            Object[] args = new Object[] { tank.getNumber() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBER, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBER, args, tank);
        } else {
            TankModelImpl tankModelImpl = (TankModelImpl) tank;

            if ((tankModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NUMBER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { tank.getNumber() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBER, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBER, args,
                    tank);
            }
        }
    }

    protected void clearUniqueFindersCache(Tank tank) {
        TankModelImpl tankModelImpl = (TankModelImpl) tank;

        Object[] args = new Object[] { tank.getNumber() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBER, args);

        if ((tankModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NUMBER.getColumnBitmask()) != 0) {
            args = new Object[] { tankModelImpl.getOriginalNumber() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBER, args);
        }
    }

    /**
     * Creates a new tank with the primary key. Does not add the tank to the database.
     *
     * @param tankId the primary key for the new tank
     * @return the new tank
     */
    @Override
    public Tank create(long tankId) {
        Tank tank = new TankImpl();

        tank.setNew(true);
        tank.setPrimaryKey(tankId);

        return tank;
    }

    /**
     * Removes the tank with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param tankId the primary key of the tank
     * @return the tank that was removed
     * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank remove(long tankId) throws NoSuchTankException, SystemException {
        return remove((Serializable) tankId);
    }

    /**
     * Removes the tank with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the tank
     * @return the tank that was removed
     * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank remove(Serializable primaryKey)
        throws NoSuchTankException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Tank tank = (Tank) session.get(TankImpl.class, primaryKey);

            if (tank == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchTankException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(tank);
        } catch (NoSuchTankException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Tank removeImpl(Tank tank) throws SystemException {
        tank = toUnwrappedModel(tank);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(tank)) {
                tank = (Tank) session.get(TankImpl.class,
                        tank.getPrimaryKeyObj());
            }

            if (tank != null) {
                session.delete(tank);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (tank != null) {
            clearCache(tank);
        }

        return tank;
    }

    @Override
    public Tank updateImpl(com.brest.ericpol.service.model.Tank tank)
        throws SystemException {
        tank = toUnwrappedModel(tank);

        boolean isNew = tank.isNew();

        TankModelImpl tankModelImpl = (TankModelImpl) tank;

        Session session = null;

        try {
            session = openSession();

            if (tank.isNew()) {
                session.save(tank);

                tank.setNew(false);
            } else {
                session.merge(tank);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !TankModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((tankModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFICATION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        tankModelImpl.getOriginalModification()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODIFICATION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFICATION,
                    args);

                args = new Object[] { tankModelImpl.getModification() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODIFICATION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFICATION,
                    args);
            }
        }

        EntityCacheUtil.putResult(TankModelImpl.ENTITY_CACHE_ENABLED,
            TankImpl.class, tank.getPrimaryKey(), tank);

        clearUniqueFindersCache(tank);
        cacheUniqueFindersCache(tank);

        return tank;
    }

    protected Tank toUnwrappedModel(Tank tank) {
        if (tank instanceof TankImpl) {
            return tank;
        }

        TankImpl tankImpl = new TankImpl();

        tankImpl.setNew(tank.isNew());
        tankImpl.setPrimaryKey(tank.getPrimaryKey());

        tankImpl.setTankId(tank.getTankId());
        tankImpl.setNumber(tank.getNumber());
        tankImpl.setModification(tank.getModification());
        tankImpl.setPrice(tank.getPrice());

        return tankImpl;
    }

    /**
     * Returns the tank with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the tank
     * @return the tank
     * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank findByPrimaryKey(Serializable primaryKey)
        throws NoSuchTankException, SystemException {
        Tank tank = fetchByPrimaryKey(primaryKey);

        if (tank == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchTankException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return tank;
    }

    /**
     * Returns the tank with the primary key or throws a {@link com.brest.ericpol.service.NoSuchTankException} if it could not be found.
     *
     * @param tankId the primary key of the tank
     * @return the tank
     * @throws com.brest.ericpol.service.NoSuchTankException if a tank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank findByPrimaryKey(long tankId)
        throws NoSuchTankException, SystemException {
        return findByPrimaryKey((Serializable) tankId);
    }

    /**
     * Returns the tank with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the tank
     * @return the tank, or <code>null</code> if a tank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Tank tank = (Tank) EntityCacheUtil.getResult(TankModelImpl.ENTITY_CACHE_ENABLED,
                TankImpl.class, primaryKey);

        if (tank == _nullTank) {
            return null;
        }

        if (tank == null) {
            Session session = null;

            try {
                session = openSession();

                tank = (Tank) session.get(TankImpl.class, primaryKey);

                if (tank != null) {
                    cacheResult(tank);
                } else {
                    EntityCacheUtil.putResult(TankModelImpl.ENTITY_CACHE_ENABLED,
                        TankImpl.class, primaryKey, _nullTank);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(TankModelImpl.ENTITY_CACHE_ENABLED,
                    TankImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return tank;
    }

    /**
     * Returns the tank with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param tankId the primary key of the tank
     * @return the tank, or <code>null</code> if a tank with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Tank fetchByPrimaryKey(long tankId) throws SystemException {
        return fetchByPrimaryKey((Serializable) tankId);
    }

    /**
     * Returns all the tanks.
     *
     * @return the tanks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Tank> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Tank> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Tank> findAll(int start, int end,
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

        List<Tank> list = (List<Tank>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_TANK);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_TANK;

                if (pagination) {
                    sql = sql.concat(TankModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Tank>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Tank>(list);
                } else {
                    list = (List<Tank>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the tanks from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Tank tank : findAll()) {
            remove(tank);
        }
    }

    /**
     * Returns the number of tanks.
     *
     * @return the number of tanks
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

                Query q = session.createQuery(_SQL_COUNT_TANK);

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

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the tank persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.brest.ericpol.service.model.Tank")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Tank>> listenersList = new ArrayList<ModelListener<Tank>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Tank>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(TankImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
