package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.interfaces.traits.HasConsumption;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.Warranty;
import cz.cvut.fel.omo.smarthome.models.house.devices.misc.DeviceConsumption;
import cz.cvut.fel.omo.smarthome.models.house.devices.state.DeviceState;
import cz.cvut.fel.omo.smarthome.models.house.devices.state.IdleState;

abstract public class Device implements Observer, EventPublisher, HasConsumption {
    protected DeviceState state;

    protected DeviceConsumption consumption;

    protected Integer durability;

    private Warranty warranty;

    public Device() {
        this.state = new IdleState();
    }

    @Override
    public DeviceConsumption getConsumption() {
        return consumption;
    }

    public void subscribeToEvents() {
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
}
