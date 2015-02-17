package com.brest.ericpol.service.model;

import com.brest.ericpol.service.service.ClpSerializer;
import com.brest.ericpol.service.service.EquipmentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class EquipmentClp extends BaseModelImpl<Equipment> implements Equipment {
    private long _equipmentId;
    private String _modification;
    private long _price;
    private long _tankId;
    private BaseModel<?> _equipmentRemoteModel;
    private Class<?> _clpSerializerClass = com.brest.ericpol.service.service.ClpSerializer.class;

    public EquipmentClp() {
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
    public long getPrimaryKey() {
        return _equipmentId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setEquipmentId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _equipmentId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getEquipmentId() {
        return _equipmentId;
    }

    @Override
    public void setEquipmentId(long equipmentId) {
        _equipmentId = equipmentId;

        if (_equipmentRemoteModel != null) {
            try {
                Class<?> clazz = _equipmentRemoteModel.getClass();

                Method method = clazz.getMethod("setEquipmentId", long.class);

                method.invoke(_equipmentRemoteModel, equipmentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getModification() {
        return _modification;
    }

    @Override
    public void setModification(String modification) {
        _modification = modification;

        if (_equipmentRemoteModel != null) {
            try {
                Class<?> clazz = _equipmentRemoteModel.getClass();

                Method method = clazz.getMethod("setModification", String.class);

                method.invoke(_equipmentRemoteModel, modification);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPrice() {
        return _price;
    }

    @Override
    public void setPrice(long price) {
        _price = price;

        if (_equipmentRemoteModel != null) {
            try {
                Class<?> clazz = _equipmentRemoteModel.getClass();

                Method method = clazz.getMethod("setPrice", long.class);

                method.invoke(_equipmentRemoteModel, price);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getTankId() {
        return _tankId;
    }

    @Override
    public void setTankId(long tankId) {
        _tankId = tankId;

        if (_equipmentRemoteModel != null) {
            try {
                Class<?> clazz = _equipmentRemoteModel.getClass();

                Method method = clazz.getMethod("setTankId", long.class);

                method.invoke(_equipmentRemoteModel, tankId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getEquipmentRemoteModel() {
        return _equipmentRemoteModel;
    }

    public void setEquipmentRemoteModel(BaseModel<?> equipmentRemoteModel) {
        _equipmentRemoteModel = equipmentRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _equipmentRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_equipmentRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            EquipmentLocalServiceUtil.addEquipment(this);
        } else {
            EquipmentLocalServiceUtil.updateEquipment(this);
        }
    }

    @Override
    public Equipment toEscapedModel() {
        return (Equipment) ProxyUtil.newProxyInstance(Equipment.class.getClassLoader(),
            new Class[] { Equipment.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        EquipmentClp clone = new EquipmentClp();

        clone.setEquipmentId(getEquipmentId());
        clone.setModification(getModification());
        clone.setPrice(getPrice());
        clone.setTankId(getTankId());

        return clone;
    }

    @Override
    public int compareTo(Equipment equipment) {
        long primaryKey = equipment.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EquipmentClp)) {
            return false;
        }

        EquipmentClp equipment = (EquipmentClp) obj;

        long primaryKey = equipment.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{equipmentId=");
        sb.append(getEquipmentId());
        sb.append(", modification=");
        sb.append(getModification());
        sb.append(", price=");
        sb.append(getPrice());
        sb.append(", tankId=");
        sb.append(getTankId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.brest.ericpol.service.model.Equipment");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>equipmentId</column-name><column-value><![CDATA[");
        sb.append(getEquipmentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modification</column-name><column-value><![CDATA[");
        sb.append(getModification());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>price</column-name><column-value><![CDATA[");
        sb.append(getPrice());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tankId</column-name><column-value><![CDATA[");
        sb.append(getTankId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
