package org.example.lesson8_homework.task1;

public class Bugatti extends Car{
    public Bugatti(String model, int year, double price,int speed) {
        super(model, year, price,speed);
    }

    @Override
    public void demonstrate() {
        System.out.println(getClass().getSimpleName() + " " + getModel() + " is riding at " + getSpeed() + " km per hour") ;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {model: " + getModel() + "; year: " + getYear() + "; price: " + getPrice() + "$}";
    }

}
