package com.brest.ericpol.service.service.persistence;

import com.brest.ericpol.service.model.Tank;
import com.brest.ericpol.service.service.TankLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Viktor Kolbik
 * @generated
 */
public abstract class TankActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TankActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TankLocalServiceUtil.getService());
        setClass(Tank.class);

        setClassLoader(com.brest.ericpol.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("tankId");
    }
}
