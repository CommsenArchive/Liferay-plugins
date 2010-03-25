package com.commsen.liferay.portlet.customglobalmarkup.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MarkupLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.commsen.liferay.portlet.customglobalmarkup.service.impl.MarkupLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MarkupLocalService {
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup addMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup createMarkup(
        long id);

    public void deleteMarkup(long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup getMarkup(
        long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getMarkups(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMarkupsCount() throws com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge) throws com.liferay.portal.SystemException;

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
