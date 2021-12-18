package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.IsHungry;

import java.util.ArrayList;

public class Kid extends Person{
    public Kid() {
        addRandomlyPublishedEvent(new IsHungry());
    }
}
