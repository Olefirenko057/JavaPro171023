package org.example.lesson10_homework.task2.ordersClasses;

import org.example.lesson10_homework.task2.enumsForOrders.Desserts;
import org.example.lesson10_homework.task2.enumsForOrders.Drinks;
import org.example.lesson10_homework.task2.enumsForOrders.MainCourse;
import org.example.lesson10_homework.task2.enumsForOrders.Starters;
import org.example.lesson10_homework.task2.humans.Client;
import org.example.lesson10_homework.task2.humans.Waiter;

public class Order {
    //2)* В ресторане официанты подают заказы Order на кухню. Очень важно чтобы заказы брались в работу поварами строго в том порядке,
    //в котором они были переданы на кухню. Создайте множество (Set) заказов, которые будут передаваться на кухню официантом и реализуйте
    //механизм взятия в работу этих заказом поваром.
    //Используйте LinkedHashSet для решения этой задачи.
    //Характеристики Order определите самостоятельно.
    private Desserts dessert;
    private Drinks drink;
    private Starters starter;
    private MainCourse mainCourse;
    private Waiter waiter;
    private Client client;
    private int orderId;
    private String clientName;


    public Order(Desserts dessert, Drinks drink, Starters starter, MainCourse mainCourse) {
        this.dessert = dessert;
        this.drink = drink;
        this.starter = starter;
        this.mainCourse = mainCourse;
    }

    public Desserts getDessert() {
        return dessert;
    }

    public Drinks getDrink() {
        return drink;
    }

    public Starters getStarter() {
        return starter;
    }

    public MainCourse getMainCourse() {
        return mainCourse;
    }

    public void setDessert(Desserts dessert) {
        this.dessert = dessert;
    }

    public void setDrink(Drinks drink) {
        this.drink = drink;
    }

    public void setStarter(Starters starter) {
        this.starter = starter;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        return getOrderId() == order.getOrderId();
    }

    @Override
    public int hashCode() {
        return getOrderId();
    }

    @Override
    public String toString() {
        return "Order{" +
                "dessert=" + dessert +
                ", drink=" + drink +
                ", starter=" + starter +
                ", mainCourse=" + mainCourse +
                ", orderId=" + orderId +
                '}';
    }
}
