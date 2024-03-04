package org.example.lesson13_homework.task1;

import java.util.*;

public class Citizens {
    // 1 уровень сложности: 1) Есть Map, в котором храниться количество жителей по разным городам.
    //
    //
    //Найдите город с самым большим количеством жителей.
    //
    //Найдите среднее количество жителей по всем городам.
    //
    //Найдите все города, у которых количество жителей одинаковое.

    public static void main(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        map.put("Vienna",1_500_000);
        map.put("Tokyo", 30_000_000);
        map.put("Munich", 1_500_000);
        map.put("Kyiv", 2_000_000);
        map.put("Warsaw", 2_000_000);
        map.put("Tel_Aviv", 400_000);
        map.put("Beijing", 20_000_000);

        System.out.println(findCityWithBiggestPopulation(map)); //Найдите город с самым большим количеством жителей.

        System.out.println(findAverageQuantity(map));  //Найдите среднее количество жителей по всем городам.

        System.out.println(citiesWithSamePopulation(map));

        System.out.println(citiesWithSamePopulation(map));


    }

    public static String findCityWithBiggestPopulation(Map<String,Integer> map) {
        List<Integer> populations = new ArrayList<>();
        populations.addAll(map.values());
        populations.sort((o1,o2) -> o2 - o1);
        for (String city : map.keySet()) {
            if(map.get(city) == populations.get(0)) {
                return city;
            }
        }
        return null;
    }

    public static int findAverageQuantity(Map<String,Integer> map) {
        List<Integer> populations = new ArrayList<>();
        populations.addAll(map.values());
        int result = 0;
        for (Integer population : populations) {
            result += population;
        }
        return result / populations.size();
    }

    public static List<String> citiesWithSamePopulation(Map<String,Integer> map) {
        List<Integer> list = new ArrayList<>();
        List<String> cities = new ArrayList<>();
        for(Map.Entry<String,Integer> pair : map.entrySet()) {
            if(list.contains(pair.getValue())) {
                for (Map.Entry<String,Integer> pair1 : map.entrySet()) {
                    if(pair.getValue().equals(pair1.getValue()) && !pair.getKey().equals(pair1.getKey())) {
                        cities.add(pair.getKey());
                        cities.add(pair1.getKey());
                    }
                }
            } else {
                list.add(pair.getValue());
            }
        }
        return cities;
    }
}
