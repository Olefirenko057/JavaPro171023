package org.example.de.telran.lesson2.homework.task3;

abstract public class Employee {
    //3*. Вы работаете на предприятии, где работает большое количество сотрудников.
    //Создайте классы и схему наследования для организационной структуры предприятия:
    //Базовый класс - Employee с перечнем характеристик и поведением, которые присутствуют у любого сотрудника.
    //А далее все зависит от подразделений где они работают и их функциональных обязанностей.
    private String name;
    private int age;
    private int yearsOfExperience;
    private double salary;

    public Employee(String name, int age, int yearsOfExperience) {
        this.name = name;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        if(yearsOfExperience <= 2)
            this.salary = 1000;
        else if(yearsOfExperience >= 3 && yearsOfExperience <= 7)
            this.salary = 1600;
        else
            this.salary = 2000;
    }

    abstract public void work();
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public double getSalary() {
        return salary;
    }
}
