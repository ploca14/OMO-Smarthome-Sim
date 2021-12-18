package cz.cvut.fel.omo.smarthome.events.inhabitantevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;

public class isCrying extends ImportantEvent {
    private String description = "Inhabitant is crying.";

    @Override
    public String getDescription() {
        return description;
    }
}
