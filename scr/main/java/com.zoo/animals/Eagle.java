package com.zoo.animals;

import com.zoo.food.Meat;
import com.zoo.interfaces.Flyable;

public class Eagle extends Carnivore implements Flyable {
    @Override
    public void fly() {
        System.out.println("Орел летит");
    }
}
