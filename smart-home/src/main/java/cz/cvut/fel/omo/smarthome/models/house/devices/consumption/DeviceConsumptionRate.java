package cz.cvut.fel.omo.smarthome.models.house.devices.consumption;

/**
 * Contains information about how much a device conumes in one ticků
 */
public class DeviceConsumptionRate {
    private final Integer gasPerTick;

    private final Integer electricityPerTick;

    private final Integer waterPerTick;

    public DeviceConsumptionRate(Integer gasPerTick, Integer electricityPerTick, Integer waterPerTick) {
        this.gasPerTick = gasPerTick;
        this.electricityPerTick = electricityPerTick;
        this.waterPerTick = waterPerTick;
    }

    public Integer getGasPerTick() {
        return gasPerTick;
    }

    public Integer getElectricityPerTick() {
        return electricityPerTick;
    }

    public Integer getWaterPerTick() {
        return waterPerTick;
    }
}
