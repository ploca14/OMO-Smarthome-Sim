package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.IsTooHumid;
import cz.cvut.fel.omo.smarthome.models.house.House;
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

    @Override
    public void subscribeToEvents() {
        House.getInstance().attach(this, new IsTooHumid());
    }
}
