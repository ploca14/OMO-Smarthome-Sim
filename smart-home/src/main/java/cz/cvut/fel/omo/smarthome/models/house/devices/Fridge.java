package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.alerts.IsMakingWeirdSounds;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.models.house.devices.items.Food;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Person;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Fridge extends Device {
    Integer capacity = 50;
    Stack<Food> contents = new Stack<>();

    public Fridge() {
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 5);
        this.activeConsumptionRate = DeviceConsumptionRate.of(0, 0, 40);
        addRandomlyPublishedEvent(new IsMakingWeirdSounds());
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    public void accept(Person person) {
        person.use(this);
    }

    public void storeFood(Food food) {
        if (contents.size() < capacity) {
            contents.push(food);
        }
    }

    public Food takeFood() {
        return contents.pop();
    }
}
