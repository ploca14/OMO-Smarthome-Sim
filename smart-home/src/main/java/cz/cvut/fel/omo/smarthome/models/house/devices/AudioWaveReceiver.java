package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public class AudioWaveReceiver extends Device{
    public AudioWaveReceiver() {
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 7);
        this.activeConsumptionRate = DeviceConsumptionRate.of(0, 0, 55);
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }
}
