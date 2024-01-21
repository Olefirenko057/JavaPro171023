package org.example.de.telran.lesson2.homework.task2;

public class LandAnimal extends Animal {

    private int pawsQuantity;
    public LandAnimal(String name, int age, boolean hasTail, double weight, String colour, int pawsQuantity) {
        super(name, age, hasTail, weight, colour);
        this.pawsQuantity = pawsQuantity;
    }

}
