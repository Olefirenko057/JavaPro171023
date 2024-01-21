package org.example.de.telran.lesson2.homework.task1;

public class Cat extends Pet {

    private boolean isHissing;
    public Cat(String name, int age, double weight, String breed, boolean isHissing) {
        super(name, age, weight, breed);
        this.isHissing = isHissing;
    }
}
