package cz.cvut.fel.omo.smarthome.models.house.furniture;

import cz.cvut.fel.omo.smarthome.models.house.sportsequipment.SportsEquipment;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;

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

    @Override
    public void accept(ConfigurationVisitor configurationVisitor) {
        super.accept(configurationVisitor);
        for (SportsEquipment sportsEquipment : sportsEquipment){
            sportsEquipment.accept(configurationVisitor);
        }
    }
}
