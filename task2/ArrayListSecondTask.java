package org.example.lesson8_homework.task2;

import org.example.lesson8_homework.task1.Bugatti;
import org.example.lesson8_homework.task1.Car;
import org.example.lesson8_homework.task1.Lamborghini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ArrayListSecondTask {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(6,10,20,100,1,5,2));
        Integer theSmallestValue = theSmallestValue(integerList);
        System.out.println(theSmallestValue);  //Перебрать ArrayList и найти наименьший элемент.


        //Перебрать ArrayList и найти количество элементов, начинающихся с определенной буквы.
        List<String> developersTools = new ArrayList<>();
        developersTools.add("Computer");
        developersTools.add("Server");
        developersTools.add("Repository");
        developersTools.add("Keyboard");
        developersTools.add("Compiler");
        developersTools.add("Screen");
        System.out.println(qtyOfElementsStartingWithLetter(developersTools,'c'));

        ////Создать ArrayList с объектами вашего собственного класса и удалить все элементы, удовлетворяющие определенному условию.
        List<Car> cars = new ArrayList<>();
        cars.add(new Bugatti("Chiron",2013,275_000,350));
        cars.add(new Lamborghini("Avendator",2024,500_000,300));
        cars.add(new Lamborghini("Countach",2019,230_000,280));
        cars.add(new Bugatti("Veyron",2022,400_000,350));
        cars.add(new Lamborghini("Urus",2023,290_000,280));
        removeOlderModelsFromStock(cars);

        
    }

    public static Integer theSmallestValue(List<Integer> ints) {
        if(!ints.isEmpty()) {
            int minValue = ints.get(0);
            for (int i = 1; i < ints.size(); i++) {
                if(minValue > ints.get(i)) {
                    minValue = ints.get(i);
                }
            }
            return minValue;
        } else {
            return null;
        }
    }

    public static int qtyOfElementsStartingWithLetter(List<String> strings,char firstLetter) {
        int countWords = 0;
        if(!strings.isEmpty()) {
            for (int i = 0; i < strings.size(); i++) {
                String smallLetterOption = strings.get(i).toLowerCase(Locale.ROOT);
                if(strings.get(i).charAt(0) == firstLetter || smallLetterOption.charAt(0) == firstLetter) {
                    countWords++;
                }
            }
        }
        return countWords;
    }
    
   public static void removeOlderModelsFromStock(List<Car> cars) {
        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getYear() < 2020) {
                cars.remove(cars.get(i));
                i--;
            }
        }
       System.out.println("Cars after sorting: ");
       System.out.println(cars);
   }
}
