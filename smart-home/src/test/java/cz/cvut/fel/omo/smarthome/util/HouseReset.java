package cz.cvut.fel.omo.smarthome.util;

import cz.cvut.fel.omo.smarthome.models.house.House;

import java.lang.reflect.Field;

/**
 * Inspired by:
 * https://github.com/KyryloSemenko/staticFieldMock/blob/master/src/test/java/com/example/DriverSnapshotHandlerTest.java
 */
public class HouseReset {

    /**
     * Remove the mocked instance from the class. It is important to clean up the class, because other tests will be confused with the mocked instance.
     * @throws Exception if the instance could not be accessible
     */
    public static void resetHouseSingleton() throws NoSuchFieldException, IllegalAccessException {
        Field instance = House.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }
}
