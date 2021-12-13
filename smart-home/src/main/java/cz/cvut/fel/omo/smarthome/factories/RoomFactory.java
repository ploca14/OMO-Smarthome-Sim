package cz.cvut.fel.omo.smarthome.factories;

import cz.cvut.fel.omo.smarthome.builders.RoomBuilder;
import cz.cvut.fel.omo.smarthome.models.house.Room;
import cz.cvut.fel.omo.smarthome.models.house.devices.*;
import cz.cvut.fel.omo.smarthome.models.house.furniture.SportsEquipmentRack;
import cz.cvut.fel.omo.smarthome.models.house.sportsequipment.Bike;
import cz.cvut.fel.omo.smarthome.models.house.sportsequipment.Skis;

// TODO nejak jeste udelat windowblinds
public class RoomFactory {
    public Room makeKitchen(){
        RoomBuilder roomBuilder = new RoomBuilder();
        roomBuilder.
                addDevice(new Fridge()).
                addDevice(new Dishwasher()).
                addDevice(new Light()).
                addDevice(new Light()).
                addDevice(new Oven()).
                addDevice(new Microwave()).
                addDevice(new AC()).
                addDevice(new Sensor()).
                addWindow().
                addWindow();

        return roomBuilder.getResult();
    }

    public Room makeLivingRoom(){
        RoomBuilder roomBuilder = new RoomBuilder();
        roomBuilder.
                addDevice(new TV()).
                addDevice(new Light()).
                addDevice(new Light()).
                addDevice(new Light()).
                addDevice(new Light()).
                addDevice(new AC()).
                addDevice(new AudioWaveReceiver()).
                addDevice(new Dehumidifier()).
                addDevice(new Sensor()).
                addWindow();

        return roomBuilder.getResult();
    }

    public Room makeCellar(){
        RoomBuilder roomBuilder = new RoomBuilder();
        SportsEquipmentRack rack = new SportsEquipmentRack();
        rack.addSportsEquipment(new Bike());
        rack.addSportsEquipment(new Skis());

        roomBuilder.addFurniture(rack);
        return roomBuilder.getResult();
    }

    public Room makeTVRoom(){
        RoomBuilder roomBuilder = new RoomBuilder();
        roomBuilder.
                addDevice(new TV()).
                addDevice(new TV()).
                addDevice(new TV()).
                addDevice(new TV()).
                addDevice(new Fridge()).
                addWindow().
                addWindow().
                addWindow().
                addWindow();

        return roomBuilder.getResult();
    }
}
