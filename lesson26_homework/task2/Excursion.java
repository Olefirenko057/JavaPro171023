package org.example.homeworks.lesson26_homework.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Excursion {
    //2*. Вы едете на экскурсию. Каждый человек, при входе в автобус, называет свою фамилию.
    //Экскурсовод ставит у себя в блокноте птичку и если количество людей по списку совпадает
    //автобус уезжает на экскурсию. Сымитируйте данный процесс работы.
    //Какой синхронизатор с библиотеки concurrent Вы бы использовали для данного процесса?
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<String> touristsNames = List.of("Ivan","Nelly","Viktoria","Mark","Tom","Ivana","Monika","Steve");
        CountDownLatch countDownLatch = new CountDownLatch(9);
        Guide guide = new Guide(countDownLatch,touristsNames,atomicInteger);
        List<Tourist> tourists = List.of(
                new Tourist("Ivan",countDownLatch,guide),
                new Tourist("Nelly",countDownLatch,guide),
                new Tourist("Viki",countDownLatch,guide),
                new Tourist("Mark",countDownLatch,guide),
                new Tourist("Tom",countDownLatch,guide),
                new Tourist("Ivana",countDownLatch,guide),
                new Tourist("Monika",countDownLatch,guide),
                new Tourist("Steve",countDownLatch,guide)
        );
        new Thread(guide).start();
        for (int i = 0; i < tourists.size(); i++) {
            new Thread(tourists.get(i)).start();
        }
    }
}

