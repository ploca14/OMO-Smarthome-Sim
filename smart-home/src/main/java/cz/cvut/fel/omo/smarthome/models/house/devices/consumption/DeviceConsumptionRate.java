package cz.cvut.fel.omo.smarthome.models.house.devices.consumption;

/**
 * Contains information about how much a device conumes in one ticků
 */
public class DeviceConsumptionRate {
    private Integer gasPerTick = 0;

    private Integer electricityPerTick = 0;

    private Integer waterPerTick = 0;

    public Integer getGasPerTick() {
        return gasPerTick;
    }

    public void setGasPerTick(Integer gasPerTick) {
        this.gasPerTick = gasPerTick;
    }

    public Integer getElectricityPerTick() {
        return electricityPerTick;
    }

    public void setElectricityPerTick(Integer electricityPerTick) {
        this.electricityPerTick = electricityPerTick;
    }

    public Integer getWaterPerTick() {
        return waterPerTick;
    }

    public void setWaterPerTick(Integer waterPerTick) {
        this.waterPerTick = waterPerTick;
    }
}
