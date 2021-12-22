package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.interfaces.traits.HasBrightness;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Person;

public class Light extends Device implements HasBrightness {
    Integer brightness = 50;

    public Light() {
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 0);
        this.activeConsumptionRate = DeviceConsumptionRate.of(0, 0, 20);
    }

    @Override
    public void subscribeToEvents() {
        // TODO
    }

    public void accept(Person person) {
        person.use(this);
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer getBrightness() {
        return brightness;
    }

    @Override
    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    public void turnOn() {
        super.activate();
    }

    public void turnOff() {
        super.deactivate();
    }
}
