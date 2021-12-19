package cz.cvut.fel.omo.smarthome.models.house.furniture;

import cz.cvut.fel.omo.smarthome.models.house.sportsequipment.SportsEquipment;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;

import java.util.ArrayList;

public class SportsEquipmentRack extends Furniture{
    ArrayList<SportsEquipment> sportsEquipment = new ArrayList<>();

    public void addSportsEquipment(SportsEquipment sportsEquipment){
        this.sportsEquipment.add(sportsEquipment);
    }

    public SportsEquipment takeSportsEquipment(){
        if (sportsEquipment.size() != 0){
            SportsEquipment equipment = sportsEquipment.get(0);
            sportsEquipment.remove(equipment);
            return equipment;
        }

        return null;
    }

    public boolean isEmpty(){
        return sportsEquipment.size() == 0;
    }

    @Override
    public void accept(ConfigurationVisitor configurationVisitor) {
        super.accept(configurationVisitor);
        for (SportsEquipment sportsEquipment : sportsEquipment){
            sportsEquipment.accept(configurationVisitor);
        }
    }
}
