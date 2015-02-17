package com.brest.ericpol.service.service.messaging;

import com.brest.ericpol.service.service.ClpSerializer;
import com.brest.ericpol.service.service.EquipmentLocalServiceUtil;
import com.brest.ericpol.service.service.TankLocalServiceUtil;

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
            EquipmentLocalServiceUtil.clearService();

            TankLocalServiceUtil.clearService();
        }
    }
}
