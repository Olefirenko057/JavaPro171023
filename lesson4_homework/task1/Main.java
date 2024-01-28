package org.example.lesson4_homework.task1;

public class Main {
    public static void main(String[] args) {
        UtileClass utileClass = new UtileClass();
        utileClass.getValues(5,6);
        utileClass.getValues(1.5,7.2);
        utileClass.getValues(14.7,6);
        utileClass.getValues(new Integer[]{6,25,4,98});
        utileClass.getValues(new Double[]{9.6,10.0,7.1,9.2,19.8});
    }
}
