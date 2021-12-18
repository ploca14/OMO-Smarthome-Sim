package cz.cvut.fel.omo.smarthome.events.abstractevents;

import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Adult;
import cz.cvut.fel.omo.smarthome.reports.visitors.EventVisitor;

// TODO soucasny problem, Event se pouziva v randomeventech u publisheur, kde se entita znovupouziva a publishuje se
// TODO jenze to potom zkurvi source toho eventu? Je reseni to udelat immutable?
abstract public class Event{
    protected EventPublisher source;

    protected Observer handledBy;

    public Event() {
    }

    public Event(Event event){
        this.source = event.source;
        this.handledBy = event.handledBy;
    }

    public abstract void accept(Observer observer);

    public abstract String getDescription();

    public abstract Event makeCopy();

    public abstract void accept(EventVisitor visitor);

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
