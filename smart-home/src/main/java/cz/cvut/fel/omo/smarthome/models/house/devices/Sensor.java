package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsTooBright;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsTooDark;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsTooHot;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsTooHumid;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsSad;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Person;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;
import java.util.Random;

public abstract class Sensor extends Device {
    Random rand = new Random();

    public Sensor() {
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 1);
        this.activeConsumptionRate = DeviceConsumptionRate.of(0, 0, 2);
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    public void accept(Person person) {
        person.use(this);
    }

    @Override
    public void simulateOneTick(){
        super.simulateOneTick();
        simulateChange();
    }

    private void simulateChange() {
        double probability = this.rand.nextDouble();

        if (probability <= 0.05) { // 5% chance
            publishRandomEvent();
        }
    }
}
