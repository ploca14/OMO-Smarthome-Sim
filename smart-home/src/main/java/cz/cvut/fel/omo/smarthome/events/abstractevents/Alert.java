package cz.cvut.fel.omo.smarthome.events.abstractevents;

import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;

abstract public class Alert extends Event{
    public Alert() {
    }

    public Alert(Event event) {
        super(event);
    }

    @Override
    public void accept(Observer observer) {
        observer.notify(this);
    }
}
