package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.iterators.SmartHomeIterator;
import cz.cvut.fel.omo.smarthome.models.OutsideWorld;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.furniture.SportsEquipmentRack;
import cz.cvut.fel.omo.smarthome.models.house.sportsequipment.SportsEquipment;
import cz.cvut.fel.omo.smarthome.util.NameGenerator;

import java.util.AbstractMap;
import java.util.Map;

public abstract class Person extends Inhabitant{
    Map.Entry<SportsEquipment, SportsEquipmentRack> borrowedSportsEquipment;

    private boolean waitingForSport = false;

    public Person() {
        name = NameGenerator.getPersonName();
    }

    @Override
    public void simulateOneTick() {
        super.simulateOneTick();
        if (waitingForSport || rand.nextInt(4) % 2 == 0){
            waitingForSport = false;
            goSport();
        }

        else{
            // TODO interact with devices
            return;
        }
    }

    private void goSport(){
        if (borrowSportsEquipment()){
            currentRoom.removeInhabitant(this);
            OutsideWorld.getInstance().addPerson(this);
            House.getInstance().detach(this);
        }

        else{
            waitingForSport = true;
        }
    }

    /**
     *
     * @return false if no sports equipment is available
     */
    private boolean borrowSportsEquipment(){
        House house = House.getInstance();
        SmartHomeIterator<SportsEquipmentRack> sportsEquipmentRackIterator = house.getSportsEquipmentRackIterator();
        while (sportsEquipmentRackIterator.hasNext()){
            SportsEquipmentRack rack = sportsEquipmentRackIterator.next();
            if (!rack.isEmpty()){
                this.borrowedSportsEquipment = new AbstractMap.SimpleEntry<SportsEquipment, SportsEquipmentRack>(rack.takeSportsEquipment(), rack);
                return true;
            }
        }
        return false;
    }

    public void returnSportsEquipment(){
        if (borrowedSportsEquipment != null){
            SportsEquipment equipment = borrowedSportsEquipment.getKey();
            SportsEquipmentRack rack = borrowedSportsEquipment.getValue();
            rack.addSportsEquipment(equipment);
            borrowedSportsEquipment = null;
        }
    }

    public void returnHome(){
        House.getInstance().getFloors().get(0).getRooms().get(0).addInhabitant(this);
        returnSportsEquipment();
        subscribeToEvents();
    }
}
