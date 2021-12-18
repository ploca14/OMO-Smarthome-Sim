package cz.cvut.fel.omo.smarthome.events.inhabitantevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;

public class isCrying extends ImportantEvent {
    private final String description = "Inhabitant is crying.";

    public isCrying() {
    }

    public isCrying(Event event) {
        super(event);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Event makeCopy() {
        return new isCrying(this);
    }
}
