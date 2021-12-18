package cz.cvut.fel.omo.smarthome.events.deviceevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;

public class IsTooHumid extends ImportantEvent {
    private final String description = "Humidity in a room is too high.";

    public IsTooHumid() {
    }

    public IsTooHumid(Event event) {
        super(event);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Event makeCopy() {
        return new IsTooHumid(this);
    }
}
