package com.commsen.liferay.portlet.customglobalmarkup.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the markup local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Milen Dyankov
 * @see MarkupLocalServiceUtil
 * @see com.commsen.liferay.portlet.customglobalmarkup.service.base.MarkupLocalServiceBaseImpl
 * @see com.commsen.liferay.portlet.customglobalmarkup.service.impl.MarkupLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MarkupLocalService extends PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MarkupLocalServiceUtil} to access the markup local service. Add custom service methods to {@link com.commsen.liferay.portlet.customglobalmarkup.service.impl.MarkupLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the markup to the database. Also notifies the appropriate model listeners.
    *
    * @param markup the markup
    * @return the markup that was added
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup addMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new markup with the primary key. Does not add the markup to the database.
    *
    * @param id the primary key for the new markup
    * @return the new markup
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup createMarkup(
        long id);

    /**
    * Deletes the markup with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the markup
    * @throws PortalException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteMarkup(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the markup from the database. Also notifies the appropriate model listeners.
    *
    * @param markup the markup
    * @throws SystemException if a system exception occurred
    */
    public void deleteMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup fetchMarkup(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the markup with the primary key.
    *
    * @param id the primary key of the markup
    * @return the markup
    * @throws PortalException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup getMarkup(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getMarkups(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of markups.
    *
    * @return the number of markups
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMarkupsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the markup in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param markup the markup
    * @return the markup that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the markup in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param markup the markup
    * @param merge whether to merge the markup with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the markup that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getMarkups(
        long groupId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getActiveTopMarkups(
        long groupId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getActiveBottomMarkups(
        long groupId);

    public void activate(long id);

    public void deactivate(long id);
}
