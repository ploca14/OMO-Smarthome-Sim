package cz.cvut.fel.omo.smarthome.events.abstractevents;

import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;

abstract public class ImportantEvent extends Event{
    public ImportantEvent() {
    }

    public ImportantEvent(Event event) {
        super(event);
    }

    @Override
    public void accept(Observer observer) {
        observer.notify(this);
    }
}
