package com.brest.ericpol.service.service.persistence;

import com.brest.ericpol.service.model.Equipment;
import com.brest.ericpol.service.service.EquipmentLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Viktor Kolbik
 * @generated
 */
public abstract class EquipmentActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EquipmentActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EquipmentLocalServiceUtil.getService());
        setClass(Equipment.class);

        setClassLoader(com.brest.ericpol.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("equipmentId");
    }
}
