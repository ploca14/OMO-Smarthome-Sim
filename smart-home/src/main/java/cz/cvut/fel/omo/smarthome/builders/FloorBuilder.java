package cz.cvut.fel.omo.smarthome.builders;

import cz.cvut.fel.omo.smarthome.factories.RoomFactory;
import cz.cvut.fel.omo.smarthome.models.house.Floor;
import cz.cvut.fel.omo.smarthome.models.house.Room;

import java.util.ArrayList;

public class FloorBuilder {
    private ArrayList<Room> rooms = new ArrayList<>();

    private RoomFactory roomFactory = new RoomFactory();

    private Floor floor;

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

    public Floor getResult(){
        if (floor == null) return new Floor(rooms);

        return floor;
    }
}
