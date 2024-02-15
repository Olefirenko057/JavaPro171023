package org.example.lesson9_homework.task1;

import org.example.lesson9_homework.task1.Animal;

import java.util.*;

public class Limpopo {
    public List<Animal> animals = new LinkedList<>();

    public Limpopo() {
        initializeAnimals();
    }

    private void initializeAnimals() {
        for (int i = 0; i < 10_000_000; i++) {
            animals.add(new Animal());
        }
    }

    public int changeQuantityOfAnimals() {
        ListIterator<Animal> listIterator;
        int j = 0;
        while(j < 10) {
            int res  = animals.size() / 1000;
            int plusAnimalsPerYear = res * 6;
            for (int i = 0; i < plusAnimalsPerYear; i++) {
                animals.add(new Animal());
            }

//            int initialSize = animals.size();
//            listIterator = animals.listIterator();
//            while (listIterator.hasNext() && listIterator.nextIndex() < initialSize) {
//                int currentIndex = listIterator.nextIndex();
//                listIterator.next();
//                if (currentIndex % 3 == 0 && currentIndex != 0) {
//                    for (int i = 0; i < 14; i++) {
//                        listIterator.add(new Animal());
//                        listIterator.previous();
//                    }
//                    for (int i = 0; i < 8; i++) {
//                        listIterator.next();
//                        listIterator.remove();
//                    }
//                }
//            }
            j++;
        }
        return animals.size();
    }




}
