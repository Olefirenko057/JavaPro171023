package org.example.de.telran.lesson2.homework.task1;

public class Dog extends Pet {

    private boolean isBarking;
    public Dog(String name, int age, double weight, String breed, boolean isBarking) {
        super(name, age, weight, breed);
        this.isBarking = isBarking;
    }
}
