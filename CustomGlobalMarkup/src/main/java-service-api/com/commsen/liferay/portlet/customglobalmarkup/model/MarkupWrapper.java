package com.commsen.liferay.portlet.customglobalmarkup.model;

/**
 * <p>
 * This class is a wrapper for {@link Markup}.
 * </p>
 *
 * @author    Milen Dyankov
 * @see       Markup
 * @generated
 */
public class MarkupWrapper implements Markup {
    private Markup _markup;

    public MarkupWrapper(Markup markup) {
        _markup = markup;
    }

    public long getPrimaryKey() {
        return _markup.getPrimaryKey();
    }

    public void setPrimaryKey(long pk) {
        _markup.setPrimaryKey(pk);
    }

    public long getId() {
        return _markup.getId();
    }

    public void setId(long id) {
        _markup.setId(id);
    }

    public long getCompanyId() {
        return _markup.getCompanyId();
    }

    public void setCompanyId(long companyId) {
        _markup.setCompanyId(companyId);
    }

    public long getGroupId() {
        return _markup.getGroupId();
    }

    public void setGroupId(long groupId) {
        _markup.setGroupId(groupId);
    }

    public java.lang.String getMarkup() {
        return _markup.getMarkup();
    }

    public void setMarkup(java.lang.String markup) {
        _markup.setMarkup(markup);
    }

    public boolean getActive() {
        return _markup.getActive();
    }

    public boolean isActive() {
        return _markup.isActive();
    }

    public void setActive(boolean active) {
        _markup.setActive(active);
    }

    public short getLocation() {
        return _markup.getLocation();
    }

    public void setLocation(short location) {
        _markup.setLocation(location);
    }

    public Markup toEscapedModel() {
        return _markup.toEscapedModel();
    }

    public boolean isNew() {
        return _markup.isNew();
    }

    public void setNew(boolean n) {
        _markup.setNew(n);
    }

    public boolean isCachedModel() {
        return _markup.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _markup.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _markup.isEscapedModel();
    }

    public void setEscapedModel(boolean escapedModel) {
        _markup.setEscapedModel(escapedModel);
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _markup.getPrimaryKeyObj();
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _markup.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _markup.setExpandoBridgeAttributes(serviceContext);
    }

    public java.lang.Object clone() {
        return _markup.clone();
    }

    public int compareTo(Markup markup) {
        return _markup.compareTo(markup);
    }

    public int hashCode() {
        return _markup.hashCode();
    }

    public java.lang.String toString() {
        return _markup.toString();
    }

    public java.lang.String toXmlString() {
        return _markup.toXmlString();
    }

    public Markup getWrappedMarkup() {
        return _markup;
    }
}
