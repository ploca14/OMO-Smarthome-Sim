package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsSad;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.Manual;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.ManualPool;

public class Adult extends Person implements Observer {
    public Adult() {
        addRandomlyPublishedEvent(new IsSad());
    }

    public void findManual(Device device){
        Manual manual = ManualPool.getManual(device);
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void subscribeToEvents() {
        throw new UnsupportedOperationException();
    }
}
