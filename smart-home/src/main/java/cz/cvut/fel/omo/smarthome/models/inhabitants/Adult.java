package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.alerts.IsMakingWeirdSounds;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsBroken;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsCrying;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsHungry;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsSad;
import cz.cvut.fel.omo.smarthome.iterators.SmartHomeIterator;
import cz.cvut.fel.omo.smarthome.models.OutsideWorld;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.Manual;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.ManualPool;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.Warranty;
import cz.cvut.fel.omo.smarthome.models.house.furniture.SportsEquipmentRack;
import cz.cvut.fel.omo.smarthome.models.house.sportsequipment.SportsEquipment;

import java.util.AbstractMap;
import java.util.Map;

// TODO move implements observer up to inhabitant
public class Adult extends Person {
    public Adult() {
        super();
        addRandomlyPublishedEvent(new IsSad());
    }

    private Manual findManual(Device device){
        return ManualPool.getManual(device);
    }

    @Override
    public void subscribeToEvents() {
        House house = House.getInstance();
        house.attach(this, new IsCrying());
        house.attach(this, new IsHungry());
        house.attach(this, new IsMakingWeirdSounds());
        house.attach(this, new IsSad());
        house.attach(this, new IsBroken());
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notify(IsBroken event) {
        Device brokenDevice = (Device) event.getSource();
        Manual manual = findManual(brokenDevice);
        Warranty warranty = brokenDevice.getWarranty();
        brokenDevice.repair(manual, warranty);
    }
}
