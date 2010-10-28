package com.commsen.liferay.portlet.customglobalmarkup.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class MarkupClp extends BaseModelImpl<Markup> implements Markup {
    private long _id;
    private long _companyId;
    private long _groupId;
    private String _markup;
    private boolean _active;
    private short _location;

    public MarkupClp() {
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
        return _markup;
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
            return this;
        } else {
            return (Markup) Proxy.newProxyInstance(Markup.class.getClassLoader(),
                new Class[] { Markup.class }, new AutoEscapeBeanHandler(this));
        }
    }

    public Object clone() {
        MarkupClp clone = new MarkupClp();

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

        MarkupClp markup = null;

        try {
            markup = (MarkupClp) obj;
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
        StringBundler sb = new StringBundler(13);

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
        StringBundler sb = new StringBundler(22);

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
