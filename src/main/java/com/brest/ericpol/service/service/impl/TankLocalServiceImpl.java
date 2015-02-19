package com.brest.ericpol.service.service.impl;

import com.brest.ericpol.MyBean;
import com.brest.ericpol.service.NoSuchTankException;
import com.brest.ericpol.service.model.Equipment;
import com.brest.ericpol.service.model.Tank;
import com.brest.ericpol.service.service.base.TankLocalServiceBaseImpl;
import com.brest.ericpol.service.service.persistence.TankUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the tank local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.brest.ericpol.service.service.TankLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Viktor Kolbik
 * @see com.brest.ericpol.service.service.base.TankLocalServiceBaseImpl
 * @see com.brest.ericpol.service.service.TankLocalServiceUtil
 */
public class TankLocalServiceImpl extends TankLocalServiceBaseImpl {

    public List<MyBean> getFullEntity(List<Tank> list) throws SystemException {
        List<MyBean> newList = new ArrayList<MyBean>();

        for (Tank tank : list){
            newList.add(new MyBean(tank.getTankId(),
                    tank.getNumber(),
                    tank.getModification(),
                    tank.getPrice(),
                    equipmentPersistence.findByTankId(tank.getTankId())));
        }

        return newList;
    }

    public Tank addTank(String number, String modification, Long price)
            throws PortalException, SystemException {
        long id= CounterLocalServiceUtil.increment(Tank.class.getName());
        Tank tank = tankPersistence.create(id);
        tank.setModification(modification);
        tank.setPrice(price);
        tank.setNumber(number);
        return tankPersistence.update(tank);
    }

    public void updateTank(Long tankId, String number, String modification, Long price) throws PortalException, SystemException{
        Tank tank = tankPersistence.create(tankId);
        tank.setNew(false);
        tank.setNumber(number);
        tank.setModification(modification);
        tank.setPrice(price);
        tankPersistence.update(tank);
    }

    public List<Tank> findByModification(String modification) throws SystemException {
        return TankUtil.findByModification(modification);
    }

    public List<Tank> findByPrice(Long lowBorder, Long topBorder) throws SystemException{
        List<Tank> list1 = TankUtil.findBylowerPrice(lowBorder);
        List<Tank> list2 = TankUtil.findByhigherPrice(topBorder);
        List<Tank> list = new ArrayList<Tank>();

        for(Tank tank : list1){
            if(list2.contains(tank)){
                list.add(tank);
            }
        }

        return list;
    }

    public void deleteTank(Long tankId) throws SystemException, NoSuchModelException {
        equipmentPersistence.removeByTankId(tankId);
        tankPersistence.remove(tankId);
    }

    public Tank findByNumber(String number) throws SystemException, NoSuchTankException {
        return tankPersistence.findByNumber(number);
    }

    public List<Tank> getAllTanks() throws SystemException {
        return tankPersistence.findAll();
    }

}
