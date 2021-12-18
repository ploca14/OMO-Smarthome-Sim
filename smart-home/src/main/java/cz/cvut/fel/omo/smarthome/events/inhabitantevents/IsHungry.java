package cz.cvut.fel.omo.smarthome.events.inhabitantevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;

public class IsHungry extends ImportantEvent {
    private final String description = "Inhabitant is hungry.";

    public IsHungry(Event event) {
        super(event);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Event makeCopy() {
        return new IsHungry(this);
    }
}
