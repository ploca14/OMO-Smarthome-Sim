package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.alerts.IsMakingWeirdSounds;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;

public class Fridge extends Device{
    public Fridge() {
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 5);
        this.activeConsumptionRate = DeviceConsumptionRate.of(0, 0, 40);
        addRandomlyPublishedEvent(new IsMakingWeirdSounds());
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

}
