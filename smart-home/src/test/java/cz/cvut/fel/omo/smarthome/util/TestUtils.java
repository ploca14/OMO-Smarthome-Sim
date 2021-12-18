package cz.cvut.fel.omo.smarthome.util;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.models.house.House;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.reflect.Field;

public class TestUtils {
    public static void loadTestConfiguration() throws IOException, ParseException {
        InputStream inputStream = TestUtils.class
                .getClassLoader().getResourceAsStream("TestCFG.json");
        Configuration.loadFromFile(new InputStreamReader(inputStream));
    }

    /**
     * Remove the mocked instance from the class. It is important to clean up the class, because other tests will be confused with the mocked instance.
     * @throws Exception if the instance could not be accessible
     *
     * Inspired by:
     * https://github.com/KyryloSemenko/staticFieldMock/blob/master/src/test/java/com/example/DriverSnapshotHandlerTest.java
     */
    public static void resetHouseSingleton() throws NoSuchFieldException, IllegalAccessException {
        Field instance = House.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }
}
