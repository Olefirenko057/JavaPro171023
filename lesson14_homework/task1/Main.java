package org.example.lesson14_homework.task1;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        // 1 уровень сложности: 1) Написать функциональный интерфейс Printable, который содержит один метод void print(String text).
        //Используя этот интерфейс, напишите lambda выражения для печати переданного текста большими буквами,
        //и маленькими буквами.
        Printable printable = text ->  System.out.println(text.toUpperCase() + " " + text.toLowerCase());
        printable.print("Hello");


        //Возможно ли данный интерфейс заменить одним из стандартных функциональных интерфейсов?
        //Если да, приведите пример.
        Consumer<String> stringConsumer = text ->  System.out.println(text.toUpperCase() + " " + text.toLowerCase());
        stringConsumer.accept("World");
    }
}
