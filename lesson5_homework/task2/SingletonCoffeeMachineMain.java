package org.example.lesson5_homework.task2;

public class SingletonCoffeeMachineMain {
    public static void main(String[] args) {
        CoffeeMachine p1 = CoffeeMachine.getInstance();
        CoffeeMachine.getInstance().getCoffee();
    }
}
