package cz.cvut.fel.omo.smarthome.models;

import cz.cvut.fel.omo.smarthome.models.inhabitants.Inhabitant;

import java.util.ArrayList;

public class OutsideWorld {
    private ArrayList<Inhabitant> inhabitants;

    public void addInhabitant(Inhabitant inhabitant){
        inhabitant.goOutside();
        inhabitants.add(inhabitant);
    }
}
