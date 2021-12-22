package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.iterators.RoomIterator;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.Room;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.reports.Action;
import cz.cvut.fel.omo.smarthome.reports.visitors.ActivityAndUsageVisitor;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// TODO implement observer
abstract public class Inhabitant implements EventPublisher, Observer {
    protected final Random rand = new Random();

    protected String name;

    protected Room currentRoom;

    private boolean isOutside = true;

    private List<Action> actionList = new ArrayList<>();

    public List<Action> getActionList() {
        return actionList;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    public void accept(ConfigurationVisitor configurationVisitor){
        configurationVisitor.visitInhabitant(this);
    }


    public void accept(ActivityAndUsageVisitor activityAndUsageVisitor) {
        if (this.actionList.isEmpty()) return;

        activityAndUsageVisitor.visitInhabitant(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + name;
    }

    public void simulateOneTick(){
        if (rand.nextInt(4) == 0) {
            publishRandomEvent();
        }

        if (rand.nextInt(4) == 1) {
            goToRandomRoom();
        }
    }

    private void goToRandomRoom() {
        RoomIterator roomIterator = House.getInstance().getRoomIterator();
        Integer randomIndex = rand.nextInt(roomIterator.size());
        goToRoom(roomIterator.get(randomIndex));
    }

    public void goToRoom(Room room){
        if (this.currentRoom != null){
            this.currentRoom.removeInhabitant(this);
        }
        isOutside = false;
        currentRoom = room;
        room.addInhabitant(this);
    }

    @Override
    public boolean isInRoomWithSource(Event event) {
        return this.currentRoom.getInhabitants().contains(event.getSource())
                || this.currentRoom.getDevices().contains(event.getSource());
    }

    public void setCurrentRoom(Room currentRoom) {
        this.isOutside = false;
        this.currentRoom = currentRoom;
    }

    public void setOutside(){
        this.isOutside = true;
        this.currentRoom = null;
    }

    public boolean isOutside(){
        return isOutside;
    }

    public void logUsage(Device device) {
        actionList.add(new Action(this, device));
    }
}
