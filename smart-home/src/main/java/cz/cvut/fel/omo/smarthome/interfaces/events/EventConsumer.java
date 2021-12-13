package cz.cvut.fel.omo.smarthome.interfaces.events;

import cz.cvut.fel.omo.smarthome.events.Event;

public interface EventConsumer {
    void consumeEvent(Event event);
}
