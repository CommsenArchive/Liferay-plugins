package com.commsen.liferay.portlet.customglobalmarkup.service.persistence;

public class MarkupUtil {
    private static MarkupPersistence _persistence;

    public static void cacheResult(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup) {
        getPersistence().cacheResult(markup);
    }

    public static void cacheResult(
        java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> markups) {
        getPersistence().cacheResult(markups);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup create(
        long id) {
        return getPersistence().create(id);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup remove(
        long id)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence().remove(id);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup remove(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(markup);
    }

    /**
     * @deprecated Use <code>update(Markup markup, boolean merge)</code>.
     */
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup update(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(markup);
    }

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
    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup update(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(markup, merge);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateImpl(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(markup, merge);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByPrimaryKey(
        long id)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence().findByGroupId_First(groupId, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence().findByGroupId_Last(groupId, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence().findByGroupId_PrevAndNext(id, groupId, obc);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId) throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_First(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId_First(companyId, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByCompanyId_Last(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId_Last(companyId, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByCompanyId_PrevAndNext(
        long id, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId_PrevAndNext(id, companyId, obc);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location) throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupIdAndLocation(groupId, location);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation(groupId, location, start, end);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdAndLocation(
        long groupId, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation(groupId, location, start, end, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdAndLocation_First(
        long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation_First(groupId, location, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdAndLocation_Last(
        long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation_Last(groupId, location, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupIdAndLocation_PrevAndNext(
        long id, long groupId, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdAndLocation_PrevAndNext(id, groupId, location,
            obc);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation(groupId, active, location);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation(groupId, active, location,
            start, end);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findByGroupIdStatusAndLocation(
        long groupId, boolean active, short location, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation(groupId, active, location,
            start, end, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdStatusAndLocation_First(
        long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation_First(groupId, active,
            location, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup findByGroupIdStatusAndLocation_Last(
        long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation_Last(groupId, active,
            location, obc);
    }

    public static com.commsen.liferay.portlet.customglobalmarkup.model.Markup[] findByGroupIdStatusAndLocation_PrevAndNext(
        long id, long groupId, boolean active, short location,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.commsen.liferay.portlet.customglobalmarkup.NoSuchMarkupException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByGroupIdStatusAndLocation_PrevAndNext(id, groupId,
            active, location, obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    public static void removeByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByGroupIdAndLocation(groupId, location);
    }

    public static void removeByGroupIdStatusAndLocation(long groupId,
        boolean active, short location)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByGroupIdStatusAndLocation(groupId, active, location);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    public static int countByGroupIdAndLocation(long groupId, short location)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByGroupIdAndLocation(groupId, location);
    }

    public static int countByGroupIdStatusAndLocation(long groupId,
        boolean active, short location)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByGroupIdStatusAndLocation(groupId, active, location);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static MarkupPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(MarkupPersistence persistence) {
        _persistence = persistence;
    }
}
