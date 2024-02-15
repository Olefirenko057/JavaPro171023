package org.example.lesson9_homework.task2;

import java.util.*;

public class ListWithLoops {

    //-  создать лист, наполнить его 10 млн.элементов
    //
    //
    //
    //внутри тела просто будем присваивать i-тый элемент в переменную temp
    //
    //перебрать весь список и замерять время выполнения:
    //  а) с помощью for-each loop
    //  b) классический for, с выполнением условия i<list.size()
    //  c) классический for, но проходим список с конца до начала (i--)
    //  d) используя Itertor
    //  e) используя ListIterator и перемещаясь от начала списка до конца
    //  e) используя ListIterator с перемещением от конца списка к началу
    //Замер производительности делать для каждого из подпунктов отдельно,
    //используя например сходный шаблон кода:  инструкцию java:
    //       long startTime = System.currentTimeMillis();
    //       //…… Ваша реализация перебора списка, например
    //       for (int i : list) {
    //           int temp = i;
    //       }
    //       long endTime = System.currentTimeMillis();
    //       System.out.println("for-each loop: " + (endTime - startTime));
    //время выполнения каждого перебора вывести в консоль
    //Определите, какой вариант перебора списка работает быстрее всего.
    public static void main(String[] args) {
        List<Integer> integerList1 = new ArrayList<>();
        List<Integer> integerList2 = new LinkedList<>();
        long startTime;
        long endTime;

        for (int i = 0; i < 10_000_000; i++) {
            integerList1.add(i);
        }
        for (int i = 0; i < 10_000_000; i++) {
            integerList2.add(i);
        }
//        System.out.println(integerList1);
//        System.out.println(integerList2);


//        а) с помощью for-each loop
        startTime = System.currentTimeMillis();
        for(Integer element : integerList1) {
            int temp = element;
        }
        endTime = System.currentTimeMillis();
        System.out.println("for-each loop for ArrayList " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(Integer element : integerList1) {
            int temp = element;
        }
        endTime = System.currentTimeMillis();
        System.out.println("for-each loop for LinkedList " + (endTime - startTime));


        //  b) классический for, с выполнением условия i<list.size()
        startTime = System.currentTimeMillis();
        for (int i = 0; i < integerList1.size(); i++) {
            int temp = integerList1.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("classic for loop for ArrayList " + (endTime - startTime));
//
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < integerList2.size(); i++) {
//            int temp = integerList2.get(i);
//            System.out.println(temp);
//        }
//        endTime = System.currentTimeMillis();
        System.out.println("classic for loop for LinkedList too slow and too long");


       //  c) классический for, но проходим список с конца до начала (i--)
        startTime = System.currentTimeMillis();
        for (int i = integerList1.size() - 1; i >= 0; i--) {
            int temp = integerList1.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("classic reversed for loop for ArrayList " + (endTime - startTime));

//        startTime = System.currentTimeMillis();
//        for (int i = integerList2.size() - 1; i >= 0; i--) {
//            int temp = integerList2.get(i);
//        }
//        endTime = System.currentTimeMillis();
        System.out.println("classic reversed for loop for LinkedList too slow and too long ");


        //  d) используя Iterator
        Iterator<Integer> iterator = integerList1.iterator();
        startTime = System.currentTimeMillis();
        while (iterator.hasNext()) {
            Integer temp = iterator.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Iterator for ArrayList " + (endTime - startTime));

        iterator = integerList2.iterator();
        startTime = System.currentTimeMillis();
        while (iterator.hasNext()) {
            Integer temp = iterator.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Iterator for LinkedList " + (endTime - startTime));


        //  e) используя ListIterator и перемещаясь от начала списка до конца
        ListIterator<Integer> listIterator = integerList1.listIterator();
        startTime = System.currentTimeMillis();
        while (listIterator.hasNext()) {
            Integer temp = listIterator.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("ListIterator for ArrayList " + (endTime - startTime));

        ListIterator<Integer> listIterator2 = integerList1.listIterator();
        startTime = System.currentTimeMillis();
        while (listIterator2.hasNext()) {
            Integer temp = listIterator2.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("ListIterator for LinkedList " + (endTime - startTime));



        //  f) используя ListIterator с перемещением от конца списка к началу
        startTime = System.currentTimeMillis();
        while (listIterator.hasPrevious()) {
            Integer temp = listIterator.previous();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Reversed ListIterator for ArrayList " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        while (listIterator2.hasPrevious()) {
            Integer temp = listIterator2.previous();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Reversed ListIterator for LinkedList " + (endTime - startTime));


    }
}
