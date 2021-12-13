package cz.cvut.fel.omo.smarthome.events;

import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Adult;

abstract public class Event {
    public abstract void accept(Observer observer);
}
