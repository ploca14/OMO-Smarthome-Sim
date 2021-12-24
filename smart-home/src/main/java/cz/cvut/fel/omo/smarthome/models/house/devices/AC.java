package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsTooBright;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsTooHot;
import cz.cvut.fel.omo.smarthome.interfaces.traits.HasTemperature;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Person;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public class AC extends Device implements HasTemperature {
    Integer temperature = 21;

    public AC() {
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 8);
        this.activeConsumptionRate = DeviceConsumptionRate.of(20, 0, 70);
    }

    @Override
    public void subscribeToEvents() {
        House.getInstance().attach(this, new IsTooHot());
    }

    public void accept(Person person) {
        person.use(this);
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public void turnOn(){
        super.turnOn();
    }

    public void turnOff(){
        super.turnOff();
    }

    public void start(){
        super.activate();
    }

    public void stop(){
        super.deactivate();
    }

    @Override
    public void notify(IsTooHot event) {
        start();
        lowerTemperature();
    }
}
