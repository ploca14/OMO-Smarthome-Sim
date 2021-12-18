package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsCrying;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsHungry;

public class Kid extends Person{
    public Kid() {
        addRandomlyPublishedEvent(new IsHungry());
        addRandomlyPublishedEvent(new IsCrying());
    }
}
