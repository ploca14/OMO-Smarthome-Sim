package cz.cvut.fel.omo.smarthome.events.deviceevents;

import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;

public class IsTooHumid extends ImportantEvent {
    private String description = "Humidity in a room is too high.";

    @Override
    public String getDescription() {
        return description;
    }
}
