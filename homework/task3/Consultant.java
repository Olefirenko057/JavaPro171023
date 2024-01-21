package org.example.de.telran.lesson2.homework.task3;

public class Consultant extends Employee{
    public Consultant(String name, int age, int yearsOfExperience) {
        super(name, age, yearsOfExperience);
    }

    @Override
    public void work() {
        System.out.println(getName() + " advices people on IT. He gets " + getSalary() + "$ per month");
    }
}
