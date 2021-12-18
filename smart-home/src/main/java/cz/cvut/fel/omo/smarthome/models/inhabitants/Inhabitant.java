package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;

import java.util.ArrayList;
import java.util.Random;

abstract public class Inhabitant implements EventPublisher {
    Random rand = new Random();

    public void accept(ConfigurationVisitor configurationVisitor){
        configurationVisitor.visitInhabitant(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public void simulateOneTick(){
        publishRandomEvent();
        if (rand.nextInt(4) == 0){
            publishRandomEvent();
        }
    }
}
