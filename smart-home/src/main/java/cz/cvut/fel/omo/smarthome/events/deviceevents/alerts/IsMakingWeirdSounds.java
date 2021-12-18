package cz.cvut.fel.omo.smarthome.events.deviceevents.alerts;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Alert;
import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsTooBright;

public class IsMakingWeirdSounds extends Alert {
    private final String description = "A device is making weird sounds.";

    public IsMakingWeirdSounds() {
    }

    public IsMakingWeirdSounds(Event event) {
        super(event);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Event makeCopy() {
        return new IsMakingWeirdSounds(this);
    }
}
