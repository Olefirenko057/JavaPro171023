package org.example.lesson4_homework.task3;

public class SimpleMain {
    public static void main(String[] args) {
        Swim human = new Human("Bob",30);
        Swim fish = new Fish("Trout",3.8);
        Swim boat = new Boat(35);
        human.swim();
        fish.swim();
        boat.swim();
    }
}
