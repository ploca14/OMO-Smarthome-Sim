package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.events.abstractevents.Event;
import cz.cvut.fel.omo.smarthome.events.deviceevents.alerts.IsMakingWeirdSounds;
import cz.cvut.fel.omo.smarthome.events.deviceevents.importantevents.IsBroken;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsCrying;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsHungry;
import cz.cvut.fel.omo.smarthome.events.inhabitantevents.importantevents.IsSad;
import cz.cvut.fel.omo.smarthome.models.house.House;
import cz.cvut.fel.omo.smarthome.models.house.devices.AC;
import cz.cvut.fel.omo.smarthome.models.house.devices.AudioVideoReceiver;
import cz.cvut.fel.omo.smarthome.models.house.devices.Dehumidifier;
import cz.cvut.fel.omo.smarthome.models.house.devices.Device;
import cz.cvut.fel.omo.smarthome.models.house.devices.Dishwasher;
import cz.cvut.fel.omo.smarthome.models.house.devices.Fridge;
import cz.cvut.fel.omo.smarthome.models.house.devices.Light;
import cz.cvut.fel.omo.smarthome.models.house.devices.Microwave;
import cz.cvut.fel.omo.smarthome.models.house.devices.Oven;
import cz.cvut.fel.omo.smarthome.models.house.devices.Sensor;
import cz.cvut.fel.omo.smarthome.models.house.devices.TV;
import cz.cvut.fel.omo.smarthome.models.house.devices.WindowBlind;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.Manual;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.ManualPool;
import cz.cvut.fel.omo.smarthome.models.house.devices.documentation.Warranty;
import cz.cvut.fel.omo.smarthome.models.house.devices.items.CD;

// TODO move implements observer up to inhabitant
public class Adult extends Person {
    public Adult() {
        super();
        addRandomlyPublishedEvent(new IsSad());
    }

    @Override
    public void use(AC ac) {
        int choice = rand.nextInt(6);
        switch (choice) {
            case 0 -> ac.turnOn();
            case 1 -> ac.turnOff();
            case 2 -> ac.lowerTemperature();
            case 3 -> ac.raiseTemperature();
            case 4 -> ac.start();
            case 5 -> ac.stop();
        }

        logUsage(ac);
    }

    @Override
    public void use(AudioVideoReceiver audioVideoReceiver) {
        int choice = rand.nextInt(5);
        switch (choice) {
            case 0 -> audioVideoReceiver.turnOff();
            case 1 -> audioVideoReceiver.turnOn();
            case 2 -> {
                if (audioVideoReceiver.hasCD()) {
                    audioVideoReceiver.removeCD();
                }
                audioVideoReceiver.insertCD(new CD());
            }
            case 3 -> audioVideoReceiver.play();
            case 4 -> audioVideoReceiver.stop();
        }

        logUsage(audioVideoReceiver);
    }

    @Override
    public void use(Dehumidifier dehumidifier) {
        int choice = rand.nextInt(4);
        switch (choice) {
            case 0 -> dehumidifier.turnOn();
            case 1 -> dehumidifier.turnOff();
            case 2 -> dehumidifier.start();
            case 3 -> dehumidifier.stop();
        }

        logUsage(dehumidifier);
    }

    @Override
    public void use(Dishwasher dishwasher) {
        int choice = rand.nextInt(2);
        switch (choice) {
            case 0 -> dishwasher.start();
            case 1 -> dishwasher.stop();
        }

        logUsage(dishwasher);
    }

    @Override
    public void use(Fridge fridge) {
        logUsage(fridge);
    }

    @Override
    public void use(Light light) {
        int choice = rand.nextInt(4);
        switch (choice) {
            case 0 -> light.turnOff();
            case 1 -> light.turnOn();
            case 2 -> light.lowerBrightness();
            case 3 -> light.raiseBrightness();
        }

        logUsage(light);
    }

    @Override
    public void use(Microwave microwave) {
        logUsage(microwave);
    }

    @Override
    public void use(Oven oven) {
        logUsage(oven);
    }

    @Override
    public void use(TV tv) {
        int choice = rand.nextInt(4);
        switch (choice) {
            case 0 -> tv.turnOn();
            case 1 -> tv.turnOff();
        }

        logUsage(tv);
    }

    @Override
    public void use(WindowBlind windowBlind) {
        int choice = rand.nextInt(4);
        switch (choice) {
            case 0 -> windowBlind.open();
            case 1 -> windowBlind.close();
        }

        logUsage(windowBlind);
    }

    @Override
    public void use(Sensor sensor) {
        logUsage(sensor);
    }

    private Manual findManual(Device device){
        return ManualPool.getManual(device);
    }

    @Override
    public void subscribeToEvents() {
        House house = House.getInstance();
        house.attach(this, new IsCrying());
        house.attach(this, new IsHungry());
        house.attach(this, new IsMakingWeirdSounds());
        house.attach(this, new IsSad());
        house.attach(this, new IsBroken());
    }

    @Override
    public void notify(Event event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notify(IsBroken event) {
        Device brokenDevice = (Device) event.getSource();
        Manual manual = findManual(brokenDevice);
        Warranty warranty = brokenDevice.getWarranty();
        brokenDevice.repair(manual, warranty);
    }
}
