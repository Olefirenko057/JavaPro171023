package org.example.lesson10_homework.task2;

import org.example.lesson10_homework.task2.enumsForOrders.Desserts;
import org.example.lesson10_homework.task2.enumsForOrders.Drinks;
import org.example.lesson10_homework.task2.enumsForOrders.MainCourse;
import org.example.lesson10_homework.task2.enumsForOrders.Starters;
import org.example.lesson10_homework.task2.humans.Bartender;
import org.example.lesson10_homework.task2.humans.Client;
import org.example.lesson10_homework.task2.humans.Cook;
import org.example.lesson10_homework.task2.humans.Waiter;
import org.example.lesson10_homework.task2.ordersClasses.Order;
import org.example.lesson10_homework.task2.ordersClasses.OrdersStorage;

public class Main {
    public static void main(String[] args) {
        Waiter waiter1 = new Waiter("Milana","Joe");
        Waiter waiter2 = new Waiter("Martin","Kno");

        Client client1 = new Client("Johny","Stevens");
        Client client2 = new Client("Ju","Po");
        Client client3 = new Client("Boris","Ivani");
        Client client4 = new Client("Lama","Stevens");

        Cook startersCook = new Cook("Steven","Johnson");
        Cook mainCourseCook = new Cook("Viktoria","Baumann");
        Cook dessertsCook = new Cook("Ivan","Nikolic");
        Bartender bartender = new Bartender("Max","Dustin");


        client1.placeAnOrder(waiter1,new Order(Desserts.BISCUITS,Drinks.COLA, Starters.CARPACCIO,MainCourse.BURGER));
        client2.placeAnOrder(waiter1,new Order(null,Drinks.COLA, Starters.CARPACCIO,MainCourse.BURGER));
        System.out.println(OrdersStorage.orders);
        System.out.println(waiter1);

        startersCook.cookStarters();
        mainCourseCook.cookMainCourse();
        dessertsCook.cookDesserts();
        bartender.pourDrinks();
        OrdersStorage.deleteCompletedOrders();
        System.out.println(waiter1);

        System.out.println(OrdersStorage.orders);
        System.out.println(OrdersStorage.activeOrders);


        client3.placeAnOrder(waiter2,new Order(Desserts.CHOCOLATE_CAKE,Drinks.COLA, Starters.CHICKEN_SOUP,MainCourse.PIZZA));
        client4.placeAnOrder(waiter1,new Order(Desserts.ICE_CREAM,Drinks.APPLE_JUICE, Starters.SALAD_OF_VEGETABLES,MainCourse.GRILLED_SALMON));
        System.out.println(waiter2);
        System.out.println(waiter1);

        System.out.println(OrdersStorage.orders);
        System.out.println(OrdersStorage.activeOrders);

        startersCook.cookStarters();
        mainCourseCook.cookMainCourse();
        dessertsCook.cookDesserts();
        bartender.pourDrinks();
        OrdersStorage.deleteCompletedOrders();


        System.out.println(OrdersStorage.orders);
        System.out.println(OrdersStorage.activeOrders);
    }
}
