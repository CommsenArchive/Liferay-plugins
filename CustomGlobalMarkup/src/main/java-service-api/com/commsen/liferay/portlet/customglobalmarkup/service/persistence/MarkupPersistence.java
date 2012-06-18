package com.commsen.liferay.portlet.customglobalmarkup.service.persistence;

import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the markup service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Milen Dyankov
 * @see MarkupPersistenceImpl
 * @see MarkupUtil
 * @generated
 */
public interface MarkupPersistence extends BasePersistence<Markup> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MarkupUtil} to access the markup persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the markup in the entity cache if it is enabled.
    *
    * @param markup the markup
    */
    public void cacheResult(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup);

    /**
    * Caches the markups in the entity cache if it is enabled.
    *
    * @param markups the markups
    */
    public void cacheResult(
        java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> markups);

    /**
    * Creates a new markup with the primary key. Does not add the markup to the database.
    *
    * @param id the primary key for the new markup
    * @return the new markup
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup create(
        long id);

    /**
    * Removes the markup with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the markup
    * @return the markup that was removed
    * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup remove(
        long id)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateImpl(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the markup with the primary key or throws a {@link com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException} if it could not be found.
    *
    * @param id the primary key of the markup
    * @return the markup
    * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByPrimaryKey(
        long id)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the markup with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the markup
    * @return the markup, or <code>null</code> if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the markups where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the markups where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByCompanyId_PrevAndNext(
        long id, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the markups where groupId = &#63; and location = &#63;.
    *
    * @param groupId the group ID
    * @param location the location
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdAndLocation_First(
        long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdAndLocation_Last(
        long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupIdAndLocation_PrevAndNext(
        long id, long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the markups where groupId = &#63; and active = &#63; and location = &#63;.
    *
    * @param groupId the group ID
    * @param active the active
    * @param location the location
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdStatusAndLocation_First(
        long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdStatusAndLocation_Last(
        long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupIdStatusAndLocation_PrevAndNext(
        long id, long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the markups.
    *
    * @return the markups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the markups where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the markups where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the markups where groupId = &#63; and location = &#63; from the database.
    *
    * @param groupId the group ID
    * @param location the location
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the markups where groupId = &#63; and active = &#63; and location = &#63; from the database.
    *
    * @param groupId the group ID
    * @param active the active
    * @param location the location
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupIdStatusAndLocation(long groupId, boolean active,
        short location)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the markups from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of markups where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of markups where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of markups where groupId = &#63; and location = &#63;.
    *
    * @param groupId the group ID
    * @param location the location
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        short location)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of markups.
    *
    * @return the number of markups
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
