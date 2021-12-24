package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsBroken;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.interfaces.traits.HasConsumption;
import cz.cvut.fel.omo.smarthome.models.house.Room;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionTracker;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.Manual;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.Warranty;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.models.house.devices.state.DeviceState;
import cz.cvut.fel.omo.smarthome.models.house.devices.state.IdleState;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Person;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

import java.util.Random;

abstract public class Device implements Observer, EventPublisher, HasConsumption {
    private Random rand = new Random();

    private Integer durability = (50 + rand.nextInt(100));

    protected DeviceState state = new IdleState();

    protected final DeviceConsumptionTracker consumptionTracker = new DeviceConsumptionTracker(this);

    protected DeviceConsumptionRate idleConsumptionRate;

    protected DeviceConsumptionRate activeConsumptionRate;

    private Warranty warranty;

    private Room room;

    @Override
    public DeviceConsumptionTracker getConsumptionTracker() {
        return consumptionTracker;
    }

    public void subscribeToEvents() {}

    public void repair(Manual manual, Warranty warranty){
        if (manual.getDeviceType().equals(this.getClass()) && warranty.getDevice().equals(this)){
            durability = (50 + rand.nextInt(100));
        }
    }

    protected void turnOn(){
        state.turnOn(this);
    };

    protected void turnOff(){
        state.turnOff(this);
    };

    protected void activate(){
        state.activate(this);
    };

    protected void deactivate(){
        state.deactivate(this);
    };

    public void setState(DeviceState state){
        this.state = state;
    }

    public boolean isBroken(){
        return durability <= 0;
    }

    public Warranty getWarranty() {
        if (warranty == null) {
            warranty = Warranty.downloadWarranty(this);
        }

        return warranty;
    }

    public DeviceState getState() {
        return state;
    }

    public void accept(ConfigurationVisitor configurationVisitor){
        configurationVisitor.visitDevice(this);
    }

    @Override
    public void accept(ConsumptionVisitor consumptionVisitor) {
        consumptionVisitor.visitDevice(this);
    }

    abstract public void accept(Person person);

    public void simulateOneTick(){
        consumptionTracker.incrementPerTick();
        simulateDeviceWear();
    }

    protected void simulateDeviceWear(){
        if (!isBroken()){
            durability -= Configuration.getInstance().getDeviceWearRate();
            if (isBroken()) {
                publishEvent(new IsBroken());
                turnOff();
            }
        }
    }

    public DeviceConsumptionRate getIdleConsumptionRate() {
        return idleConsumptionRate;
    }

    public DeviceConsumptionRate getActiveConsumptionRate() {
        return activeConsumptionRate;
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public Room getCurrentRoom() {
        return room;
    }
}
