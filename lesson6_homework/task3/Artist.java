package org.example.lesson6_homework.task3;

public abstract class Artist {
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    abstract public void showTalent();

    public String getName() {
        return name;
    }
}
