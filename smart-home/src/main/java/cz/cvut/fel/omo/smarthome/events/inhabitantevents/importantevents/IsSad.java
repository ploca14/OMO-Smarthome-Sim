package cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;

public class IsSad extends ImportantEvent {
    private final String description = "Inhabitant is sad.";

    public IsSad() {
    }

    public IsSad(Event event) {
        super(event);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Event makeCopy() {
        return new IsSad(this);
    }
}
