package cz.cvut.fel.omo.smarthome.iterators;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.factories.OrdinaryHouseFactory;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Adult;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Dog;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Inhabitant;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Kid;
import cz.cvut.fel.omo.smarthome.simulation.Simulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InhabitantIteratorTest {

    @Test
    public void next_defaultHouseConfiguration_4ADults2Kids3Dogs(){
        Configuration cfg = Configuration.getInstance();
        Simulation simulation = new Simulation(cfg);
        InhabitantIterator iterator = simulation.getHouse().getInhabitantIterator();
        Integer adultCount = 0;
        Integer kidCount = 0;
        Integer dogCount = 0;

        while (iterator.hasNext()){
            Inhabitant inhabitant = iterator.next();
            if (inhabitant instanceof Adult) adultCount++;
            if (inhabitant instanceof Dog) dogCount++;
            if (inhabitant instanceof Kid) kidCount++;
        }

        Assertions.assertEquals(4, adultCount);
        Assertions.assertEquals(2, kidCount);
        Assertions.assertEquals(3, dogCount);
    }

    @Test
    public void hasNext_emptyHouse_FalseImmediately(){
        House house = (new OrdinaryHouseFactory()).buildHouse();
        InhabitantIterator iterator = house.getInhabitantIterator();

        boolean hasNext = iterator.hasNext();


        Assertions.assertEquals(false, hasNext);
    }

    @Test
    public void next_customlyPlacedInhabitans_2Inhabitants(){
        Integer inhabitantCount = 0;
        House house = (new OrdinaryHouseFactory()).buildHouse();
        house.getFloors().get(0).getRooms().get(0).addInhabitant(new Adult());
        house.getFloors().get(1).getRooms().get(1).addInhabitant(new Adult());

        InhabitantIterator iterator = house.getInhabitantIterator();
        while (iterator.hasNext()){
            Inhabitant inhabitant = iterator.next();
            inhabitantCount++;
        }

        Assertions.assertEquals(2, inhabitantCount);
    }
}
