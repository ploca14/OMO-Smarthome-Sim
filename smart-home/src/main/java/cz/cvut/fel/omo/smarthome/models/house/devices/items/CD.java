package cz.cvut.fel.omo.smarthome.models.house.devices.items;

import cz.cvut.fel.omo.smarthome.reports.visitors.ConfigurationVisitor;

public class CD extends Item {
    public void accept(ConfigurationVisitor configurationVisitor){
        configurationVisitor.visitCD(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
