package cz.cvut.fel.omo.smarthome.interfaces.traits;

public interface HasBrightness {
    Integer DEFAULT_STEP = 1;

    /**
     * @return A number between 0-100
     */
    Integer getBrightness();

    void setBrightness(Integer brightness);

    default void raiseBrightness() {
        if (getBrightness() + DEFAULT_STEP <= 100) {
            setBrightness(getBrightness() + DEFAULT_STEP);
        }
    }

    default void raiseBrightness(Integer step) {
        if (getBrightness() + step <= 100) {
            setBrightness(getBrightness() + step);
        }
    }

    default void lowerBrightness() {
        if (getBrightness() + DEFAULT_STEP >= 0) {
            setBrightness(getBrightness() + DEFAULT_STEP);
        }
    }

    default void lowerBrightness(Integer step) {
        if (getBrightness() + step >= 0) {
            setBrightness(getBrightness() + step);
        }
    }
}
