package com.zoo.animals;

import com.zoo.food.Fish;
import com.zoo.food.Food;
import com.zoo.interfaces.Swimmable;

public class Dolphin extends Carnivore implements Swimmable {
    @Override
    public void eat(Food food) {
        if (food instanceof Fish) {
            System.out.println("Дельфин ест рыбу");
        } else {
            System.out.println("Дельфин не ест рыбу");
        }
    }

    @Override
    public void swim() {
        System.out.println("Дельфин плывет");
    }
}
