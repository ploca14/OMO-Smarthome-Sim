package cz.cvut.fel.omo.smarthome.simulation;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;

public class Simulation {
    private Integer currentSimulationTick = 1;

    public Integer getTimeElapsed() {
        return currentSimulationTick;
    }

    public Simulation(Configuration configuration) {

    }

    public void execute(){

    }
}
