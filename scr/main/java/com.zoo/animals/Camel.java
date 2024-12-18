package com.zoo.animals;

import com.zoo.interfaces.Walkable;

public class Camel extends Herbivore implements Walkable {
    @Override
    public void walk() {
        System.out.println("Верблюд идет");
    }
}
