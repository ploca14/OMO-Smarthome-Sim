package cz.cvut.fel.omo.smarthome.events.inhabitantevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;

public class IsHungry extends ImportantEvent {
    private String description = "Inhabitant is hungry.";

    @Override
    public String getDescription() {
        return description;
    }
}
