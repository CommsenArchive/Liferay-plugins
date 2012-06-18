package com.commsen.liferay.portlet.customglobalmarkup.service.persistence;

import com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException;
import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;
import com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupImpl;
import com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupModelImpl;
import com.commsen.liferay.portlet.customglobalmarkup.service.persistence.MarkupPersistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.model.CacheModel;
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
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MarkupUtil} to access the markup persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MarkupImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, MarkupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, MarkupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            MarkupModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, MarkupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, MarkupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            MarkupModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDLOCATION =
        new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, MarkupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndLocation",
            new String[] {
                Long.class.getName(), Short.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDLOCATION =
        new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, MarkupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByGroupIdAndLocation",
            new String[] { Long.class.getName(), Short.class.getName() },
            MarkupModelImpl.GROUPID_COLUMN_BITMASK |
            MarkupModelImpl.LOCATION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDLOCATION = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByGroupIdAndLocation",
            new String[] { Long.class.getName(), Short.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDSTATUSANDLOCATION =
        new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, MarkupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByGroupIdStatusAndLocation",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                Short.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDSTATUSANDLOCATION =
        new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, MarkupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByGroupIdStatusAndLocation",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                Short.class.getName()
            },
            MarkupModelImpl.GROUPID_COLUMN_BITMASK |
            MarkupModelImpl.ACTIVE_COLUMN_BITMASK |
            MarkupModelImpl.LOCATION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDSTATUSANDLOCATION =
        new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByGroupIdStatusAndLocation",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                Short.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, MarkupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, MarkupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
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
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MarkupPersistenceImpl.class);
    private static Markup _nullMarkup = new MarkupImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Markup> toCacheModel() {
                return _nullMarkupCacheModel;
            }
        };

    private static CacheModel<Markup> _nullMarkupCacheModel = new CacheModel<Markup>() {
            public Markup toEntityModel() {
                return _nullMarkup;
            }
        };

    @BeanReference(type = MarkupPersistence.class)
    protected MarkupPersistence markupPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the markup in the entity cache if it is enabled.
     *
     * @param markup the markup
     */
    public void cacheResult(Markup markup) {
        EntityCacheUtil.putResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupImpl.class, markup.getPrimaryKey(), markup);

        markup.resetOriginalValues();
    }

    /**
     * Caches the markups in the entity cache if it is enabled.
     *
     * @param markups the markups
     */
    public void cacheResult(List<Markup> markups) {
        for (Markup markup : markups) {
            if (EntityCacheUtil.getResult(
                        MarkupModelImpl.ENTITY_CACHE_ENABLED, MarkupImpl.class,
                        markup.getPrimaryKey()) == null) {
                cacheResult(markup);
            } else {
                markup.resetOriginalValues();
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
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MarkupImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MarkupImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the markup.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Markup markup) {
        EntityCacheUtil.removeResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
            MarkupImpl.class, markup.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Markup> markups) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Markup markup : markups) {
            EntityCacheUtil.removeResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
                MarkupImpl.class, markup.getPrimaryKey());
        }
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
     * @param id the primary key of the markup
     * @return the markup that was removed
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup remove(long id) throws NoSuchMarkupException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the markup with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the markup
     * @return the markup that was removed
     * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Markup remove(Serializable primaryKey)
        throws NoSuchMarkupException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Markup markup = (Markup) session.get(MarkupImpl.class, primaryKey);

            if (markup == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMarkupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
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

    @Override
    protected Markup removeImpl(Markup markup) throws SystemException {
        markup = toUnwrappedModel(markup);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, markup);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(markup);

        return markup;
    }

    @Override
    public Markup updateImpl(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge) throws SystemException {
        markup = toUnwrappedModel(markup);

        boolean isNew = markup.isNew();

        MarkupModelImpl markupModelImpl = (MarkupModelImpl) markup;

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

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !MarkupModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((markupModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(markupModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { Long.valueOf(markupModelImpl.getGroupId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((markupModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(markupModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { Long.valueOf(markupModelImpl.getCompanyId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((markupModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDLOCATION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(markupModelImpl.getOriginalGroupId()),
                        Short.valueOf(markupModelImpl.getOriginalLocation())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDLOCATION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDLOCATION,
                    args);

                args = new Object[] {
                        Long.valueOf(markupModelImpl.getGroupId()),
                        Short.valueOf(markupModelImpl.getLocation())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDLOCATION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDLOCATION,
                    args);
            }

            if ((markupModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDSTATUSANDLOCATION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(markupModelImpl.getOriginalGroupId()),
                        Boolean.valueOf(markupModelImpl.getOriginalActive()),
                        Short.valueOf(markupModelImpl.getOriginalLocation())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDSTATUSANDLOCATION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDSTATUSANDLOCATION,
                    args);

                args = new Object[] {
                        Long.valueOf(markupModelImpl.getGroupId()),
                        Boolean.valueOf(markupModelImpl.getActive()),
                        Short.valueOf(markupModelImpl.getLocation())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDSTATUSANDLOCATION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDSTATUSANDLOCATION,
                    args);
            }
        }

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
     * Returns the markup with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the markup
     * @return the markup
     * @throws com.liferay.portal.NoSuchModelException if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Markup findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the markup with the primary key or throws a {@link com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException} if it could not be found.
     *
     * @param id the primary key of the markup
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
     * Returns the markup with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the markup
     * @return the markup, or <code>null</code> if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Markup fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the markup with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the markup
     * @return the markup, or <code>null</code> if a markup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Markup fetchByPrimaryKey(long id) throws SystemException {
        Markup markup = (Markup) EntityCacheUtil.getResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
                MarkupImpl.class, id);

        if (markup == _nullMarkup) {
            return null;
        }

        if (markup == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                markup = (Markup) session.get(MarkupImpl.class, Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (markup != null) {
                    cacheResult(markup);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(MarkupModelImpl.ENTITY_CACHE_ENABLED,
                        MarkupImpl.class, id, _nullMarkup);
                }

                closeSession(session);
            }
        }

        return markup;
    }

    /**
     * Returns all the markups where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the markups where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of markups
     * @param end the upper bound of the range of markups (not inclusive)
     * @return the range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the markups where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of markups
     * @param end the upper bound of the range of markups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
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

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                list = (List<Markup>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first markup in the ordered set where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
     * Returns the last markup in the ordered set where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
     * Returns the markups before and after the current markup in the ordered set where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the primary key of the current markup
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(markup);

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
     * Returns all the markups where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the markups where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of markups
     * @param end the upper bound of the range of markups (not inclusive)
     * @return the range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the markups where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of markups
     * @param end the upper bound of the range of markups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByCompanyId(long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
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

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                list = (List<Markup>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first markup in the ordered set where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
     * Returns the last markup in the ordered set where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
     * Returns the markups before and after the current markup in the ordered set where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the primary key of the current markup
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(markup);

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
     * Returns all the markups where groupId = &#63; and location = &#63;.
     *
     * @param groupId the group ID
     * @param location the location
     * @return the matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdAndLocation(long groupId, short location)
        throws SystemException {
        return findByGroupIdAndLocation(groupId, location, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the markups where groupId = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param location the location
     * @param start the lower bound of the range of markups
     * @param end the upper bound of the range of markups (not inclusive)
     * @return the range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdAndLocation(long groupId, short location,
        int start, int end) throws SystemException {
        return findByGroupIdAndLocation(groupId, location, start, end, null);
    }

    /**
     * Returns an ordered range of all the markups where groupId = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param location the location
     * @param start the lower bound of the range of markups
     * @param end the upper bound of the range of markups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdAndLocation(long groupId, short location,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDLOCATION;
            finderArgs = new Object[] { groupId, location };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDLOCATION;
            finderArgs = new Object[] {
                    groupId, location,
                    
                    start, end, orderByComparator
                };
        }

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
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

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(location);

                list = (List<Markup>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first markup in the ordered set where groupId = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param location the location
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
     * Returns the last markup in the ordered set where groupId = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param location the location
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
     * Returns the markups before and after the current markup in the ordered set where groupId = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the primary key of the current markup
     * @param groupId the group ID
     * @param location the location
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(location);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(markup);

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
     * Returns all the markups where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * @param groupId the group ID
     * @param active the active
     * @param location the location
     * @return the matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdStatusAndLocation(long groupId,
        boolean active, short location) throws SystemException {
        return findByGroupIdStatusAndLocation(groupId, active, location,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the markups where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param active the active
     * @param location the location
     * @param start the lower bound of the range of markups
     * @param end the upper bound of the range of markups (not inclusive)
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
     * Returns an ordered range of all the markups where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param active the active
     * @param location the location
     * @param start the lower bound of the range of markups
     * @param end the upper bound of the range of markups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findByGroupIdStatusAndLocation(long groupId,
        boolean active, short location, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDSTATUSANDLOCATION;
            finderArgs = new Object[] { groupId, active, location };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDSTATUSANDLOCATION;
            finderArgs = new Object[] {
                    groupId, active, location,
                    
                    start, end, orderByComparator
                };
        }

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
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

            Session session = null;

            try {
                session = openSession();

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
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first markup in the ordered set where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param active the active
     * @param location the location
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
     * Returns the last markup in the ordered set where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param active the active
     * @param location the location
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
     * Returns the markups before and after the current markup in the ordered set where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the primary key of the current markup
     * @param groupId the group ID
     * @param active the active
     * @param location the location
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
            Object[] values = orderByComparator.getOrderByConditionValues(markup);

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
     * Returns all the markups.
     *
     * @return the markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the markups.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of markups
     * @param end the upper bound of the range of markups (not inclusive)
     * @return the range of markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the markups.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of markups
     * @param end the upper bound of the range of markups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of markups
     * @throws SystemException if a system exception occurred
     */
    public List<Markup> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Markup> list = (List<Markup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
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

            Session session = null;

            try {
                session = openSession();

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
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the markups where groupId = &#63; from the database.
     *
     * @param groupId the group ID
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
     * @param companyId the company ID
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
     * @param groupId the group ID
     * @param location the location
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
     * @param groupId the group ID
     * @param active the active
     * @param location the location
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
     * Returns the number of markups where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching markups
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MARKUP_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

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
     * Returns the number of markups where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching markups
     * @throws SystemException if a system exception occurred
     */
    public int countByCompanyId(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_MARKUP_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

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
     * Returns the number of markups where groupId = &#63; and location = &#63;.
     *
     * @param groupId the group ID
     * @param location the location
     * @return the number of matching markups
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupIdAndLocation(long groupId, short location)
        throws SystemException {
        Object[] finderArgs = new Object[] { groupId, location };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPIDANDLOCATION,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_MARKUP_WHERE);

            query.append(_FINDER_COLUMN_GROUPIDANDLOCATION_GROUPID_2);

            query.append(_FINDER_COLUMN_GROUPIDANDLOCATION_LOCATION_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

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
     * Returns the number of markups where groupId = &#63; and active = &#63; and location = &#63;.
     *
     * @param groupId the group ID
     * @param active the active
     * @param location the location
     * @return the number of matching markups
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupIdStatusAndLocation(long groupId, boolean active,
        short location) throws SystemException {
        Object[] finderArgs = new Object[] { groupId, active, location };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPIDSTATUSANDLOCATION,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_MARKUP_WHERE);

            query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_GROUPID_2);

            query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_ACTIVE_2);

            query.append(_FINDER_COLUMN_GROUPIDSTATUSANDLOCATION_LOCATION_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

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
     * Returns the number of markups.
     *
     * @return the number of markups
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

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

    public void destroy() {
        EntityCacheUtil.removeCache(MarkupImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
