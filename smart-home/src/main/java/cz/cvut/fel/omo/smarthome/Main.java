package cz.cvut.fel.omo.smarthome;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.simulation.Simulation;

public class Main {
    public static void main(String[] args) {
        Simulation simulation;
        if (args.length > 0){
            throw new UnsupportedOperationException(); // TODO loading cfg from file
        }

        else{
            simulation = new Simulation(Configuration.getInstance());
        }

        simulation.execute();
    }
}
