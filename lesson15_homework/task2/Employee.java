package org.example.homeworks.lesson15_homework.task2;

public class Employee {
    private String firstName,lastName;
    private Position position;
    private Department department;
    private double salary;

    public Employee(String firstName, String lastName, Position position, Department department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
