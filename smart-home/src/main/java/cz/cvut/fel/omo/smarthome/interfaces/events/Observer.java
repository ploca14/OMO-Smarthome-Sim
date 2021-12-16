package cz.cvut.fel.omo.smarthome.interfaces.events;

import cz.cvut.fel.omo.smarthome.events.Event;
import cz.cvut.fel.omo.smarthome.events.ImportantEvent;

public interface Observer {
    /**
     * notify (DRUH_EVENTU);
     *
     * potom co vytvorime ruzne eventy
     * napr. DeviceBrokeDownEvent atd...
     */

    default void notify(Event event){};

    void subscribeToEvents(); // Defines all events, the observer wants to listen to
}
