package com.commsen.liferay.portlet.customglobalmarkup.service.messaging;

import com.commsen.liferay.portlet.customglobalmarkup.service.ClpSerializer;
import com.commsen.liferay.portlet.customglobalmarkup.service.MarkupLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            MarkupLocalServiceUtil.clearService();
        }
    }
}
