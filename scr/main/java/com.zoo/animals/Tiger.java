package com.zoo.animals;

import com.zoo.food.Beef;
import com.zoo.food.Food;
import com.zoo.interfaces.Walkable;

public class Tiger extends Carnivore implements Walkable {
    @Override
    public void eat(Food food) {
        if (food instanceof Beef) {
            System.out.println("Тигр ест говядину.");
        } else {
            System.out.println("Тигр не ест говядину");
        }
    }

    @Override
    public void walk() {
        System.out.println("Тигр идет.");
    }
}
