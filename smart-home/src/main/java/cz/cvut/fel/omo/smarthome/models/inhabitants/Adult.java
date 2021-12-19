package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.alerts.IsMakingWeirdSounds;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsBroken;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsCrying;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsHungry;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsSad;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.Manual;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.ManualPool;
import cz.cvut.fel.omo.smarthome.models.house.furniture.SportsEquipmentRack;
import cz.cvut.fel.omo.smarthome.models.house.sportsequipment.SportsEquipment;

import java.util.Map;

// TODO move implements observer up to inhabitant
public class Adult extends Person {
    Map.Entry<SportsEquipment, SportsEquipmentRack> borrowedSportsEquipment;

    public Adult() {
        super();
        addRandomlyPublishedEvent(new IsSad());
    }

    private void returnSportsEquipment(){
        SportsEquipment equipment = borrowedSportsEquipment.getKey();
        SportsEquipmentRack rack = borrowedSportsEquipment.getValue();
    }

    public void findManual(Device device){
        Manual manual = ManualPool.getManual(device);
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
        return;
        //throw new UnsupportedOperationException();
    }
}
