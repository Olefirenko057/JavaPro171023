package org.example.homeworks.lesson26_homework.task2;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Guide implements Runnable {
    CountDownLatch countDownLatch;
    private List<String> list;
    private AtomicInteger peopleOnTheBus;

    public Guide(CountDownLatch countDownLatch, List<String> list, AtomicInteger peopleOnTheBus) {
        this.countDownLatch = countDownLatch;
        this.list = list;
        this.peopleOnTheBus = peopleOnTheBus;
    }

    @Override
    public void run() {
        while (peopleOnTheBus.get() != list.size()) {
            int oldValue = peopleOnTheBus.get();
            while (oldValue == peopleOnTheBus.get()) {

            }
            countDownLatch.countDown();
        }
        System.err.println("There is guide's permission to go!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        countDownLatch.countDown();
    }

    public AtomicInteger getPeopleOnTheBus() {
        return peopleOnTheBus;
    }
}
