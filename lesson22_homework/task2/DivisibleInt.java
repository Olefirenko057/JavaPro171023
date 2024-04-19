package org.example.homeworks.lesson22_homework.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DivisibleInt {
    //.Посчитайте количество всех целых чисел в диапазоне от Integer.MINVALUE до Integer.MAXVALUE,
    //которые делятся на введенное пользователем число number без остатка.
    //Просчитайте время, которое необходимо для вычисления данного результата в одном потоке.
    //Просчитайте время, которое необходимо пользователю для выполнения этих задачи параллельно,
    //количество создаваемых потоков countThreads пользователь тоже должен ввести вручную .
    public static void main(String[] args) throws InterruptedException {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int res = scanner.nextInt();
        divisibleByNumSingleThread(res,min,max);

        System.out.println("Enter the count of threads");
        int threadsCount = scanner.nextInt();
        long rangeSize =  (long)max - (long)min + 1;
        int gapNumber = (int)(rangeSize/threadsCount);
        List<MyThread> threads = new ArrayList<>();
        int left = min;
        int right = left + gapNumber - 1 ;
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadsCount ; i++) {
            if(i + 1 == threadsCount) {
                right = max;
            }
            MyThread myThread = new MyThread(left,right,res);
            threads.add(myThread);
            myThread.start();

            left = right;
            right = left + gapNumber - 1;
        }

        for(MyThread thread : threads) {
            thread.join();
        }
        int totalQuantity = 0;
        for (MyThread thread : threads) {
            totalQuantity += thread.getQuantity();
        }
        System.out.println("It took " + ((System.currentTimeMillis() - start) + " milliseconds sec to find " + totalQuantity + " appropriate numbers"));
    }


    public static void divisibleByNumSingleThread(int num,int min,int max) {
        long start = System.currentTimeMillis();
        int quantity = 0;
        if(num != 0 && num != 1) {
            for (int i = min ; i < max; i++) {
                if (i % num == 0) {
                    quantity++;
                }
            }
        }
        System.out.println("It took " + ((System.currentTimeMillis() - start) + " milliseconds sec to find " + quantity + " appropriate numbers"));
    }



}
class MyThread extends Thread {
    private int leftBoundary;
    private int rightBoundary;
    private int keyNumber;
    private int quantity;

    public MyThread(int leftBoundary, int rightBoundary,int keyNumber) {
        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
        this.keyNumber = keyNumber;
    }

    @Override
    public void run() {
        for (int i = leftBoundary; i < rightBoundary ; i++) {
            if(i % keyNumber == 0) {
                quantity++;
            }
        }
    }

    public int getLeftBoundary() {
        return leftBoundary;
    }

    public int getRightBoundary() {
        return rightBoundary;
    }

    public int getKeyNumber() {
        return keyNumber;
    }

    public int getQuantity() {
        return quantity;
    }
}



