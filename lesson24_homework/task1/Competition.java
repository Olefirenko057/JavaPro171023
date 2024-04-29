package org.example.homeworks.lesson24_homework.task1;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Competition {
    // 1 уровень сложности: 1. На соревнованиях 5 спортсменов начинают одновременно стрелять в одну мишень.
    //Если кто-нибудь в нее попадает(сделать Random-но), то мишень разрушается и другие в нее уже попасть не могут,
    //но что-то пошло не так. Исправь программу, чтобы другие потоки "видели" изменения значения
    //переменной isHit и больше его не меняли. Как только мишень разрушена кем то из стрелков,
    //соревнования прекращаются. Воспользуйся классом AtomicBoolean и его методами.
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Participant participant1 = new Participant("Ivan",atomicBoolean);
        Participant participant2 = new Participant("Alex",atomicBoolean);
        Participant participant3 = new Participant("Tom",atomicBoolean);
        Participant participant4 = new Participant("Marry",atomicBoolean);
        Participant participant5 = new Participant("Steve",atomicBoolean);
        Thread thread1 = new Thread(participant1);
        Thread thread2 = new Thread(participant2);
        Thread thread3 = new Thread(participant3);
        Thread thread4 = new Thread(participant4);
        Thread thread5 = new Thread(participant5);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

class Participant implements Runnable {
    private String name;
    private AtomicBoolean isHit;
    public Participant(String name, AtomicBoolean isHit) {
        this.name = name;
        this.isHit = isHit;
    }

    @Override
    public void run() {
        Random random = new Random();
            while (!isHit.get()) {
                System.out.println(name + " has fired");
                if (random.nextInt(2) == 0) {
                    synchronized (isHit) {
                        if(!isHit.get()) {
                            System.out.println(name + " has hit the target. The competition is over");
                            isHit.set(true);
                        }
                    }
                } else {
                    System.out.println(name + " has missed. Play on!");
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        System.out.println(name + " can't fire. No target found");
    }
}
