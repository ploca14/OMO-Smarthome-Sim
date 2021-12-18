package cz.cvut.fel.omo.smarthome.events.deviceevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;

public class IsTooBright extends ImportantEvent {
    private final String description = "A room is too bright.";

    public IsTooBright() {
    }

    public IsTooBright(Event event) {
        super(event);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Event makeCopy() {
        return new IsTooBright(this);
    }
}
