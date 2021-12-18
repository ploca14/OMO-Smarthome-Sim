package cz.cvut.fel.omo.smarthome.events.inhabitantevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;

public class isSad extends ImportantEvent {
    private final String description = "Inhabitant is sad.";

    public isSad() {
    }

    public isSad(Event event) {
        super(event);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Event makeCopy() {
        return new isSad(this);
    }
}
