package cz.cvut.fel.omo.smarthome.models.house;

import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.house.furniture.Furniture;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Inhabitant;

import java.util.ArrayList;

public class Room {
    private ArrayList<Device> devices = new ArrayList<>();

    private ArrayList<Window> windows = new ArrayList<>();

    private ArrayList<Furniture> furniture = new ArrayList<>();

    private ArrayList<Inhabitant> inhabitants = new ArrayList<>();

    public void addDevice(Device device){
        devices.add(device);
        device.subscribeToEvents();
    }

    public void addWindow(){
        windows.add(new Window());
    }

    public void addFurniture(Furniture furniture){
        this.furniture.add(furniture);
    }

    public void addInhabitant(Inhabitant inhabitant){
        inhabitants.add(inhabitant);
    }

    public void removeInhabitant(Inhabitant inhabitant){
        inhabitants.remove(inhabitant);
    }
}
