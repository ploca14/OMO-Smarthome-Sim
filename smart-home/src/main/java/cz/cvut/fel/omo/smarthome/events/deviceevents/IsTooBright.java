package cz.cvut.fel.omo.smarthome.events.deviceevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;

public class IsTooBright extends ImportantEvent {
    private String description = "A room is too bright.";

    @Override
    public String getDescription() {
        return description;
    }
}
