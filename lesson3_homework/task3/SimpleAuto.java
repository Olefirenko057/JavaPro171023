package org.example.lesson3_homework.task3;

public class SimpleAuto {
    public static void main(String[] args) {
        Auto audi = new Audi("Q8","Black",280,600,"Petrol",1000,true);
        AutoMechanic autoMechanic = audi;
        Driver driver = audi;
        System.out.println(audi.getClass().getSimpleName() + "`s fuel type is " + autoMechanic.getFuelType() + " and the power is " + autoMechanic.getPower());
        System.out.println("The mileage is " + autoMechanic.getMileage() + ", so the car is " + autoMechanic.getToKnowIfItIsNew());
        System.out.println();
        System.out.println();
        System.out.println("Dear customer, your " + audi.getClass().getSimpleName() + driver.getModel() + "`s maximal speed is " + driver.getMaxSpeed());
        System.out.println("Your current speed is " + driver.checkCurrentSpeed());
    }
}
