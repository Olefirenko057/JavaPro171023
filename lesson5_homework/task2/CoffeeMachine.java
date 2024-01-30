package org.example.lesson5_homework.task2;

import java.util.Scanner;

public class CoffeeMachine {
    public static CoffeeTypes[] coffeeTypes = CoffeeTypes.values();
    public static volatile CoffeeMachine instance;

    private CoffeeMachine() {
    }

    public static CoffeeMachine getInstance() {
        if(instance == null) {
            synchronized (CoffeeMachine.class) {
                if(instance == null) {
                    instance = new CoffeeMachine();
                    return instance;
                }
            }
        }
        return instance;
    }

    public void getCoffee() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Which coffee would you like to get?");
            System.out.println("[0 - cappuccino, 1 - espresso, 2 - americano, 3 - double espresso, 4 - latte]");
            int temp = sc.nextInt();
            switch (temp) {
                case 0:
                    System.out.println("You get your " + CoffeeTypes.CAPPUCCINO);
                    break;
                case 1:
                    System.out.println("You get your " + CoffeeTypes.ESPRESSO);
                    break;
                case 2:
                    System.out.println("You get your " + CoffeeTypes.AMERICANO);
                    break;
                case 3:
                    System.out.println("You get your " + CoffeeTypes.DOUBLE_ESPRESSO);
                    break;
                case 4:
                    System.out.println("You get your " + CoffeeTypes.LATTE);
                    break;
                default:
                    System.out.println("Wrong value");
            }
    }
}
