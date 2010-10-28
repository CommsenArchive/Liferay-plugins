package com.commsen.liferay.portlet.customglobalmarkup.service;

/**
 * <p>
 * This class is a wrapper for {@link MarkupLocalService}.
 * </p>
 *
 * @author    Milen Dyankov
 * @see       MarkupLocalService
 * @generated
 */
public class MarkupLocalServiceWrapper implements MarkupLocalService {
    private MarkupLocalService _markupLocalService;

    public MarkupLocalServiceWrapper(MarkupLocalService markupLocalService) {
        _markupLocalService = markupLocalService;
    }

    /**
    * Adds the markup to the database. Also notifies the appropriate model listeners.
    *
    * @param markup the markup to add
    * @return the markup that was added
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup addMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _markupLocalService.addMarkup(markup);
    }

    /**
    * Creates a new markup with the primary key. Does not add the markup to the database.
    *
    * @param id the primary key for the new markup
    * @return the new markup
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup createMarkup(
        long id) {
        return _markupLocalService.createMarkup(id);
    }

    /**
    * Deletes the markup with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the markup to delete
    * @throws PortalException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteMarkup(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _markupLocalService.deleteMarkup(id);
    }

    /**
    * Deletes the markup from the database. Also notifies the appropriate model listeners.
    *
    * @param markup the markup to delete
    * @throws SystemException if a system exception occurred
    */
    public void deleteMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.kernel.exception.SystemException {
        _markupLocalService.deleteMarkup(markup);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query to search with
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _markupLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query to search with
    * @param start the lower bound of the range of model instances to return
    * @param end the upper bound of the range of model instances to return (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _markupLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query to search with
    * @param start the lower bound of the range of model instances to return
    * @param end the upper bound of the range of model instances to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _markupLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Counts the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query to search with
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _markupLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Gets the markup with the primary key.
    *
    * @param id the primary key of the markup to get
    * @return the markup
    * @throws PortalException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup getMarkup(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _markupLocalService.getMarkup(id);
    }

    /**
    * Gets a range of all the markups.
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
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getMarkups(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _markupLocalService.getMarkups(start, end);
    }

    /**
    * Gets the number of markups.
    *
    * @return the number of markups
    * @throws SystemException if a system exception occurred
    */
    public int getMarkupsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _markupLocalService.getMarkupsCount();
    }

    /**
    * Updates the markup in the database. Also notifies the appropriate model listeners.
    *
    * @param markup the markup to update
    * @return the markup that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _markupLocalService.updateMarkup(markup);
    }

    /**
    * Updates the markup in the database. Also notifies the appropriate model listeners.
    *
    * @param markup the markup to update
    * @param merge whether to merge the markup with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the markup that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _markupLocalService.updateMarkup(markup, merge);
    }

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getMarkups(
        long groupId) {
        return _markupLocalService.getMarkups(groupId);
    }

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getActiveTopMarkups(
        long groupId) {
        return _markupLocalService.getActiveTopMarkups(groupId);
    }

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getActiveBottomMarkups(
        long groupId) {
        return _markupLocalService.getActiveBottomMarkups(groupId);
    }

    public void activate(long id) {
        _markupLocalService.activate(id);
    }

    public void deactivate(long id) {
        _markupLocalService.deactivate(id);
    }

    public MarkupLocalService getWrappedMarkupLocalService() {
        return _markupLocalService;
    }
}
