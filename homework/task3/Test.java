package org.example.de.telran.lesson2.homework.task3;

import org.example.de.telran.lesson2.homework.task3.groups.*;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        Group1 group1 = new Group1();
//        System.out.println(group1.showTheStudentsCast(group1.getPersons()));

        Group2 group2 = new Group2();
//        System.out.println(group2.showTheStudentsCast(group2.getPersons()));

        Group3 group3 = new Group3();
//        System.out.println(group3.showTheStudentsCast(group2.getPersons()));
        Group4 group4 = new Group4();
//        System.out.println(group3.showTheStudentsCast(group2.getPersons()));
        Group5 group5 = new Group5();
//          System.out.println(group3.showTheStudentsCast(group2.getPersons()));

        Group[] groups = new Group[]{group1,group2,group3,group4,group5};

        Teacher teacher1 = new Teacher("Ivan", 40,5);
        teacher1.work();
        System.out.println(teacher1.addGroups(groups));

        System.out.println();

        Teacher teacher2 = new Teacher("Dima", 23,1);
        teacher2.work();
        System.out.println(teacher2.addGroups(groups));

        System.out.println();

        Teacher teacher3 = new Teacher("Alex", 32,7);
        teacher3.work();
        System.out.println(teacher3.addGroups(groups));

        System.out.println();

        Consultant consultant1 = new Consultant("Mark", 30, 6);
        consultant1.work();

        System.out.println();

        Consultant consultant2 = new Consultant("John", 45, 15);
        consultant2.work();

        System.out.println();

        AccountsDepartment accountsDepartment = new AccountsDepartment("Viktor", 28,6);
        Employee[] employees = new Employee[]{teacher1,teacher2,teacher3,consultant1,consultant2,accountsDepartment};
        accountsDepartment.work();
        accountsDepartment.payWages(employees);

    }
}
