package cz.cvut.fel.omo.smarthome.builders;

import cz.cvut.fel.omo.smarthome.models.house.Room;
import cz.cvut.fel.omo.smarthome.models.house.Window;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.house.devices.WindowBlind;
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
        room.addWindow(new Window());
        return this;
    }

    public RoomBuilder addWindow(boolean withBlind){
        Window window = new Window();

        if (withBlind){
            Device windowBlind = new WindowBlind(window);
            room.addDevice(windowBlind);
        }

        room.addWindow(window);
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
