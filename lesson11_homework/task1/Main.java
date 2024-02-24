package org.example.lesson11_homework.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<House> houses = new TreeSet<>();
        houses.add(new House(200,200_000,"Berlin",true));
        houses.add(new House(180,130_000,"Krakow",true));
        houses.add(new House(150,170_000,"Prague",true));
        houses.add(new House(300,250_000,"Rome",true));
        houses.add(new House(270,400_000,"Vienna",true));
        houses.add(new House(210, 170_000, "Bratislava", false));
        houses.add(new House(110, 150_000, "Berlin", false));
        houses.add(new House(140, 150_000, "Rome", false));
        houses.add(new House(200, 270_000, "Vienna", true));
        houses.add(new House(500, 700_000, "Vienna", true));
        houses.add(new House(185, 135_000, "Krakow", true));
        System.out.println(houses);

        System.out.println(sortInfoByCities(houses));
        System.out.println(sortInfoByCitiesAndArea(houses));
    }

    public static List<House> sortInfoByCities(Set<House> houseSet) {

        List<House> houses = new ArrayList<>(houseSet);
        Collections.sort(houses,(new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                int result = o1.getCity().compareTo(o2.getCity());
                return result;
            }
        }));

        return houses;
    }

    public static Set<House> sortInfoByCitiesAndArea(Set<House> houseSet) {
        Set<House> sortedByCitiesAndAreas = new TreeSet<>(new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                int result = o1.getCity().compareTo(o2.getCity());
                if(result == 0) {
                    result = Integer.compare(o1.getArea(),o2.getArea());
                    return result;
                }
                return result;
            }
        });
        sortedByCitiesAndAreas.addAll(houseSet);
        return sortedByCitiesAndAreas;
    }




}
