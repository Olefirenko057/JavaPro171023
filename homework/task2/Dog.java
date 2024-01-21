package org.example.de.telran.lesson2.homework.task2;

public class Dog extends LandAnimal {

    private String breed;

    public Dog(String name, int age, boolean hasTail, double weight, String colour, int pawsQuantity,String breed) {
        super(name, age, hasTail, weight, colour, pawsQuantity);
        this.breed = breed;
    }

    public void giveSound() {
        System.out.println("Our dog's breed is " + breed + " and it says 'Woof!'");
    }
}
