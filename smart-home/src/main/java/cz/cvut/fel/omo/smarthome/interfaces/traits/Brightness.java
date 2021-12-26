package cz.cvut.fel.omo.smarthome.interfaces.traits;

public class Brightness {
    Integer DEFAULT_STEP = 1;
    Integer brightness = 50;

    public void raiseBrightness() {
        if (brightness + DEFAULT_STEP <= 100) {
            raiseBrightness(DEFAULT_STEP);
        }
    }

    public void raiseBrightness(Integer step) {
        if (brightness + step <= 100) {
            brightness += step;
        }
    }

    public void lowerBrightness() {
        if (brightness + DEFAULT_STEP >= 0) {
            lowerBrightness(DEFAULT_STEP);
        }
    }

    public void lowerBrightness(Integer step) {
        if (brightness + step >= 0) {
            brightness -= step;
        }
    }
}
