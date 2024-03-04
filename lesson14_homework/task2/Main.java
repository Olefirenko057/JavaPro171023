package org.example.lesson14_homework.task2;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //Создать лямбда выражение, которое возвращает значение true,
        //если строка не null, используя функциональный интерфейс Predicate.
        System.out.println(isNull("l"));

        //Создать лямбда выражение, которое проверяет, что строка не пуста,
        //используя функциональный интерфейс Predicate.
        System.out.println(isEmpty(""));

        //Написать программу проверяющую, что строка не null и не пуста,
        //используя функциональный интерфейс Predicate.
        System.out.println(isEmptyAndIsNull("li"));

        //Написать программу, которая проверяет, что строка начинается буквой “J”или “N”
        //и заканчивается “A”. Используем функциональный интерфейс Predicate.
        System.out.println(startsWithJAndNEndsWithA("JapA"));

        //Написать лямбда выражение, которое принимает на вход число и возвращает значение “Положительное число”,
        //“Отрицательное число” или  “Ноль”. Используем функциональный интерфейс Function.
        System.out.println(checkANumber(0));

        //Написать лямбда выражение, которое возвращает случайное число от 0 до 10.
        //Используем функциональный интерфейс Supplier.
        System.out.println(generateRandomInt(0,10));

        Random r = new Random();
        System.out.println(r.nextInt(2));

    }

    public static boolean isNull(String word) {
        Predicate<String> stringPredicate = (text) -> {
            if (text != null) {
                return true;
            } else {
                return false;
            }
        };
        return stringPredicate.test(word);
    }

    public static boolean isEmpty(String word) {
        Predicate<String> stringPredicate = (text) -> {
            if(text.length() > 0) {
                return true;
            } else {
                return false;
            }
        };
        return stringPredicate.test(word);
    }

    public static boolean isEmptyAndIsNull(String word) {
        Predicate<String> stringPredicate = (text) -> {
            if(text.length() > 0 && text != null) {
                return true;
            } else {
                return false;
            }
        };
        return stringPredicate.test(word);
    }

    public static boolean startsWithJAndNEndsWithA(String word) {
        Predicate<String> stringPredicate = (text) -> {
            if((text.toLowerCase().charAt(0) == 'j' || text.toLowerCase().charAt(0) == 'n') && text.toLowerCase().charAt(text.length() - 1) == 'a') {
                return true;
            } else {
                return false;
            }
        };
        return stringPredicate.test(word);
    }

    public static String checkANumber(int n) {
        Function<Integer,String> function = (number) -> {
            if(number > 0) {
                return number + " is a positive number";
            } else if(number < 0) {
                return number + " is a negative number";
            } else {
                return number + " is " + number;
            }
        };
        return function.apply(n);
    }

    public static int generateRandomInt(int min,int max) {
        Supplier<Integer> supplier = () -> {
            Random r = new Random();
            return r.nextInt(min,max + 1);
        };
        return supplier.get();
    }
}
