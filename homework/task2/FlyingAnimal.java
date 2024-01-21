package org.example.de.telran.lesson2.homework.task2;

public class FlyingAnimal extends Animal {

    private int wingsQuantity;
    public FlyingAnimal(String name, int age, boolean hasTail, double weight, String colour,int wingsQuantity) {
        super(name, age, hasTail, weight, colour);
        this.wingsQuantity = wingsQuantity;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking now");
    }

    @Override
    public void move() {
        if(getAge() >= 2)
            System.out.println(getName() + " is flying so fast");
        else
            System.out.println(getName() + " is flying pretty slowly");
    }
}
