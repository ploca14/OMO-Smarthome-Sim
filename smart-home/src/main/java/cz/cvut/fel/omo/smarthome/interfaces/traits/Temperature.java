package cz.cvut.fel.omo.smarthome.interfaces.traits;

public class Temperature {
    Integer DEFAULT_STEP = 1;
    Integer temperature = 50;

    public void raiseTemperature() {
        if (temperature + DEFAULT_STEP <= 100) {
            raiseTemperature(DEFAULT_STEP);
        }
    }

    public void raiseTemperature(Integer step) {
        if (temperature + step <= 100) {
            temperature += step;
        }
    }

    public void lowerTemperature() {
        if (temperature + DEFAULT_STEP >= 0) {
            lowerTemperature(DEFAULT_STEP);
        }
    }

    public void lowerTemperature(Integer step) {
        if (temperature + step >= 0) {
            temperature -= step;
        }
    }
}
