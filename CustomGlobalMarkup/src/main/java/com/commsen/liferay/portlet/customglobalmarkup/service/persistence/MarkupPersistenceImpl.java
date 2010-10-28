package com.commsen.liferay.portlet.customglobalmarkup.service.persistence;

import com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException;
import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;
import com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupImpl;
import com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupModelImpl;
import com.commsen.liferay.portlet.customglobalmarkup.service.persistence.MarkupPersistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the markup service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link MarkupUtil} to access the markup persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Milen Dyankov
 * @see MarkupPersistence
 * @see MarkupUtil
 * @generated
 */
public class MarkupPersistenceImpl extends BasePersistenceImpl<Markup>
    implements MarkupPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = MarkupImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByGroupId", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByCompanyId", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_GROUPIDANDLOCATION = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByGroupIdAndLocation",
            new String[] {
                Long.class.getName(), Short.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDLOCATION = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByGroupIdAndLocation",
            new String[] { Long.class.getName(), Short.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_GROUPIDSTATUSANDLOCATION = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByGroupIdStatusAndLocation",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                Short.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDSTATUSANDLOCATION =
        new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByGroupIdStatusAndLocation",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                Short.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static final String _SQL_SELECT_MARKUP = "SELECT markup FROM Markup markup";
    private static final String _SQL_SELECT_MARKUP_WHERE = "SELECT markup FROM Markup markup WHERE ";
    private static final String _SQL_COUNT_MARKUP = "SELECT COUNT(markup) FROM Markup markup";
    private static final String _SQL_COUNT_MARKUP_WHERE = "SELECT COUNT(markup) FROM Markup markup WHERE ";
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "markup.groupId = ?";
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "markup.companyId = ?";
    private static final String _FINDER_COLUMN_GROUPIDANDLOCATION_GROUPID_2 = "markup.groupId = ? AND ";
    private static final String _FINDER_COLUMN_GROUPIDANDLOCATION_LOCATION_2 = "markup.location = ?";
    private static final String _FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_GROUPID_2 =
        "markup.groupId = ? AND ";
    private static final String _FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_ACTIVE_2 =
        "markup.active = ? AND ";
    private static final String _FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_LOCATION_2 =
        "markup.location = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "markup.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Markup exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Markup exists with the key {";
    private static Log _log = LogFactoryUtil.getLog(MarkupPersistenceImpl.class);
    @BeanReference(type = MarkupPersistence.class)
    protected MarkupPersistence markupPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the markup in the entity cache if it is enabled.
     *
     * @param markup the markup to cache
     */
    public void cacheResult(Markup markup) {
        EntityCacheUtil.putResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupImpl.class, markup.getPrimaryKey(), markup);
    }

    /**
     * Caches the markups in the entity cache if it is enabled.
     *
     * @param markups the markups to cache
     */
    public void cacheResult(List<Markup> markups) {
        for (Markup markup : markups) {
            if (EntityCacheUtil.getResult(
                        MarkupModelImpl.ENTITY_CACHE_ENABLED, MarkupImpl.class,
                        markup.getPrimaryKey(), this) == null) {
                cacheResult(markup);
            }
        }
    }

    /**
     * Clears the cache for all markups.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    public void clearCache() {
        CacheRegistryUtil.clear(MarkupImpl.class.getName());
        EntityCacheUtil.clearCache(MarkupImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    /**
     * Clears the cache for the markup.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    public void clearCache(Markup markup) {
        EntityCacheUtil.removeResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupImpl.class, markup.getPrimaryKey());
    }

    /**
     * Creates a new markup with the primary key. Does not add the markup to the database.
     *
     * @param id the primary key for the new markup
     * @return the new markup
     */
    public Markup create(long id) {
        Markup markup = new MarkupImpl();

        markup.setNew(true);
        markup.setPrimaryKey(id);

        return markup;
    }

    /**
     * Removes the markup with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the markup to remove
     * @return the markup that was removed
     * @throws com.liferay.portal.NoSuchModelException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup remove(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return remove(((Long) primaryKey).longValue());
    }

    /**
     * Removes the markup with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the markup to remove
     * @return the markup that was removed
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup remove(long id) throws NoSuchMarkupException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Markup markup = (Markup) session.get(MarkupImpl.class, new Long(id));

            if (markup == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
                }

                throw new NoSuchMarkupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    id);
            }

            return remove(markup);
        } catch (NoSuchMarkupException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Markup removeImpl(Markup markup) throws SystemException {
        markup = toUnwrappedModel(markup);

        Session session = null;

        try {
            session = openSession();

            if (markup.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(MarkupImpl.class,
                        markup.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(markup);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupImpl.class, markup.getPrimaryKey());

        return markup;
    }

    public Markup updateImpl(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge) throws SystemException {
        markup = toUnwrappedModel(markup);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, markup, merge);

            markup.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupImpl.class, markup.getPrimaryKey(), markup);

        return markup;
    }

    protected Markup toUnwrappedModel(Markup markup) {
        if (markup instanceof MarkupImpl) {
            return markup;
        }

        MarkupImpl markupImpl = new MarkupImpl();

        markupImpl.setNew(markup.isNew());
        markupImpl.setPrimaryKey(markup.getPrimaryKey());

        markupImpl.setId(markup.getId());
        markupImpl.setCompanyId(markup.getCompanyId());
        markupImpl.setGroupId(markup.getGroupId());
        markupImpl.setMarkup(markup.getMarkup());
        markupImpl.setActive(markup.isActive());
        markupImpl.setLocation(markup.getLocation());

        return markupImpl;
    }

    /**
     * Finds the markup with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the markup to find
     * @return the markup
     * @throws com.liferay.portal.NoSuchModelException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Finds the markup with the primary key or throws a {@link com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException} if it could not be found.
     *
     * @param id the primary key of the markup to find
     * @return the markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup findByPrimaryKey(long id)
        throws NoSuchMarkupException, SystemException {
        Markup markup = fetchByPrimaryKey(id);

        if (markup == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchMarkupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return markup;
    }

    /**
     * Finds the markup with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the markup to find
     * @return the markup, or <code>null</code> if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Finds the markup with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the markup to find
     * @return the markup, or <code>null</code> if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup fetchByPrimaryKey(long id) throws SystemException {
        Markup markup = (Markup) EntityCacheUtil.getResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
                MarkupImpl.class, id, this);

        if (markup == null) {
            Session session = null;

            try {
                session = openSession();

                markup = (Markup) session.get(MarkupImpl.class, new Long(id));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (markup != null) {
                    cacheResult(markup);
                }

                closeSession(session);
            }
        }

        return markup;
    }

    /**
     * Finds all the markups where groupId = &#63;.
     *
     * @param groupId the group id to search with
     * @return the matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Finds a range of all the markups where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param start the lower bound of the range of markups to return
     * @param end the upper bound of the range of markups to return (not inclusive)
     * @return the range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Finds an ordered range of all the markups where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param start the lower bound of the range of markups to return
     * @param end the upper bound of the range of markups to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                groupId,
                
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = null;

                if (orderByComparator != null) {
                    query = new StringBundler(3 +
                            (orderByComparator.getOrderByFields().length * 3));
                } else {
                    query = new StringBundler(2);
                }

                query.append(_SQL_SELECT_MARKUP_WHERE);

                query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

                if (orderByComparator != null) {
                    appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                        orderByComparator);
                }

                String sql = query.toString();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                list = (List<Markup>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Markup>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Finds the first markup in the ordered set where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param orderByComparator the comparator to order the set by
     * @return the first matching markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a matching markup could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        List<Markup> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the last markup in the ordered set where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param orderByComparator the comparator to order the set by
     * @return the last matching markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a matching markup could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        int count = countByGroupId(groupId);

        List<Markup> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the markups before and after the current markup in the ordered set where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the primary key of the current markup
     * @param groupId the group id to search with
     * @param orderByComparator the comparator to order the set by
     * @return the previous, current, and next markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup[] findByGroupId_PrevAndNext(long id, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        Markup markup = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Markup[] array = new MarkupImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, markup, groupId,
                    orderByComparator, true);

            array[1] = markup;

            array[2] = getByGroupId_PrevAndNext(session, markup, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Markup getByGroupId_PrevAndNext(Session session, Markup markup,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MARKUP_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByFields = orderByComparator.getOrderByFields();

            if (orderByFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
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
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByValues(markup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Markup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Finds all the markups where companyId = &#63;.
     *
     * @param companyId the company id to search with
     * @return the matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Finds a range of all the markups where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company id to search with
     * @param start the lower bound of the range of markups to return
     * @param end the upper bound of the range of markups to return (not inclusive)
     * @return the range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Finds an ordered range of all the markups where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company id to search with
     * @param start the lower bound of the range of markups to return
     * @param end the upper bound of the range of markups to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByCompanyId(long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                companyId,
                
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = null;

                if (orderByComparator != null) {
                    query = new StringBundler(3 +
                            (orderByComparator.getOrderByFields().length * 3));
                } else {
                    query = new StringBundler(2);
                }

                query.append(_SQL_SELECT_MARKUP_WHERE);

                query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

                if (orderByComparator != null) {
                    appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                        orderByComparator);
                }

                String sql = query.toString();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                list = (List<Markup>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Markup>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Finds the first markup in the ordered set where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company id to search with
     * @param orderByComparator the comparator to order the set by
     * @return the first matching markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a matching markup could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        List<Markup> list = findByCompanyId(companyId, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("companyId=");
            msg.append(companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the last markup in the ordered set where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company id to search with
     * @param orderByComparator the comparator to order the set by
     * @return the last matching markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a matching markup could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        int count = countByCompanyId(companyId);

        List<Markup> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("companyId=");
            msg.append(companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the markups before and after the current markup in the ordered set where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the primary key of the current markup
     * @param companyId the company id to search with
     * @param orderByComparator the comparator to order the set by
     * @return the previous, current, and next markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup[] findByCompanyId_PrevAndNext(long id, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        Markup markup = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Markup[] array = new MarkupImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, markup, companyId,
                    orderByComparator, true);

            array[1] = markup;

            array[2] = getByCompanyId_PrevAndNext(session, markup, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Markup getByCompanyId_PrevAndNext(Session session, Markup markup,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MARKUP_WHERE);

        query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByFields = orderByComparator.getOrderByFields();

            if (orderByFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
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
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByValues(markup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Markup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Finds all the markups where groupId = &#63; and location = &#63;.
     *
     * @param groupId the group id to search with
     * @param location the location to search with
     * @return the matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdAndLocation(long groupId, short location)
        throws SystemException {
        return findByGroupIdAndLocation(groupId, location, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Finds a range of all the markups where groupId = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param location the location to search with
     * @param start the lower bound of the range of markups to return
     * @param end the upper bound of the range of markups to return (not inclusive)
     * @return the range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdAndLocation(long groupId, short location,
        int start, int end) throws SystemException {
        return findByGroupIdAndLocation(groupId, location, start, end, null);
    }

    /**
     * Finds an ordered range of all the markups where groupId = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param location the location to search with
     * @param start the lower bound of the range of markups to return
     * @param end the upper bound of the range of markups to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdAndLocation(long groupId, short location,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                groupId, location,
                
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPIDANDLOCATION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = null;

                if (orderByComparator != null) {
                    query = new StringBundler(4 +
                            (orderByComparator.getOrderByFields().length * 3));
                } else {
                    query = new StringBundler(3);
                }

                query.append(_SQL_SELECT_MARKUP_WHERE);

                query.append(_FINDER_COLUMN_GROUPIDANDLOCATION_GROUPID_2);

                query.append(_FINDER_COLUMN_GROUPIDANDLOCATION_LOCATION_2);

                if (orderByComparator != null) {
                    appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                        orderByComparator);
                }

                String sql = query.toString();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(location);

                list = (List<Markup>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Markup>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPIDANDLOCATION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Finds the first markup in the ordered set where groupId = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param location the location to search with
     * @param orderByComparator the comparator to order the set by
     * @return the first matching markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a matching markup could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup findByGroupIdAndLocation_First(long groupId, short location,
        OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        List<Markup> list = findByGroupIdAndLocation(groupId, location, 0, 1,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(", location=");
            msg.append(location);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the last markup in the ordered set where groupId = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param location the location to search with
     * @param orderByComparator the comparator to order the set by
     * @return the last matching markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a matching markup could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup findByGroupIdAndLocation_Last(long groupId, short location,
        OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        int count = countByGroupIdAndLocation(groupId, location);

        List<Markup> list = findByGroupIdAndLocation(groupId, location,
                count - 1, count, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(", location=");
            msg.append(location);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the markups before and after the current markup in the ordered set where groupId = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the primary key of the current markup
     * @param groupId the group id to search with
     * @param location the location to search with
     * @param orderByComparator the comparator to order the set by
     * @return the previous, current, and next markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup[] findByGroupIdAndLocation_PrevAndNext(long id, long groupId,
        short location, OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        Markup markup = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Markup[] array = new MarkupImpl[3];

            array[0] = getByGroupIdAndLocation_PrevAndNext(session, markup,
                    groupId, location, orderByComparator, true);

            array[1] = markup;

            array[2] = getByGroupIdAndLocation_PrevAndNext(session, markup,
                    groupId, location, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Markup getByGroupIdAndLocation_PrevAndNext(Session session,
        Markup markup, long groupId, short location,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MARKUP_WHERE);

        query.append(_FINDER_COLUMN_GROUPIDANDLOCATION_GROUPID_2);

        query.append(_FINDER_COLUMN_GROUPIDANDLOCATION_LOCATION_2);

        if (orderByComparator != null) {
            String[] orderByFields = orderByComparator.getOrderByFields();

            if (orderByFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
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
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(location);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByValues(markup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Markup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Finds all the markups where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * @param groupId the group id to search with
     * @param active the active to search with
     * @param location the location to search with
     * @return the matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdStatusAndLocation(long groupId,
        boolean active, short location) throws SystemException {
        return findByGroupIdStatusAndLocation(groupId, active, location,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Finds a range of all the markups where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param active the active to search with
     * @param location the location to search with
     * @param start the lower bound of the range of markups to return
     * @param end the upper bound of the range of markups to return (not inclusive)
     * @return the range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdStatusAndLocation(long groupId,
        boolean active, short location, int start, int end)
        throws SystemException {
        return findByGroupIdStatusAndLocation(groupId, active, location, start,
            end, null);
    }

    /**
     * Finds an ordered range of all the markups where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param active the active to search with
     * @param location the location to search with
     * @param start the lower bound of the range of markups to return
     * @param end the upper bound of the range of markups to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdStatusAndLocation(long groupId,
        boolean active, short location, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                groupId, active, location,
                
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPIDSTATUSANDLOCATION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = null;

                if (orderByComparator != null) {
                    query = new StringBundler(5 +
                            (orderByComparator.getOrderByFields().length * 3));
                } else {
                    query = new StringBundler(4);
                }

                query.append(_SQL_SELECT_MARKUP_WHERE);

                query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_GROUPID_2);

                query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_ACTIVE_2);

                query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_LOCATION_2);

                if (orderByComparator != null) {
                    appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                        orderByComparator);
                }

                String sql = query.toString();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(active);

                qPos.add(location);

                list = (List<Markup>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Markup>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPIDSTATUSANDLOCATION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Finds the first markup in the ordered set where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param active the active to search with
     * @param location the location to search with
     * @param orderByComparator the comparator to order the set by
     * @return the first matching markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a matching markup could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup findByGroupIdStatusAndLocation_First(long groupId,
        boolean active, short location, OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        List<Markup> list = findByGroupIdStatusAndLocation(groupId, active,
                location, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(8);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(", active=");
            msg.append(active);

            msg.append(", location=");
            msg.append(location);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the last markup in the ordered set where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group id to search with
     * @param active the active to search with
     * @param location the location to search with
     * @param orderByComparator the comparator to order the set by
     * @return the last matching markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a matching markup could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup findByGroupIdStatusAndLocation_Last(long groupId,
        boolean active, short location, OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        int count = countByGroupIdStatusAndLocation(groupId, active, location);

        List<Markup> list = findByGroupIdStatusAndLocation(groupId, active,
                location, count - 1, count, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(8);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(", active=");
            msg.append(active);

            msg.append(", location=");
            msg.append(location);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the markups before and after the current markup in the ordered set where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the primary key of the current markup
     * @param groupId the group id to search with
     * @param active the active to search with
     * @param location the location to search with
     * @param orderByComparator the comparator to order the set by
     * @return the previous, current, and next markup
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup[] findByGroupIdStatusAndLocation_PrevAndNext(long id,
        long groupId, boolean active, short location,
        OrderByComparator orderByComparator)
        throws NoSuchMarkupException, SystemException {
        Markup markup = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Markup[] array = new MarkupImpl[3];

            array[0] = getByGroupIdStatusAndLocation_PrevAndNext(session,
                    markup, groupId, active, location, orderByComparator, true);

            array[1] = markup;

            array[2] = getByGroupIdStatusAndLocation_PrevAndNext(session,
                    markup, groupId, active, location, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Markup getByGroupIdStatusAndLocation_PrevAndNext(
        Session session, Markup markup, long groupId, boolean active,
        short location, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MARKUP_WHERE);

        query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_GROUPID_2);

        query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_ACTIVE_2);

        query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_LOCATION_2);

        if (orderByComparator != null) {
            String[] orderByFields = orderByComparator.getOrderByFields();

            if (orderByFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
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
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(active);

        qPos.add(location);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByValues(markup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Markup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Finds all the markups.
     *
     * @return the markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Finds a range of all the markups.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of markups to return
     * @param end the upper bound of the range of markups to return (not inclusive)
     * @return the range of markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Finds an ordered range of all the markups.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of markups to return
     * @param end the upper bound of the range of markups to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = null;
                String sql = null;

                if (orderByComparator != null) {
                    query = new StringBundler(2 +
                            (orderByComparator.getOrderByFields().length * 3));

                    query.append(_SQL_SELECT_MARKUP);

                    appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                        orderByComparator);

                    sql = query.toString();
                } else {
                    sql = _SQL_SELECT_MARKUP;
                }

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Markup>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Markup>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Markup>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the markups where groupId = &#63; from the database.
     *
     * @param groupId the group id to search with
     * @throws SystemException if a system exception occurred
     */
    public void removeByGroupId(long groupId) throws SystemException {
        for (Markup markup : findByGroupId(groupId)) {
            remove(markup);
        }
    }

    /**
     * Removes all the markups where companyId = &#63; from the database.
     *
     * @param companyId the company id to search with
     * @throws SystemException if a system exception occurred
     */
    public void removeByCompanyId(long companyId) throws SystemException {
        for (Markup markup : findByCompanyId(companyId)) {
            remove(markup);
        }
    }

    /**
     * Removes all the markups where groupId = &#63; and location = &#63; from the database.
     *
     * @param groupId the group id to search with
     * @param location the location to search with
     * @throws SystemException if a system exception occurred
     */
    public void removeByGroupIdAndLocation(long groupId, short location)
        throws SystemException {
        for (Markup markup : findByGroupIdAndLocation(groupId, location)) {
            remove(markup);
        }
    }

    /**
     * Removes all the markups where groupId = &#63; and active = &#63; and location = &#63; from the database.
     *
     * @param groupId the group id to search with
     * @param active the active to search with
     * @param location the location to search with
     * @throws SystemException if a system exception occurred
     */
    public void removeByGroupIdStatusAndLocation(long groupId, boolean active,
        short location) throws SystemException {
        for (Markup markup : findByGroupIdStatusAndLocation(groupId, active,
                location)) {
            remove(markup);
        }
    }

    /**
     * Removes all the markups from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Markup markup : findAll()) {
            remove(markup);
        }
    }

    /**
     * Counts all the markups where groupId = &#63;.
     *
     * @param groupId the group id to search with
     * @return the number of matching markups
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = new StringBundler(2);

                query.append(_SQL_COUNT_MARKUP_WHERE);

                query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

                String sql = query.toString();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Counts all the markups where companyId = &#63;.
     *
     * @param companyId the company id to search with
     * @return the number of matching markups
     * @throws SystemException if a system exception occurred
     */
    public int countByCompanyId(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = new StringBundler(2);

                query.append(_SQL_COUNT_MARKUP_WHERE);

                query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

                String sql = query.toString();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Counts all the markups where groupId = &#63; and location = &#63;.
     *
     * @param groupId the group id to search with
     * @param location the location to search with
     * @return the number of matching markups
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupIdAndLocation(long groupId, short location)
        throws SystemException {
        Object[] finderArgs = new Object[] { groupId, location };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPIDANDLOCATION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = new StringBundler(3);

                query.append(_SQL_COUNT_MARKUP_WHERE);

                query.append(_FINDER_COLUMN_GROUPIDANDLOCATION_GROUPID_2);

                query.append(_FINDER_COLUMN_GROUPIDANDLOCATION_LOCATION_2);

                String sql = query.toString();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(location);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPIDANDLOCATION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Counts all the markups where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * @param groupId the group id to search with
     * @param active the active to search with
     * @param location the location to search with
     * @return the number of matching markups
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupIdStatusAndLocation(long groupId, boolean active,
        short location) throws SystemException {
        Object[] finderArgs = new Object[] { groupId, active, location };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPIDSTATUSANDLOCATION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBundler query = new StringBundler(4);

                query.append(_SQL_COUNT_MARKUP_WHERE);

                query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_GROUPID_2);

                query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_ACTIVE_2);

                query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_LOCATION_2);

                String sql = query.toString();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(active);

                qPos.add(location);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPIDSTATUSANDLOCATION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Counts all the markups.
     *
     * @return the number of markups
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_MARKUP);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the markup persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.commsen.liferay.portlet.customglobalmarkup.model.Markup")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Markup>> listenersList = new ArrayList<ModelListener<Markup>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Markup>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
