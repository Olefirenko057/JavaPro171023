package org.example.lesson4_homework.task3;

public class Human implements Swim {
    private String fullName;
    private int age;

    public Human(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    @Override
    public void swim() {
        System.out.println(fullName + " is swimming");
    }
}
