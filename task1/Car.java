package org.example.lesson8_homework.task1;

import java.util.Objects;

public abstract class Car {
    private String model;
    private int year;
    private double price;
    private int speed;

    public Car(String model, int year, double price,int speed) {
        this.model = model;
        this.year = year;
        this.price = price;
        if(speed > 0) {
            this.speed = speed;
        } else {
            this.speed = 50;
        }
    }

    public abstract void demonstrate();

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Double.compare(car.price, price) == 0 && speed == car.speed && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year, price, speed);
    }
}
