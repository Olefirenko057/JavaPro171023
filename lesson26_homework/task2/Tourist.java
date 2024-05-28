package org.example.homeworks.lesson26_homework.task2;

import java.util.concurrent.CountDownLatch;

public class Tourist implements Runnable {
    private String name;
    private CountDownLatch countDownLatch;
    private Guide guide;

    public Tourist(String name, CountDownLatch countDownLatch, Guide guide) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.guide = guide;
    }

    @Override
    public void run() {
        System.out.println(this.name + " boards the bus");
        System.out.println(this.name + " is waiting for others");
        guide.getPeopleOnTheBus().incrementAndGet();
//        guide.countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.name + " is finally on the way");
    }
}
