package org.example.de.telran.lesson2.homework.task2;

public class Cat extends LandAnimal {
    private String breed;

    public Cat(String name, int age, boolean hasTail, double weight, String colour, int pawsQuantity,String breed) {
        super(name, age, hasTail, weight, colour, pawsQuantity);
        this.breed = breed;
    }

    public void giveSound() {
        System.out.println("Our cat's breed is " + breed + " and it says 'Meooow!'");
    }
}
