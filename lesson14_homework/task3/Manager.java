package org.example.lesson14_homework.task3;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Manager {
    private String name;
    private int age;

    public Manager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PriorityQueue<Tasks> giveTasksToSubordinate(Employee employee, PriorityQueue<Tasks> tasks) {
        employee.setTasks(tasks);
        return employee.getTasks();
    }

    public void manageEmployee(Employee employee,PriorityQueue<Tasks> tasks) {
        if(FunctionalInterfaces.hasNextTask.test(tasks.size())) {
            FunctionalInterfaces.currentTask.accept(tasks.peek(),employee);
            Random r = new Random();
            System.out.println(employee.getHoursWorked() + "hours");
            addingNewTasks(employee,r.nextInt(2),FunctionalInterfaces.checkNewTasks,FunctionalInterfaces.hasNextTask);
            System.out.println();
            manageEmployee(employee,tasks);
        } else {
            System.out.println("Nothing else is needed. Your working day is finished.");
            System.out.println("You worked " + employee.getHoursWorked() + " hours");
        }
    }


    public void addingNewTasks(Employee employee, int result, BiPredicate<Integer,Employee> hasNewTask, Predicate<Integer> hasNext) {
        if(FunctionalInterfaces.checkNewTasks.test(result,employee)) {
            Random r = new Random();
            Tasks newTask = Tasks.values()[r.nextInt(4)];
            employee.getTasks().add(newTask);
            if(FunctionalInterfaces.hasNextTask.test(employee.getTasks().size())) {
                System.out.println("Yes, you have one more task to do. New task is " + newTask);
            } else {
                System.out.println("Unfortunately your working day is not finished yet. Your new task is " + newTask);
            }
        } else {
            if(FunctionalInterfaces.hasNextTask.test(employee.getTasks().size())) {
                System.out.println("No, just continue completing next tasks");
            }
        }
    }
}
