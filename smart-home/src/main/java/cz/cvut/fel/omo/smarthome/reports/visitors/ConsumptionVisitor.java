package cz.cvut.fel.omo.smarthome.reports.visitors;

import cz.cvut.fel.omo.smarthome.configuration.Configuration;
import cz.cvut.fel.omo.smarthome.iterators.DeviceIterator;
import cz.cvut.fel.omo.smarthome.iterators.InhabitantIterator;
import cz.cvut.fel.omo.smarthome.models.house.Floor;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumption;
import cz.cvut.fel.omo.smarthome.models.house.devices.consumption.DeviceConsumptionTracker;
import cz.cvut.fel.omo.smarthome.reports.ConsumptionReport;
import cz.cvut.fel.omo.smarthome.reports.HouseConfigurationReport;

public class ConsumptionVisitor {
    StringBuilder reportTextBuilder = new StringBuilder();

    private DeviceConsumption totalConsumption = DeviceConsumption.of(0, 0, 0);

    private DeviceConsumption sinceLastVisitConsumption = DeviceConsumption.of(0, 0, 0);

    public void visitDevice(Device device){
        DeviceConsumptionTracker tracker = device.getConsumptionTracker();
        sinceLastVisitConsumption = DeviceConsumption.of(sinceLastVisitConsumption, tracker.getConsumptionSinceReset());
        totalConsumption = DeviceConsumption.of(totalConsumption, tracker.getTotalConsumption());

        reportTextBuilder.append(device).append("\n");
        reportTextBuilder.append("- Totally consumed:\n").append(totalConsumption);
        reportTextBuilder.append("- Consumed since last consumption report:\n").append(sinceLastVisitConsumption).append("\n");

        tracker.reset();
    }

    public void visitHouse(House house){
        reportTextBuilder.append("------------ Consumption report ------------\n");
        DeviceIterator deviceIterator = house.getDeviceIterator();

        while(deviceIterator.hasNext()){
            deviceIterator.next().accept(this);
        }

        reportTextBuilder.append("\n").append("Total consumption in house:\n").append(totalConsumption).append("\n");
        reportTextBuilder.append("Consumption in house since last measuring:\n").append(sinceLastVisitConsumption);
    }

    public ConsumptionReport getReport(){
        return new ConsumptionReport(reportTextBuilder.toString());
    }
}
