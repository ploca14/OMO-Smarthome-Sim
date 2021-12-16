package cz.cvut.fel.omo.smarthome.iterators;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.simulation.Simulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeviceIteratorTest {

    @Test
    public void defaultHouseConfiguration_DeviceIteratorNext_(){
        Configuration cfg = new Configuration();
        Simulation simulation = new Simulation(cfg);
        DeviceIterator iterator = simulation.getHouse().getDeviceIterator();
        Integer deviceCount = 0;

        while (iterator.hasNext()){
            Device device = iterator.next();
            deviceCount++;
        }

        Assertions.assertEquals(17, deviceCount);
    }
}
