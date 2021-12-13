package cz.cvut.fel.omo.smarthome.interfaces.events;

import cz.cvut.fel.omo.smarthome.events.Event;
import cz.cvut.fel.omo.smarthome.models.house.House;

public interface EventPublisher {
    private void publishEvent(Event event){
        House.getInstance().consumeEvent(event);
    }
}
