package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.alerts.IsMakingWeirdSounds;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsCrying;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsHungry;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsSad;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.models.house.House;
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
        House.getInstance().attach(this, new IsCrying());
        House.getInstance().attach(this, new IsHungry());
        House.getInstance().attach(this, new IsMakingWeirdSounds());
        House.getInstance().attach(this, new IsSad());
    }
}
