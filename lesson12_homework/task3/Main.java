package org.example.lesson12_homework.task3;

import java.util.*;

public class Main {
    //3)** Автозаправка. По умолчанию автомобили заправляются согласно стандартной очереди FIFO. Но автомобили скорой помощи
    //всегда заправляются вне очереди.
    //В час пик, общественные автобусы получают максимальный приоритет по заправке, но скорая помощь все равно более приоритетна.
    //Во время стихийных бедствий (снегопад, наводнение) технологический транспорт городских служб заправляется вне очереди.
    //Какую бы коллекцию Вы использовали для реализацию данного алгоритма?
    //
    //Напишите программу, которая бы имитировала работу.
    public static void main(String[] args) {

        Iterator<OpeningHours> openingHoursIterator = Arrays.asList(OpeningHours.values()).iterator();
        while (openingHoursIterator.hasNext()) {
            Auto auto1 = new Auto(CarTypes.AMBULANCE,"Black");
            Auto auto2 = new Auto(CarTypes.PASSENGER_CAR,"Black");
            Auto auto3 = new Auto(CarTypes.AMBULANCE,"White");
            Auto auto4 = new Auto(CarTypes.AMBULANCE,"White");
            Auto auto5 = new Auto(CarTypes.BUS,"Yellow");
            Auto auto6 = new Auto(CarTypes.PASSENGER_CAR,"Black");
            Auto auto7 = new Auto(CarTypes.TECHNOLOGICAL_TRANSPORT,"Black");
            Auto auto8 = new Auto(CarTypes.BUS,"Blue");
            WorkingHours.currentTime = openingHoursIterator.next();
            GasStation.getInstance().fillCars(WorkingHours.currentTime());
            System.out.println();
        }







    }

}
