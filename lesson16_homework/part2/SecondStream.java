package org.example.homeworks.lesson16_homework.part2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SecondStream {
    // Задача 1: Фильтрация четных чисел и умножение на 2.
    // Задача 2: Удаление дубликатов из списка строк.
    // Задача 3: Сортировка списка чисел в порядке убывания и выбор первых трех элементов.
    // Задача 4: Фильтрация строк, начинающихся на "A" и преобразование в верхний регистр.
    // Задача 6: Фильтрация чисел больше 50 и вывод их квадратов.
    // Задача 7: Оставить только слова, содержащие букву "o" и вывести их в обратном порядке.
    // Задача 8: Фильтрация чисел, оставить только нечетные и вывести их в порядке возрастания.
    // Задача 9: Получить среднее значение чисел в списке.
    // Задача 10: Получить строку, объединяющую элементы списка через запятую.
    // Задача 11: Получить список квадратов чисел из другого списка.
    // Задача 12: Получить список букв из списка слов и вывести их в алфавитном порядке.
    // Задача 13: Получить первые 3 строки из списка и вывести их в обратном порядке.
    // Задача 14: Пропустить первые 2 элемента и оставить только уникальные.
    public static void main(String[] args) {
        // Задача 1: Фильтрация четных чисел и умножение на 2.
        System.out.println(filterEvenAndMultiplyByTwo(List.of(3,6,12,31,27,90)));

        // Задача 2: Удаление дубликатов из списка строк.
        System.out.println(removeDuplicates(List.of("Pipe","Agency","Criteria","Order","Agency","Pipe","Order","Village")));

        // Задача 3: Сортировка списка чисел в порядке убывания и выбор первых трех элементов.
        System.out.println(sortAndGetFirstThree(List.of(4,10,32,55,23,74)));

        // Задача 4: Фильтрация строк, начинающихся на "A" и преобразование в верхний регистр.
        System.out.println(getWordsBeginningWithA(List.of("Apricot","alias","grape","Asphalt","Trip","gold","app")));

        // Задача 5: Пропуск первых двух элементов и вывод оставшихся.
        System.out.println(omitFirstTwoElements(List.of("Apricot","alias","grape","Asphalt","Trip","gold","app")));

        // Задача 6: Фильтрация чисел больше 50 и вывод их квадратов.
        System.out.println(getSquare(List.of(4,10,32,55,23,74)));

        // Задача 7: Оставить только слова, содержащие букву "o" и вывести их в обратном порядке.
        System.out.println(wordsContainingO(List.of("Apricot","alias","grape","Asphalt","Trip","gold","app")));

        // Задача 8: Фильтрация чисел, оставить только нечетные и вывести их в порядке возрастания.
        System.out.println(getOddAscendingDigits(List.of(4,10,32,55,23,74)));

        // Задача 9: Получить среднее значение чисел в списке.
        System.out.println(getAvgValue(List.of(4,10,32,55,23,74)));

        // Задача 10: Получить строку, объединяющую элементы списка через запятую.
        System.out.println(uniteElements(List.of("Pipe","Agency","Criteria","Order","Agency","Pipe","Order","Village")));

        // Задача 11: Получить список квадратов чисел из другого списка.
        System.out.println(getSquareValues(List.of(4,10,32,55,23,74)));

        // Задача 12: Получить список букв из списка слов и вывести их в алфавитном порядке.
        System.out.println(getChars((List.of("Pipe","Agency","Criteria","Order"))));

        // Задача 13: Получить первые 3 строки из списка и вывести их в обратном порядке.
        System.out.println(getFirstThreeReversed(List.of("Pipe","Agency","Criteria","Order")));

        // Задача 14: Пропустить первые 2 элемента и оставить только уникальные.
        System.out.println(omitTwoFirstLeaveDistinct(List.of(4,10,10,10,32,55,23,74)));

    }
    public static List<Integer> filterEvenAndMultiplyByTwo(List<Integer> list) {
        List<Integer> resultList = new ArrayList<>();
        list.stream()
                .filter(x -> x % 2 == 0 && x != 0)
                .forEach(x -> resultList.add(Math.multiplyExact(x,2)));
        return resultList;
    }

    public static List<String> removeDuplicates(List<String> list) {
        list = list.stream()
                .distinct()
                .collect(Collectors.toList());
        return list;
    }
    public static List<Integer> sortAndGetFirstThree(List<Integer> list) {
        return list.stream()
                .sorted((x,y) -> y - x)
                .limit(3)
                .collect(Collectors.toList());
    }
    public static List<String> getWordsBeginningWithA(List<String> list) {
        return list.stream()
                .filter(word -> word.toUpperCase().startsWith("A"))
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList());
    }
    public static List<String> omitFirstTwoElements(List<String> list) {
       return list.stream()
                .skip(2)
                .collect(Collectors.toList());
    }
    public static Map<Integer,Integer> getSquare(List<Integer> list) {
        return list.stream()
                .filter(x -> x > 50)
                .collect(Collectors.toMap(Function.identity(),x -> x * x));
    }
    public static List<String> wordsContainingO(List<String> list) {
        List<String> newList = new ArrayList<>();
        List<String> strings = list.stream()
                .filter(x -> x.contains("o") || x.contains("O"))
                .toList();
        for (int i = strings.size() - 1; i >= 0 ; i--) {
            newList.add(strings.get(i));
        }
        return newList;
    }
    public static List<Integer> getOddAscendingDigits(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 != 0)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }
    public static double getAvgValue(List<Integer> list) {
        return list.stream()
                .collect(Collectors.averagingDouble(x -> x));
    }
    public static String uniteElements(List<String> strings) {
        return strings.stream()
                .collect(Collectors.joining(","));
    }
    public static List<Double> getSquareValues(List<Integer> list) {
        List<Double> result =
        list.stream()
                .mapToDouble(x -> Math.pow(x,2))
                .boxed()
                .collect(Collectors.toList());
        return result;
    }

    public static List<Character> getChars(List<String> list) {
          return list.stream()
                  .flatMap(x -> x.toLowerCase().chars().mapToObj(y -> (char) y))
                  .distinct()
                  .sorted(Character::compareTo)
                  .collect(Collectors.toList());
    }
    public static List<String> getFirstThreeReversed(List<String> list) {
        return list.stream()
                .limit(3)
                .sorted(Comparator.reverseOrder())
                .toList();
    }
    public static String omitTwoFirstLeaveDistinct(List<Integer> list) {
        Integer[] res = list.stream()
                .skip(2)
                .distinct()
                .toArray(Integer[]::new);
        return Arrays.toString(res);
    }

}
