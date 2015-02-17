package com.brest.ericpol.service.model.impl;

import com.brest.ericpol.service.model.Tank;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Tank in entity cache.
 *
 * @author Viktor Kolbik
 * @see Tank
 * @generated
 */
public class TankCacheModel implements CacheModel<Tank>, Externalizable {
    public long tankId;
    public String number;
    public String modification;
    public long price;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{tankId=");
        sb.append(tankId);
        sb.append(", number=");
        sb.append(number);
        sb.append(", modification=");
        sb.append(modification);
        sb.append(", price=");
        sb.append(price);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Tank toEntityModel() {
        TankImpl tankImpl = new TankImpl();

        tankImpl.setTankId(tankId);

        if (number == null) {
            tankImpl.setNumber(StringPool.BLANK);
        } else {
            tankImpl.setNumber(number);
        }

        if (modification == null) {
            tankImpl.setModification(StringPool.BLANK);
        } else {
            tankImpl.setModification(modification);
        }

        tankImpl.setPrice(price);

        tankImpl.resetOriginalValues();

        return tankImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        tankId = objectInput.readLong();
        number = objectInput.readUTF();
        modification = objectInput.readUTF();
        price = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(tankId);

        if (number == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(number);
        }

        if (modification == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(modification);
        }

        objectOutput.writeLong(price);
    }
}
