package cz.cvut.fel.omo.smarthome.interfaces.events;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;

public interface EventConsumer {
    void consumeEvent(EventPublisher source, Event event);
}
