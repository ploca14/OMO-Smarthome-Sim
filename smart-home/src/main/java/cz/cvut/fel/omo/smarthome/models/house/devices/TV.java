package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public class TV extends Device{
    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(ConsumptionVisitor consumptionVisitor) {
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
