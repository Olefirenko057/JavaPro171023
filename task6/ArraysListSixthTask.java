package org.example.lesson8_homework.task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysListSixthTask {
    //Перебрать ArrayList и найти наибольшую возрастающую последовательность элементов.
    //Перебрать ArrayList и удалить все дубликаты элементов.
    //Перебрать ArrayList и создать новый список, содержащий только уникальные строки.
    //Перебрать ArrayList и объединить все строки в одну с использованием разделителя.
    public static void main(String[] args) {
        //Перебрать ArrayList и найти наибольшую возрастающую последовательность элементов.
        List<Integer> integerList = new ArrayList<>(Arrays.asList(6,1,10,20,30,15,100,150,100,20,1,5,2,21,50,65,2000,2100));
        System.out.println(theBiggestAscendingSnippet(integerList));

        //Перебрать ArrayList и удалить все дубликаты элементов.
        List<Integer> integerList2 = new ArrayList<>(Arrays.asList(6,1,10,20,10,6,100,50,5,1,100));
        System.out.println(listWithNoDuplicates(integerList2));

        //Перебрать ArrayList и создать новый список, содержащий только уникальные строки.
        List<String> stringList = new ArrayList<>(Arrays.asList("London","Madrid","Kiyv","London","Milano","Kiyv","Vienna","Berlin","Berlin"));
        System.out.println(uniqueStrings(stringList));

        // //Перебрать ArrayList и объединить все строки в одну с использованием разделителя.
        System.out.println(concatStrings(uniqueStrings(stringList)));



    }

    public static List<Integer> theBiggestAscendingSnippet(List<Integer> integerList) {
        List<List<Integer>> listOfAscending = new ArrayList<>();
        while(true) {
            List<Integer> mountingNumbers = new ArrayList<>();
            for (int i = 0; i <= integerList.size() - 1; i++) {
                if (i != integerList.size() - 1 && integerList.get(i) < integerList.get(i + 1)) {
                    mountingNumbers.add(integerList.get(i));
                } else if(i == (integerList.size() - 1)) {
                    if (integerList.get(i) > integerList.get(i - 1)) {
                        mountingNumbers.add(integerList.get(i));
                        listOfAscending.add(List.copyOf(mountingNumbers));
                    }
                } else {
                    mountingNumbers.add(integerList.get(i));
                    listOfAscending.add(List.copyOf(mountingNumbers));
                    mountingNumbers.clear();
                }
            }
            break;
        }
        List<Integer> biggestAscending = listOfAscending.get(0);
        for (int i = 1; i < listOfAscending.size(); i++) {
            if(biggestAscending.size() < listOfAscending.get(i).size()) {
                biggestAscending = listOfAscending.get(i);
            }
        }
        return biggestAscending;
    }

    private static <T> List<T> listWithNoDuplicates(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    j--;
                }
            }
        }
        return list;
    }

    private static List<String> uniqueStrings(List<String> stringList) {
        List<String> uniqueValues = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
                if(!uniqueValues.contains(stringList.get(i))) {
                    uniqueValues.add(stringList.get(i));
                }
        }
        return uniqueValues;
    }

    private static StringBuilder concatStrings(List<String> listString) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < listString.size(); i++) {
            stringBuilder.append(listString.get(i) + " ");
        }
        return stringBuilder;
    }
}
