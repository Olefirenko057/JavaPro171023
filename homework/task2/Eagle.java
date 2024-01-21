package org.example.de.telran.lesson2.homework.task2;

public class Eagle extends FlyingAnimal {
    private double beakLength;
    public Eagle(String name, int age, boolean hasTail, double weight, String colour, int wingsQuantity, double beakLength) {
        super(name, age, hasTail, weight, colour, wingsQuantity);
        this.beakLength = beakLength;
    }

    public void scream() {
        if(beakLength > 2) {
            System.out.println(getName() + " screams so loud with its big beak");
        } else {
            System.out.println(getName() + " screams pretty quite with its small beak");
        }
    }
}
