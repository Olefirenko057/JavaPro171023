package org.example.lesson10_homework.task2.humans;

import org.example.lesson10_homework.task2.ordersClasses.Order;
import org.example.lesson10_homework.task2.ordersClasses.OrdersStorage;


public class Bartender extends Person{
    public Bartender(String name, String surname) {
        super(name, surname);
    }

    public void pourDrinks() {
        for (Order order : OrdersStorage.orders) {
            if(order.getDrink() != null) {
                System.out.println(order.getDrink() + " is being poured for " + order.getClientName());
                System.out.println(order.getDrink() + " has been poured and is ready");
                order.setDrink(null);
            }
        }
    }
}
