package org.example.homeworks.lesson26_homework.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class Task1 {
    // 1 уровень сложности: 1. У вас в магазине распродажа. К вам набежало 10 000 клиентов и вы пытаетесь корректно всех обслужить с учетом того,
    //что одновременно у вас внутри магазина может находиться не более 10 покупателей(согласно карантинным нормам)
    //и время обслуживания одного покупателя занимает 30 секунд (это время можно менять, чтобы увидеть окончание работы ;)). Сымитируйте данный процесс работы и
    //подсчитайте за какой период времени вы сможете обслужить данный объем покупателей?
    //Отдельный покупатель - отдельный поток. Какой синхронизатор с библиотеки concurrent Вы бы использовали?
    public static void main(String[] args)  {
        Semaphore semaphore = new Semaphore(10,true);
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 10_000; i++) {
            executor.execute(new Customer(semaphore,i));
        }
        executor.shutdown();
    }
}

class Customer implements Runnable {

    private Semaphore semaphore;
    private int id;

    public Customer(Semaphore semaphore,int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Customer " + this.id + " has been let inside");
            Thread.sleep(30);
            System.out.println("Customer " + this.id + " has bought something");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
