package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.models.house.Window;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public class WindowBlind extends Device{
    private final Window window;

    public WindowBlind(Window window) {
        this.window = window;
        window.setBlind(this);
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 1);
        this.activeConsumptionRate = DeviceConsumptionRate.of(0, 0, 4);
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
    public void accept(ConfigurationVisitor configurationVisitor) {
    }


    @Override
    public void accept(ConsumptionVisitor consumptionVisitor) {
        throw new UnsupportedOperationException();
    }
}
