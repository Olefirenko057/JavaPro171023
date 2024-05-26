package org.example.homeworks.lesson25_homework.task2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Task2 {
    //2*. На склад приезжает машина, в которой загружено N ящиков (пользователь вводит с клавиатуры).
    //Автоматизированный разгрузчик вытягивает с машины ящик и кладет на рампу с определенным интервалом времени, на которой может одновременно разместиться например 2 ящика.
    //В это время подъезжает автоматизированный погрузчик и везет его на место хранения. Он за раз может взять всего 1 ящик. Каждый участник процесса представлен в виде отдельного потока Java.
    //Создайте программу, которая синхронизирует работу в данном процессе разгрузки автомобиля, с условием того, что Разгрузчик может быть только один, а Погрузчиков может быть 2 и более (на ваше усмотрение).
    public static void main(String[] args) throws InterruptedException {
        Stack<Box> boxes = new Stack<>();
        boxes.add(new Box());
        boxes.add(new Box());
        boxes.add(new Box());
        boxes.add(new Box());
        boxes.add(new Box());
        boxes.add(new Box());

        Truck truck = new Truck(boxes);
        Ramp ramp = new Ramp(new ArrayDeque<>());
        Unload unload = new Unload(truck,ramp);
        Load load = new Load(ramp,unload);
        Load load2 = new Load(ramp,unload);
        truck.start();
        unload.start();
        load.start();
        load2.start();

        truck.join();
        unload.join();
        load.join();
        load2.join();
    }

}

class Unload extends Thread {
    private Truck truck;
    private Ramp ramp;
    private boolean isActive = true;
    public Unload(Truck truck,Ramp ramp) {
        this.truck = truck;
        this.ramp = ramp;
    }
    private Box getBoxFromTheTruck() {
        synchronized (truck) {
            while (!truck.isHasArrived() || truck.getBoxes().isEmpty()) {
                try {
                    truck.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Box currentBox = truck.getBoxes().pop();
            return currentBox;
        }
    }
    public void putBoxOnTheRamp() {
        while (isActive) {
            Box currentBox = getBoxFromTheTruck();
            synchronized (ramp) {
                while (ramp.getBoxes().size() >= 2) {
                    try {
                        ramp.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                ramp.getBoxes().offer(currentBox);
                System.out.println("Box has been put");
                ramp.notifyAll();
            }
            if(truck.getBoxes().isEmpty()) {
                isActive = false;
            }
        }
    }

    @Override
    public void run() {
        putBoxOnTheRamp();
    }

    public boolean isActive() {
        return isActive;
    }
}

class Load extends Thread {
    private Ramp ramp;
    private Unload unload;

    public Load(Ramp ramp, Unload unload) {
        this.ramp = ramp;
        this.unload = unload;
    }

    public void getBoxFromTheRamp() {
            while (unload.isActive()) {
                synchronized (ramp) {
                    while (ramp.getBoxes().isEmpty()) {
                        try {
                            ramp.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    ramp.getBoxes().poll();
                    System.out.println("Box has been taken away by " + Thread.currentThread().getName());
                    ramp.notifyAll();
                }
            }
     }
    @Override
    public void run() {
        getBoxFromTheRamp();
    }
}

class Ramp {
    private Queue<Box> boxes;

    public Ramp(Queue<Box> boxes) {
        this.boxes = boxes;
    }

    public Queue<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(Queue<Box> boxes) {
        this.boxes = boxes;
    }
}

class Truck extends Thread {
    private boolean hasArrived;
    private Stack<Box> boxes;
    public Truck(Stack<Box> boxes) {
        this.hasArrived = true;
        this.boxes = boxes;
    }
    public void arrive() {
        synchronized (this) {
            hasArrived = true;
            notifyAll();
        }
    }

    @Override
    public void run() {
        arrive();
    }

    public Stack<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(Stack<Box> boxes) {
        this.boxes = boxes;
    }
    public boolean isHasArrived() {
        return hasArrived;
    }
}

class Box {
    private final int weight = 10;
}



