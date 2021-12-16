package cz.cvut.fel.omo.smarthome.reports;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.factories.OrdinaryHouseFactory;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.simulation.Simulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HouseConfigurationReportTest {
    @Test
    public void houseGetHouseConfigurationReport_defaultConfiguration_noExceptionThrown() {
        Configuration cfg = new Configuration();
        Simulation simulation = new Simulation(cfg);
        House house = simulation.getHouse();
        HouseConfigurationReport report = house.getHouseConfigurationReport();
        System.out.println(report);
    }
}
