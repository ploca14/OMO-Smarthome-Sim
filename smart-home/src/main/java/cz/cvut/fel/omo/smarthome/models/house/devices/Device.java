package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.interfaces.traits.HasConsumption;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionTracker;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.Warranty;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.models.house.devices.state.DeviceState;
import cz.cvut.fel.omo.smarthome.models.house.devices.state.IdleState;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;

abstract public class Device implements Observer, EventPublisher, HasConsumption {
    protected DeviceState state = new IdleState();

    protected DeviceConsumptionTracker consumptionTracker = new DeviceConsumptionTracker(this);

    protected DeviceConsumptionRate consumption;

    protected Integer durability;

    private Warranty warranty;

    @Override
    public DeviceConsumptionRate getConsumptionRate() {
        return consumption;
    }

    @Override
    public DeviceConsumptionTracker getConsumptionTracker() {
        return consumptionTracker;
    }

    public void subscribeToEvents() {
        throw new UnsupportedOperationException();
        // TODO
    }

    public void turnOn(){
        state.turnOn(this);
    };

    public void turnOff(){
        state.turnOff(this);
    };

    public void activate(){
        state.activate(this);
    };

    public void deactivate(){
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
            warranty = new Warranty();
        }

        return warranty;
    }

    public void accept(ConfigurationVisitor configurationVisitor){
        configurationVisitor.visitDevice(this);
    }

    //public abstract void simulateOneTick();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
