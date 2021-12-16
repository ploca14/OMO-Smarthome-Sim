package cz.cvut.fel.omo.smarthome.events.abstractevents;

import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Adult;

abstract public class Event {
    protected EventPublisher source;

    protected Observer handledBy;

    public abstract void accept(Observer observer);

    public abstract String getDescription();

    public EventPublisher getSource() {
        return source;
    }

    public Observer getHandledBy() {
        return handledBy;
    }

    public void markHandled(Observer handler) {
        this.handledBy = handler;
    }

    public boolean isHandled(){
        return handledBy != null;
    }

    public void setSource(EventPublisher source) {
        this.source = source;
    }

    public void setHandledBy(Observer handledBy) {
        this.handledBy = handledBy;
    }
}
