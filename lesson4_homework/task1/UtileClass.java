package org.example.lesson4_homework.task1;

import java.util.Arrays;

public class UtileClass {

    public void getValues(int arg1,int arg2) {
        int maxValue;
        int minValue;
        int avgValue;
        if(arg1 == 0 && arg2 == 0) {
            throw new RuntimeException("Cannot have two zero arguments");
        }else if (arg1 > arg2) {
            maxValue = arg1;
            minValue = arg2;
            avgValue = (arg1 + arg2) / 2;
        } else if(arg1 < arg2) {
            maxValue = arg2;
            minValue = arg1;
            avgValue = (arg2 + arg1) / 2;
        } else {
            maxValue = arg1;
            minValue = arg1;
            avgValue = arg1;
        }
        System.out.println("Max = " + maxValue + ", Min = " + minValue + ", Avg = " + avgValue);
    }

    public void getValues(double arg1,double arg2) {
        double maxValue;
        double minValue;
        double avgValue;
        if(arg1 == 0 && arg2 == 0) {
            throw new RuntimeException("Cannot have two zero arguments");
        } else if (arg1 > arg2) {
            maxValue = arg1;
            minValue = arg2;
            avgValue = (arg1 + arg2) / 2;
        } else if(arg1 < arg2) {
            maxValue = arg2;
            minValue = arg1;
            avgValue = (arg2 + arg1) / 2;
        } else {
            maxValue = arg1;
            minValue = arg1;
            avgValue = arg1;
        }
        System.out.println("Max = " + maxValue + ", Min = " + minValue + ", Avg = " + avgValue);
    }

    public void getValues(double arg1,int arg2) {
        double maxValue;
        double minValue;
        double avgValue;
        if(arg1 == 0 && arg2 == 0) {
            throw new RuntimeException("Cannot have two zero arguments");
        } else if (arg1 > arg2) {
            maxValue = arg1;
            minValue = arg2;
            avgValue = (arg1 + arg2) / 2;
        } else if(arg1 < arg2) {
            maxValue = arg2;
            minValue = arg1;
            avgValue = (arg2 + arg1) / 2;
        } else {
            maxValue = arg1;
            minValue = arg1;
            avgValue = arg1;
        }
        System.out.println("Max = " + maxValue + ", Min = " + minValue + ", Avg = " + avgValue);
    }
    public void getValues(Integer[] integers) {
        int counter = 0;
        int maxValue;
        int minValue;
        int avgValue;
        for (int i = 0; i < integers.length; i++) {
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[i] > integers[j]) {
                    int temp = integers[i];
                    integers[i] = integers[j];
                    integers[j] = temp;
                }
            }
        }
       for(Integer integer : integers) {
           counter += integer;
       }
        maxValue = integers[integers.length - 1];
        minValue = integers[0];
        if(counter != 0) {
            avgValue = counter / integers.length;
        } else {
            throw new RuntimeException("Cannot have all zero elements in an array");
        }
        System.out.println("Max = " + maxValue + ", Min = " + minValue + ", Avg = " + avgValue);
    }


    public void getValues(Double[] doubles) {
        double counter = 0;
        double maxValue;
        double minValue;
        double avgValue;
        for (int i = 0; i < doubles.length; i++) {
            for (int j = 1; j < doubles.length; j++) {
                if (doubles[i] > doubles[j]) {
                    double temp = doubles[i];
                    doubles[i] = doubles[j];
                    doubles[j] = temp;
                }
            }
        }
        for(Double doubleValue : doubles) {
            counter += doubleValue;
        }
        maxValue = doubles[doubles.length - 1];
        minValue = doubles[0];
        if(counter != 0) {
            avgValue = counter / doubles.length;
        } else {
            throw new RuntimeException("Cannot have all zero elements in an array");
        }
        System.out.println("Max = " + maxValue + ", Min = " + minValue + ", Avg = " + avgValue);
    }
}
