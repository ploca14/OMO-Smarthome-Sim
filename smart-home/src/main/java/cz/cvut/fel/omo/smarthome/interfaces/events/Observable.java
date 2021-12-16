package cz.cvut.fel.omo.smarthome.interfaces.events;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;

public interface Observable {
    public void attach(Observer observer, Event event);

    // Detaches observer from a single event
    public void detach(Observer observer, Event event);

    // Detaches observer from all events, that it subscribes
    public void detach(Observer observer);
}
