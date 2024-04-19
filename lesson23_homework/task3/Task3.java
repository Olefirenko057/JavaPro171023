package org.example.homeworks.lesson23_homework.task3;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        //3*. Запустите в 3 потока просчет количества всех простых чисел в интервале от 2 до 1000000.
        //Через 5 секунд завершите принудительно выполнение 1-го потока командой из главного.
        //Через 10 секунд завершите и 2-й поток.
        //Через 15 секунд - 3-й поток.
        //Время подкорректируйте под скорость своего компьютера.
        int min = 2;
        int max = 1_000_000;
        int chunk = (max - min + 1) / 3;
        int start = min;
        int end = start + chunk;
        MyThread[] threads = new MyThread[3];
        for (int i = 0; i < threads.length; i++) {
            if(i + 1 == threads.length) {
                end = max;
            }
            threads[i] = new MyThread(start,end);
            threads[i].start();
            start = end;
            end = start + chunk;
        }
        Thread.sleep(50);
        threads[0].interrupt();
        Thread.sleep(50);
        threads[1].interrupt();
        Thread.sleep(50);
        threads[2].interrupt();
    }


}

class MyThread extends Thread {
    private int start;
    private int end;
    private int currentNumber;
    private int count;
    public MyThread(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public void run() {
        for (int i = start; i < end ; i++) {
                if (isPrime(i)) {
                    count++;
                }
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " interrupted. It was interrupted at number " + i + "(" + start + "-" + end +")." + " Count: " + count);
                    return;
                }
        }
        System.out.println(Thread.currentThread().getName() + " has finished its execution. Count: " + count + " " + start + "-" + end);
    }

    public boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
