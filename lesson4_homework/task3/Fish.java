package org.example.lesson4_homework.task3;

import org.w3c.dom.ls.LSOutput;

public class Fish implements Swim {
    private String type;
    private double weight;

    public Fish(String type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public void swim() {
        System.out.println(type + " is swimming " + ((weight < 4) ? "fast" : "slowly"));
    }
}
