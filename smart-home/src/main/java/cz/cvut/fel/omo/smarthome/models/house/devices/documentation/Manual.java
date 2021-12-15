package cz.cvut.fel.omo.smarthome.models.house.devices.documentation;

import cz.cvut.fel.omo.smarthome.models.house.devices.Device;

public class Manual {
    private Device deviceType;

    public Manual(Device deviceType) {
        this.deviceType = deviceType;
    }

    public Device getDeviceType() {
        return deviceType;
    }
}
