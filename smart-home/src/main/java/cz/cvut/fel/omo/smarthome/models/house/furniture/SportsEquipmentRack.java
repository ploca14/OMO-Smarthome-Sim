package cz.cvut.fel.omo.smarthome.models.house.furniture;

import cz.cvut.fel.omo.smarthome.models.house.sportsequipment.SportsEquipment;

import java.util.ArrayList;

public class SportsEquipmentRack extends Furniture{
    ArrayList<SportsEquipment> sportsEquipment;

    public SportsEquipmentRack() {
        this.sportsEquipment = new ArrayList<>();
    }

    public void addSportsEquipment(SportsEquipment sportsEquipment){
        this.sportsEquipment.add(sportsEquipment);
    }

    public void removeSportsEquipment(SportsEquipment sportsEquipment){
        this.sportsEquipment.remove(sportsEquipment);
    }
}
