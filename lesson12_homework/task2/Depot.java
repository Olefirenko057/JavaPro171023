package org.example.lesson12_homework.task2;

import org.example.lesson12_homework.task2.Brick;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Depot {
    //2)* Тот же склад, что и в случае п.1 но у Вас есть две двери - одна в начале склада, вторая в конце.
    //
    //Как бы вы построили оптимальный рабочий процесс на Вашем складе, какую бы коллекцию использовали для имитации процесса работы?
    //
    //Напишите программу, которая бы имитировала работу.
    private class DepotInstance {
        public static final Depot DEPOT_INSTANCE = new Depot();
    }

    public static Depot getDepot() {
        return DepotInstance.DEPOT_INSTANCE;
    }
    private final Deque<Brick> brickArrayDeque = new ArrayDeque<>();
    public void addNewItem(Brick brick) {
         brickArrayDeque.offerLast(new Brick());
    }
    public Deque<Brick> fetchBrickForCustomer(int quantity, Customer customer) {
        int counter = 0;
        if(quantity <= brickArrayDeque.size()) {
            while (counter != quantity) {
                customer.getQueue().offer(brickArrayDeque.pollFirst());
                counter++;
            }
            System.out.println("You have received " + quantity + " bricks");
        } else {
            Scanner sc = new Scanner(System.in);
            int result;
            if(brickArrayDeque.size() > 0) {
                while (true) {
                    if(brickArrayDeque.size() > 1) {
                        System.out.println("Unfortunately we don't have " + quantity + " bricks in stock");
                        System.out.println("Would you like to get " + brickArrayDeque.size() + " bricks?.These are all we have got[1 - yes, 2 - no]");
                        result = sc.nextInt();
                        if(result == 1) {
                            while (!brickArrayDeque.isEmpty()) {
                                customer.getQueue().offer(brickArrayDeque.pollFirst());
                                counter++;
                            }
                            System.out.println("You have received " + counter + " bricks");
                            break;
                        } else if(result == 2) {
                            System.out.println("Goodbye!");
                            break;
                        } else {
                            System.out.println("Wrong answer. Try one more time");
                        }
                    } else {
                        System.out.println("Would you like to get " + quantity + " brick.This is all we have got[1 - yes, 2 - no]");
                    }
                }
            } else {
                System.out.println("Unfortunately , we don't have any bricks available now");
            }
        }
        return (Deque<Brick>) customer.getQueue();
    }

    public Deque<Brick> askForNewBricks(int quantity) {
        if(quantity <= 100) {
            for (int i = 0; i < quantity; i++) {
                this.brickArrayDeque.offerLast(new Brick());
            }
        }
        return brickArrayDeque;
    }
}
