package cz.cvut.fel.omo.smarthome.reports.visitors;

import cz.cvut.fel.omo.smarthome.iterators.DeviceIterator;
import cz.cvut.fel.omo.smarthome.iterators.InhabitantIterator;
import cz.cvut.fel.omo.smarthome.models.house.Floor;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;

public class ConsumptionVisitor {
    StringBuilder reportTextBuilder = new StringBuilder();

    private Integer totalElectricity = 0;

    private Integer totalGas = 0;

    private Integer totalWater = 0;

    public void visitDevice(Device device){
        throw new UnsupportedOperationException();
    }

    public void visitHouse(House house){
        reportTextBuilder.append("------------ Consumption report ------------\n");
        DeviceIterator deviceIterator = house.getDeviceIterator();

        while(deviceIterator.hasNext()){
            deviceIterator.next().accept(this);
        }
    }
}
