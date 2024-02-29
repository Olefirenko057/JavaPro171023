package org.example.lesson12_homework.task1;

import java.util.Scanner;
import java.util.Stack;

public class Depot {
     // 1 уровень сложности: 1) Вы работаете на складе, который продает один вид продукции, не имеющий сроков хранения, например кирпич.
     //У вас всего одни двери на складе, через которые вы загружаете новый товар и отгружаете заказчикам тоже через эту же дверь.
     //Как бы вы построили рабочий процесс на Вашем складе, какую бы коллекцию использовали для имитации процесса работы?
     //Напишите программу, которая бы имитировала работу.

    private class depotInstance {
        public static final Depot DEPOT_INSTANCE = new Depot();
    }

    public static Depot getDepot() {
        return depotInstance.DEPOT_INSTANCE;
    }
    private final Stack<Brick> brickStack = new Stack<>();
    public Brick addNewItem(Brick brick) {
        return brickStack.push(brick);
    }
    public Stack<Brick> fetchBrickForCustomer(int quantity, Customer customer) {
        int counter = 0;
        if(quantity <= brickStack.size()) {
            while (counter != quantity) {
                customer.getStack().push(this.brickStack.pop());
                counter++;
            }
            System.out.println("You have received " + quantity + " bricks");
        } else {
            Scanner sc = new Scanner(System.in);
            int result;
            if(brickStack.size() > 0) {
                while (true) {
                    if(brickStack.size() > 1) {
                        System.out.println("Unfortunately we don't have " + quantity + " bricks in stock");
                        System.out.println("Would you like to get " + brickStack.size() + " bricks?.These are all we have got[1 - yes, 2 - no]");
                        result = sc.nextInt();
                        if(result == 1) {
                            while (!brickStack.isEmpty()) {
                                customer.getStack().push(this.brickStack.pop());
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
        return customer.getStack();
    }

    public Stack<Brick> askForNewBricks(int quantity) {
        if(quantity <= 100) {
            for (int i = 0; i < quantity; i++) {
               addNewItem(new Brick());
            }
        }
        return brickStack;
    }
}
