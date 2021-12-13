package cz.cvut.fel.omo.smarthome.builders;

import cz.cvut.fel.omo.smarthome.factories.RoomFactory;
import cz.cvut.fel.omo.smarthome.models.house.Floor;
import cz.cvut.fel.omo.smarthome.models.house.Room;

import java.util.ArrayList;

public class FloorBuilder {
    private ArrayList<Room> rooms = new ArrayList<>();

    private RoomFactory roomFactory = new RoomFactory();

    public FloorBuilder addKitchen(){
        rooms.add(roomFactory.makeKitchen());
        return this;
    }

    public FloorBuilder addCellar(){
        rooms.add(roomFactory.makeCellar());
        return this;
    }

    public FloorBuilder addLivingRoom(){
        rooms.add(roomFactory.makeLivingRoom());
        return this;
    }

    public FloorBuilder addTVRoom(){
        rooms.add(roomFactory.makeTVRoom());
        return this;
    }

    public Floor getResult(){
        return new Floor(rooms);
    }
}
