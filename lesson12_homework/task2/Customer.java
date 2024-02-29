package org.example.lesson12_homework.task2;

import org.example.lesson12_homework.task2.Brick;

import java.util.ArrayDeque;
import java.util.Queue;


public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private final Queue <Brick> queue= new ArrayDeque<>();
    public void requestBricks(int quantity) {
        Depot.getDepot().fetchBrickForCustomer(quantity,this);
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Queue<Brick> getQueue() {
        return queue;
    }
}
