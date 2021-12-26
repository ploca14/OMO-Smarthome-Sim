package cz.cvut.fel.omo.smarthome.interfaces.traits;

import cz.cvut.fel.omo.smarthome.models.house.devices.items.Food;

public interface HasCook {
    Cook cook = new Cook();

    void cookFood(Food food);

    default boolean isCooking() {
        return cook.isCooking();
    }

    default Food getCookedFood() {
        return cook.getCookedFood();
    }

}
