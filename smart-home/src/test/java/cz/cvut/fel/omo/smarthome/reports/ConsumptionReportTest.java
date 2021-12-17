package cz.cvut.fel.omo.smarthome.reports;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.simulation.Simulation;
import org.junit.jupiter.api.Test;

public class ConsumptionReportTest {
    @Test
    public void houseGetHouseConfigurationReport_defaultConfigurationNoConsumption_noExceptionThrown() {
        Configuration cfg = Configuration.getInstance();
        Simulation simulation = new Simulation(cfg);
        House house = simulation.getHouse();
        ConsumptionReport report = house.getConsumptionReport();
        System.out.println(report);
    }
}
