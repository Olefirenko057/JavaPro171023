package org.example.lesson10_homework.task2.humans;

import org.example.lesson10_homework.task2.ordersClasses.Order;
import org.example.lesson10_homework.task2.ordersClasses.OrdersStorage;

import java.util.HashSet;
import java.util.Set;

public class Waiter extends Person {
    protected Set<Client> clients = new HashSet<>();
    public Waiter(String name, String surname) {
        super(name, surname);
    }

    protected void acceptOrder(Client client, Order order) {
        client.setClientId(OrdersStorage.orders.size() + 1);
        clients.add(client);
        order.setClientName(client.getName());
        order.setOrderId(OrdersStorage.orders.size() + 1);
        OrdersStorage.orders.add(order);
        OrdersStorage.activeOrders.add(order);
    }

    public Set<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "clients=" + clients +
                '}';
    }
}
