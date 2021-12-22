package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.models.house.Window;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Person;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public class WindowBlind extends Device {
    private final Window window;
    private boolean isOpen = false;

    public WindowBlind(Window window) {
        this.window = window;
        window.setBlind(this);
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 0);
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

    /**
     * WindowBLind is handled through Window entity.
     * Therefore the method is empty, so that it does not appear twice in the report.
     * @param configurationVisitor
     */
    @Override
    public void accept(ConfigurationVisitor configurationVisitor) {
    }

    public void accept(Person person) {
        person.use(this);
    }

    public void open() {
        if (!isOpen) {
            super.activate();
            consumptionTracker.incrementPerTick();
            super.deactivate();
        }
    }

    public void close() {
        if (isOpen) {
            super.activate();
            consumptionTracker.incrementPerTick();
            super.deactivate();
        }
    }
}
