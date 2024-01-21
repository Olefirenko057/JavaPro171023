package org.example.de.telran.lesson2.homework.task2;

public class Animal {
    //2*. Создать классы и схему наследования для задачи учета животных в зоопарке:
    //
    //
    //
    //Как минимум должен быть общий класс Animal с характеристиками и поведением, характерными для всех животных.
    //А дальше уже Ваше творчество, в котором вы должны разбить животных на группы и подгруппы.
    private String name;
    private int age;
    private boolean hasTail;
    private double weight;
    private String colour;

    public Animal(String name, int age, boolean hasTail, double weight, String colour) {
        this.name = name;
        this.age = age;
        this.hasTail = hasTail;
        this.weight = weight;
        this.colour = colour;
    }

    public void eat() {
        System.out.println(colour + " " + name + " is eating now");
    }

    public void move() {
        if(age >= 3)
            System.out.println(name + " is running so fast");
        else
            System.out.println(name + " is running pretty slowly");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasTail() {
        return hasTail;
    }

    public double getWeight() {
        return weight;
    }

    public String getColour() {
        return colour;
    }
}
