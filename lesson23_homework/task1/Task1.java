package org.example.homeworks.lesson23_homework.task1;

public class Task1 {
    // 1 уровень сложности: 1. Запустите в 3 потока просчет суммы всех чисел, который без остатка делятся на 17  в интервале от 0 до 10 млн. Показывайте на экран, как будет накапливаться сумма по каждому потоку.
    //После запуска просчета, главный поток остановите на 1 секунду и завершите его. Все дочерние потоки должны автоматически закрыться.
    public static void main(String[] args) throws InterruptedException {
        int target = 17;
        int min = 0;
        int max = 10_000_000;
        int threadsQuantity = 3;
        int gapNumber = (max - min + 1) / threadsQuantity;
        int start = min;
        int end;
        int i = 0;
        MyThread[] threads = new MyThread[3];
        while (i < threads.length) {
            end = start + gapNumber;
            if(i + 1 == threads.length) {
                end = max;
            }
            threads[i] = new MyThread(start,end,target);
            threads[i].setDaemon(true);
            threads[i].start();
            start = gapNumber;
            i++;
        }
//        for (MyThread thread : threads) {
//            System.out.println(thread.getName() + ": " + thread.getStartPoint() + "-" + thread.getEndPoint());
//        }
        Thread.sleep(1000);
        System.out.println("Main Thread is terminated");
    }
}

class MyThread extends Thread {
    private final int startPoint;
    private final int endPoint;
    private final int targetNumber;
    private int sum;

    public MyThread(int startPoint, int endPoint, int targetNumber) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.targetNumber = targetNumber;
    }

    public void run() {
        for (int i = startPoint; i < endPoint ; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i % targetNumber == 0) {
                sum += i;
                System.out.println(Thread.currentThread().getName() + " - " + sum);
            }
        }
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

}
