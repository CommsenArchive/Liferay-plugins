package com.commsen.liferay.portlet.customglobalmarkup.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="MarkupModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Markup</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.commsen.liferay.portlet.customglobalmarkup.model.Markup
 * @see com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupImpl
 * @see com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupModelImpl
 *
 */
public interface MarkupModel extends BaseModel<Markup> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getId();

    public void setId(long id);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public String getMarkup();

    public void setMarkup(String markup);

    public boolean getActive();

    public boolean isActive();

    public void setActive(boolean active);

    public short getLocation();

    public void setLocation(short location);

    public Markup toEscapedModel();
}
