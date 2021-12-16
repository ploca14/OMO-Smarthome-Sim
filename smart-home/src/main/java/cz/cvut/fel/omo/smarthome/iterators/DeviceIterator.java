package cz.cvut.fel.omo.smarthome.iterators;

import cz.cvut.fel.omo.smarthome.models.house.Floor;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.Room;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Inhabitant;

import java.util.ArrayList;

public class DeviceIterator {
    private House house;

    private Integer floorIndex;

    private Integer roomIndex;

    private Integer devicesInRoomIndex;

    private boolean moreDevicesLeft;

    private ArrayList<Device> devicesInRoom;

    public DeviceIterator(House house) {
        this.house = house;
        floorIndex = 0;
        roomIndex = 0;
        devicesInRoomIndex = 0;
        moreDevicesLeft = true;
        moveToNextDevice();
    }

    public boolean hasNext() {
        return moreDevicesLeft;
    }

    /**
     * Returns nextInhabitant attribute and moves the iterator to next inhabitant.
     *
     * @return Inhabitant
     */
    public Device next() {
        Device toReturn = devicesInRoom.get(devicesInRoomIndex);
        moveToNextDevice();
        return toReturn;
    }

    /**
     * Moves the iterator to next Inhabitant
     */
    private void moveToNextDevice() {
        if (devicesInRoom != null && devicesInRoomIndex < devicesInRoom.size() - 1){
            devicesInRoomIndex++;
            return;
        }

        ArrayList<Floor> floors = house.getFloors();


        for (int fi = floorIndex; fi < floors.size(); fi++){
            ArrayList<Room> roomsOnFloor = floors.get(fi).getRooms();
            for (int ri = roomIndex; ri < roomsOnFloor.size(); ri++){
                ArrayList<Device> devices = roomsOnFloor.get(ri).getDevices();
                if (devices.size() != 0){
                    saveIteratorState(devices, ri, fi);
                    return;
                }
            }
        }

        this.moreDevicesLeft = false;
    }

    private void saveIteratorState(ArrayList<Device> devices, Integer roomIndex, Integer floorIndex){
        this.devicesInRoom = devices;
        this.devicesInRoomIndex = 0;
        roomIndex++;
        this.roomIndex = roomIndex;
        this.floorIndex = floorIndex;
    }
}
