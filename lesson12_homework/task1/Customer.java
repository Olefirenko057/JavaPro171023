package org.example.lesson12_homework.task1;

import java.util.Stack;

public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private final Stack<Brick> stack = new Stack<>();
    public void requestBricks(int quantity) {
        Depot.getDepot().fetchBrickForCustomer(quantity,this);
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Stack<Brick> getStack() {
        return stack;
    }
}
