package com.commsen.liferay.portlet.customglobalmarkup.model.impl;

import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;
import com.commsen.liferay.portlet.customglobalmarkup.model.MarkupSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="MarkupModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Markup</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.commsen.liferay.portlet.customglobalmarkup.model.Markup
 * @see com.commsen.liferay.portlet.customglobalmarkup.model.MarkupModel
 * @see com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupImpl
 *
 */
public class MarkupModelImpl extends BaseModelImpl<Markup> {
    public static final String TABLE_NAME = "CGM_Markup";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "markup", new Integer(Types.VARCHAR) },
            

            { "active_", new Integer(Types.BOOLEAN) },
            

            { "location", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table CGM_Markup (id_ LONG not null primary key,companyId LONG,groupId LONG,markup VARCHAR(2000) null,active_ BOOLEAN,location INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table CGM_Markup";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.commsen.liferay.portlet.customglobalmarkup.model.Markup"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.commsen.liferay.portlet.customglobalmarkup.model.Markup"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.commsen.liferay.portlet.customglobalmarkup.model.Markup"));
    private long _id;
    private long _companyId;
    private long _groupId;
    private String _markup;
    private boolean _active;
    private short _location;
    private transient ExpandoBridge _expandoBridge;

    public MarkupModelImpl() {
    }

    public static Markup toModel(MarkupSoap soapModel) {
        Markup model = new MarkupImpl();

        model.setId(soapModel.getId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setGroupId(soapModel.getGroupId());
        model.setMarkup(soapModel.getMarkup());
        model.setActive(soapModel.getActive());
        model.setLocation(soapModel.getLocation());

        return model;
    }

    public static List<Markup> toModels(MarkupSoap[] soapModels) {
        List<Markup> models = new ArrayList<Markup>(soapModels.length);

        for (MarkupSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public String getMarkup() {
        return GetterUtil.getString(_markup);
    }

    public void setMarkup(String markup) {
        _markup = markup;
    }

    public boolean getActive() {
        return _active;
    }

    public boolean isActive() {
        return _active;
    }

    public void setActive(boolean active) {
        _active = active;
    }

    public short getLocation() {
        return _location;
    }

    public void setLocation(short location) {
        _location = location;
    }

    public Markup toEscapedModel() {
        if (isEscapedModel()) {
            return (Markup) this;
        } else {
            Markup model = new MarkupImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setId(getId());
            model.setCompanyId(getCompanyId());
            model.setGroupId(getGroupId());
            model.setMarkup(HtmlUtil.escape(getMarkup()));
            model.setActive(getActive());
            model.setLocation(getLocation());

            model = (Markup) Proxy.newProxyInstance(Markup.class.getClassLoader(),
                    new Class[] { Markup.class }, new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(Markup.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        MarkupImpl clone = new MarkupImpl();

        clone.setId(getId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setMarkup(getMarkup());
        clone.setActive(getActive());
        clone.setLocation(getLocation());

        return clone;
    }

    public int compareTo(Markup markup) {
        long pk = markup.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Markup markup = null;

        try {
            markup = (Markup) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = markup.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{id=");
        sb.append(getId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", markup=");
        sb.append(getMarkup());
        sb.append(", active=");
        sb.append(getActive());
        sb.append(", location=");
        sb.append(getLocation());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.commsen.liferay.portlet.customglobalmarkup.model.Markup");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>markup</column-name><column-value><![CDATA[");
        sb.append(getMarkup());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>location</column-name><column-value><![CDATA[");
        sb.append(getLocation());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
