package cz.cvut.fel.omo.smarthome.interfaces.traits;

import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionTracker;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public interface HasConsumption {
    DeviceConsumptionRate getConsumptionRate();

    DeviceConsumptionTracker getConsumptionTracker();

    void accept(ConsumptionVisitor consumptionVisitor);
}
