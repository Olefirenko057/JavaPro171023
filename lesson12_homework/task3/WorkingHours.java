package org.example.lesson12_homework.task3;

import java.util.Random;

public class WorkingHours {
    public static OpeningHours currentTime;
    private static int auxiliaryIndex = -1;
    public static OpeningHours currentTime() {
        Random r = new Random();
        if(auxiliaryIndex < OpeningHours.values().length) {
            if(auxiliaryIndex < OpeningHours.values().length - 1) {
                currentTime = OpeningHours.values()[++auxiliaryIndex];
                currentTime.setCurrentWeather(currentTime.getPossibleWeather()[r.nextInt(currentTime.getPossibleWeather().length)]);
                System.out.println(currentTime + " o'clock " + currentTime.getCurrentWeather());
            } else {
                auxiliaryIndex++;
            }
        }
        return currentTime;
    }



}
