package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.models.house.Room;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;
import cz.cvut.fel.omo.smarthome.util.NameGenerator;

import java.util.ArrayList;
import java.util.Random;


// TODO implement observer
abstract public class Inhabitant implements EventPublisher, Observer {
    private final Random rand = new Random();

    protected String name;

    private Room currentRoom;

    private boolean isOutside = true;

    @Override
    public boolean canMove() {
        return true;
    }

    public void accept(ConfigurationVisitor configurationVisitor){
        configurationVisitor.visitInhabitant(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + name;
    }

    public void simulateOneTick(){
        if (rand.nextInt(4) == 0){
            publishRandomEvent();
        }
    }

    private void goToRoom(Room room){
        if (this.currentRoom != null){
            this.currentRoom.removeInhabitant(this);
        }
        isOutside = false;
        currentRoom = room;
        room.addInhabitant(this);
    }

    @Override // TODO test this might not work properly
    public boolean isInRoomWithSource(Event event) {
        return this.currentRoom.getInhabitants().contains(event.getSource())
                || this.currentRoom.getDevices().contains(event.getSource());
    }

    public void setCurrentRoom(Room currentRoom) {
        this.isOutside = false;
        this.currentRoom = currentRoom;
    }

    public boolean isOutside(){
        return isOutside;
    }
}
