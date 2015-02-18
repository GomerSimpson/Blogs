package com.brest.ericpol.service.service.impl;

import com.brest.ericpol.service.model.Equipment;
import com.brest.ericpol.service.service.base.EquipmentLocalServiceBaseImpl;
import com.brest.ericpol.service.service.persistence.EquipmentUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class EquipmentLocalServiceImpl extends EquipmentLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.brest.ericpol.service.service.EquipmentLocalServiceUtil} to access the equipment local service.
     */

    public Equipment addEquipment(String modification, Long price, Long tankId)
            throws PortalException, SystemException {
        long id= CounterLocalServiceUtil.increment(Equipment.class.getName());
        Equipment equipment = equipmentPersistence.create(id);
        equipment.setModification(modification);
        equipment.setPrice(price);
        equipment.setTankId(tankId);
        return equipmentPersistence.update(equipment);
    }

    public void updateEquipment(Long equipmentId, String modification, Long price, Long tankId) throws SystemException {
        Equipment equipment = equipmentPersistence.create(equipmentId);
        equipment.setNew(false);
        equipment.setModification(modification);
        equipment.setPrice(price);
        equipment.setTankId(tankId);
        equipmentPersistence.update(equipment);
    }

    public List<Equipment> getEquipmentByTankId(Long tankId) throws SystemException {
        return equipmentPersistence.findByTankId(tankId);
    }

    public List<Equipment> getAllEquipment() throws SystemException {
        return equipmentPersistence.findAll();
    }

    public List<Equipment> findByModification(String modification) throws SystemException {
        return EquipmentUtil.findByModification(modification);
    }

    public List<Equipment> findByPrice(Long lowBorder, Long topBorder) throws SystemException{
        List<Equipment> list1 = EquipmentUtil.findBylowerPrice(lowBorder);
        List<Equipment> list2 = EquipmentUtil.findByhigherPrice(topBorder);
        List<Equipment> list = new ArrayList<Equipment>();

        for(Equipment equipment : list1){
            if(list2.contains(equipment)){
                list.add(equipment);
            }
        }

        return list;
    }
}
