package cz.cvut.fel.omo.smarthome.interfaces.traits;

import cz.cvut.fel.omo.smarthome.models.house.devices.items.Food;
import cz.cvut.fel.omo.smarthome.models.house.devices.state.CookState;

public interface HasCook {

    Food getContents();
    void setContents(Food food);
    CookState getCookState();
    void setCookState(CookState cookState);

    default boolean simulateCooking() {
        if (!getCookState().equals(CookState.Off))
            getCookState().nextState();

        if (getCookState().equals(CookState.Done)) {
            getContents().cook();
            return true;
        }

        return false;
    }

    default boolean startCooking(Food food) {
        if (getCookState().equals(CookState.Off)) {
            setCookState(CookState.Preheating);
            setContents(food);
            return true;
        }
        return false;
    }
}
