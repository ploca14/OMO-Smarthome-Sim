package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public class AC extends Device{
    public AC() {
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 8);
        this.activeConsumptionRate = DeviceConsumptionRate.of(20, 0, 70);
    }

    @Override
    public void subscribeToEvents() {
        // TODO
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(ConsumptionVisitor consumptionVisitor) {
        throw new UnsupportedOperationException();
    }
}
