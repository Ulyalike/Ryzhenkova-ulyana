package com.zoo.animals;

import com.zoo.food.Food;
import com.zoo.food.Grass;

public abstract class Herbivore extends Animal {
    @Override
    public void eat(Food food) {
        if (food instanceof Grass) {
            System.out.println(this.getClass().getSimpleName() + " ест траву.");
        } else {
            System.out.println(this.getClass().getSimpleName() + " не ест это!");
        }
    }
}
