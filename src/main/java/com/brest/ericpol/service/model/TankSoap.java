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
public class TankSoap implements Serializable {
    private long _tankId;
    private String _number;
    private String _modification;
    private long _price;

    public TankSoap() {
    }

    public static TankSoap toSoapModel(Tank model) {
        TankSoap soapModel = new TankSoap();

        soapModel.setTankId(model.getTankId());
        soapModel.setNumber(model.getNumber());
        soapModel.setModification(model.getModification());
        soapModel.setPrice(model.getPrice());

        return soapModel;
    }

    public static TankSoap[] toSoapModels(Tank[] models) {
        TankSoap[] soapModels = new TankSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static TankSoap[][] toSoapModels(Tank[][] models) {
        TankSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new TankSoap[models.length][models[0].length];
        } else {
            soapModels = new TankSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static TankSoap[] toSoapModels(List<Tank> models) {
        List<TankSoap> soapModels = new ArrayList<TankSoap>(models.size());

        for (Tank model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new TankSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _tankId;
    }

    public void setPrimaryKey(long pk) {
        setTankId(pk);
    }

    public long getTankId() {
        return _tankId;
    }

    public void setTankId(long tankId) {
        _tankId = tankId;
    }

    public String getNumber() {
        return _number;
    }

    public void setNumber(String number) {
        _number = number;
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
}
