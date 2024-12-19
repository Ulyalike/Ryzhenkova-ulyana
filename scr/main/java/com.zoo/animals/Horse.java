package com.zoo.animals;

import com.zoo.interfaces.Walkable;

public class Horse extends Herbivore implements Walkable {
    @Override
    public void walk() {
        System.out.println("Лошадь идет.");
    }
}
