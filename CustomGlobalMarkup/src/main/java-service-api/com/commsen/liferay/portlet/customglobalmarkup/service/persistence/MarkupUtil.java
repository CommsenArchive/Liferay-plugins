package com.commsen.liferay.portlet.customglobalmarkup.service.persistence;

import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the markup service. This utility wraps {@link MarkupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Milen Dyankov
 * @see MarkupPersistence
 * @see MarkupPersistenceImpl
 * @generated
 */
public class MarkupUtil {
    private static MarkupPersistence _persistence;

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Markup markup) {
        getPersistence().clearCache(markup);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Markup> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Markup> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Markup> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
     */
    public static Markup remove(Markup markup) throws SystemException {
        return getPersistence().remove(markup);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Markup update(Markup markup, boolean merge)
        throws SystemException {
        return getPersistence().update(markup, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Markup update(Markup markup, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(markup, merge, serviceContext);
    }

    /**
    * Caches the markup in the entity cache if it is enabled.
    *
    * @param markup the markup to cache
    */
    public static void cacheResult(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup) {
        getPersistence().cacheResult(markup);
    }

    /**
    * Caches the markups in the entity cache if it is enabled.
    *
    * @param markups the markups to cache
    */
    public static void cacheResult(
        java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> markups) {
        getPersistence().cacheResult(markups);
    }

    /**
    * Creates a new markup with the primary key. Does not add the markup to the database.
    *
    * @param id the primary key for the new markup
    * @return the new markup
    */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the markup with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the markup to remove
    * @return the markup that was removed
    * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup remove(
        long id)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateImpl(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(markup, merge);
    }

    /**
    * Finds the markup with the primary key or throws a {@link com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException} if it could not be found.
    *
    * @param id the primary key of the markup to find
    * @return the markup
    * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByPrimaryKey(
        long id)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Finds the markup with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the markup to find
    * @return the markup, or <code>null</code> if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Finds all the markups where groupId = &#63;.
    *
    * @param groupId the group id to search with
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(id, groupId, orderByComparator);
    }

    /**
    * Finds all the markups where companyId = &#63;.
    *
    * @param companyId the company id to search with
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByCompanyId_PrevAndNext(
        long id, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(id, companyId, orderByComparator);
    }

    /**
    * Finds all the markups where groupId = &#63; and location = &#63;.
    *
    * @param groupId the group id to search with
    * @param location the location to search with
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupIdAndLocation(groupId, location);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation(groupId, location, start, end);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation(groupId, location, start, end,
            orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdAndLocation_First(
        long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation_First(groupId, location,
            orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdAndLocation_Last(
        long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation_Last(groupId, location,
            orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupIdAndLocation_PrevAndNext(
        long id, long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation_PrevAndNext(id, groupId, location,
            orderByComparator);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation(groupId, active, location);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation(groupId, active, location,
            start, end);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation(groupId, active, location,
            start, end, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdStatusAndLocation_First(
        long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation_First(groupId, active,
            location, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdStatusAndLocation_Last(
        long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation_Last(groupId, active,
            location, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupIdStatusAndLocation_PrevAndNext(
        long id, long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation_PrevAndNext(id, groupId,
            active, location, orderByComparator);
    }

    /**
    * Finds all the markups.
    *
    * @return the markups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the markups where groupId = &#63; from the database.
    *
    * @param groupId the group id to search with
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Removes all the markups where companyId = &#63; from the database.
    *
    * @param companyId the company id to search with
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Removes all the markups where groupId = &#63; and location = &#63; from the database.
    *
    * @param groupId the group id to search with
    * @param location the location to search with
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupIdAndLocation(groupId, location);
    }

    /**
    * Removes all the markups where groupId = &#63; and active = &#63; and location = &#63; from the database.
    *
    * @param groupId the group id to search with
    * @param active the active to search with
    * @param location the location to search with
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupIdStatusAndLocation(long groupId,
        boolean active, short location)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByGroupIdStatusAndLocation(groupId, active, location);
    }

    /**
    * Removes all the markups from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Counts all the markups where groupId = &#63;.
    *
    * @param groupId the group id to search with
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Counts all the markups where companyId = &#63;.
    *
    * @param companyId the company id to search with
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Counts all the markups where groupId = &#63; and location = &#63;.
    *
    * @param groupId the group id to search with
    * @param location the location to search with
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupIdAndLocation(groupId, location);
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
    public static int countByGroupIdStatusAndLocation(long groupId,
        boolean active, short location)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByGroupIdStatusAndLocation(groupId, active, location);
    }

    /**
    * Counts all the markups.
    *
    * @return the number of markups
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static MarkupPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (MarkupPersistence) PortletBeanLocatorUtil.locate(com.commsen.liferay.portlet.customglobalmarkup.service.ClpSerializer.SERVLET_CONTEXT_NAME,
                    MarkupPersistence.class.getName());
        }

        return _persistence;
    }

    public void setPersistence(MarkupPersistence persistence) {
        _persistence = persistence;
    }
}
