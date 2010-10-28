package com.commsen.liferay.portlet.customglobalmarkup.service.impl;

import java.util.Collections;
import java.util.List;

import com.commsen.liferay.portlet.customglobalmarkup.CustomGlobalMarkupLocation;
import com.commsen.liferay.portlet.customglobalmarkup.model.Markup;
import com.commsen.liferay.portlet.customglobalmarkup.service.base.MarkupLocalServiceBaseImpl;
import com.commsen.liferay.portlet.customglobalmarkup.service.persistence.MarkupUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the markup local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalServiceUtil} to access
 * the markup local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Milen Dyankov
 * @see com.commsen.liferay.portlet.customglobalmarkup.service.base.MarkupLocalServiceBaseImpl
 * @see com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalServiceUtil
 */
public class MarkupLocalServiceImpl extends MarkupLocalServiceBaseImpl {
	public List<Markup> getMarkups(long groupId) {

		List<Markup> markups = Collections.emptyList();
		try {
			markups = MarkupUtil.findByGroupId(groupId);
		} catch (SystemException e) {
			_log.error("Failed to load markups to be displayed on the top of the page", e);
		}

		return markups;
	}


	public List<Markup> getActiveTopMarkups(long groupId) {

		List<Markup> markups = Collections.emptyList();
		try {
			markups = MarkupUtil.findByGroupIdStatusAndLocation(groupId, true, CustomGlobalMarkupLocation.TOP);
		} catch (SystemException e) {
			_log.error("Failed to load markups to be displayed on the top of the page", e);
		}

		return markups;
	}


	public List<Markup> getActiveBottomMarkups(long groupId) {

		List<Markup> markups = Collections.emptyList();
		try {
			markups = MarkupUtil.findByGroupIdStatusAndLocation(groupId, true, CustomGlobalMarkupLocation.BOTTOM);
		} catch (SystemException e) {
			_log.error("Failed to load markups to be displayed on the bottom of the page", e);
		}

		return markups;
	}


	public void activate(long id) {
		try {
			Markup markup = getMarkup(id);
			if (markup != null && !markup.isActive()) {
				markup.setActive(true);
				updateMarkup(markup);
			}
		} catch (SystemException e) {
			_log.error("Failed to activate markup " + id, e);
		} catch (PortalException e) {
			_log.error("Failed to activate markup " + id, e);
		}
	}


	public void deactivate(long id) {
		try {
			Markup markup = getMarkup(id);
			if (markup != null && markup.isActive()) {
				markup.setActive(false);
				updateMarkup(markup);
			}
		} catch (SystemException e) {
			_log.error("Failed to deactivate markup " + id, e);
		} catch (PortalException e) {
			_log.error("Failed to deactivate markup " + id, e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MarkupLocalServiceImpl.class);

}
