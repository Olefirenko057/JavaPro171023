package org.example.lesson6_homework.task3;

public class Clown extends Artist{
    public Clown(String name) {
        super(name);
    }

    @Override
    public void showTalent() {
        System.out.println(getClass().getSimpleName()+ " " + getName() + " is on the stage and he makes people laugh");
    }
}
