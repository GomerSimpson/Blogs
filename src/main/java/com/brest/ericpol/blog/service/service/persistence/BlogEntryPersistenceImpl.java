package com.brest.ericpol.blog.service.service.persistence;

import com.brest.ericpol.blog.service.NoSuchBlogEntryException;
import com.brest.ericpol.blog.service.model.BlogEntry;
import com.brest.ericpol.blog.service.model.impl.BlogEntryImpl;
import com.brest.ericpol.blog.service.model.impl.BlogEntryModelImpl;
import com.brest.ericpol.blog.service.service.persistence.BlogEntryPersistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the blog entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Viktor Kolbik
 * @see BlogEntryPersistence
 * @see BlogEntryUtil
 * @generated
 */
public class BlogEntryPersistenceImpl extends BasePersistenceImpl<BlogEntry>
    implements BlogEntryPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link BlogEntryUtil} to access the blog entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = BlogEntryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Long.class.getName() },
            BlogEntryModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "blogEntry.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            BlogEntryModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "blogEntry.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            BlogEntryModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "blogEntry.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERGROUPCOMPANYID =
        new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserGroupCompanyId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUPCOMPANYID =
        new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUserGroupCompanyId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            },
            BlogEntryModelImpl.USERID_COLUMN_BITMASK |
            BlogEntryModelImpl.GROUPID_COLUMN_BITMASK |
            BlogEntryModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERGROUPCOMPANYID = new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByUserGroupCompanyId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            });
    private static final String _FINDER_COLUMN_USERGROUPCOMPANYID_USERID_2 = "blogEntry.userId = ? AND ";
    private static final String _FINDER_COLUMN_USERGROUPCOMPANYID_GROUPID_2 = "blogEntry.groupId = ? AND ";
    private static final String _FINDER_COLUMN_USERGROUPCOMPANYID_COMPANYID_2 = "blogEntry.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATELATERTHAN =
        new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDateLaterThan",
            new String[] {
                Date.class.getName(), Long.class.getName(), Long.class.getName(),
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATELATERTHAN =
        new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDateLaterThan",
            new String[] {
                Date.class.getName(), Long.class.getName(), Long.class.getName(),
                Long.class.getName()
            });
    private static final String _FINDER_COLUMN_DATELATERTHAN_ENTRYDATE_1 = "blogEntry.entryDate > NULL AND ";
    private static final String _FINDER_COLUMN_DATELATERTHAN_ENTRYDATE_2 = "blogEntry.entryDate > ? AND ";
    private static final String _FINDER_COLUMN_DATELATERTHAN_USERID_2 = "blogEntry.userId = ? AND ";
    private static final String _FINDER_COLUMN_DATELATERTHAN_GROUPID_2 = "blogEntry.groupId = ? AND ";
    private static final String _FINDER_COLUMN_DATELATERTHAN_COMPANYID_2 = "blogEntry.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATEEARLIERTHAN =
        new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, BlogEntryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDateEarlierThan",
            new String[] {
                Date.class.getName(), Long.class.getName(), Long.class.getName(),
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATEEARLIERTHAN =
        new FinderPath(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDateEarlierThan",
            new String[] {
                Date.class.getName(), Long.class.getName(), Long.class.getName(),
                Long.class.getName()
            });
    private static final String _FINDER_COLUMN_DATEEARLIERTHAN_ENTRYDATE_1 = "blogEntry.entryDate < NULL AND ";
    private static final String _FINDER_COLUMN_DATEEARLIERTHAN_ENTRYDATE_2 = "blogEntry.entryDate < ? AND ";
    private static final String _FINDER_COLUMN_DATEEARLIERTHAN_USERID_2 = "blogEntry.userId = ? AND ";
    private static final String _FINDER_COLUMN_DATEEARLIERTHAN_GROUPID_2 = "blogEntry.groupId = ? AND ";
    private static final String _FINDER_COLUMN_DATEEARLIERTHAN_COMPANYID_2 = "blogEntry.companyId = ?";
    private static final String _SQL_SELECT_BLOGENTRY = "SELECT blogEntry FROM BlogEntry blogEntry";
    private static final String _SQL_SELECT_BLOGENTRY_WHERE = "SELECT blogEntry FROM BlogEntry blogEntry WHERE ";
    private static final String _SQL_COUNT_BLOGENTRY = "SELECT COUNT(blogEntry) FROM BlogEntry blogEntry";
    private static final String _SQL_COUNT_BLOGENTRY_WHERE = "SELECT COUNT(blogEntry) FROM BlogEntry blogEntry WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "blogEntry.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BlogEntry exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BlogEntry exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(BlogEntryPersistenceImpl.class);
    private static BlogEntry _nullBlogEntry = new BlogEntryImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<BlogEntry> toCacheModel() {
                return _nullBlogEntryCacheModel;
            }
        };

    private static CacheModel<BlogEntry> _nullBlogEntryCacheModel = new CacheModel<BlogEntry>() {
            @Override
            public BlogEntry toEntityModel() {
                return _nullBlogEntry;
            }
        };

    public BlogEntryPersistenceImpl() {
        setModelClass(BlogEntry.class);
    }

    /**
     * Returns all the blog entries where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BlogEntry> findByUserId(long userId) throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<BlogEntry> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

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
    @Override
    public List<BlogEntry> findByUserId(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<BlogEntry> list = (List<BlogEntry>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BlogEntry blogEntry : list) {
                if ((userId != blogEntry.getUserId())) {
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

            query.append(_SQL_SELECT_BLOGENTRY_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BlogEntry>(list);
                } else {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
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
     * Returns the first blog entry in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching blog entry
     * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry findByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByUserId_First(userId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

    /**
     * Returns the first blog entry in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry fetchByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<BlogEntry> list = findByUserId(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last blog entry in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching blog entry
     * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry findByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByUserId_Last(userId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

    /**
     * Returns the last blog entry in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry fetchByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<BlogEntry> list = findByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public BlogEntry[] findByUserId_PrevAndNext(long entryId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = findByPrimaryKey(entryId);

        Session session = null;

        try {
            session = openSession();

            BlogEntry[] array = new BlogEntryImpl[3];

            array[0] = getByUserId_PrevAndNext(session, blogEntry, userId,
                    orderByComparator, true);

            array[1] = blogEntry;

            array[2] = getByUserId_PrevAndNext(session, blogEntry, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BlogEntry getByUserId_PrevAndNext(Session session,
        BlogEntry blogEntry, long userId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BLOGENTRY_WHERE);

        query.append(_FINDER_COLUMN_USERID_USERID_2);

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
            query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(blogEntry);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BlogEntry> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the blog entries where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserId(long userId) throws SystemException {
        for (BlogEntry blogEntry : findByUserId(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(blogEntry);
        }
    }

    /**
     * Returns the number of blog entries where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserId(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BLOGENTRY_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

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
     * Returns all the blog entries where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BlogEntry> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<BlogEntry> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

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
    @Override
    public List<BlogEntry> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<BlogEntry> list = (List<BlogEntry>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BlogEntry blogEntry : list) {
                if ((groupId != blogEntry.getGroupId())) {
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

            query.append(_SQL_SELECT_BLOGENTRY_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BlogEntry>(list);
                } else {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
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
     * Returns the first blog entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching blog entry
     * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByGroupId_First(groupId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

    /**
     * Returns the first blog entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<BlogEntry> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last blog entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching blog entry
     * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByGroupId_Last(groupId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

    /**
     * Returns the last blog entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<BlogEntry> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public BlogEntry[] findByGroupId_PrevAndNext(long entryId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = findByPrimaryKey(entryId);

        Session session = null;

        try {
            session = openSession();

            BlogEntry[] array = new BlogEntryImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, blogEntry, groupId,
                    orderByComparator, true);

            array[1] = blogEntry;

            array[2] = getByGroupId_PrevAndNext(session, blogEntry, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BlogEntry getByGroupId_PrevAndNext(Session session,
        BlogEntry blogEntry, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BLOGENTRY_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
            query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(blogEntry);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BlogEntry> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the blog entries where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (BlogEntry blogEntry : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(blogEntry);
        }
    }

    /**
     * Returns the number of blog entries where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BLOGENTRY_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

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
     * Returns all the blog entries where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BlogEntry> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

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
    @Override
    public List<BlogEntry> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

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
    @Override
    public List<BlogEntry> findByCompanyId(long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<BlogEntry> list = (List<BlogEntry>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BlogEntry blogEntry : list) {
                if ((companyId != blogEntry.getCompanyId())) {
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

            query.append(_SQL_SELECT_BLOGENTRY_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BlogEntry>(list);
                } else {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
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
     * Returns the first blog entry in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching blog entry
     * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByCompanyId_First(companyId,
                orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

    /**
     * Returns the first blog entry in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching blog entry, or <code>null</code> if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<BlogEntry> list = findByCompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last blog entry in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching blog entry
     * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByCompanyId_Last(companyId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

    /**
     * Returns the last blog entry in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching blog entry, or <code>null</code> if a matching blog entry could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<BlogEntry> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public BlogEntry[] findByCompanyId_PrevAndNext(long entryId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = findByPrimaryKey(entryId);

        Session session = null;

        try {
            session = openSession();

            BlogEntry[] array = new BlogEntryImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, blogEntry,
                    companyId, orderByComparator, true);

            array[1] = blogEntry;

            array[2] = getByCompanyId_PrevAndNext(session, blogEntry,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BlogEntry getByCompanyId_PrevAndNext(Session session,
        BlogEntry blogEntry, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BLOGENTRY_WHERE);

        query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
            query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(blogEntry);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BlogEntry> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the blog entries where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (BlogEntry blogEntry : findByCompanyId(companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(blogEntry);
        }
    }

    /**
     * Returns the number of blog entries where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCompanyId(long companyId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BLOGENTRY_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

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
     * Returns all the blog entries where userId = &#63; and groupId = &#63; and companyId = &#63;.
     *
     * @param userId the user ID
     * @param groupId the group ID
     * @param companyId the company ID
     * @return the matching blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BlogEntry> findByUserGroupCompanyId(long userId, long groupId,
        long companyId) throws SystemException {
        return findByUserGroupCompanyId(userId, groupId, companyId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<BlogEntry> findByUserGroupCompanyId(long userId, long groupId,
        long companyId, int start, int end) throws SystemException {
        return findByUserGroupCompanyId(userId, groupId, companyId, start, end,
            null);
    }

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
    @Override
    public List<BlogEntry> findByUserGroupCompanyId(long userId, long groupId,
        long companyId, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUPCOMPANYID;
            finderArgs = new Object[] { userId, groupId, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERGROUPCOMPANYID;
            finderArgs = new Object[] {
                    userId, groupId, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<BlogEntry> list = (List<BlogEntry>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BlogEntry blogEntry : list) {
                if ((userId != blogEntry.getUserId()) ||
                        (groupId != blogEntry.getGroupId()) ||
                        (companyId != blogEntry.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_BLOGENTRY_WHERE);

            query.append(_FINDER_COLUMN_USERGROUPCOMPANYID_USERID_2);

            query.append(_FINDER_COLUMN_USERGROUPCOMPANYID_GROUPID_2);

            query.append(_FINDER_COLUMN_USERGROUPCOMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(groupId);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BlogEntry>(list);
                } else {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
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
    @Override
    public BlogEntry findByUserGroupCompanyId_First(long userId, long groupId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByUserGroupCompanyId_First(userId, groupId,
                companyId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

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
    @Override
    public BlogEntry fetchByUserGroupCompanyId_First(long userId, long groupId,
        long companyId, OrderByComparator orderByComparator)
        throws SystemException {
        List<BlogEntry> list = findByUserGroupCompanyId(userId, groupId,
                companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public BlogEntry findByUserGroupCompanyId_Last(long userId, long groupId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByUserGroupCompanyId_Last(userId, groupId,
                companyId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

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
    @Override
    public BlogEntry fetchByUserGroupCompanyId_Last(long userId, long groupId,
        long companyId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByUserGroupCompanyId(userId, groupId, companyId);

        if (count == 0) {
            return null;
        }

        List<BlogEntry> list = findByUserGroupCompanyId(userId, groupId,
                companyId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public BlogEntry[] findByUserGroupCompanyId_PrevAndNext(long entryId,
        long userId, long groupId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = findByPrimaryKey(entryId);

        Session session = null;

        try {
            session = openSession();

            BlogEntry[] array = new BlogEntryImpl[3];

            array[0] = getByUserGroupCompanyId_PrevAndNext(session, blogEntry,
                    userId, groupId, companyId, orderByComparator, true);

            array[1] = blogEntry;

            array[2] = getByUserGroupCompanyId_PrevAndNext(session, blogEntry,
                    userId, groupId, companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BlogEntry getByUserGroupCompanyId_PrevAndNext(Session session,
        BlogEntry blogEntry, long userId, long groupId, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BLOGENTRY_WHERE);

        query.append(_FINDER_COLUMN_USERGROUPCOMPANYID_USERID_2);

        query.append(_FINDER_COLUMN_USERGROUPCOMPANYID_GROUPID_2);

        query.append(_FINDER_COLUMN_USERGROUPCOMPANYID_COMPANYID_2);

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
            query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        qPos.add(groupId);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(blogEntry);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BlogEntry> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the blog entries where userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
     *
     * @param userId the user ID
     * @param groupId the group ID
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserGroupCompanyId(long userId, long groupId,
        long companyId) throws SystemException {
        for (BlogEntry blogEntry : findByUserGroupCompanyId(userId, groupId,
                companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(blogEntry);
        }
    }

    /**
     * Returns the number of blog entries where userId = &#63; and groupId = &#63; and companyId = &#63;.
     *
     * @param userId the user ID
     * @param groupId the group ID
     * @param companyId the company ID
     * @return the number of matching blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserGroupCompanyId(long userId, long groupId,
        long companyId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERGROUPCOMPANYID;

        Object[] finderArgs = new Object[] { userId, groupId, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_BLOGENTRY_WHERE);

            query.append(_FINDER_COLUMN_USERGROUPCOMPANYID_USERID_2);

            query.append(_FINDER_COLUMN_USERGROUPCOMPANYID_GROUPID_2);

            query.append(_FINDER_COLUMN_USERGROUPCOMPANYID_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(groupId);

                qPos.add(companyId);

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
     * Returns all the blog entries where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
     *
     * @param entryDate the entry date
     * @param userId the user ID
     * @param groupId the group ID
     * @param companyId the company ID
     * @return the matching blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BlogEntry> findByDateLaterThan(Date entryDate, long userId,
        long groupId, long companyId) throws SystemException {
        return findByDateLaterThan(entryDate, userId, groupId, companyId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<BlogEntry> findByDateLaterThan(Date entryDate, long userId,
        long groupId, long companyId, int start, int end)
        throws SystemException {
        return findByDateLaterThan(entryDate, userId, groupId, companyId,
            start, end, null);
    }

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
    @Override
    public List<BlogEntry> findByDateLaterThan(Date entryDate, long userId,
        long groupId, long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATELATERTHAN;
        finderArgs = new Object[] {
                entryDate, userId, groupId, companyId,
                
                start, end, orderByComparator
            };

        List<BlogEntry> list = (List<BlogEntry>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BlogEntry blogEntry : list) {
                if ((entryDate.getTime() >= blogEntry.getEntryDate().getTime()) ||
                        (userId != blogEntry.getUserId()) ||
                        (groupId != blogEntry.getGroupId()) ||
                        (companyId != blogEntry.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(6 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(6);
            }

            query.append(_SQL_SELECT_BLOGENTRY_WHERE);

            boolean bindEntryDate = false;

            if (entryDate == null) {
                query.append(_FINDER_COLUMN_DATELATERTHAN_ENTRYDATE_1);
            } else {
                bindEntryDate = true;

                query.append(_FINDER_COLUMN_DATELATERTHAN_ENTRYDATE_2);
            }

            query.append(_FINDER_COLUMN_DATELATERTHAN_USERID_2);

            query.append(_FINDER_COLUMN_DATELATERTHAN_GROUPID_2);

            query.append(_FINDER_COLUMN_DATELATERTHAN_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEntryDate) {
                    qPos.add(CalendarUtil.getTimestamp(entryDate));
                }

                qPos.add(userId);

                qPos.add(groupId);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BlogEntry>(list);
                } else {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
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
    @Override
    public BlogEntry findByDateLaterThan_First(Date entryDate, long userId,
        long groupId, long companyId, OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByDateLaterThan_First(entryDate, userId,
                groupId, companyId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("entryDate=");
        msg.append(entryDate);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

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
    @Override
    public BlogEntry fetchByDateLaterThan_First(Date entryDate, long userId,
        long groupId, long companyId, OrderByComparator orderByComparator)
        throws SystemException {
        List<BlogEntry> list = findByDateLaterThan(entryDate, userId, groupId,
                companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public BlogEntry findByDateLaterThan_Last(Date entryDate, long userId,
        long groupId, long companyId, OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByDateLaterThan_Last(entryDate, userId,
                groupId, companyId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("entryDate=");
        msg.append(entryDate);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

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
    @Override
    public BlogEntry fetchByDateLaterThan_Last(Date entryDate, long userId,
        long groupId, long companyId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByDateLaterThan(entryDate, userId, groupId, companyId);

        if (count == 0) {
            return null;
        }

        List<BlogEntry> list = findByDateLaterThan(entryDate, userId, groupId,
                companyId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public BlogEntry[] findByDateLaterThan_PrevAndNext(long entryId,
        Date entryDate, long userId, long groupId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = findByPrimaryKey(entryId);

        Session session = null;

        try {
            session = openSession();

            BlogEntry[] array = new BlogEntryImpl[3];

            array[0] = getByDateLaterThan_PrevAndNext(session, blogEntry,
                    entryDate, userId, groupId, companyId, orderByComparator,
                    true);

            array[1] = blogEntry;

            array[2] = getByDateLaterThan_PrevAndNext(session, blogEntry,
                    entryDate, userId, groupId, companyId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BlogEntry getByDateLaterThan_PrevAndNext(Session session,
        BlogEntry blogEntry, Date entryDate, long userId, long groupId,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BLOGENTRY_WHERE);

        boolean bindEntryDate = false;

        if (entryDate == null) {
            query.append(_FINDER_COLUMN_DATELATERTHAN_ENTRYDATE_1);
        } else {
            bindEntryDate = true;

            query.append(_FINDER_COLUMN_DATELATERTHAN_ENTRYDATE_2);
        }

        query.append(_FINDER_COLUMN_DATELATERTHAN_USERID_2);

        query.append(_FINDER_COLUMN_DATELATERTHAN_GROUPID_2);

        query.append(_FINDER_COLUMN_DATELATERTHAN_COMPANYID_2);

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
            query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindEntryDate) {
            qPos.add(CalendarUtil.getTimestamp(entryDate));
        }

        qPos.add(userId);

        qPos.add(groupId);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(blogEntry);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BlogEntry> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the blog entries where entryDate &gt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
     *
     * @param entryDate the entry date
     * @param userId the user ID
     * @param groupId the group ID
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByDateLaterThan(Date entryDate, long userId,
        long groupId, long companyId) throws SystemException {
        for (BlogEntry blogEntry : findByDateLaterThan(entryDate, userId,
                groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(blogEntry);
        }
    }

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
    @Override
    public int countByDateLaterThan(Date entryDate, long userId, long groupId,
        long companyId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATELATERTHAN;

        Object[] finderArgs = new Object[] { entryDate, userId, groupId, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_COUNT_BLOGENTRY_WHERE);

            boolean bindEntryDate = false;

            if (entryDate == null) {
                query.append(_FINDER_COLUMN_DATELATERTHAN_ENTRYDATE_1);
            } else {
                bindEntryDate = true;

                query.append(_FINDER_COLUMN_DATELATERTHAN_ENTRYDATE_2);
            }

            query.append(_FINDER_COLUMN_DATELATERTHAN_USERID_2);

            query.append(_FINDER_COLUMN_DATELATERTHAN_GROUPID_2);

            query.append(_FINDER_COLUMN_DATELATERTHAN_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEntryDate) {
                    qPos.add(CalendarUtil.getTimestamp(entryDate));
                }

                qPos.add(userId);

                qPos.add(groupId);

                qPos.add(companyId);

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
     * Returns all the blog entries where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63;.
     *
     * @param entryDate the entry date
     * @param userId the user ID
     * @param groupId the group ID
     * @param companyId the company ID
     * @return the matching blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BlogEntry> findByDateEarlierThan(Date entryDate, long userId,
        long groupId, long companyId) throws SystemException {
        return findByDateEarlierThan(entryDate, userId, groupId, companyId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<BlogEntry> findByDateEarlierThan(Date entryDate, long userId,
        long groupId, long companyId, int start, int end)
        throws SystemException {
        return findByDateEarlierThan(entryDate, userId, groupId, companyId,
            start, end, null);
    }

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
    @Override
    public List<BlogEntry> findByDateEarlierThan(Date entryDate, long userId,
        long groupId, long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATEEARLIERTHAN;
        finderArgs = new Object[] {
                entryDate, userId, groupId, companyId,
                
                start, end, orderByComparator
            };

        List<BlogEntry> list = (List<BlogEntry>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (BlogEntry blogEntry : list) {
                if ((entryDate.getTime() <= blogEntry.getEntryDate().getTime()) ||
                        (userId != blogEntry.getUserId()) ||
                        (groupId != blogEntry.getGroupId()) ||
                        (companyId != blogEntry.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(6 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(6);
            }

            query.append(_SQL_SELECT_BLOGENTRY_WHERE);

            boolean bindEntryDate = false;

            if (entryDate == null) {
                query.append(_FINDER_COLUMN_DATEEARLIERTHAN_ENTRYDATE_1);
            } else {
                bindEntryDate = true;

                query.append(_FINDER_COLUMN_DATEEARLIERTHAN_ENTRYDATE_2);
            }

            query.append(_FINDER_COLUMN_DATEEARLIERTHAN_USERID_2);

            query.append(_FINDER_COLUMN_DATEEARLIERTHAN_GROUPID_2);

            query.append(_FINDER_COLUMN_DATEEARLIERTHAN_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEntryDate) {
                    qPos.add(CalendarUtil.getTimestamp(entryDate));
                }

                qPos.add(userId);

                qPos.add(groupId);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BlogEntry>(list);
                } else {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
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
    @Override
    public BlogEntry findByDateEarlierThan_First(Date entryDate, long userId,
        long groupId, long companyId, OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByDateEarlierThan_First(entryDate, userId,
                groupId, companyId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("entryDate=");
        msg.append(entryDate);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

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
    @Override
    public BlogEntry fetchByDateEarlierThan_First(Date entryDate, long userId,
        long groupId, long companyId, OrderByComparator orderByComparator)
        throws SystemException {
        List<BlogEntry> list = findByDateEarlierThan(entryDate, userId,
                groupId, companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public BlogEntry findByDateEarlierThan_Last(Date entryDate, long userId,
        long groupId, long companyId, OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByDateEarlierThan_Last(entryDate, userId,
                groupId, companyId, orderByComparator);

        if (blogEntry != null) {
            return blogEntry;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("entryDate=");
        msg.append(entryDate);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBlogEntryException(msg.toString());
    }

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
    @Override
    public BlogEntry fetchByDateEarlierThan_Last(Date entryDate, long userId,
        long groupId, long companyId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByDateEarlierThan(entryDate, userId, groupId, companyId);

        if (count == 0) {
            return null;
        }

        List<BlogEntry> list = findByDateEarlierThan(entryDate, userId,
                groupId, companyId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public BlogEntry[] findByDateEarlierThan_PrevAndNext(long entryId,
        Date entryDate, long userId, long groupId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = findByPrimaryKey(entryId);

        Session session = null;

        try {
            session = openSession();

            BlogEntry[] array = new BlogEntryImpl[3];

            array[0] = getByDateEarlierThan_PrevAndNext(session, blogEntry,
                    entryDate, userId, groupId, companyId, orderByComparator,
                    true);

            array[1] = blogEntry;

            array[2] = getByDateEarlierThan_PrevAndNext(session, blogEntry,
                    entryDate, userId, groupId, companyId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected BlogEntry getByDateEarlierThan_PrevAndNext(Session session,
        BlogEntry blogEntry, Date entryDate, long userId, long groupId,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BLOGENTRY_WHERE);

        boolean bindEntryDate = false;

        if (entryDate == null) {
            query.append(_FINDER_COLUMN_DATEEARLIERTHAN_ENTRYDATE_1);
        } else {
            bindEntryDate = true;

            query.append(_FINDER_COLUMN_DATEEARLIERTHAN_ENTRYDATE_2);
        }

        query.append(_FINDER_COLUMN_DATEEARLIERTHAN_USERID_2);

        query.append(_FINDER_COLUMN_DATEEARLIERTHAN_GROUPID_2);

        query.append(_FINDER_COLUMN_DATEEARLIERTHAN_COMPANYID_2);

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
            query.append(BlogEntryModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindEntryDate) {
            qPos.add(CalendarUtil.getTimestamp(entryDate));
        }

        qPos.add(userId);

        qPos.add(groupId);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(blogEntry);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<BlogEntry> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the blog entries where entryDate &lt; &#63; and userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
     *
     * @param entryDate the entry date
     * @param userId the user ID
     * @param groupId the group ID
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByDateEarlierThan(Date entryDate, long userId,
        long groupId, long companyId) throws SystemException {
        for (BlogEntry blogEntry : findByDateEarlierThan(entryDate, userId,
                groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(blogEntry);
        }
    }

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
    @Override
    public int countByDateEarlierThan(Date entryDate, long userId,
        long groupId, long companyId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATEEARLIERTHAN;

        Object[] finderArgs = new Object[] { entryDate, userId, groupId, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_COUNT_BLOGENTRY_WHERE);

            boolean bindEntryDate = false;

            if (entryDate == null) {
                query.append(_FINDER_COLUMN_DATEEARLIERTHAN_ENTRYDATE_1);
            } else {
                bindEntryDate = true;

                query.append(_FINDER_COLUMN_DATEEARLIERTHAN_ENTRYDATE_2);
            }

            query.append(_FINDER_COLUMN_DATEEARLIERTHAN_USERID_2);

            query.append(_FINDER_COLUMN_DATEEARLIERTHAN_GROUPID_2);

            query.append(_FINDER_COLUMN_DATEEARLIERTHAN_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEntryDate) {
                    qPos.add(CalendarUtil.getTimestamp(entryDate));
                }

                qPos.add(userId);

                qPos.add(groupId);

                qPos.add(companyId);

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
     * Caches the blog entry in the entity cache if it is enabled.
     *
     * @param blogEntry the blog entry
     */
    @Override
    public void cacheResult(BlogEntry blogEntry) {
        EntityCacheUtil.putResult(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryImpl.class, blogEntry.getPrimaryKey(), blogEntry);

        blogEntry.resetOriginalValues();
    }

    /**
     * Caches the blog entries in the entity cache if it is enabled.
     *
     * @param blogEntries the blog entries
     */
    @Override
    public void cacheResult(List<BlogEntry> blogEntries) {
        for (BlogEntry blogEntry : blogEntries) {
            if (EntityCacheUtil.getResult(
                        BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
                        BlogEntryImpl.class, blogEntry.getPrimaryKey()) == null) {
                cacheResult(blogEntry);
            } else {
                blogEntry.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all blog entries.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(BlogEntryImpl.class.getName());
        }

        EntityCacheUtil.clearCache(BlogEntryImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the blog entry.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(BlogEntry blogEntry) {
        EntityCacheUtil.removeResult(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryImpl.class, blogEntry.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<BlogEntry> blogEntries) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (BlogEntry blogEntry : blogEntries) {
            EntityCacheUtil.removeResult(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
                BlogEntryImpl.class, blogEntry.getPrimaryKey());
        }
    }

    /**
     * Creates a new blog entry with the primary key. Does not add the blog entry to the database.
     *
     * @param entryId the primary key for the new blog entry
     * @return the new blog entry
     */
    @Override
    public BlogEntry create(long entryId) {
        BlogEntry blogEntry = new BlogEntryImpl();

        blogEntry.setNew(true);
        blogEntry.setPrimaryKey(entryId);

        return blogEntry;
    }

    /**
     * Removes the blog entry with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param entryId the primary key of the blog entry
     * @return the blog entry that was removed
     * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry remove(long entryId)
        throws NoSuchBlogEntryException, SystemException {
        return remove((Serializable) entryId);
    }

    /**
     * Removes the blog entry with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the blog entry
     * @return the blog entry that was removed
     * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry remove(Serializable primaryKey)
        throws NoSuchBlogEntryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            BlogEntry blogEntry = (BlogEntry) session.get(BlogEntryImpl.class,
                    primaryKey);

            if (blogEntry == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchBlogEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(blogEntry);
        } catch (NoSuchBlogEntryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected BlogEntry removeImpl(BlogEntry blogEntry)
        throws SystemException {
        blogEntry = toUnwrappedModel(blogEntry);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(blogEntry)) {
                blogEntry = (BlogEntry) session.get(BlogEntryImpl.class,
                        blogEntry.getPrimaryKeyObj());
            }

            if (blogEntry != null) {
                session.delete(blogEntry);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (blogEntry != null) {
            clearCache(blogEntry);
        }

        return blogEntry;
    }

    @Override
    public BlogEntry updateImpl(
        com.brest.ericpol.blog.service.model.BlogEntry blogEntry)
        throws SystemException {
        blogEntry = toUnwrappedModel(blogEntry);

        boolean isNew = blogEntry.isNew();

        BlogEntryModelImpl blogEntryModelImpl = (BlogEntryModelImpl) blogEntry;

        Session session = null;

        try {
            session = openSession();

            if (blogEntry.isNew()) {
                session.save(blogEntry);

                blogEntry.setNew(false);
            } else {
                session.merge(blogEntry);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !BlogEntryModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((blogEntryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        blogEntryModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { blogEntryModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((blogEntryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        blogEntryModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { blogEntryModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((blogEntryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        blogEntryModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { blogEntryModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((blogEntryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUPCOMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        blogEntryModelImpl.getOriginalUserId(),
                        blogEntryModelImpl.getOriginalGroupId(),
                        blogEntryModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERGROUPCOMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUPCOMPANYID,
                    args);

                args = new Object[] {
                        blogEntryModelImpl.getUserId(),
                        blogEntryModelImpl.getGroupId(),
                        blogEntryModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERGROUPCOMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUPCOMPANYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
            BlogEntryImpl.class, blogEntry.getPrimaryKey(), blogEntry);

        return blogEntry;
    }

    protected BlogEntry toUnwrappedModel(BlogEntry blogEntry) {
        if (blogEntry instanceof BlogEntryImpl) {
            return blogEntry;
        }

        BlogEntryImpl blogEntryImpl = new BlogEntryImpl();

        blogEntryImpl.setNew(blogEntry.isNew());
        blogEntryImpl.setPrimaryKey(blogEntry.getPrimaryKey());

        blogEntryImpl.setEntryId(blogEntry.getEntryId());
        blogEntryImpl.setUserId(blogEntry.getUserId());
        blogEntryImpl.setGroupId(blogEntry.getGroupId());
        blogEntryImpl.setCompanyId(blogEntry.getCompanyId());
        blogEntryImpl.setEntryText(blogEntry.getEntryText());
        blogEntryImpl.setEntryDate(blogEntry.getEntryDate());

        return blogEntryImpl;
    }

    /**
     * Returns the blog entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the blog entry
     * @return the blog entry
     * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry findByPrimaryKey(Serializable primaryKey)
        throws NoSuchBlogEntryException, SystemException {
        BlogEntry blogEntry = fetchByPrimaryKey(primaryKey);

        if (blogEntry == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchBlogEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return blogEntry;
    }

    /**
     * Returns the blog entry with the primary key or throws a {@link com.brest.ericpol.blog.service.NoSuchBlogEntryException} if it could not be found.
     *
     * @param entryId the primary key of the blog entry
     * @return the blog entry
     * @throws com.brest.ericpol.blog.service.NoSuchBlogEntryException if a blog entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry findByPrimaryKey(long entryId)
        throws NoSuchBlogEntryException, SystemException {
        return findByPrimaryKey((Serializable) entryId);
    }

    /**
     * Returns the blog entry with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the blog entry
     * @return the blog entry, or <code>null</code> if a blog entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        BlogEntry blogEntry = (BlogEntry) EntityCacheUtil.getResult(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
                BlogEntryImpl.class, primaryKey);

        if (blogEntry == _nullBlogEntry) {
            return null;
        }

        if (blogEntry == null) {
            Session session = null;

            try {
                session = openSession();

                blogEntry = (BlogEntry) session.get(BlogEntryImpl.class,
                        primaryKey);

                if (blogEntry != null) {
                    cacheResult(blogEntry);
                } else {
                    EntityCacheUtil.putResult(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
                        BlogEntryImpl.class, primaryKey, _nullBlogEntry);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(BlogEntryModelImpl.ENTITY_CACHE_ENABLED,
                    BlogEntryImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return blogEntry;
    }

    /**
     * Returns the blog entry with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param entryId the primary key of the blog entry
     * @return the blog entry, or <code>null</code> if a blog entry with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public BlogEntry fetchByPrimaryKey(long entryId) throws SystemException {
        return fetchByPrimaryKey((Serializable) entryId);
    }

    /**
     * Returns all the blog entries.
     *
     * @return the blog entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<BlogEntry> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<BlogEntry> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<BlogEntry> findAll(int start, int end,
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

        List<BlogEntry> list = (List<BlogEntry>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_BLOGENTRY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_BLOGENTRY;

                if (pagination) {
                    sql = sql.concat(BlogEntryModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<BlogEntry>(list);
                } else {
                    list = (List<BlogEntry>) QueryUtil.list(q, getDialect(),
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
     * Removes all the blog entries from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (BlogEntry blogEntry : findAll()) {
            remove(blogEntry);
        }
    }

    /**
     * Returns the number of blog entries.
     *
     * @return the number of blog entries
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

                Query q = session.createQuery(_SQL_COUNT_BLOGENTRY);

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
     * Initializes the blog entry persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.brest.ericpol.blog.service.model.BlogEntry")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<BlogEntry>> listenersList = new ArrayList<ModelListener<BlogEntry>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<BlogEntry>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(BlogEntryImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
