package com.brest.ericpol.service.model.impl;

import com.brest.ericpol.service.model.Equipment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Equipment in entity cache.
 *
 * @author Viktor Kolbik
 * @see Equipment
 * @generated
 */
public class EquipmentCacheModel implements CacheModel<Equipment>,
    Externalizable {
    public long equipmentId;
    public String modification;
    public long price;
    public long tankId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{equipmentId=");
        sb.append(equipmentId);
        sb.append(", modification=");
        sb.append(modification);
        sb.append(", price=");
        sb.append(price);
        sb.append(", tankId=");
        sb.append(tankId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Equipment toEntityModel() {
        EquipmentImpl equipmentImpl = new EquipmentImpl();

        equipmentImpl.setEquipmentId(equipmentId);

        if (modification == null) {
            equipmentImpl.setModification(StringPool.BLANK);
        } else {
            equipmentImpl.setModification(modification);
        }

        equipmentImpl.setPrice(price);
        equipmentImpl.setTankId(tankId);

        equipmentImpl.resetOriginalValues();

        return equipmentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        equipmentId = objectInput.readLong();
        modification = objectInput.readUTF();
        price = objectInput.readLong();
        tankId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(equipmentId);

        if (modification == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(modification);
        }

        objectOutput.writeLong(price);
        objectOutput.writeLong(tankId);
    }
}
