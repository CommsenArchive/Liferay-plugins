package com.commsen.liferay.portlet.customglobalmarkup.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MarkupPersistence extends BasePersistence {
    public void cacheResult(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup);

    public void cacheResult(
        java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> markups);

    public void clearCache();

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup create(
        long id);

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup remove(
        long id)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup remove(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Markup markup, boolean merge)</code>.
     */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup update(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                markup the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when markup is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup update(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateImpl(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByPrimaryKey(
        long id)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_First(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_Last(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByCompanyId_PrevAndNext(
        long id, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location) throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdAndLocation_First(
        long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdAndLocation_Last(
        long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupIdAndLocation_PrevAndNext(
        long id, long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdStatusAndLocation_First(
        long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdStatusAndLocation_Last(
        long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupIdStatusAndLocation_PrevAndNext(
        long id, long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.SystemException;

    public void removeByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.SystemException;

    public void removeByGroupIdStatusAndLocation(long groupId, boolean active,
        short location) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public int countByCompanyId(long companyId)
        throws com.liferay.portal.SystemException;

    public int countByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.SystemException;

    public int countByGroupIdStatusAndLocation(long groupId, boolean active,
        short location) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
