package org.example.homeworks.lesson25_homework.task1;

import java.util.*;

public class Robot {
    // 1 уровень сложности: 1. У вас есть стол, на который один робоманипулятор кладет деталь, а второй забирает эту деталь.
    // Когда Робот1 положит деталь на стол, он должен обязательно ждать, пока Робот2 заберет эту деталь и только тогда класть следующую. Постройте программу, которая автоматизирует эту работу.
    //Количество деталей, которые должны обработать манипуляторы, пользователь задает с клавиатуры.
    public static void main(String[] args) {
        Table table = new Table();
        Robot1 robot1 = new Robot1(table);
        Robot2 robot2 = new Robot2(table);
    }

}
class Item {
    private int id;

    public Item(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                '}';
    }
}

class Table {
   private Stack<Item> items;
   private boolean hasItem = false;
   private Item currentItemOnTheTable;
    public Table() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of items");
        int quantity = 0;
        try {
            quantity = scanner.nextInt();
            if(quantity > 10 || quantity < 2) {
                throw new RuntimeException();
            }
        } catch (RuntimeException exception) {
            quantity = 2;
        }
        items = new Stack<>();
        for (int i = 0; i < quantity; i++) {
            items.add(new Item(i));
        }
    }

    public synchronized void put(Item item) {
        if(hasItem) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentItemOnTheTable = item;
        System.out.println(currentItemOnTheTable + " has been put on the table");
        hasItem = true;
        notify();
    }

    public synchronized void take() {
        if(!hasItem) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(currentItemOnTheTable + " has been taken away from the table");
        hasItem = false;
        notify();
    }

    public Stack<Item> getItems() {
        return items;
    }
}

class Robot1 implements Runnable {
    private Table table;

    public Robot1(Table table) {
        this.table = table;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!table.getItems().isEmpty()) {
            table.put(table.getItems().pop());
        }
    }
}

class Robot2 implements Runnable {
    private Table table;

    public Robot2(Table table) {
        this.table = table;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int initialItemsQuantity = table.getItems().size();
        for (int i = 0; i <= initialItemsQuantity; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            table.take();
        }
    }
}
