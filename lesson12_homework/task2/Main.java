package org.example.lesson12_homework.task2;

import org.example.lesson12_homework.task2.Customer;
import org.example.lesson12_homework.task2.Depot;

public class Main {

    public static void main(String[] args) {
       Customer customer1 = new Customer("Albert",30);
        customer1.requestBricks(5);

        System.out.println();

        Depot.getDepot().askForNewBricks(10);
        customer1.requestBricks(5);
        System.out.println(customer1.getQueue());

        System.out.println();

        Customer customer2 = new Customer("Robert",45);
        customer2.requestBricks(10);

        System.out.println(customer1.getQueue().size());
        System.out.println(customer2.getQueue().size());
    }

}
