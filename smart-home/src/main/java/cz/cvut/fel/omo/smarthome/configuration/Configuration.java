package cz.cvut.fel.omo.smarthome.configuration;

import cz.cvut.fel.omo.smarthome.models.house.House;

import java.io.FileInputStream;

public class Configuration {
    private Integer simulationLength;

    private Integer reportRate; // After how many ticks are the reports should be generated

    private HouseType housetType;



    public Configuration() {

    }

    public Configuration(FileInputStream file){

    }
}
