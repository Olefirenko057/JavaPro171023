package org.example.lesson6_homework.task2;

public class MainBox {
    public static void main(String[] args) {
        Box<Integer,Double,Integer> box1 = new Box<>(5,6.5,8);
        box1.putAnItem(new Item<>("Ball",3,1.2,10));
        System.out.println(box1.sendAnItem());
    }
}
