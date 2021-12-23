package cz.cvut.fel.omo.smarthome.models.house.devices;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsDoneCooking;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsDoneWashing;
import cz.cvut.fel.omo.smarthome.interfaces.traits.HasCook;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionRate;
import cz.cvut.fel.omo.smarthome.models.house.devices.items.Food;
import cz.cvut.fel.omo.smarthome.models.house.devices.state.CookState;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Person;
import cz.cvut.fel.omo.smarthome.reports.visitors.ConsumptionVisitor;

public class Microwave extends Device implements HasCook {
    private CookState cookState = CookState.Off;
    private Food contents;

    public Microwave() {
        this.idleConsumptionRate = DeviceConsumptionRate.of(0,0, 1);
        this.activeConsumptionRate = DeviceConsumptionRate.of(0, 0, 100);
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    public void accept(Person person) {
        person.use(this);
    }

    @Override
    public void simulateOneTick(){
        super.simulateOneTick();
        if (!cookState.equals(CookState.Off)) {
            if (simulateCooking()) {
                publishEvent(new IsDoneCooking());
                deactivate();
            }
        }
    }

    public void turnOn() {
        super.turnOn();
    }

    public void turnOff() {
        super.turnOff();
        cookState = CookState.Off;
    }

    public void cookFood(Food food) {
        if (startCooking(food)) {
            super.activate();
        }
    }

    @Override
    public Food getContents() {
        return contents;
    }

    @Override
    public void setContents(Food food) {
        contents = food;
    }

    @Override
    public CookState getCookState() {
        return cookState;
    }

    @Override
    public void setCookState(CookState cookState) {
        this.cookState = cookState;
    }
}
