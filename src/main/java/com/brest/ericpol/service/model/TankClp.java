package com.brest.ericpol.service.model;

import com.brest.ericpol.service.service.ClpSerializer;
import com.brest.ericpol.service.service.TankLocalServiceUtil;

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


public class TankClp extends BaseModelImpl<Tank> implements Tank {
    private long _tankId;
    private String _number;
    private String _modification;
    private long _price;
    private BaseModel<?> _tankRemoteModel;
    private Class<?> _clpSerializerClass = com.brest.ericpol.service.service.ClpSerializer.class;

    public TankClp() {
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
    public long getPrimaryKey() {
        return _tankId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setTankId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _tankId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getTankId() {
        return _tankId;
    }

    @Override
    public void setTankId(long tankId) {
        _tankId = tankId;

        if (_tankRemoteModel != null) {
            try {
                Class<?> clazz = _tankRemoteModel.getClass();

                Method method = clazz.getMethod("setTankId", long.class);

                method.invoke(_tankRemoteModel, tankId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNumber() {
        return _number;
    }

    @Override
    public void setNumber(String number) {
        _number = number;

        if (_tankRemoteModel != null) {
            try {
                Class<?> clazz = _tankRemoteModel.getClass();

                Method method = clazz.getMethod("setNumber", String.class);

                method.invoke(_tankRemoteModel, number);
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

        if (_tankRemoteModel != null) {
            try {
                Class<?> clazz = _tankRemoteModel.getClass();

                Method method = clazz.getMethod("setModification", String.class);

                method.invoke(_tankRemoteModel, modification);
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

        if (_tankRemoteModel != null) {
            try {
                Class<?> clazz = _tankRemoteModel.getClass();

                Method method = clazz.getMethod("setPrice", long.class);

                method.invoke(_tankRemoteModel, price);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getTankRemoteModel() {
        return _tankRemoteModel;
    }

    public void setTankRemoteModel(BaseModel<?> tankRemoteModel) {
        _tankRemoteModel = tankRemoteModel;
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

        Class<?> remoteModelClass = _tankRemoteModel.getClass();

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

        Object returnValue = method.invoke(_tankRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            TankLocalServiceUtil.addTank(this);
        } else {
            TankLocalServiceUtil.updateTank(this);
        }
    }

    @Override
    public Tank toEscapedModel() {
        return (Tank) ProxyUtil.newProxyInstance(Tank.class.getClassLoader(),
            new Class[] { Tank.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        TankClp clone = new TankClp();

        clone.setTankId(getTankId());
        clone.setNumber(getNumber());
        clone.setModification(getModification());
        clone.setPrice(getPrice());

        return clone;
    }

    @Override
    public int compareTo(Tank tank) {
        long primaryKey = tank.getPrimaryKey();

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

        if (!(obj instanceof TankClp)) {
            return false;
        }

        TankClp tank = (TankClp) obj;

        long primaryKey = tank.getPrimaryKey();

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

        sb.append("{tankId=");
        sb.append(getTankId());
        sb.append(", number=");
        sb.append(getNumber());
        sb.append(", modification=");
        sb.append(getModification());
        sb.append(", price=");
        sb.append(getPrice());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.brest.ericpol.service.model.Tank");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>tankId</column-name><column-value><![CDATA[");
        sb.append(getTankId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>number</column-name><column-value><![CDATA[");
        sb.append(getNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modification</column-name><column-value><![CDATA[");
        sb.append(getModification());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>price</column-name><column-value><![CDATA[");
        sb.append(getPrice());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
