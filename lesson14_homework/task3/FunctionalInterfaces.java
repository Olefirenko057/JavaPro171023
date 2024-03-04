package org.example.lesson14_homework.task3;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaces {
    public static Predicate<Integer> hasNextTask = size -> size > 0;
    public static BiConsumer<Tasks,Employee> currentTask = (task,employee) -> {
        System.out.println(employee.getName() + ", your current task is " + task);
        employee.setHoursWorked(employee.getHoursWorked() + task.hoursForCompletion);
        System.out.println(employee.getTasks().poll() + " has been completed");
        System.out.println("Now we have to check if we need you to do something else");
    };
    public static BiPredicate<Integer,Employee> checkNewTasks = (value, employee) -> value == 0 && (employee.getHoursWorked() <= 4 && !employee.getTasks().isEmpty());
}
