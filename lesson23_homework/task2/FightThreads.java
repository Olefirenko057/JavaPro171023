package org.example.homeworks.lesson23_homework.task2;

import java.util.Scanner;

 class ThreadsArgument {
         //2*. Создайте 2 потока (1 - Курица, 2 - Яйцо).
    //Первый будет постоянно выводить слово "Курица" и останавливаться на 1 сек.
    //Второй будет постоянно выводить слово "Яйцо" и тоже останавливаться на 1 сек.
    //Главный поток выводит на экран сообщение "Кто же первый? " и запускает оба дочерних потока.
    //Потом главный поток спрашивает у пользователя: "Кто же прав?"
    //Если пользователь вводит 1, главный поток выключает поток, который выводит "Яйцо".
    //Если вводит 2, главный поток выключает дочерний поток, который выводит "Курица".
    //Иначе выключает оба потока и возвращает фразу "Как же вы надоели!"
     public static void main(String[] args) throws InterruptedException {;
         Chicken chickenThread = new Chicken();
         Egg eggThread = new Egg();
         System.out.println("Who was first?");
         chickenThread.start();
         eggThread.start();

         Thread.sleep(5000);
         Thread.currentThread().setPriority(6);
         System.out.println("Who is right?[1 - chicken][2 - egg]");
         Scanner scanner = new Scanner(System.in);
         int res = scanner.nextInt();
         if(res == 1) {
             eggThread.interrupt();
             Thread.sleep(1000);
             chickenThread.interrupt();
             System.out.println("Chicken is a right option!");
         } else if(res == 2) {
             chickenThread.interrupt();
             Thread.sleep(1000);
             eggThread.interrupt();
             System.out.println("Egg is a right option!");
         } else {
             System.out.println("You are annoying!");
             eggThread.interrupt();
             chickenThread.interrupt();
         }
     }

     static class Chicken extends Thread {
         public void run() {
             while (!Thread.interrupted()) {
                 System.out.println(getClass().getSimpleName());
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     Thread.currentThread().interrupt();
                 }
             }
         }
     }

     static class Egg extends Thread {
         public void run() {
             while(!Thread.interrupted()) {
                 System.out.println(getClass().getSimpleName());
                 try {
                     sleep(1000);
                 } catch (InterruptedException e) {
                     Thread.currentThread().interrupt();
                 }
             }
         }
     }
}

