package org.example.lesson10_homework.task2.humans;

import org.example.lesson10_homework.task2.ordersClasses.Order;

public class Client extends Person {

    private int clientId;
    public Client(String name, String surname) {
        super(name, surname);
    }
    public void placeAnOrder(Waiter waiter, Order order) {
        order.setClient(this);
        order.setWaiter(waiter);
        waiter.acceptOrder(this,order);
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;

        return clientId == client.clientId;
    }

    @Override
    public int hashCode() {
        return clientId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                '}';
    }
}
