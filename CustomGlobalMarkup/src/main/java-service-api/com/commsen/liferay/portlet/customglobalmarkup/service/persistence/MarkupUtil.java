package com.commsen.liferay.portlet.customglobalmarkup.service.persistence;

import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the markup service. This utility wraps {@link MarkupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
    * @param markup the markup
    */
    public static void cacheResult(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup) {
        getPersistence().cacheResult(markup);
    }

    /**
    * Caches the markups in the entity cache if it is enabled.
    *
    * @param markups the markups
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
    * @param id the primary key of the markup
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
    * Returns the markup with the primary key or throws a {@link com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException} if it could not be found.
    *
    * @param id the primary key of the markup
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
    * Returns the markup with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the markup
    * @return the markup, or <code>null</code> if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the markups where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(id, groupId, orderByComparator);
    }

    /**
    * Returns all the markups where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByCompanyId_PrevAndNext(
        long id, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(id, companyId, orderByComparator);
    }

    /**
    * Returns all the markups where groupId = &#63; and location = &#63;.
    *
    * @param groupId the group ID
    * @param location the location
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupIdAndLocation(groupId, location);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation(groupId, location, start, end);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation(groupId, location, start, end,
            orderByComparator);
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
    * Returns all the markups where groupId = &#63; and active = &#63; and location = &#63;.
    *
    * @param groupId the group ID
    * @param active the active
    * @param location the location
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation(groupId, active, location,
            start, end);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation(groupId, active, location,
            start, end, orderByComparator);
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
    * Returns all the markups.
    *
    * @return the markups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the markups where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Removes all the markups where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Removes all the markups where groupId = &#63; and location = &#63; from the database.
    *
    * @param groupId the group ID
    * @param location the location
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupIdAndLocation(groupId, location);
    }

    /**
    * Removes all the markups where groupId = &#63; and active = &#63; and location = &#63; from the database.
    *
    * @param groupId the group ID
    * @param active the active
    * @param location the location
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
    * Returns the number of markups where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the number of markups where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns the number of markups where groupId = &#63; and location = &#63;.
    *
    * @param groupId the group ID
    * @param location the location
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupIdAndLocation(groupId, location);
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
    public static int countByGroupIdStatusAndLocation(long groupId,
        boolean active, short location)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByGroupIdStatusAndLocation(groupId, active, location);
    }

    /**
    * Returns the number of markups.
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
            _persistence = (MarkupPersistence) PortletBeanLocatorUtil.locate(com.commsen.liferay.portlet.customglobalmarkup.service.ClpSerializer.getServletContextName(),
                    MarkupPersistence.class.getName());

            ReferenceRegistry.registerReference(MarkupUtil.class, "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(MarkupPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(MarkupUtil.class, "_persistence");
    }
}
