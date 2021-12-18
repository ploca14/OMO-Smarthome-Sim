package cz.cvut.fel.omo.smarthome.models.house;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventConsumer;
import cz.cvut.fel.omo.smarthome.interfaces.events.EventPublisher;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observable;
import cz.cvut.fel.omo.smarthome.interfaces.events.Observer;
import cz.cvut.fel.omo.smarthome.interfaces.reports.HasReport;
import cz.cvut.fel.omo.smarthome.iterators.DeviceIterator;
import cz.cvut.fel.omo.smarthome.iterators.InhabitantIterator;
import cz.cvut.fel.omo.smarthome.models.vehicles.Vehicle;
import cz.cvut.fel.omo.smarthome.reports.ActivityAndUsageReport;
import cz.cvut.fel.omo.smarthome.reports.ConsumptionReport;
import cz.cvut.fel.omo.smarthome.reports.EventReport;
import cz.cvut.fel.omo.smarthome.reports.HouseConfigurationReport;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

import java.util.*;

public class House implements EventConsumer, Observable, HasReport {
    private ArrayList<Floor> floors = new ArrayList<>();

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private HashMap<Class<? extends Event>, ArrayList<Observer>> observers = new HashMap<>();

    private Queue<Event> unhandledEvents = new LinkedList<>();

    private Queue<Event> handledEvents = new LinkedList<>();

    private static House instance;

    private House() {
    }

    public static House getInstance() {
        if (instance == null){
            instance = new House();
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
    public void consumeEvent(EventPublisher source, Event event) {
        event.setSource(source);
        unhandledEvents.add(event);
    }

    /**
     * Event handling happens in a following way:
     * 1. Dequeue one by one all unhandled events from the unhandledEvents queue.
     * 2. If there are some observers registered to listen to that event, then choose one of them randomly
     * and let him handle the event.
     * 2.1 If the observer is a device, then ensure that the device is in the same room as the source of the event.
     * 3. Mark the event as handled
     * 4. Enqueue the events again which could not be handled by any observer.
     */
    public void handleEvents(){
        ArrayList<Event> noObserverFound = new ArrayList<>();
        Event currentEvent;
        Random rand = new Random();
        while (!unhandledEvents.isEmpty()){
            currentEvent = unhandledEvents.remove();
            ArrayList<Observer> listOfObservers = observers.get(currentEvent.getClass());
            if (listOfObservers != null && listOfObservers.size() != 0){
                Integer randomObserverIndex = rand.nextInt(listOfObservers.size());
                Observer handlingObserver = listOfObservers.get(randomObserverIndex);
                currentEvent.accept(handlingObserver); // TODO ensure that device is in a same room
                markEventHandled(currentEvent, handlingObserver);
            }
            else{
                noObserverFound.add(currentEvent);
            }
        }
        unhandledEvents.addAll(noObserverFound);
    }

    private void markEventHandled(Event event, Observer handler){
        event.setHandledBy(handler);
        handledEvents.add(event);
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

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public InhabitantIterator getInhabitantIterator(){
        return new InhabitantIterator(this);
    }

    public DeviceIterator getDeviceIterator(){
        return new DeviceIterator(this);
    }

    @Override
    public HouseConfigurationReport getHouseConfigurationReport() {
        ConfigurationVisitor configurationVisitor = new ConfigurationVisitor();
        this.accept(configurationVisitor);
        return configurationVisitor.getReport();
    }

    @Override
    public ActivityAndUsageReport getActivityAndUsageReport() {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public ConsumptionReport getConsumptionReport() {
        ConsumptionVisitor consumptionVisitor = new ConsumptionVisitor();
        this.accept(consumptionVisitor);
        return consumptionVisitor.getReport();
    }

    @Override
    public EventReport getEventReport() {
        throw new UnsupportedOperationException(); // TODO
    }

    public void accept(ConfigurationVisitor configurationVisitor){
        configurationVisitor.visitHouse(this);
    }

    public void accept(ConsumptionVisitor consumptionVisitor){
        consumptionVisitor.visitHouse(this);
    }
}
