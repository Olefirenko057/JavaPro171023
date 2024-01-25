package org.example.lesson3_homework.task3;

import java.util.Random;

public class Auto implements AutoMechanic,Driver {
//    Есть класс Авто со свои набором характеристик и поведения.
//            Подумайте, какие ресурсы класса Авто могут доступны только Автомеханику, а какие простому Водителю.
//    Создайте интерфейсы Автомеханик и Водитель, и с их помощью разделите доступ к методам класса Авто.
    private String model;
    private String colour;
    private int maxSpeed;
    private int power;
    private String fuelType;
    private double mileage;
    private boolean isRiding;
    private final boolean isNew;

    public Auto(String model, String colour, int maxSpeed, int power, String fuelType, double mileage,boolean isRiding) {
        this.model = model;
        this.colour = colour;
        this.maxSpeed = maxSpeed;
        this.power = power;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.isRiding = isRiding;
        this.isNew = (mileage < 100) ? true : false;
    }

    public int checkCurrentSpeed() {
        if(isRiding) {
            Random random = new Random();
            return random.nextInt(1,maxSpeed);
        } else {
            return 0;
        }
    }
    public String getToKnowIfItIsNew() {
        if(isNew) {
            return "new";
        } else {
            return "not new";
        }
    }


    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getPower() {
        return power;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getMileage() {
        return mileage;
    }

    public boolean isRiding() {
        return isRiding;
    }


}
