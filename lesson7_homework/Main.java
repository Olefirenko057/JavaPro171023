package org.example.lesson7_homework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        DynamicIntArray dynamicIntArray = new DynamicIntArray(2);

        dynamicIntArray.add(1);
        System.out.println(dynamicIntArray);

        dynamicIntArray.add(2);
        System.out.println(dynamicIntArray);

        dynamicIntArray.add(0);
        System.out.println(dynamicIntArray);

        dynamicIntArray.delete(2);
        System.out.println(dynamicIntArray);

        dynamicIntArray.add(new int[]{5,6,7,9});
        System.out.println(dynamicIntArray);

        dynamicIntArray.insert(5,13);
        System.out.println(dynamicIntArray);

        System.out.println(dynamicIntArray.get(5));


    }
}
