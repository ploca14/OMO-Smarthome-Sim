package cz.cvut.fel.omo.smarthome.events.inhabitantevents.alerts;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Alert;
import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;

public class IsBarking extends Alert {
    private final String description = "Dog is barking.";

    public IsBarking() {
    }

    public IsBarking(Event event) {
        super(event);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Event makeCopy() {
        return new IsBarking(this);
    }
}
