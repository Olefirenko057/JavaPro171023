package org.example.lesson8_homework.task3;

import org.example.lesson8_homework.task1.Bugatti;
import org.example.lesson8_homework.task1.Car;
import org.example.lesson8_homework.task1.Lamborghini;

import java.util.ArrayList;
import java.util.List;

public class ArrayListThirdTask {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(List.of(3,4,22,66,74,101,55,88,40,51));
        System.out.println(removeEvenNumbersAndUpdateList(integerList)); //  //Перебрать ArrayList и удалить все четные числа.

        List<String> stringList = new ArrayList<>(List.of("Tools","Bar","Laptop","TV"));
        System.out.println(concatListElements(stringList));  //Перебрать ArrayList и объединить все элементы в одну строку.

        //Создать ArrayList с объектами вашего собственного класса и вывести только те, которые удовлетворяют определенному условию.
        List<Car> cars = new ArrayList<>();
        cars.add(new Bugatti("Chiron",2013,275_000,350));
        cars.add(new Lamborghini("Avendator",2024,500_000,300));
        cars.add(new Lamborghini("Countach",2019,230_000,280));
        cars.add(new Bugatti("Veyron",2022,400_000,350));
        cars.add(new Lamborghini("Urus",2023,290_000,280));

        System.out.println(getLamborghiniCars(cars));

    }

    public static List<Integer> removeEvenNumbersAndUpdateList(List<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            if(integerList.get(i) % 2 == 0) {
                integerList.remove(i);
                i--;
            }
        }
        return integerList;
    }

    public static <T> String concatListElements(List<T> stringList) {
        String elementsStorage = stringList.get(0) + " ";
        for (int i = 1; i < stringList.size(); i++) {
            elementsStorage += stringList.get(i) + " ";
        }
        return elementsStorage;
    }

    public static List<Car> getLamborghiniCars(List<Car> cars) {
        List<Car> lambos = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getClass().getSimpleName().equals("Lamborghini")) {
                lambos.add(cars.get(i));
            }
        }
        return lambos;
    }
}
