package cz.cvut.fel.omo.smarthome.models.inhabitants;

import cz.cvut.fel.omo.smarthome.util.NameGenerator;

public abstract class Person extends Inhabitant{
    public Person() {
        super();
        name = NameGenerator.getPersonName();
    }
}
