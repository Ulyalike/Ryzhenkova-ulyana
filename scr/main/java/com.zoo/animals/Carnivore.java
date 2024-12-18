package com.zoo.animals;

import com.zoo.food.Food;
import com.zoo.food.Meat;

public abstract class Carnivore extends Animal {
    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println(this.getClass().getSimpleName() + " ест мясо.");
        } else {
            System.out.println(this.getClass().getSimpleName() + " не ест мясо");
        }
    }
}
