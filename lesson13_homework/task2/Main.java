package org.example.lesson13_homework.task2;

import java.util.*;

//2) У вас есть приют для животных, в которых живут коты.
//Есть объект Cat с данными: имя, возраст, вес, порода.
//
//
//
//создайте Map, ключом которого будет имя, а значением объект Cat.
//
//информация о котах должна храниться в упорядоченном виде по имени.
//
//выведите имена котов, порода которых равна N (на ваше усмотрение).
//
//выведите список всех котов, вес которых больше значения М (на ваше усмотрение).
//
//* найдите кота с самым большим весом и возрастом одновременно.
public class Main {
    public static void main(String[] args) {
        //создайте Map, ключом которого будет имя, а значением объект Cat.
        Map<String,Cat> map = new TreeMap<>();
        map.put("Poll", new Cat(5,3,Breed.BRITISH));
        map.put("Felix", new Cat(2,4,Breed.SIAMESE));
        map.put("Mur", new Cat(10,5,Breed.SCOTTISH));
        map.put("Yena", new Cat(1,2,Breed.SCOTTISH));
        map.put("John", new Cat(5,5,Breed.EGYPTIAN));
        map.put("Mila", new Cat(12,10,Breed.SIAMESE));
        map.put("Clara", new Cat(7,3,Breed.BRITISH));

        System.out.println(map);  //информация о котах должна храниться в упорядоченном виде по имени.

        System.out.println(findCats(Breed.BRITISH,map)); ////выведите имена котов, порода которых равна N (на ваше усмотрение).

        System.out.println(findCatsThickerThan(4,map)); ////выведите список всех котов, вес которых больше значения М (на ваше усмотрение).

        System.out.println(thickestAndEldestCats(map));

    }

    public static Map<String,Cat> findCats(Breed breed, Map<String,Cat> map) {
        Map<String,Cat> cats = new TreeMap<>();
        for (Map.Entry<String,Cat> cat : map.entrySet()) {
            if(cat.getValue().getBreed() == breed) {
                cats.put(cat.getKey(),cat.getValue());
            }
        }
        return cats;
    }

    public static Map<String,Cat> findCatsThickerThan(int kg,Map<String,Cat> map) {
        Map<String,Cat> cats = new TreeMap<>();
        for(Map.Entry<String,Cat> cat : map.entrySet()) {
            if(cat.getValue().getWeight() > kg) {
                cats.put(cat.getKey(),cat.getValue());
            }
        }
        return cats;
    }

    public static Map<String,Cat> thickestAndEldestCats(Map<String,Cat> map) {
        Map<String,Cat> cats = new LinkedHashMap<>();
        SortedSet<Cat> catsByAge = new TreeSet<>((o1,o2) -> {
            int result = o2.getAge() - o1.getAge();
            if(result == 0) {
                result = Double.compare(o1.getWeight(),o2.getWeight());
                return result;
            }
            return result;
        });
        catsByAge.addAll(map.values());
        SortedSet<Cat> catsByWeight = new TreeSet<>(((o1, o2) -> {
            int result = Double.compare(o2.getWeight(),o1.getWeight());
            if(result == 0) {
                result = o2.getAge() - o1.getAge();
                return result;
            }
            return result;
        }));
        catsByWeight.addAll(map.values());

        if(catsByWeight.first() == catsByAge.first()) {
            for (Map.Entry<String,Cat> cat : map.entrySet()) {
                if(cat.getValue() == catsByWeight.first()) {
                    cats.put(cat.getKey(),cat.getValue());
                    return cats;
                }
            }
        } else {
            for(Map.Entry<String,Cat> cat : map.entrySet()) {
                if(cat.getValue() == catsByWeight.first() || cat.getValue() == catsByAge.first()) {
                    cats.put(cat.getKey(),cat.getValue());
                }
            }
        }
        return cats;
    }
}
