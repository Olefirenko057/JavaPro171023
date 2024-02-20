package org.example.lesson10_homework.task2.ordersClasses;

import org.example.lesson10_homework.task2.ordersClasses.Order;

import java.util.LinkedHashSet;
import java.util.Set;

public class OrdersStorage {

    public static Set<Order> orders = new LinkedHashSet<>();
    public static Set<Order> activeOrders = new LinkedHashSet<>();

    public static void deleteCompletedOrders() {
        for (Order order : orders) {
            if(order.getStarter() == null && order.getDessert() == null && order.getStarter() == null && order.getDrink() == null) {
                order.getWaiter().getClients().remove(order.getClient());
                activeOrders.remove(order);
            }
        }
    }
}
