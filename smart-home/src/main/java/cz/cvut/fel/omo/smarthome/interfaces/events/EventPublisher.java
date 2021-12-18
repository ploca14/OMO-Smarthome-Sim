package cz.cvut.fel.omo.smarthome.interfaces.events;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.models.house.House;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public interface EventPublisher {
    // TODO mozna problem parametrizace tu te classy, checkni v debuggeru co tam je za keys
    // TODO jestli to jsou fakt ty spravne typy, anebo tam bude jenom eventPublisher.class
    HashMap<Class<? extends EventPublisher>, ArrayList<Event>> canPublishRandomly = new HashMap<>();

    default void publishEvent(Event event){
        House.getInstance().consumeEvent(this, event);
    }

    default void publishRandomEvent() {
        if (canPublishRandomlyAtleastOneEvent()) publishEvent(getRandomEvent());
    }

    default void addRandomlyPublishedEvent(Event event){
        ArrayList<Event> eventsThisCanPublish = canPublishRandomly.get(this.getClass());
        if (eventsThisCanPublish == null){
            eventsThisCanPublish = new ArrayList<>();
        }

        for (Event e : eventsThisCanPublish) {
            if (e.getClass().equals(event.getClass())) return;
        }

        eventsThisCanPublish.add(event);
    }

    default boolean canPublishRandomlyAtleastOneEvent(){
        ArrayList<Event> events = canPublishRandomly.get(this.getClass());
        return events != null && events.size() != 0;
    }

    private Event getRandomEvent(){
        Random rand = new Random();
        ArrayList<Event> events = canPublishRandomly.get(this.getClass());
        Event randomEvent = clone(events.get(rand.nextInt(canPublishRandomly.size()));
        return randomEvent;
    }
}
