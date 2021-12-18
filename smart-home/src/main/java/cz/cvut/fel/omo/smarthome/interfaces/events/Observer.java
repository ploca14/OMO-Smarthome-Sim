package cz.cvut.fel.omo.smarthome.interfaces.events;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.alerts.IsMakingWeirdSounds;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.*;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsCrying;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsHungry;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsSad;

public interface Observer {
    /**
     * notify (DRUH_EVENTU);
     *
     * potom co vytvorime ruzne eventy
     * napr. DeviceBrokeDownEvent atd...
     */

    default void notify(Event event){};

    default void notify(IsMakingWeirdSounds event){};

    default void notify(IsTooBright event){};

    default void notify(IsTooDark event){};

    default void notify(IsTooHot event){};

    default void notify(IsTooHumid event){};

    default void notify(IsCrying event){};

    default void notify(IsSad event){};

    default void notify(IsHungry event){};

    default void notify (IsBroken event){};

    void subscribeToEvents(); // Defines all events, the observer wants to listen to
}
