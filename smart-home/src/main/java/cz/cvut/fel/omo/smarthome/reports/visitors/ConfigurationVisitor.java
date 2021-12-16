package cz.cvut.fel.omo.smarthome.reports.visitors;

import cz.cvut.fel.omo.smarthome.iterators.InhabitantIterator;
import cz.cvut.fel.omo.smarthome.models.house.Floor;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.Room;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.house.furniture.Furniture;
import cz.cvut.fel.omo.smarthome.models.house.sportsequipment.SportsEquipment;
import cz.cvut.fel.omo.smarthome.models.inhabitants.Inhabitant;
import cz.cvut.fel.omo.smarthome.reports.HouseConfigurationReport;

public class ConfigurationVisitor {
    StringBuilder reportTextBuilder = new StringBuilder();

    public void visitDevice(Device device){
        reportTextBuilder.append("---- Device: ").append(device.toString()).append("\n");
    }

    public void visitHouse(House house){
        reportTextBuilder.append("These inhabitants are currently present: \n");
        InhabitantIterator inhabitantIterator = house.getInhabitantIterator();
        while (inhabitantIterator.hasNext()){
            reportTextBuilder.append(inhabitantIterator.next().toString()).append("\n");
        }

        reportTextBuilder.append("#######################################\n");
        reportTextBuilder.append("- House\n");
        for (Floor floor : house.getFloors()){
            floor.accept(this);
        }
    }

    public void visitFloor(Floor floor){
        reportTextBuilder.append("-- Floor\n");
        for (Room room : floor.getRooms()){
            room.accept(this);
        }
    }

    public void visitRoom(Room room){
        reportTextBuilder.append("--- Room\n");
        for (Inhabitant inhabitant : room.getInhabitants()){
            inhabitant.accept(this);
        }

        for (Device device : room.getDevices()){
            device.accept(this);
        }

        for (Furniture furniture : room.getFurniture()){
            furniture.accept(this);
        }
    }

    public void visitInhabitant(Inhabitant inhabitant){
        reportTextBuilder.append("---- Inhabitant: ").append(inhabitant.toString()).append(("\n"));
    }

    public void visitFurniture(Furniture furniture){
        reportTextBuilder.append("---- Furniture:").append(furniture.toString()).append("\n");
    }

    public void visitSportsEquipment(SportsEquipment sportsEquipment){
        reportTextBuilder.append("----- Sportsequipment: ").append(sportsEquipment.toString()).append(("\n"));
    }

    public HouseConfigurationReport getReport(){
        return new HouseConfigurationReport(reportTextBuilder.toString());
    }
}
