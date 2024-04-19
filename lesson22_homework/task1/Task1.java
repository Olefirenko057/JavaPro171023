package org.example.homeworks.lesson22_homework.task1;

import java.util.Scanner;

public class Task1 {
    //. Пользователь с клавиатуры вводит цифру. Вы создаете динамически нужное количество потоков равное
    //введенной цифре, нумеруете их и запускаете на выполнение.
    //Каждый поток должен выводить свой номер на экран 100 раз с интервалом 100 миллисекунд перед каждым выводом.
    //Сделайте так, чтобы главный поток выполнения программы не завершился до окончания работы всех дочерних потоков.
    public static void main(String[] args) throws InterruptedException {
        int threadsCount = 0;
        System.out.println("Enter the count of threads");
        Scanner scanner = new Scanner(System.in);
        threadsCount = scanner.nextInt();
        for (int i = 0; i < threadsCount; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
            myThread.join();
        }
        System.out.println("The main thread has been terminated");
    }
}

class MyThread extends Thread{
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + (i + 1));
        }
    }
}
