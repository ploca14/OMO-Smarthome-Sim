package cz.cvut.fel.omo.smarthome.events.deviceevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;

public class IsTooDark extends ImportantEvent {
    private String description = "A room is too dark.";

    @Override
    public String getDescription() {
        return description;
    }
}
