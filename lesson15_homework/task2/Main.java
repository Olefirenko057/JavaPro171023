package org.example.homeworks.lesson15_homework.task2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //4. Получить список сотрудников из отдела маркетинг и увеличить зп на 15%
        //5. Получить сотрудника с самой низкой зп
        //6*. Получить сотрудника с самой высокой зп
        //7. Получите сотрудников из всех отделов с максимальной зп
        //8. Сгруппировать сотрудников по должности
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan","Stevens",Position.MIDDLE,Department.FRONTEND,3000));
        employees.add(new Employee("Peter","Johnson",Position.MIDDLE,Department.QA,2700));
        employees.add(new Employee("Alexandra","Bol",Position.JUNIOR,Department.MARKETING,900));
        employees.add(new Employee("Mark","Gatsby",Position.SENIOR,Department.BACKEND,5000));
        employees.add(new Employee("Eva","Stones",Position.MIDDLE,Department.BACKEND,3500));
        employees.add(new Employee("Kyle","Terry",Position.SENIOR,Department.MARKETING,4600));
        employees.add(new Employee("Damir","Oli",Position.JUNIOR,Department.BACKEND,950));
        employees.add(new Employee("Tom","Johnson",Position.SENIOR,Department.MARKETING,4500));
        employees.add(new Employee("Robert","Po",Position.JUNIOR,Department.FRONTEND,800));

        //Вычислить среднюю зарплату всех сотрудников
        Integer getAvgSalary = (int) (employees.stream()
                .mapToDouble(employee -> employee.getSalary())
                .reduce((i, j) -> i + j).getAsDouble()) / employees.size();
        System.out.println(getAvgSalary);
        System.out.println();
        //Получить список сотрудников с зп > 1000
        List<Employee> employees1 = employees.stream()
                .filter(employee -> employee.getSalary() > 1000)
                .toList();
        System.out.println(employees1);
        System.out.println();

        //4. Получить список сотрудников из отдела маркетинг и увеличить зп на 15%
        List<Employee> employeesFromMarketing = employees.stream()
                .filter(employee -> employee.getDepartment() == Department.MARKETING)
                .peek(employee -> employee.setSalary(employee.getSalary() * 1.15))
                .toList();
        System.out.println(employeesFromMarketing);
        System.out.println();

        //6*. Получить сотрудника с самой высокой зп
        Employee employeeWithBiggestSalary = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .get();
        System.out.println(employeeWithBiggestSalary);
        System.out.println();

        //7. Получите сотрудников из всех отделов с максимальной зп

        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())))));
        System.out.println();

        //8. Сгруппировать сотрудников по должности
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((x,y) -> System.out.println(x + " " + y));


    }
}
