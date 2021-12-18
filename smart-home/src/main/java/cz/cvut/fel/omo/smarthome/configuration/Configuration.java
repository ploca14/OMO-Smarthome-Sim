package cz.cvut.fel.omo.smarthome.configuration;

import java.io.FileInputStream;

public class Configuration {
    private static FileInputStream file = null;

    private static Configuration instance;

    private Integer simulationLength;

    private Integer reportRate; // After how many ticks the reports should be generated

    private Integer Adults;

    private Integer Dogs;

    private Integer Kids;

    private Integer deviceWearRate; // How much durability device loses after a tick

    private HouseType houseType;

    private Integer electricityUnitCost;

    private Integer waterUnitCost;

    private Integer gasUnitCost;

    private Configuration() {
        simulationLength = 20;
        reportRate = 10;
        Adults = 4;
        Kids = 2;
        Dogs = 3;
        deviceWearRate = 100;
        houseType = HouseType.ORDINARY;
        electricityUnitCost = 2;
        waterUnitCost = 1;
        gasUnitCost = 5;
    }

    private Configuration(FileInputStream file){
        throw new UnsupportedOperationException();
    }

    public static Configuration getInstance(){
        if (instance == null){
            instance = file == null ? new Configuration() : new Configuration(file);
        }

        return instance;
    }

    public static void loadFromFile(FileInputStream file){
        Configuration.file = file;
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

    public Integer getDeviceWearRate() {
        return deviceWearRate;
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
