package com.commsen.liferay.portlet.customglobalmarkup.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;


/**
 * <a href="MarkupLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalService
 *
 */
public class MarkupLocalServiceUtil {
    private static MarkupLocalService _service;

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup addMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException {
        return getService().addMarkup(markup);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup createMarkup(
        long id) {
        return getService().createMarkup(id);
    }

    public static void deleteMarkup(long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMarkup(id);
    }

    public static void deleteMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException {
        getService().deleteMarkup(markup);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup getMarkup(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMarkup(id);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getMarkups(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getMarkups(start, end);
    }

    public static int getMarkupsCount()
        throws com.liferay.portal.SystemException {
        return getService().getMarkupsCount();
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException {
        return getService().updateMarkup(markup);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateMarkup(markup, merge);
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
            Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    MarkupLocalServiceUtil.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
                    portletClassLoader);

            _service = new MarkupLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);
        }

        return _service;
    }

    public void setService(MarkupLocalService service) {
        _service = service;
    }
}
