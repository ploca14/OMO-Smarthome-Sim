package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.Event;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public class Dehumidifier extends Device{
    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(ConsumptionVisitor consumptionVisitor) {
        throw new UnsupportedOperationException();
    }
}
