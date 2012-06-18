package com.commsen.liferay.portlet.customglobalmarkup.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Milen Dyankov
 * @generated
 */
public class MarkupSoap implements Serializable {
    private long _id;
    private long _companyId;
    private long _groupId;
    private String _markup;
    private boolean _active;
    private short _location;

    public MarkupSoap() {
    }

    public static MarkupSoap toSoapModel(Markup model) {
        MarkupSoap soapModel = new MarkupSoap();

        soapModel.setId(model.getId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setMarkup(model.getMarkup());
        soapModel.setActive(model.getActive());
        soapModel.setLocation(model.getLocation());

        return soapModel;
    }

    public static MarkupSoap[] toSoapModels(Markup[] models) {
        MarkupSoap[] soapModels = new MarkupSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MarkupSoap[][] toSoapModels(Markup[][] models) {
        MarkupSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MarkupSoap[models.length][models[0].length];
        } else {
            soapModels = new MarkupSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MarkupSoap[] toSoapModels(List<Markup> models) {
        List<MarkupSoap> soapModels = new ArrayList<MarkupSoap>(models.size());

        for (Markup model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MarkupSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
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
}
