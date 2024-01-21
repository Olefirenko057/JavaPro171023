package org.example.de.telran.lesson2.homework.task3.groups;

import java.util.Arrays;
import java.util.Scanner;

 public class Group {
    private Person[] persons;
    private final int maxPersonsQuantity = 3;
    private boolean hasTeacher;

    public Group() {
        this.persons = new Person[maxPersonsQuantity];
        addingPeopleToTheGroup(this.persons);
    }
    private void addingPeopleToTheGroup(Person[] persons) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < persons.length; i++) {
            System.out.println();
            System.out.println(getClass().getSimpleName());
            System.out.println("Student " + (i + 1));
            System.out.println("What is the student's name?");
            String temp = sc.next();
            System.out.println("What is their age?");
            int numTemp = sc.nextInt();
            persons[i] = new Person(temp, numTemp);
            System.out.println("Student " + persons[i].getName() + " has been added");
        }
        System.out.println("The " + getClass().getSimpleName() + " has been succesfully created");
        System.out.println();
    }


    public String showTheStudentsCast(Person[] persons) {
        return Arrays.toString(persons);
    }

     public void setHasTeacher(boolean hasTeacher) {
         this.hasTeacher = hasTeacher;
     }

     public boolean isHasTeacher() {
        return hasTeacher;
    }

    public Person[] getPersons() {
        return persons;
    }

    public int getMaxPersonsQuantity() {
        return maxPersonsQuantity;
    }

     @Override
     public String toString() {
         return getClass().getSimpleName() + "{" +
                 "persons=" + Arrays.toString(persons) +
                 '}';
     }
 }
