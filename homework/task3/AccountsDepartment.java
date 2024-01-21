package org.example.de.telran.lesson2.homework.task3;

public class AccountsDepartment extends Employee {
//    private Employee[] employees;
    public AccountsDepartment(String name, int age, int yearsOfExperience) {
        super(name, age, yearsOfExperience);
    }

    @Override
    public void work() {
        System.out.println(getName() + " gives salary to our employees and to themselves as well. They get " + getSalary() + "$ per month");
    }

    public void payWages(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if(!employees[i].getName().equals(getName()))
                System.out.println(getName() + " has paid " + employees[i].getName() + " " + employees[i].getSalary() + "$ salary" );
            else
                System.out.println(getName() + " has paid himself " + getSalary() + "$ salary");
        }
    }


}
