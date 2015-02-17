package com.brest.ericpol.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Equipment}.
 * </p>
 *
 * @author Viktor Kolbik
 * @see Equipment
 * @generated
 */
public class EquipmentWrapper implements Equipment, ModelWrapper<Equipment> {
    private Equipment _equipment;

    public EquipmentWrapper(Equipment equipment) {
        _equipment = equipment;
    }

    @Override
    public Class<?> getModelClass() {
        return Equipment.class;
    }

    @Override
    public String getModelClassName() {
        return Equipment.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("equipmentId", getEquipmentId());
        attributes.put("modification", getModification());
        attributes.put("price", getPrice());
        attributes.put("tankId", getTankId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long equipmentId = (Long) attributes.get("equipmentId");

        if (equipmentId != null) {
            setEquipmentId(equipmentId);
        }

        String modification = (String) attributes.get("modification");

        if (modification != null) {
            setModification(modification);
        }

        Long price = (Long) attributes.get("price");

        if (price != null) {
            setPrice(price);
        }

        Long tankId = (Long) attributes.get("tankId");

        if (tankId != null) {
            setTankId(tankId);
        }
    }

    /**
    * Returns the primary key of this equipment.
    *
    * @return the primary key of this equipment
    */
    @Override
    public long getPrimaryKey() {
        return _equipment.getPrimaryKey();
    }

    /**
    * Sets the primary key of this equipment.
    *
    * @param primaryKey the primary key of this equipment
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _equipment.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the equipment ID of this equipment.
    *
    * @return the equipment ID of this equipment
    */
    @Override
    public long getEquipmentId() {
        return _equipment.getEquipmentId();
    }

    /**
    * Sets the equipment ID of this equipment.
    *
    * @param equipmentId the equipment ID of this equipment
    */
    @Override
    public void setEquipmentId(long equipmentId) {
        _equipment.setEquipmentId(equipmentId);
    }

    /**
    * Returns the modification of this equipment.
    *
    * @return the modification of this equipment
    */
    @Override
    public java.lang.String getModification() {
        return _equipment.getModification();
    }

    /**
    * Sets the modification of this equipment.
    *
    * @param modification the modification of this equipment
    */
    @Override
    public void setModification(java.lang.String modification) {
        _equipment.setModification(modification);
    }

    /**
    * Returns the price of this equipment.
    *
    * @return the price of this equipment
    */
    @Override
    public long getPrice() {
        return _equipment.getPrice();
    }

    /**
    * Sets the price of this equipment.
    *
    * @param price the price of this equipment
    */
    @Override
    public void setPrice(long price) {
        _equipment.setPrice(price);
    }

    /**
    * Returns the tank ID of this equipment.
    *
    * @return the tank ID of this equipment
    */
    @Override
    public long getTankId() {
        return _equipment.getTankId();
    }

    /**
    * Sets the tank ID of this equipment.
    *
    * @param tankId the tank ID of this equipment
    */
    @Override
    public void setTankId(long tankId) {
        _equipment.setTankId(tankId);
    }

    @Override
    public boolean isNew() {
        return _equipment.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _equipment.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _equipment.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _equipment.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _equipment.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _equipment.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _equipment.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _equipment.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _equipment.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _equipment.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _equipment.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EquipmentWrapper((Equipment) _equipment.clone());
    }

    @Override
    public int compareTo(com.brest.ericpol.service.model.Equipment equipment) {
        return _equipment.compareTo(equipment);
    }

    @Override
    public int hashCode() {
        return _equipment.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.brest.ericpol.service.model.Equipment> toCacheModel() {
        return _equipment.toCacheModel();
    }

    @Override
    public com.brest.ericpol.service.model.Equipment toEscapedModel() {
        return new EquipmentWrapper(_equipment.toEscapedModel());
    }

    @Override
    public com.brest.ericpol.service.model.Equipment toUnescapedModel() {
        return new EquipmentWrapper(_equipment.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _equipment.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _equipment.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _equipment.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EquipmentWrapper)) {
            return false;
        }

        EquipmentWrapper equipmentWrapper = (EquipmentWrapper) obj;

        if (Validator.equals(_equipment, equipmentWrapper._equipment)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Equipment getWrappedEquipment() {
        return _equipment;
    }

    @Override
    public Equipment getWrappedModel() {
        return _equipment;
    }

    @Override
    public void resetOriginalValues() {
        _equipment.resetOriginalValues();
    }
}
