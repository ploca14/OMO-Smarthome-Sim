package cz.cvut.fel.omo.smarthome.interfaces.traits;

import cz.cvut.fel.omo.smarthome.models.house.devices.items.Food;
import cz.cvut.fel.omo.smarthome.models.house.devices.state.CookState;

public class Cook {
    private CookState cookState = CookState.Off;
    private Food contents;

    public void simulateCooking() {
        if (cookState.equals(CookState.Off)) return;

        if (cookState.equals(CookState.Done)) {
            contents.cook();
        }

        cookState = cookState.nextState();
    }

    public void startCooking(Food food) {
        if (cookState.equals(CookState.Off)) {
            cookState = CookState.Preheating;
            contents = food;
        }
    }

    public Food getCookedFood() {
        Food tmp = contents;
        contents = null;
        cookState = CookState.Off;
        return tmp;
    }

    public boolean isDone() {
        return contents != null && contents.isCooked();
    }

    public boolean isCooking() {
        return !cookState.equals(CookState.Off);
    }
}
