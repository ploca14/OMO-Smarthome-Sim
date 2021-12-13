package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;

abstract public class Device implements Observer, EventPublisher {
    public void subscribeToEvents() {
        // TODO
    }
}
