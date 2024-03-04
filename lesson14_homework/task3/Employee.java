package org.example.lesson14_homework.task3;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

//3**) У нас есть профессия в строительстве - чернорабочий. Он может выполнять любые низкоквалифицированные
//        работы на стройке. На каждый день ему дается список работ, которые он должен выполнить, но не факт
//        что в течении рабочего времени его задание может измениться.
//        Напишите программу рабочего дня профессии, которая позволяет динамический давать ему задание на работу,
//        в любое нужное время. И он их должен выполнять. Применяйте функциональные интерфейсы.
public class Employee{
    private String name;
    private int age;
    private double hoursWorked;
    private PriorityQueue<Tasks> tasks;

    private Manager manager = new Manager("Tom",40);

    public Employee(String name, int age, PriorityQueue<Tasks> tasks) {
        this.name = name;
        this.age = age;
        this.tasks = tasks;
    }
    public void completeDailyTasks(PriorityQueue<Tasks> tasks) {
        manager.manageEmployee(this,tasks);
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public PriorityQueue<Tasks> getTasks() {
        return tasks;
    }

    public Manager getManager() {
        return manager;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setTasks(PriorityQueue<Tasks> tasks) {
        this.tasks = tasks;
    }
}
