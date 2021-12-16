package cz.cvut.fel.omo.smarthome.builders;

import cz.cvut.fel.omo.smarthome.models.house.Room;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.house.furniture.Furniture;

public class RoomBuilder {
    private Room room;

    public RoomBuilder() {
        room = new Room();
    }

    public RoomBuilder addDevice(Device device){
        room.addDevice(device);
        return this;
    }

    public RoomBuilder addFurniture(Furniture furniture){
        room.addFurniture(furniture);
        return this;
    }

    public RoomBuilder addWindow(){
        room.addWindow();
        return this;
    }

    public Room getResult(){
        Room result = this.room;
        reset();
        return result;
    }

    private void reset(){
        room = new Room();
    }
}
