package com.commsen.liferay.portlet.customglobalmarkup.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the markup local service. This utility wraps {@link com.commsen.liferay.portlet.customglobalmarkup.service.impl.MarkupLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Milen Dyankov
 * @see MarkupLocalService
 * @see com.commsen.liferay.portlet.customglobalmarkup.service.base.MarkupLocalServiceBaseImpl
 * @see com.commsen.liferay.portlet.customglobalmarkup.service.impl.MarkupLocalServiceImpl
 * @generated
 */
public class MarkupLocalServiceUtil {
    private static MarkupLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.commsen.liferay.portlet.customglobalmarkup.service.impl.MarkupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the markup to the database. Also notifies the appropriate model listeners.
    *
    * @param markup the markup
    * @return the markup that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup addMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addMarkup(markup);
    }

    /**
    * Creates a new markup with the primary key. Does not add the markup to the database.
    *
    * @param id the primary key for the new markup
    * @return the new markup
    */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup createMarkup(
        long id) {
        return getService().createMarkup(id);
    }

    /**
    * Deletes the markup with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the markup
    * @throws PortalException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static void deleteMarkup(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteMarkup(id);
    }

    /**
    * Deletes the markup from the database. Also notifies the appropriate model listeners.
    *
    * @param markup the markup
    * @throws SystemException if a system exception occurred
    */
    public static void deleteMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteMarkup(markup);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup fetchMarkup(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchMarkup(id);
    }

    /**
    * Returns the markup with the primary key.
    *
    * @param id the primary key of the markup
    * @return the markup
    * @throws PortalException if a markup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup getMarkup(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getMarkup(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getMarkups(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMarkups(start, end);
    }

    /**
    * Returns the number of markups.
    *
    * @return the number of markups
    * @throws SystemException if a system exception occurred
    */
    public static int getMarkupsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMarkupsCount();
    }

    /**
    * Updates the markup in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param markup the markup
    * @return the markup that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateMarkup(markup);
    }

    /**
    * Updates the markup in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param markup the markup
    * @param merge whether to merge the markup with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the markup that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateMarkup(markup, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getMarkups(
        long groupId) {
        return getService().getMarkups(groupId);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getActiveTopMarkups(
        long groupId) {
        return getService().getActiveTopMarkups(groupId);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getActiveBottomMarkups(
        long groupId) {
        return getService().getActiveBottomMarkups(groupId);
    }

    public static void activate(long id) {
        getService().activate(id);
    }

    public static void deactivate(long id) {
        getService().deactivate(id);
    }

    public static void clearService() {
        _service = null;
    }

    public static MarkupLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MarkupLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    MarkupLocalService.class.getName(), portletClassLoader);

            _service = new MarkupLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(MarkupLocalServiceUtil.class,
                "_service");
            MethodCache.remove(MarkupLocalService.class);
        }

        return _service;
    }

    public void setService(MarkupLocalService service) {
        MethodCache.remove(MarkupLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(MarkupLocalServiceUtil.class,
            "_service");
        MethodCache.remove(MarkupLocalService.class);
    }
}
