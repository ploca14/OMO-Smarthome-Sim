package cz.cvut.fel.omo.smarthome.models.house.devices.consumption;

/**
 * Contains information about the consumption of a device in an arbitrary long time interval.
 */
public class DeviceConsumption {
    private final Integer water;

    private final Integer gas;

    private final Integer electricity;

    public DeviceConsumption(Integer water, Integer gas, Integer electricity) {
        this.water = water;
        this.gas = gas;
        this.electricity = electricity;
    }

    public Integer getWater() {
        return water;
    }

    public Integer getGas() {
        return gas;
    }

    public Integer getElectricity() {
        return electricity;
    }
}
