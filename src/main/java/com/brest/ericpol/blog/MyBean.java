package com.brest.ericpol.blog;

import com.brest.ericpol.service.model.Equipment;

import java.util.List;

public class MyBean {

    private Long tankId;
    private String tankNumber;
    private String tankModification;
    private Long tankPrice;
    private List<Equipment> tankEquipment;

    public MyBean(Long tankId, String tankNumber, String tankModification, Long tankPrice, List<Equipment> tankEquipment){
        setTankId(tankId);
        setTankPrice(tankPrice);
        setTankModification(tankModification);
        setTankNumber(tankNumber);
        setTankEquipment(tankEquipment);
    }

    public void setTankId(Long tankId){
        this.tankId = tankId;
    }

    public void setTankNumber(String tankNumber){
        this.tankNumber = tankNumber;
    }

    public void setTankModification(String tankModification){
        this.tankModification = tankModification;
    }

    public void setTankPrice(Long tankPrice){
        this.tankPrice = tankPrice;
    }

    public void setTankEquipment(List<Equipment> tankEquipment){
        this.tankEquipment = tankEquipment;
    }

    public Long getTankId(){
        return tankId;
    }

    public String getTankNumber(){
        return tankNumber;
    }

    public String getTankModification(){
        return tankModification;
    }

    public Long getTankPrice(){
        return tankPrice;
    }

    public List<Equipment> getTankEquipment(){
        return tankEquipment;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "tankId=" + tankId +
                ", tankNumber='" + tankNumber + '\'' +
                ", tankModification='" + tankModification + '\'' +
                ", tankPrice=" + tankPrice +
                ", tankEquipment=" + tankEquipment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyBean)) return false;

        MyBean myBean = (MyBean) o;

        if (tankEquipment != null ? !tankEquipment.equals(myBean.tankEquipment) : myBean.tankEquipment != null)
            return false;
        if (tankId != null ? !tankId.equals(myBean.tankId) : myBean.tankId != null) return false;
        if (tankModification != null ? !tankModification.equals(myBean.tankModification) : myBean.tankModification != null)
            return false;
        if (tankNumber != null ? !tankNumber.equals(myBean.tankNumber) : myBean.tankNumber != null) return false;
        if (tankPrice != null ? !tankPrice.equals(myBean.tankPrice) : myBean.tankPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tankId != null ? tankId.hashCode() : 0;
        result = 31 * result + (tankNumber != null ? tankNumber.hashCode() : 0);
        result = 31 * result + (tankModification != null ? tankModification.hashCode() : 0);
        result = 31 * result + (tankPrice != null ? tankPrice.hashCode() : 0);
        result = 31 * result + (tankEquipment != null ? tankEquipment.hashCode() : 0);
        return result;
    }
}