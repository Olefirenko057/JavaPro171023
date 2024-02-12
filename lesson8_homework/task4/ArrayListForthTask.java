package org.example.lesson8_homework.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListForthTask {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(6,10,20,100,1,5,2));
        System.out.println(powElements(integerList)); //Перебрать ArrayList и найти сумму квадратов всех элементов.

        List<String> stringList = new ArrayList<>(List.of("Tools","Bar","Laptop","TV"));
        System.out.println(theShortestString(stringList));   //Перебрать ArrayList и найти самую короткую строку.


        //Перебрать ArrayList и заменить все гласные буквы в каждой строке на символ ''.
        System.out.println(muteVowelLetters(stringList));

    }

    public static List<Integer> powElements(List<Integer> numbs) {
        for (int i = 0; i < numbs.size(); i++) {
            numbs.set(i, numbs.get(i) * numbs.get(i));
        }
        return numbs;
    }

    public static String theShortestString(List<String> stringList) {
        String theShortestStr = stringList.get(0);
        for (int i = 1; i < stringList.size(); i++) {
            if(theShortestStr.length() > stringList.get(i).length()) {
                theShortestStr = stringList.get(i);
            }
        }
        return theShortestStr;
    }

    public static List<String> muteVowelLetters(List<String> stringList) {
        List<String> stringsWithoutVowels = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String temp = stringList.get(i).toLowerCase();
            temp = temp.replaceAll("a" ,"");
            temp = temp.replaceAll("o","");
            temp = temp.replaceAll("e","");
            temp = temp.replaceAll("i","");
            temp = temp.replaceAll("u","");


            stringsWithoutVowels.add(temp);
        }
        return stringsWithoutVowels;
    }
}
