package org.example.de.telran.lesson2.homework.task2;

public class AnimalTest {
    public static void main(String[] args) {
        Cat cat = new Cat("George",4,true,3,"grey",4,"british");
        Dog dog = new Dog("Martin",8,true,20,"brown",4,"french bulldog");
        Eagle eagle = new Eagle("Pep",2,false,6,"black",2,4);

        cat.eat();
        cat.move();
        cat.giveSound();

        System.out.println();

        dog.eat();
        dog.move();
        dog.giveSound();

        System.out.println();

        eagle.eat();
        eagle.move();
        eagle.scream();
    }
}
