package cz.cvut.fel.omo.smarthome.interfaces.events;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.models.house.House;

import java.util.ArrayList;
import java.util.Random;

public interface EventPublisher {
    ArrayList<Event> canPublishRandomly = new ArrayList<>();

    default void publishEvent(Event event){
        House.getInstance().consumeEvent(this, event);
    }

    default void publishRandomEvent() {
        if (canPublishRandomlyAtleastOneEvent()) publishEvent(getRandomEvent());
    }

    default void addRandomlyPublishedEvent(Event event){
        for (Event e : canPublishRandomly) {
            if (e.getClass().equals(event.getClass())) return;
        }

        canPublishRandomly.add(event);
    }

    default boolean canPublishRandomlyAtleastOneEvent(){
        return canPublishRandomly.size() != 0;
    }

    default Event getRandomEvent(){
        Random rand = new Random();
        Event randomEvent = canPublishRandomly.get(rand.nextInt(canPublishRandomly.size()));
        return randomEvent;
    }
}
