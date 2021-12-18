package cz.cvut.fel.omo.smarthome.iterators;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.simulation.Simulation;
import cz.cvut.fel.omo.smarthome.util.TestUtils;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.lang.reflect.Field;

public class DeviceIteratorTest {
    @BeforeAll
    static void loadTestConfiguration() throws IOException, ParseException {
        TestUtils.loadTestConfiguration();
    }

    @BeforeEach
    public void resetSingleton() throws Exception {
        Field instance = House.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void next_defaultHouseConfiguration_17devices(){
        Configuration cfg = Configuration.getInstance();
        Simulation simulation = new Simulation(cfg);
        DeviceIterator iterator = simulation.getHouse().getDeviceIterator();
        Integer deviceCount = 0;

        while (iterator.hasNext()){
            Device device = iterator.next();
            deviceCount++;
        }

        Assertions.assertEquals(18, deviceCount);
    }
}
