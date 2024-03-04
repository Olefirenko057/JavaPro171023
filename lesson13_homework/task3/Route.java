package org.example.lesson13_homework.task3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Route {
    //3)* Найти маршрут из заданного списка билетов, желательно используя Map.
    //Учитывая список билетов, найти маршрут по порядку, используя данный список.
    //Вход:
    //«Berlin» -> «London»
    //«Tokyo» -> «Seoul»
    //«Mumbai» -> «Berlin»
    //«Seoul» -> «Mumbai»
    //Выход:
    //Tokyo->Seoul, Seoul->Mumbai, Mumbai->Berlin, Berlin->Lindon
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Berlin","London");
        map.put("Tokyo","Seoul");
        map.put("Mumbai","Berlin");
        map.put("Seoul","Mumbai");

        getARoute(map);
    }

    public static void getARoute(Map<String,String> map) {
        Map<String,String> orderedMap = new LinkedHashMap<>();
        for (Map.Entry<String,String> routs : map.entrySet()) {
            if(!map.containsValue(routs.getKey())) {
                orderedMap.put(routs.getKey(),routs.getValue());
            }
        }

        while (orderedMap.size() != map.size()) {
            for (Map.Entry<String, String> pair : orderedMap.entrySet()) {
                for (Map.Entry<String, String> routs : map.entrySet()) {
                    if (pair.getValue().equals(routs.getKey()) && !pair.equals(routs)) {
                        orderedMap.put(routs.getKey(), routs.getValue());
                    }
                }
            }
        }

        String ultimateRoute = "";
        for(Map.Entry<String,String> pair : orderedMap.entrySet()) {
            ultimateRoute += pair.getKey() + " -> " + pair.getValue() + "   ";
        }
        System.out.println(ultimateRoute);
    }
}
