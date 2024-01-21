package org.example.de.telran.lesson2.homework.task3;

import org.example.de.telran.lesson2.homework.task3.groups.Group;

import java.util.Arrays;

public class Teacher extends Employee {

    private Group[] ownGroups;
    private final int maxGroupsQuantity = 2;

    public Teacher(String name, int age, int yearsOfExperience) {
        super(name, age, yearsOfExperience);
        this.ownGroups = new Group[maxGroupsQuantity];
    }

    public String addGroups(Group[] groups) {
        int temp = 0;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i].isHasTeacher() == false) {
                if(temp < maxGroupsQuantity) {
                    ownGroups[temp] = groups[i];
                    groups[i].setHasTeacher(true);
                    temp++;
                }
            }
        }
        return Arrays.toString(ownGroups);
    }


    @Override
    public void work() {
        System.out.println(getName() + " teaches people IT. They " + getSalary() + "$ per month");
    }

}
