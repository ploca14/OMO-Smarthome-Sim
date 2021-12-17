package cz.cvut.fel.omo.smarthome.models.house.devices.consumption;

/**
 * Contains information about the consumption of a device in an arbitrary long time interval.
 */
public class DeviceConsumption {
    private final Integer water;

    private final Integer gas;

    private final Integer electricity;

    private DeviceConsumption(Integer water, Integer gas, Integer electricity) {
        this.water = water;
        this.gas = gas;
        this.electricity = electricity;
    }

    public static DeviceConsumption of(Integer water, Integer gas, Integer electricity){
        return new DeviceConsumption(water, gas, electricity);
    }

    public static DeviceConsumption of(DeviceConsumption consumption, DeviceConsumptionRate rate){
        return new DeviceConsumption(
                consumption.getWater() + rate.getWaterPerTick(),
                consumption.getGas() + rate.getGasPerTick(),
                consumption.getElectricity() + rate.getElectricityPerTick());
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
