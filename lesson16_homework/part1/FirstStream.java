package org.example.homeworks.lesson16_homework.part1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FirstStream {
    public static void main(String[] args) {
        //Задание 1: Фильтрация списка целых чисел на нечетные числа
        System.out.println(getOddNumbers(List.of(10,21,15,33,100,50,11)));
        //Задание 2: Преобразование списка строк в список чисел
        System.out.println(convertIntoInteger(List.of("10","21","15","33","100","50","11")));
        //Задание 3: Суммирование списка чисел
        System.out.println(getSumOfInts(List.of(10,21,15,33,100,50,11)));
        //Задание 4: Определение максимального значения в списке
        System.out.println(findMaxInt(List.of(10,21,15,33,100,50,11)));
        //Задание 5: Фильтрация списка строк на те, которые начинаются с определенной буквы и преобразование их в верхний регистр
        System.out.println(startsWith(List.of("Cat","Lock","Case","Smoke","Loop","Cream","Make","Saw"),"C"));
        //Задание 6: Получение списка уникальных слов из списка строк, длина которых больше 4 символов
        System.out.println(getUnique(List.of("Pipe","Agency","Criteria","Order","Agency","Pipe","Order","Village")));
        //Задание 7:Преобразование списка объектов класса в список их имен, отсортированных по возрасту ------
        System.out.println(sortStudents(List.of(new Student("Alex",20),new Student("Tom",21),new Student("Sam",19))));
        //Задание 8:Нахождение суммы чисел, кратных 3 и 5, из списка чисел -------
        System.out.println(sumOfDivisibleByThreeAndFive(List.of(5,19,24,30,21,60)));
        //Задание 9:Получение списка слов, содержащих только уникальные символы, из списка строк
        System.out.println(getUniqueChars(List.of("Pipe","Agency","Criteria","Order","Village")));
        //Задание 9:Получение списка слов, содержащих только уникальные символы, из списка строк
        System.out.println(getUniqueChars2(List.of("Pipe","Agency","Criteria","Order","Village")));



    }

    public static List<Integer> getOddNumbers(List<Integer> list) {
        return list.stream()
                .filter(integer -> integer % 2 != 0)
                .toList();
    }
    public static List<Integer> convertIntoInteger(List<String> strings) {
        List<Integer> list = new ArrayList<>();
        strings.stream()
                .forEach(x -> list.add(Integer.parseInt(x)));
        return list;
    }
    public static int getSumOfInts(List<Integer> list) {
       return list.stream().reduce(Integer::sum).get();
    }

    public static int findMaxInt(List<Integer> list) {
        return list.stream().max(Integer::compare).get();
    }
    public static List<String> startsWith(List<String> list,String letter) {
        List<String> newList = new ArrayList<>();
        list.stream()
                .filter(x -> x.startsWith(letter))
                .forEach(x -> newList.add(x.toUpperCase()));
        return newList;
    }
    public static List<String> getUnique(List<String> list) {
       return list.stream()
                .filter(word -> word.length() > 4)
                .distinct()
                .collect(Collectors.toList());
    }
    public static List<String> sortStudents(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .map(student -> student.getName())
                .collect(Collectors.toList());
    }
    public static int sumOfDivisibleByThreeAndFive(List<Integer> integers) {
        return integers.stream()
                .filter(x -> x % 3 == 0 && x % 5 == 0 && x != 0)
                .reduce(Integer::sum)
                .get();
    }
    public static List<String> getUniqueChars(List<String> list) {
        return list.stream()
                .filter(FirstStream::hasNoRepetitiveChars)
                .collect(Collectors.toList());
    }
    public static boolean hasNoRepetitiveChars(String word) {
        if (word.length() <= 1) {
            return true;
        }
        char firstChar = word.toLowerCase().charAt(0);
        String restOfWord = word.substring(1);
        if (restOfWord.indexOf(firstChar) != -1) {
            return false;
        }
        return hasNoRepetitiveChars(restOfWord);
    }

    public static List<String> getUniqueChars2(List<String> list) {
        return list.stream()
                .filter(word -> word.toLowerCase().chars().distinct().count() == word.length())
                .collect(Collectors.toList());
    }
}
