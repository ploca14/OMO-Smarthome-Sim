package cz.cvut.fel.omo.smarthome.interfaces.traits;

import cz.cvut.fel.omo.smarthome.models.house.devices.misc.DeviceConsumption;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public interface HasConsumption {
    DeviceConsumption getConsumption();

    void accept(ConsumptionVisitor consumptionVisitor);
}
