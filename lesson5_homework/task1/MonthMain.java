package org.example.lesson5_homework.task1;

import java.util.ArrayList;
import java.util.List;

public class MonthMain {
    public static void main(String[] args) {


        instantiateArrays(Months.values());



    }

    public static void instantiateArrays(Months[] months) {
        List<Months> winterMonths = new ArrayList<>();
        List<Months> springMonths = new ArrayList<>();
        List<Months> summerMonths = new ArrayList<>();
        List<Months> autumnMonths = new ArrayList<>();
        for(Months month : months) {
            switch (month) {
                case DECEMBER:
                case JANUARY :
                case FEBRUARY:
                    winterMonths.add(month);
                    System.out.println("It is " + month +  " and in winter you should it more fish");
                    break;
                case MARCH:
                case APRIL:
                case MAY:
                    springMonths.add(month);
                    System.out.println("It is " + month +  " and in spring you should it more broccoli");
                    break;
                case JUNE:
                case JULY:
                case AUGUST:
                    summerMonths.add(month);
                    System.out.println("It is " + month +  " and in summer you should it more fruits");
                    break;
                default:
                    autumnMonths.add(month);
                    System.out.println("It is " + month +  " and in autumn you should it more nuts");
            }
        }

    }
}
