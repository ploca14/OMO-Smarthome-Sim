package cz.cvut.fel.omo.smarthome.factories;

import cz.cvut.fel.omo.smarthome.builders.FloorBuilder;
import cz.cvut.fel.omo.smarthome.interfaces.factories.AbstractHouseFactory;
import cz.cvut.fel.omo.smarthome.models.house.Floor;
import cz.cvut.fel.omo.smarthome.models.house.House;

public class LuxuriouHouseFactory implements AbstractHouseFactory {
    @Override
    public House buildHouse() {
        House house = House.getInstance();
        FloorBuilder floorBuilder = new FloorBuilder();

        Floor underground = floorBuilder.
                addCellar().
                addCellar().
                getResult();
        house.addFloor(underground);

        Floor eatingFloor = floorBuilder.
                addKitchen().
                addKitchen().
                getResult();
        house.addFloor(eatingFloor);

        Floor livingFloor = floorBuilder.
                addLivingRoom().
                addTVRoom().
                getResult();
        house.addFloor(livingFloor);

        return house;
    }
}
