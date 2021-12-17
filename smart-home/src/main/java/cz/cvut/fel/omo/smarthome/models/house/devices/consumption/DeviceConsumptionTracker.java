package cz.cvut.fel.omo.smarthome.models.house.devices.consumption;

import cz.cvut.fel.omo.smarthome.models.house.devices.Device;

/**
 * Tracks the consumption of a device.
 */
public class DeviceConsumptionTracker {
    private DeviceConsumption totalConsumption;

    private DeviceConsumption consumptionSinceReset;

    private final Device device;

    public DeviceConsumptionTracker(Device device) {
        this.device = device;
    }

    public void incrementPerTick(){
        DeviceConsumptionRate consumptionRate = device.getConsumptionRate();
        totalConsumption = new DeviceConsumption(
                totalConsumption.getWater() + consumptionRate.getWaterPerTick(),
                totalConsumption.getGas() + consumptionRate.getGasPerTick(),
                totalConsumption.getElectricity() + consumptionRate.getElectricityPerTick());

        consumptionSinceReset = new DeviceConsumption(
                consumptionSinceReset.getWater() + consumptionRate.getWaterPerTick(),
                consumptionSinceReset.getGas() + consumptionRate.getGasPerTick(),
                consumptionSinceReset.getElectricity() + consumptionRate.getElectricityPerTick());
    }


    public void reset(){
        this.consumptionSinceReset = new DeviceConsumption(0, 0, 0);
    }

    public DeviceConsumption getTotalConsumption() {
        return totalConsumption;
    }

    public DeviceConsumption getConsumptionSinceReset() {
        return consumptionSinceReset;
    }
}
