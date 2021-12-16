package cz.cvut.fel.omo.smarthome.interfaces.events;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.models.house.House;

public interface EventPublisher {
    default void publishEvent(Event event){
        House.getInstance().consumeEvent(this, event);
    }
}
