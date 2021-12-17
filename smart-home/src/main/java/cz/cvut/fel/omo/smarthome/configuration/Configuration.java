package cz.cvut.fel.omo.smarthome.configuration;

import cz.cvut.fel.omo.smarthome.models.house.House;

import java.io.FileInputStream;

public class Configuration {
    private Integer simulationLength;

    private Integer reportRate; // After how many ticks the reports should be generated

    private Integer Adults;

    private Integer Dogs;

    private Integer Kids;

    private Integer deviceWear; // How much durability device loses after a tick

    private HouseType houseType;

    private Integer electricityUnitCost;

    private Integer waterUnitCost;

    private Integer gasUnitCost;

    public Configuration() {
        simulationLength = 20;
        reportRate = 10;
        Adults = 4;
        Kids = 2;
        Dogs = 3;
        deviceWear = 10;
        houseType = HouseType.ORDINARY;
        electricityUnitCost = 2;
        waterUnitCost = 1;
        gasUnitCost = 5;
    }

    public Configuration(FileInputStream file){

    }

    public Integer getSimulationLength() {
        return simulationLength;
    }

    public Integer getReportRate() {
        return reportRate;
    }

    public Integer getAdults() {
        return Adults;
    }

    public Integer getDogs() {
        return Dogs;
    }

    public Integer getKids() {
        return Kids;
    }

    public Integer getDeviceWear() {
        return deviceWear;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public Integer getElectricityUnitCost() {
        return electricityUnitCost;
    }

    public Integer getWaterUnitCost() {
        return waterUnitCost;
    }

    public Integer getGasUnitCost() {
        return gasUnitCost;
    }
}
