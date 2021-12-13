package cz.cvut.fel.omo.smarthome.models.house;

import cz.cvut.fel.omo.smarthome.events.Event;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventConsumer;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observable;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.interfaces.reports.HasReport;
import cz.cvut.fel.omo.smarthome.models.vehicles.Vehicle;
import cz.cvut.fel.omo.smarthome.reports.ActivityAndUsageReport;
import cz.cvut.fel.omo.smarthome.reports.ConsumptionReport;
import cz.cvut.fel.omo.smarthome.reports.EventReport;
import cz.cvut.fel.omo.smarthome.reports.HouseConfigurationReport;

import java.util.ArrayList;
import java.util.HashMap;

public class House implements EventConsumer, Observable, HasReport {
    private ArrayList<Floor> floors = new ArrayList<>();

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private HashMap<Class, ArrayList<Observer>> observers = new HashMap<>();

    private ArrayList<Event> unhandledEvents = new ArrayList<>();

    private static House instance;

    private House() {
    }

    public static House getInstance() {
        if (instance == null){
            return new House();
        }

        return instance;
    }

    @Override
    public void attach(Observer observer, Event event) {
        ArrayList<Observer> listOfObservers = observers.get(event.getClass());
        if (listOfObservers == null){
            listOfObservers = new ArrayList<>();
            listOfObservers.add(observer);
            observers.put(event.getClass(), listOfObservers);
        }

        else{
            listOfObservers.add(observer);
        }
    }

    @Override
    public void consumeEvent(Event event) {
        unhandledEvents.add(event);
    }

    public void handleEvents(){
        for (Event event : unhandledEvents){
            ArrayList<Observer> listOfObservers = observers.get(event.getClass());
            for (Observer observer : listOfObservers){
                event.accept(observer);
            }
        }
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public void detach(Observer observer, Event event) {
        observers.get(event.getClass()).remove(observer);
    }

    /**
     * Detaches observer from all events it is subscribed to.
     * @param observerToRemove
     */
    @Override
    public void detach(Observer observerToRemove) {
        for (ArrayList<Observer> registeredObservers : observers.values()){
            if (registeredObservers.contains(observerToRemove)) registeredObservers.remove(observerToRemove);
        }
    }

    @Override
    public HouseConfigurationReport getHouseConfigurationReport() {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public ActivityAndUsageReport getActivityAndUsageReport() {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public ConsumptionReport getConsumptionReport() {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public EventReport getEventReport() {
        throw new UnsupportedOperationException(); // TODO
    }
}
