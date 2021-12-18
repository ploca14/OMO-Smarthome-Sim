package cz.cvut.fel.omo.smarthome.simulation;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.configuration.HouseType;
import cz.cvut.fel.omo.smarthome.factories.LuxuriouHouseFactory;
import cz.cvut.fel.omo.smarthome.factories.OrdinaryHouseFactory;
import cz.cvut.fel.omo.smarthome.iterators.DeviceIterator;
import cz.cvut.fel.omo.smarthome.iterators.InhabitantIterator;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.Room;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Adult;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Dog;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Inhabitant;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Kid;

public class Simulation {
    private Configuration configuration;

    private House house;

    private Integer currentSimulationTick = 1;

    public Simulation(Configuration configuration) {
        this.configuration = configuration;
        initHouse();
        addInhabitants();
    }

    private void addInhabitants(){
        Room startingRoom = house.getFloors().get(0).getRooms().get(0);
        for (int i = 0; i < configuration.getAdults(); i++){
            startingRoom.addInhabitant(new Adult());
        }

        for (int i = 0; i < configuration.getDogs(); i++){
            startingRoom.addInhabitant(new Dog());
        }

        for (int i = 0; i < configuration.getKids(); i++){
            startingRoom.addInhabitant(new Kid());
        }
    }

    private void initHouse(){
        if (configuration.getHouseType() == HouseType.ORDINARY){
            house = new OrdinaryHouseFactory().buildHouse();
        }

        else if (configuration.getHouseType() == HouseType.LUXURIUS){
            house = new LuxuriouHouseFactory().buildHouse();
        }
    }

    public void execute(){
        while (currentSimulationTick != configuration.getSimulationLength() + 1){
            simulateDeviceActivity();
            simulateInhabitantActivity();
            currentSimulationTick++;
        }
    }

    private void simulateDeviceActivity(){
        DeviceIterator deviceIterator = house.getDeviceIterator();
        while (deviceIterator.hasNext()){
            Device device = deviceIterator.next();
            device.simulateOneTick();
        }
    }

    private void simulateInhabitantActivity(){
        InhabitantIterator inhabitantIterator = house.getInhabitantIterator();
        while (inhabitantIterator.hasNext()){
            Inhabitant inhabitant = inhabitantIterator.next();
            inhabitant.simulateOneTick();
        }
    }

    public House getHouse() {
        return house;
    }
}
