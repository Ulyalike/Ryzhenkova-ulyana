package com.zoo.main;

import com.zoo.animals.*;
import com.zoo.food.*;

public class Main {
    public static void main(String[] args) {
        Horse horse = new Horse();
        Tiger tiger = new Tiger();
        Dolphin dolphin = new Dolphin();
        Eagle eagle = new Eagle();
        Camel camel = new Camel();

        horse.walk();
        horse.eat(new Grass());

        tiger.walk();
        tiger.eat(new Beef());

        dolphin.swim();
        dolphin.eat(new Fish());

        eagle.fly();
        eagle.eat(new Beef());

        camel.walk();
        camel.eat(new Grass());
    }
}
