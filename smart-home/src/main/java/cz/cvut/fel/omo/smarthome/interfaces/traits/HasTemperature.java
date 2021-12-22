package cz.cvut.fel.omo.smarthome.interfaces.traits;

public interface HasTemperature {
    Integer DEFAULT_STEP = 1;

    /**
     * @return A number between 0-40
     */
    Integer getTemperature();

    void setTemperature(Integer temperature);

    default void raiseTemperature() {
        if (getTemperature() + DEFAULT_STEP <= 100) {
            setTemperature(getTemperature() + DEFAULT_STEP);
        }
    }

    default void raiseTemperature(Integer step) {
        if (getTemperature() + step <= 40) {
            setTemperature(getTemperature() + step);
        }
    }

    default void lowerTemperature() {
        if (getTemperature() + DEFAULT_STEP >= 0) {
            setTemperature(getTemperature() + DEFAULT_STEP);
        }
    }

    default void lowerTemperature(Integer step) {
        if (getTemperature() + step >= 0) {
            setTemperature(getTemperature() + step);
        }
    }
}
