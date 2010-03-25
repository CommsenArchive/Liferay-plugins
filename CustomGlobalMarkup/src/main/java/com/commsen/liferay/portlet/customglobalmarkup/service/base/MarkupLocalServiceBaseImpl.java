package com.commsen.liferay.portlet.customglobalmarkup.service.base;

import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;
import com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalService;
import com.commsen.liferay.portlet.customglobalmarkup.service.persistence.MarkupPersistence;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import java.util.List;


public abstract class MarkupLocalServiceBaseImpl implements MarkupLocalService {
    @BeanReference(name = "com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalService.impl")
    protected MarkupLocalService markupLocalService;
    @BeanReference(name = "com.commsen.liferay.portlet.customglobalmarkup.service.persistence.MarkupPersistence.impl")
    protected MarkupPersistence markupPersistence;

    public Markup addMarkup(Markup markup) throws SystemException {
        markup.setNew(true);

        return markupPersistence.update(markup, false);
    }

    public Markup createMarkup(long id) {
        return markupPersistence.create(id);
    }

    public void deleteMarkup(long id) throws PortalException, SystemException {
        markupPersistence.remove(id);
    }

    public void deleteMarkup(Markup markup) throws SystemException {
        markupPersistence.remove(markup);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return markupPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return markupPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Markup getMarkup(long id) throws PortalException, SystemException {
        return markupPersistence.findByPrimaryKey(id);
    }

    public List<Markup> getMarkups(int start, int end)
        throws SystemException {
        return markupPersistence.findAll(start, end);
    }

    public int getMarkupsCount() throws SystemException {
        return markupPersistence.countAll();
    }

    public Markup updateMarkup(Markup markup) throws SystemException {
        markup.setNew(false);

        return markupPersistence.update(markup, true);
    }

    public Markup updateMarkup(Markup markup, boolean merge)
        throws SystemException {
        markup.setNew(false);

        return markupPersistence.update(markup, merge);
    }

    public MarkupLocalService getMarkupLocalService() {
        return markupLocalService;
    }

    public void setMarkupLocalService(MarkupLocalService markupLocalService) {
        this.markupLocalService = markupLocalService;
    }

    public MarkupPersistence getMarkupPersistence() {
        return markupPersistence;
    }

    public void setMarkupPersistence(MarkupPersistence markupPersistence) {
        this.markupPersistence = markupPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
