package cz.cvut.fel.omo.smarthome;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.reports.Report;
import cz.cvut.fel.omo.smarthome.simulation.Simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Simulation simulation;
        if (args.length > 0){
            if (!loadConfigurationFromFile(args[0])) return;
        }

        simulation = new Simulation(Configuration.getInstance());

        simulation.execute();

        saveReportsToFile(simulation.getReports());
    }

    private static boolean loadConfigurationFromFile(String fileName){
        try{
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName);
            Configuration.loadFromFile(new InputStreamReader(inputStream));
            return true;
        }
        catch (Exception e){
            System.out.println("Failed to load configuration from file.");
            e.printStackTrace();
            return false;
        }
    }

    private static void saveReportsToFile(HashMap<Integer, ArrayList<Report>> reports){
        try {
            FileWriter myWriter = new FileWriter("reports.txt");
            for (Integer tick : reports.keySet()){
               ArrayList<Report> reportsAfterTick = reports.get(tick);
               myWriter.write("Reports after " + tick + " ticks.\n");
               for (Report report : reportsAfterTick){
                   myWriter.write(report.toString());
                   myWriter.write("\n");
               }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
