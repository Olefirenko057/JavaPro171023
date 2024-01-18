package org.example.de.telran.lesson1.homework.task1;

public class Person {
//    1 уровень сложности: 1.Класс module1.lecture1.module1.lecture1.Person
//    Создать класс module1.lecture1.module1.lecture1.Person, который содержит:
//    переменные fullName, age;
//    методы move() и talk(), в которых просто вывести на консоль сообщение -"Такой-то  module1.lecture1.module1.lecture1.Person говорит".
//    Добавьте два конструктора  - module1.lecture1.module1.lecture1.Person() и module1.lecture1.module1.lecture1.Person(fullName, age).
//    Создайте два объекта этого класса. Один объект инициализируется конструктором module1.lecture1.module1.lecture1.Person(), другой - module1.lecture1.module1.lecture1.Person(fullName, age)
//
    private String fullName;
    private int age;

    public Person() {
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        if(age > 0 && age < 120)
            this.age = age;
        else
            this.age = 0;

    }

    public void move() {
        System.out.println(fullName + " is goings");
    }
    public void talk() {
        System.out.println(fullName + " is talking");
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
}
