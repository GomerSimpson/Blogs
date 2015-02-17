package com.brest.ericpol.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Viktor Kolbik
 * @generated
 */
public class EquipmentSoap implements Serializable {
    private long _equipmentId;
    private String _modification;
    private long _price;
    private long _tankId;

    public EquipmentSoap() {
    }

    public static EquipmentSoap toSoapModel(Equipment model) {
        EquipmentSoap soapModel = new EquipmentSoap();

        soapModel.setEquipmentId(model.getEquipmentId());
        soapModel.setModification(model.getModification());
        soapModel.setPrice(model.getPrice());
        soapModel.setTankId(model.getTankId());

        return soapModel;
    }

    public static EquipmentSoap[] toSoapModels(Equipment[] models) {
        EquipmentSoap[] soapModels = new EquipmentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EquipmentSoap[][] toSoapModels(Equipment[][] models) {
        EquipmentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EquipmentSoap[models.length][models[0].length];
        } else {
            soapModels = new EquipmentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EquipmentSoap[] toSoapModels(List<Equipment> models) {
        List<EquipmentSoap> soapModels = new ArrayList<EquipmentSoap>(models.size());

        for (Equipment model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EquipmentSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _equipmentId;
    }

    public void setPrimaryKey(long pk) {
        setEquipmentId(pk);
    }

    public long getEquipmentId() {
        return _equipmentId;
    }

    public void setEquipmentId(long equipmentId) {
        _equipmentId = equipmentId;
    }

    public String getModification() {
        return _modification;
    }

    public void setModification(String modification) {
        _modification = modification;
    }

    public long getPrice() {
        return _price;
    }

    public void setPrice(long price) {
        _price = price;
    }

    public long getTankId() {
        return _tankId;
    }

    public void setTankId(long tankId) {
        _tankId = tankId;
    }
}
