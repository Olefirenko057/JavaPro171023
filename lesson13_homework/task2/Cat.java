package org.example.lesson13_homework.task2;

public class Cat {
    private int age;
    private double weight;
    private Breed breed;

    public Cat (int age, double weight, Breed breed) {
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }


    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public Breed getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", weight=" + weight +
                ", breed=" + breed +
                '}';
    }
}
