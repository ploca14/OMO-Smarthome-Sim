package cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;

public class IsCrying extends ImportantEvent {
    private final String description = "Inhabitant is crying.";

    public IsCrying() {
    }

    public IsCrying(Event event) {
        super(event);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Event makeCopy() {
        return new IsCrying(this);
    }
}
