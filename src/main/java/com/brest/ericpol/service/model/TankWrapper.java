package com.brest.ericpol.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Tank}.
 * </p>
 *
 * @author Viktor Kolbik
 * @see Tank
 * @generated
 */
public class TankWrapper implements Tank, ModelWrapper<Tank> {
    private Tank _tank;

    public TankWrapper(Tank tank) {
        _tank = tank;
    }

    @Override
    public Class<?> getModelClass() {
        return Tank.class;
    }

    @Override
    public String getModelClassName() {
        return Tank.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("tankId", getTankId());
        attributes.put("number", getNumber());
        attributes.put("modification", getModification());
        attributes.put("price", getPrice());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long tankId = (Long) attributes.get("tankId");

        if (tankId != null) {
            setTankId(tankId);
        }

        String number = (String) attributes.get("number");

        if (number != null) {
            setNumber(number);
        }

        String modification = (String) attributes.get("modification");

        if (modification != null) {
            setModification(modification);
        }

        Long price = (Long) attributes.get("price");

        if (price != null) {
            setPrice(price);
        }
    }

    /**
    * Returns the primary key of this tank.
    *
    * @return the primary key of this tank
    */
    @Override
    public long getPrimaryKey() {
        return _tank.getPrimaryKey();
    }

    /**
    * Sets the primary key of this tank.
    *
    * @param primaryKey the primary key of this tank
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _tank.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the tank ID of this tank.
    *
    * @return the tank ID of this tank
    */
    @Override
    public long getTankId() {
        return _tank.getTankId();
    }

    /**
    * Sets the tank ID of this tank.
    *
    * @param tankId the tank ID of this tank
    */
    @Override
    public void setTankId(long tankId) {
        _tank.setTankId(tankId);
    }

    /**
    * Returns the number of this tank.
    *
    * @return the number of this tank
    */
    @Override
    public java.lang.String getNumber() {
        return _tank.getNumber();
    }

    /**
    * Sets the number of this tank.
    *
    * @param number the number of this tank
    */
    @Override
    public void setNumber(java.lang.String number) {
        _tank.setNumber(number);
    }

    /**
    * Returns the modification of this tank.
    *
    * @return the modification of this tank
    */
    @Override
    public java.lang.String getModification() {
        return _tank.getModification();
    }

    /**
    * Sets the modification of this tank.
    *
    * @param modification the modification of this tank
    */
    @Override
    public void setModification(java.lang.String modification) {
        _tank.setModification(modification);
    }

    /**
    * Returns the price of this tank.
    *
    * @return the price of this tank
    */
    @Override
    public long getPrice() {
        return _tank.getPrice();
    }

    /**
    * Sets the price of this tank.
    *
    * @param price the price of this tank
    */
    @Override
    public void setPrice(long price) {
        _tank.setPrice(price);
    }

    @Override
    public boolean isNew() {
        return _tank.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _tank.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _tank.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _tank.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _tank.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _tank.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _tank.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _tank.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _tank.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _tank.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _tank.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new TankWrapper((Tank) _tank.clone());
    }

    @Override
    public int compareTo(com.brest.ericpol.service.model.Tank tank) {
        return _tank.compareTo(tank);
    }

    @Override
    public int hashCode() {
        return _tank.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.brest.ericpol.service.model.Tank> toCacheModel() {
        return _tank.toCacheModel();
    }

    @Override
    public com.brest.ericpol.service.model.Tank toEscapedModel() {
        return new TankWrapper(_tank.toEscapedModel());
    }

    @Override
    public com.brest.ericpol.service.model.Tank toUnescapedModel() {
        return new TankWrapper(_tank.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _tank.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _tank.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _tank.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TankWrapper)) {
            return false;
        }

        TankWrapper tankWrapper = (TankWrapper) obj;

        if (Validator.equals(_tank, tankWrapper._tank)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Tank getWrappedTank() {
        return _tank;
    }

    @Override
    public Tank getWrappedModel() {
        return _tank;
    }

    @Override
    public void resetOriginalValues() {
        _tank.resetOriginalValues();
    }
}
