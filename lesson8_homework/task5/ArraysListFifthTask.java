package org.example.lesson8_homework.task5;

import org.example.lesson8_homework.task1.Bugatti;
import org.example.lesson8_homework.task1.Car;
import org.example.lesson8_homework.task1.Lamborghini;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysListFifthTask {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(6,10,20,100,100,100,20,1,5,2));
        System.out.println(findSecondBiggestValue(integerList));    //Перебрать ArrayList и найти второй по величине элемент.

        List<Integer> integerList2 = new ArrayList<>(Arrays.asList(6,10,20,100,100,100,20,1,5,2));
        System.out.println(revertTheList(integerList2));    //Перебрать ArrayList и вывести все элементы в обратном порядке.

        List<String> stringList = new ArrayList<>(Arrays.asList("Kilo90","Opo","Juy32"));
        System.out.println(stringsWithoutNumbers(stringList)); //Перебрать ArrayList и вывести все строки, содержащие только буквы.


        List<String> stringList2 = new ArrayList<>(Arrays.asList("Kilo 90","lll","Opo388w","Juy32hdis","li oo"));
        System.out.println(theLongestWithoutSpacesString(stringList2));    //Перебрать ArrayList и найти самую длинную строку, не содержащую пробелов.



        //Создать ArrayList с объектами вашего собственного класса и отфильтровать только уникальные элементы.
        List<Car> cars = new ArrayList<>();
        cars.add(new Bugatti("Chiron",2013,275_000,350));
        cars.add(new Lamborghini("Avendator",2024,500_000,300));
        cars.add(new Lamborghini("Countach",2019,230_000,280));
        cars.add(new Bugatti("Veyron",2022,400_000,350));
        cars.add(new Lamborghini("Urus",2023,290_000,280));
        cars.add(new Lamborghini("Urus",2023,290_000,280));
        cars.add(new Lamborghini("Avendator",2024,500_000,300));
        cars.add(new Bugatti("Chiron",2013,275_000,350));

        System.out.println(gettingUniqueItems(cars));
    }

    public static Integer findSecondBiggestValue(List<Integer> integerList) {
        Collections.sort(integerList);
        Integer secondBiggestValue = integerList.get(integerList.size() - 2);
        if(integerList.get(integerList.size() - 2) != integerList.get(integerList.size() - 1)) {
            return secondBiggestValue;
        } else {
            for (int i = integerList.size() - 2; i > 1 ; i--) {
                if(integerList.get(i) != integerList.get(i - 1)) {
                     secondBiggestValue = integerList.get(i - 1);
                     break;
                }
            }
        }
        return secondBiggestValue;
    }

    public static <T> List<T> revertTheList(List<T> list) {
        List<T> listCopy = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            listCopy.add(list.get(i));
        }
        list = listCopy;
        return list;
    }

    public static List<String> stringsWithoutNumbers(List<String> stringList) {
        List<String> pureStrings = new ArrayList<>();
        for (String string : stringList) {
            if(!string.contains("1") && !string.contains("2") && !string.contains("3") && !string.contains("4") && !string.contains("5")
            && !string.contains("6") && !string.contains("7") && !string.contains("8") && !string.contains("9") && !string.contains("0")) {
                pureStrings.add(string);
            }
        }
        return pureStrings;
    }

    public static String theLongestWithoutSpacesString(List<String> stringList) {
        for (int i = 0; i < stringList.size();i++) {
            boolean hasNoSpaces = true;
            for (int j = 0; j < stringList.get(i).length(); j++) {
                if(stringList.get(i).charAt(j) == ' ') {
                    hasNoSpaces = false;
                    break;
                }
            }
            if (hasNoSpaces == false) {
                stringList.remove(stringList.get(i));
                 i--;
            }
        }

        String theLongestString = stringList.get(0);
        for (int i = 1; i < stringList.size(); i++) {
            if(theLongestString.length() < stringList.get(i).length()) {
                theLongestString = stringList.get(i);
            }
        }

        return theLongestString;
    }

    public static List<Car> gettingUniqueItems(List<Car> items) {
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size() ; j++) {
                if(items.get(i) != items.get(j) && items.get(i).equals(items.get(j))) {
                    items.remove(items.get(j));
                    j--;
                }
            }
        }
        return items;
    }
}
