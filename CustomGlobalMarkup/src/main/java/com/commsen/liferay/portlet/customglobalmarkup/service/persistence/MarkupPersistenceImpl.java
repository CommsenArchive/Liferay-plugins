package com.commsen.liferay.portlet.customglobalmarkup.service.persistence;

import com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException;
import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;
import com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupImpl;
import com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupModelImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MarkupPersistenceImpl extends BasePersistenceImpl
    implements MarkupPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = MarkupImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByGroupId", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_GROUPID = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
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
            "findByCompanyId", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_COMPANYID = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
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
            new String[] { Long.class.getName(), Short.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_GROUPIDANDLOCATION = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
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
                Short.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_GROUPIDSTATUSANDLOCATION =
        new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
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
    private static Log _log = LogFactoryUtil.getLog(MarkupPersistenceImpl.class);
    @BeanReference(name = "com.commsen.liferay.portlet.customglobalmarkup.service.persistence.MarkupPersistence.impl")
    protected com.commsen.liferay.portlet.customglobalmarkup.service.persistence.MarkupPersistence markupPersistence;

    public void cacheResult(Markup markup) {
        EntityCacheUtil.putResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupImpl.class, markup.getPrimaryKey(), markup);
    }

    public void cacheResult(List<Markup> markups) {
        for (Markup markup : markups) {
            if (EntityCacheUtil.getResult(
                        MarkupModelImpl.ENTITY_CACHE_ENABLED, MarkupImpl.class,
                        markup.getPrimaryKey(), this) == null) {
                cacheResult(markup);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(MarkupImpl.class.getName());
        EntityCacheUtil.clearCache(MarkupImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public Markup create(long id) {
        Markup markup = new MarkupImpl();

        markup.setNew(true);
        markup.setPrimaryKey(id);

        return markup;
    }

    public Markup remove(long id) throws NoSuchMarkupException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Markup markup = (Markup) session.get(MarkupImpl.class, new Long(id));

            if (markup == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Markup exists with the primary key " + id);
                }

                throw new NoSuchMarkupException(
                    "No Markup exists with the primary key " + id);
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

    public Markup remove(Markup markup) throws SystemException {
        for (ModelListener<Markup> listener : listeners) {
            listener.onBeforeRemove(markup);
        }

        markup = removeImpl(markup);

        for (ModelListener<Markup> listener : listeners) {
            listener.onAfterRemove(markup);
        }

        return markup;
    }

    protected Markup removeImpl(Markup markup) throws SystemException {
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

    /**
     * @deprecated Use <code>update(Markup markup, boolean merge)</code>.
     */
    public Markup update(Markup markup) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Markup markup) method. Use update(Markup markup, boolean merge) instead.");
        }

        return update(markup, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                markup the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when markup is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Markup update(Markup markup, boolean merge)
        throws SystemException {
        boolean isNew = markup.isNew();

        for (ModelListener<Markup> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(markup);
            } else {
                listener.onBeforeUpdate(markup);
            }
        }

        markup = updateImpl(markup, merge);

        for (ModelListener<Markup> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(markup);
            } else {
                listener.onAfterUpdate(markup);
            }
        }

        return markup;
    }

    public Markup updateImpl(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge) throws SystemException {
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

    public Markup findByPrimaryKey(long id)
        throws NoSuchMarkupException, SystemException {
        Markup markup = fetchByPrimaryKey(id);

        if (markup == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Markup exists with the primary key " + id);
            }

            throw new NoSuchMarkupException(
                "No Markup exists with the primary key " + id);
        }

        return markup;
    }

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

    public List<Markup> findByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId) };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("groupId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                list = q.list();
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

    public List<Markup> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    public List<Markup> findByGroupId(long groupId, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_GROUPID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("groupId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

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

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_GROUPID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Markup findByGroupId_First(long groupId, OrderByComparator obc)
        throws NoSuchMarkupException, SystemException {
        List<Markup> list = findByGroupId(groupId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Markup exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Markup findByGroupId_Last(long groupId, OrderByComparator obc)
        throws NoSuchMarkupException, SystemException {
        int count = countByGroupId(groupId);

        List<Markup> list = findByGroupId(groupId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Markup exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Markup[] findByGroupId_PrevAndNext(long id, long groupId,
        OrderByComparator obc) throws NoSuchMarkupException, SystemException {
        Markup markup = findByPrimaryKey(id);

        int count = countByGroupId(groupId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

            query.append("groupId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, markup);

            Markup[] array = new MarkupImpl[3];

            array[0] = (Markup) objArray[0];
            array[1] = (Markup) objArray[1];
            array[2] = (Markup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Markup> findByCompanyId(long companyId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(companyId) };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("companyId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                list = q.list();
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

    public List<Markup> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    public List<Markup> findByCompanyId(long companyId, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(companyId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_COMPANYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("companyId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

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

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_COMPANYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Markup findByCompanyId_First(long companyId, OrderByComparator obc)
        throws NoSuchMarkupException, SystemException {
        List<Markup> list = findByCompanyId(companyId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Markup exists with the key {");

            msg.append("companyId=" + companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Markup findByCompanyId_Last(long companyId, OrderByComparator obc)
        throws NoSuchMarkupException, SystemException {
        int count = countByCompanyId(companyId);

        List<Markup> list = findByCompanyId(companyId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Markup exists with the key {");

            msg.append("companyId=" + companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Markup[] findByCompanyId_PrevAndNext(long id, long companyId,
        OrderByComparator obc) throws NoSuchMarkupException, SystemException {
        Markup markup = findByPrimaryKey(id);

        int count = countByCompanyId(companyId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

            query.append("companyId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(companyId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, markup);

            Markup[] array = new MarkupImpl[3];

            array[0] = (Markup) objArray[0];
            array[1] = (Markup) objArray[1];
            array[2] = (Markup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Markup> findByGroupIdAndLocation(long groupId, short location)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId), new Short(location)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPIDANDLOCATION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                query.append("location = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(location);

                list = q.list();
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

    public List<Markup> findByGroupIdAndLocation(long groupId, short location,
        int start, int end) throws SystemException {
        return findByGroupIdAndLocation(groupId, location, start, end, null);
    }

    public List<Markup> findByGroupIdAndLocation(long groupId, short location,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId), new Short(location),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_GROUPIDANDLOCATION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                query.append("location = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

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

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_GROUPIDANDLOCATION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Markup findByGroupIdAndLocation_First(long groupId, short location,
        OrderByComparator obc) throws NoSuchMarkupException, SystemException {
        List<Markup> list = findByGroupIdAndLocation(groupId, location, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Markup exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(", ");
            msg.append("location=" + location);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Markup findByGroupIdAndLocation_Last(long groupId, short location,
        OrderByComparator obc) throws NoSuchMarkupException, SystemException {
        int count = countByGroupIdAndLocation(groupId, location);

        List<Markup> list = findByGroupIdAndLocation(groupId, location,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Markup exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(", ");
            msg.append("location=" + location);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Markup[] findByGroupIdAndLocation_PrevAndNext(long id, long groupId,
        short location, OrderByComparator obc)
        throws NoSuchMarkupException, SystemException {
        Markup markup = findByPrimaryKey(id);

        int count = countByGroupIdAndLocation(groupId, location);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

            query.append("groupId = ?");

            query.append(" AND ");

            query.append("location = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(location);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, markup);

            Markup[] array = new MarkupImpl[3];

            array[0] = (Markup) objArray[0];
            array[1] = (Markup) objArray[1];
            array[2] = (Markup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Markup> findByGroupIdStatusAndLocation(long groupId,
        boolean active, short location) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId), Boolean.valueOf(active), new Short(location)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPIDSTATUSANDLOCATION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" AND ");

                query.append("location = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(active);

                qPos.add(location);

                list = q.list();
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

    public List<Markup> findByGroupIdStatusAndLocation(long groupId,
        boolean active, short location, int start, int end)
        throws SystemException {
        return findByGroupIdStatusAndLocation(groupId, active, location, start,
            end, null);
    }

    public List<Markup> findByGroupIdStatusAndLocation(long groupId,
        boolean active, short location, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId), Boolean.valueOf(active), new Short(location),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_GROUPIDSTATUSANDLOCATION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" AND ");

                query.append("location = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

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

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_GROUPIDSTATUSANDLOCATION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Markup findByGroupIdStatusAndLocation_First(long groupId,
        boolean active, short location, OrderByComparator obc)
        throws NoSuchMarkupException, SystemException {
        List<Markup> list = findByGroupIdStatusAndLocation(groupId, active,
                location, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Markup exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(", ");
            msg.append("location=" + location);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Markup findByGroupIdStatusAndLocation_Last(long groupId,
        boolean active, short location, OrderByComparator obc)
        throws NoSuchMarkupException, SystemException {
        int count = countByGroupIdStatusAndLocation(groupId, active, location);

        List<Markup> list = findByGroupIdStatusAndLocation(groupId, active,
                location, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Markup exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(", ");
            msg.append("location=" + location);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMarkupException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Markup[] findByGroupIdStatusAndLocation_PrevAndNext(long id,
        long groupId, boolean active, short location, OrderByComparator obc)
        throws NoSuchMarkupException, SystemException {
        Markup markup = findByPrimaryKey(id);

        int count = countByGroupIdStatusAndLocation(groupId, active, location);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

            query.append("groupId = ?");

            query.append(" AND ");

            query.append("active_ = ?");

            query.append(" AND ");

            query.append("location = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(active);

            qPos.add(location);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, markup);

            Markup[] array = new MarkupImpl[3];

            array[0] = (Markup) objArray[0];
            array[1] = (Markup) objArray[1];
            array[2] = (Markup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            dynamicQuery.compile(session);

            return dynamicQuery.list();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            dynamicQuery.setLimit(start, end);

            dynamicQuery.compile(session);

            return dynamicQuery.list();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Markup> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Markup> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Markup> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
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

    public void removeByGroupId(long groupId) throws SystemException {
        for (Markup markup : findByGroupId(groupId)) {
            remove(markup);
        }
    }

    public void removeByCompanyId(long companyId) throws SystemException {
        for (Markup markup : findByCompanyId(companyId)) {
            remove(markup);
        }
    }

    public void removeByGroupIdAndLocation(long groupId, short location)
        throws SystemException {
        for (Markup markup : findByGroupIdAndLocation(groupId, location)) {
            remove(markup);
        }
    }

    public void removeByGroupIdStatusAndLocation(long groupId, boolean active,
        short location) throws SystemException {
        for (Markup markup : findByGroupIdStatusAndLocation(groupId, active,
                location)) {
            remove(markup);
        }
    }

    public void removeAll() throws SystemException {
        for (Markup markup : findAll()) {
            remove(markup);
        }
    }

    public int countByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("groupId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

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

    public int countByCompanyId(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(companyId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("companyId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

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

    public int countByGroupIdAndLocation(long groupId, short location)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId), new Short(location)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPIDANDLOCATION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                query.append("location = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

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

    public int countByGroupIdStatusAndLocation(long groupId, boolean active,
        short location) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId), Boolean.valueOf(active), new Short(location)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPIDSTATUSANDLOCATION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" AND ");

                query.append("location = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

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

    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.commsen.liferay.portlet.customglobalmarkup.model.Markup");

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

    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.commsen.liferay.portlet.customglobalmarkup.model.Markup")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Markup>> listenersList = new ArrayList<ModelListener<Markup>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Markup>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
