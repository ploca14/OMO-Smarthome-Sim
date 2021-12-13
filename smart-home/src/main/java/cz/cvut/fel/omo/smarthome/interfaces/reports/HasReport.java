package cz.cvut.fel.omo.smarthome.interfaces.reports;

import cz.cvut.fel.omo.smarthome.reports.ActivityAndUsageReport;
import cz.cvut.fel.omo.smarthome.reports.ConsumptionReport;
import cz.cvut.fel.omo.smarthome.reports.EventReport;
import cz.cvut.fel.omo.smarthome.reports.HouseConfigurationReport;

public interface HasReport {

    public HouseConfigurationReport getHouseConfigurationReport();

    public ActivityAndUsageReport getActivityAndUsageReport();

    public ConsumptionReport getConsumptionReport();

    public EventReport getEventReport();
}
