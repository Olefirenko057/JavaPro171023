package org.example.lesson6_homework.task1;

public class MainCalculator {
    public static void main(String[] args) {
        Calculator<Integer,Double> pair1 = new MathOperationsClass<>();
        pair1.add(5,7.5);
        pair1.div(13,6.5);

        Calculator<Double,Double> pair2 = new MathOperationsClass<>();
        pair2.add(22.2,13.1);
        pair2.multi(12.0,12.5);

        Calculator<Float,Integer> pair3 = new MathOperationsClass<>();
        pair3.sub(35f,78);
        pair3.multi(5f,10);

    }
}
