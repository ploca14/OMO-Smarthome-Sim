package cz.cvut.fel.omo.smarthome.iterators;

import cz.cvut.fel.omo.smarthome.models.house.Floor;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.Room;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Inhabitant;

import java.util.ArrayList;

public class InhabitantIterator {
    private House house;

    private Integer floorIndex;

    private Integer roomIndex;

    private Integer inhabitantInRoomIndex;

    private boolean moreInhabitantsLeft;

    private ArrayList<Inhabitant> inhabitantsInRoom;

    public InhabitantIterator(House house) {
        this.house = house;
        floorIndex = 0;
        roomIndex = 0;
        inhabitantInRoomIndex = 0;
        moreInhabitantsLeft = true;
        moveToNextInhabitant();
    }

    public boolean hasNext() {
        return moreInhabitantsLeft;
    }

    /**
     * Returns nextInhabitant attribute and moves the iterator to next inhabitant.
     *
     * @return Inhabitant
     */
    public Inhabitant next() {
        Inhabitant toReturn = inhabitantsInRoom.get(inhabitantInRoomIndex);
        moveToNextInhabitant();
        return toReturn;
    }

    /**
     * Moves the iterator to next Inhabitant
     */
    private void moveToNextInhabitant() {
        if (inhabitantsInRoom != null && inhabitantInRoomIndex < inhabitantsInRoom.size() - 1){
            inhabitantInRoomIndex++;
            return;
        }

        ArrayList<Floor> floors = house.getFloors();


        for (int fi = floorIndex; fi < floors.size(); fi++){
            ArrayList<Room> roomsOnFloor = floors.get(fi).getRooms();
            for (int ri = roomIndex; ri < roomsOnFloor.size(); ri++){
                this.roomIndex = ri;
                this.floorIndex = fi;
                ArrayList<Inhabitant> inhabitants = roomsOnFloor.get(ri).getInhabitants();
                if (inhabitants.size() != 0){
                    saveIteratorState(inhabitants, ri, fi);
                    return;
                }
            }
        }

        this.moreInhabitantsLeft = false;
    }

    private void saveIteratorState(ArrayList<Inhabitant> inhabitants, Integer roomIndex, Integer floorIndex){
        this.inhabitantsInRoom = inhabitants;
        this.inhabitantInRoomIndex = 0;
        roomIndex++;
        this.roomIndex = roomIndex;
        this.floorIndex = floorIndex;
    }
}
