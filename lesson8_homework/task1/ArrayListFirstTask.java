package org.example.lesson8_homework.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListFirstTask {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(6,10,20,100,1,5,2));
        int sum = getSum(integerList);
        System.out.println(sum);   //Найти сумму всех элементов ArrayList.
        sortThroughEachElement(integerList); // Перебрать ArrayList и вывести все элементы на экран.


//        Создать ArrayList с объектами вашего собственного класса и вывести их на экран
        List<Car> carsExhibition = new ArrayList<>();
        carsExhibition.add(new Bugatti("Veyron",2017,400_000,300));
        carsExhibition.add(new Lamborghini("Urus",2023,300_000,250));
        carsExhibition.add(new Lamborghini("Huracan",2020,270_000,320));
        sortThroughEachElement(carsExhibition);
    }

    public static Integer getSum(List<Integer> integers) {
        int sum = 0;
        if (integers.size() != 0) {
            for (int i = 0; i < integers.size(); i++) {
                sum += integers.get(i);
            }
        }
        return sum;
    }

    public static <T> void sortThroughEachElement(List<T> integers) {
        if (integers.size() != 0) {
            for (int i = 0; i < integers.size(); i++) {
                System.out.print(integers.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println(integers);
        }
    }


}
