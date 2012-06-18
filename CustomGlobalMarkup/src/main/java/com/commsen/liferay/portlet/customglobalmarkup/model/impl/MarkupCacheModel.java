package com.commsen.liferay.portlet.customglobalmarkup.model.impl;

import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Markup in entity cache.
 *
 * @author Milen Dyankov
 * @see Markup
 * @generated
 */
public class MarkupCacheModel implements CacheModel<Markup>, Serializable {
    public long id;
    public long companyId;
    public long groupId;
    public String markup;
    public boolean active;
    public short location;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", markup=");
        sb.append(markup);
        sb.append(", active=");
        sb.append(active);
        sb.append(", location=");
        sb.append(location);
        sb.append("}");

        return sb.toString();
    }

    public Markup toEntityModel() {
        MarkupImpl markupImpl = new MarkupImpl();

        markupImpl.setId(id);
        markupImpl.setCompanyId(companyId);
        markupImpl.setGroupId(groupId);

        if (markup == null) {
            markupImpl.setMarkup(StringPool.BLANK);
        } else {
            markupImpl.setMarkup(markup);
        }

        markupImpl.setActive(active);
        markupImpl.setLocation(location);

        markupImpl.resetOriginalValues();

        return markupImpl;
    }
}
