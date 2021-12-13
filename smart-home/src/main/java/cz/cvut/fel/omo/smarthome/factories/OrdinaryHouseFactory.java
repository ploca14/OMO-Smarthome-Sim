package cz.cvut.fel.omo.smarthome.factories;

import cz.cvut.fel.omo.smarthome.builders.FloorBuilder;
import cz.cvut.fel.omo.smarthome.interfaces.factories.AbstractHouseFactory;
import cz.cvut.fel.omo.smarthome.models.house.Floor;
import cz.cvut.fel.omo.smarthome.models.house.House;

public class OrdinaryHouseFactory implements AbstractHouseFactory {
    @Override
    public House buildHouse() {
        House house = House.getInstance();

        Floor underground = new FloorBuilder().
                addCellar().
                addCellar().
                getResult();
        house.addFloor(underground);

        Floor ordinaryFloor = new FloorBuilder().
                addKitchen().
                addLivingRoom().
                getResult();
        house.addFloor(ordinaryFloor);

        return house;
    }
}
