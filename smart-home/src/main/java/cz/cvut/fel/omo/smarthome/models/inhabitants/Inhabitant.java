package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;

abstract public class Inhabitant {
    public void accept(ConfigurationVisitor configurationVisitor){
        configurationVisitor.visitInhabitant(this);
    }
}
