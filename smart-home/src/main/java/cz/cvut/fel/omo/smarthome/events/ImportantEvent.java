package cz.cvut.fel.omo.smarthome.events;

import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Adult;

public class ImportantEvent extends Event{
    @Override
    public void accept(Observer observer) {
        observer.notify(this);
    }
}
