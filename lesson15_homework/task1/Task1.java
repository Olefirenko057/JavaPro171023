package org.example.homeworks.lesson15_homework.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        // 1) Дан лист строк "BigBen", "BigBob", "Big", "Ben", "Big Bob".
        //Сколько раз объект «Big» встречается в коллекции?
        List<String> list = new ArrayList<>();
        list.add("BigBen");
        list.add("BigBob");
        list.add("Big");
        list.add("Ben");
        list.add("BigBob");

        long quantity = list.stream()
                .filter(word -> word.contains("Big"))
                .count();
        System.out.println(quantity);

        //2) Найти самый маленький элемент: Arrays.asList("a1", "b5", "a2", "b4");
        list.clear();
        list = Arrays.asList("a1", "b5", "a2", "b4");

        String theSmallestElement = list.stream()
                .min(String::compareTo)
                .get();
        System.out.println(theSmallestElement);

        // Выполнить сортировку в обратном алфавитном порядке и удалить дубликаты.
        //Arrays.asList("a1", "b5", "c1", "a2", "b4", "c1", "a1");
        list = Arrays.asList("a1", "b5", "c1", "a2", "b4", "c1", "a1");
        List<String> sortedAndUnique = list.stream()
                .sorted()
                .distinct()
                .toList();
        System.out.println(sortedAndUnique);



    }
}
