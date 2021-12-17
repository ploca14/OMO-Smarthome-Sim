package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public class Oven extends Device{
    public Oven() {
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 2);
        this.activeConsumptionRate = DeviceConsumptionRate.of(0, 25, 5);
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void turnOn() {
        super.turnOn();
    }

    @Override
    public void activate() {
        super.activate();
    }

    @Override
    public void deactivate() {
        super.deactivate();
    }
}
