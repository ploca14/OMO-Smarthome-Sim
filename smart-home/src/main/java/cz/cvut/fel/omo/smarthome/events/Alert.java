package cz.cvut.fel.omo.smarthome.events;

import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;

public class Alert extends Event{
    @Override
    public void accept(Observer observer) {
        observer.notify(this);
    }
}
