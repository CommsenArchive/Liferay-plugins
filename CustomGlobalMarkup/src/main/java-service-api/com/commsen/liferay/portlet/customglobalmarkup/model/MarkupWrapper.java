package com.commsen.liferay.portlet.customglobalmarkup.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Markup}.
 * </p>
 *
 * @author    Milen Dyankov
 * @see       Markup
 * @generated
 */
public class MarkupWrapper implements Markup, ModelWrapper<Markup> {
    private Markup _markup;

    public MarkupWrapper(Markup markup) {
        _markup = markup;
    }

    public Class<?> getModelClass() {
        return Markup.class;
    }

    public String getModelClassName() {
        return Markup.class.getName();
    }

    /**
    * Returns the primary key of this markup.
    *
    * @return the primary key of this markup
    */
    public long getPrimaryKey() {
        return _markup.getPrimaryKey();
    }

    /**
    * Sets the primary key of this markup.
    *
    * @param primaryKey the primary key of this markup
    */
    public void setPrimaryKey(long primaryKey) {
        _markup.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this markup.
    *
    * @return the ID of this markup
    */
    public long getId() {
        return _markup.getId();
    }

    /**
    * Sets the ID of this markup.
    *
    * @param id the ID of this markup
    */
    public void setId(long id) {
        _markup.setId(id);
    }

    /**
    * Returns the company ID of this markup.
    *
    * @return the company ID of this markup
    */
    public long getCompanyId() {
        return _markup.getCompanyId();
    }

    /**
    * Sets the company ID of this markup.
    *
    * @param companyId the company ID of this markup
    */
    public void setCompanyId(long companyId) {
        _markup.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this markup.
    *
    * @return the group ID of this markup
    */
    public long getGroupId() {
        return _markup.getGroupId();
    }

    /**
    * Sets the group ID of this markup.
    *
    * @param groupId the group ID of this markup
    */
    public void setGroupId(long groupId) {
        _markup.setGroupId(groupId);
    }

    /**
    * Returns the markup of this markup.
    *
    * @return the markup of this markup
    */
    public java.lang.String getMarkup() {
        return _markup.getMarkup();
    }

    /**
    * Sets the markup of this markup.
    *
    * @param markup the markup of this markup
    */
    public void setMarkup(java.lang.String markup) {
        _markup.setMarkup(markup);
    }

    /**
    * Returns the active of this markup.
    *
    * @return the active of this markup
    */
    public boolean getActive() {
        return _markup.getActive();
    }

    /**
    * Returns <code>true</code> if this markup is active.
    *
    * @return <code>true</code> if this markup is active; <code>false</code> otherwise
    */
    public boolean isActive() {
        return _markup.isActive();
    }

    /**
    * Sets whether this markup is active.
    *
    * @param active the active of this markup
    */
    public void setActive(boolean active) {
        _markup.setActive(active);
    }

    /**
    * Returns the location of this markup.
    *
    * @return the location of this markup
    */
    public short getLocation() {
        return _markup.getLocation();
    }

    /**
    * Sets the location of this markup.
    *
    * @param location the location of this markup
    */
    public void setLocation(short location) {
        _markup.setLocation(location);
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

    public java.io.Serializable getPrimaryKeyObj() {
        return _markup.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _markup.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _markup.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _markup.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MarkupWrapper((Markup) _markup.clone());
    }

    public int compareTo(Markup markup) {
        return _markup.compareTo(markup);
    }

    @Override
    public int hashCode() {
        return _markup.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Markup> toCacheModel() {
        return _markup.toCacheModel();
    }

    public Markup toEscapedModel() {
        return new MarkupWrapper(_markup.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _markup.toString();
    }

    public java.lang.String toXmlString() {
        return _markup.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _markup.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Markup getWrappedMarkup() {
        return _markup;
    }

    public Markup getWrappedModel() {
        return _markup;
    }

    public void resetOriginalValues() {
        _markup.resetOriginalValues();
    }
}
