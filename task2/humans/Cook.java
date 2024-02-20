package org.example.lesson10_homework.task2.humans;

import org.example.lesson10_homework.task2.ordersClasses.Order;
import org.example.lesson10_homework.task2.ordersClasses.OrdersStorage;

public class Cook extends Person{

    public Cook(String name, String surname) {
        super(name, surname);
    }

    public void cookStarters() {
        for (Order order : OrdersStorage.orders) {
            if(order.getStarter() != null) {
                System.out.println(order.getStarter() + " is being cooked for " + order.getClientName());
                System.out.println(order.getStarter() + " has been cooked");
                order.setStarter(null);
            }
        }
    }
    public void cookMainCourse() {
        for (Order order : OrdersStorage.orders) {
            if(order.getMainCourse() != null) {
                System.out.println(order.getMainCourse() + " is being cooked for " + order.getClientName());
                System.out.println(order.getMainCourse() + " has been cooked");
                order.setMainCourse(null);
            }
        }
    }
    public void cookDesserts() {
        for (Order order : OrdersStorage.orders) {
            if(order.getDessert() != null) {
                System.out.println(order.getDessert() + " is being cooked for " + order.getClientName());
                System.out.println(order.getDessert() + " has been cooked");
                order.setDessert(null);
            }
        }
    }

}
