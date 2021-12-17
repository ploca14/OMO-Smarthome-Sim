package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public class Fridge extends Device{
    public Fridge() {
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 5);
        this.activeConsumptionRate = DeviceConsumptionRate.of(0, 0, 40);
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

}
