package com.commsen.liferay.portlet.customglobalmarkup.service.persistence;

import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the markup service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link MarkupUtil} to access the markup persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
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
    /**
    * Caches the markup in the entity cache if it is enabled.
    *
    * @param markup the markup to cache
    */
    public void cacheResult(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup);

    /**
    * Caches the markups in the entity cache if it is enabled.
    *
    * @param markups the markups to cache
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
    * @param id the primary key of the markup to remove
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
    * Finds the markup with the primary key or throws a {@link com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException} if it could not be found.
    *
    * @param id the primary key of the markup to find
    * @return the markup
    * @throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByPrimaryKey(
        long id)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the markup with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the markup to find
    * @return the markup, or <code>null</code> if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the markups where groupId = &#63;.
    *
    * @param groupId the group id to search with
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the markups where companyId = &#63;.
    *
    * @param companyId the company id to search with
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByCompanyId_PrevAndNext(
        long id, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the markups where groupId = &#63; and location = &#63;.
    *
    * @param groupId the group id to search with
    * @param location the location to search with
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdAndLocation_First(
        long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdAndLocation_Last(
        long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupIdAndLocation_PrevAndNext(
        long id, long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the markups where groupId = &#63; and active = &#63; and location = &#63;.
    *
    * @param groupId the group id to search with
    * @param active the active to search with
    * @param location the location to search with
    * @return the matching markups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdStatusAndLocation_First(
        long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdStatusAndLocation_Last(
        long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupIdStatusAndLocation_PrevAndNext(
        long id, long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the markups.
    *
    * @return the markups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the markups where groupId = &#63; from the database.
    *
    * @param groupId the group id to search with
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the markups where companyId = &#63; from the database.
    *
    * @param companyId the company id to search with
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the markups where groupId = &#63; and location = &#63; from the database.
    *
    * @param groupId the group id to search with
    * @param location the location to search with
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the markups where groupId = &#63; and active = &#63; and location = &#63; from the database.
    *
    * @param groupId the group id to search with
    * @param active the active to search with
    * @param location the location to search with
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
    * Counts all the markups where groupId = &#63;.
    *
    * @param groupId the group id to search with
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the markups where companyId = &#63;.
    *
    * @param companyId the company id to search with
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the markups where groupId = &#63; and location = &#63;.
    *
    * @param groupId the group id to search with
    * @param location the location to search with
    * @return the number of matching markups
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        short location)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the markups.
    *
    * @return the number of markups
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
