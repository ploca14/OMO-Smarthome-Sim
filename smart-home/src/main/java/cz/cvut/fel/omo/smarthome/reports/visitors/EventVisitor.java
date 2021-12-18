package cz.cvut.fel.omo.smarthome.reports.visitors;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Alert;
import cz.cvut.fel.omo.smarthome.events.abstractevents.ImportantEvent;
import cz.cvut.fel.omo.smarthome.iterators.DeviceIterator;
import cz.cvut.fel.omo.smarthome.models.house.House;

public class EventVisitor {
    public void visitHouse(House house){
        throw new UnsupportedOperationException();
    }

    public void visitAlert(Alert alert){
        throw new UnsupportedOperationException();
    }

    public void visitImportantEvent(ImportantEvent importantEvent){
        throw new UnsupportedOperationException();
    }
}
