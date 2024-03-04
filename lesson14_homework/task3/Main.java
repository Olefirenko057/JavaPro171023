package org.example.lesson14_homework.task3;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Tasks> tasks = new PriorityQueue<>(((o1,o2) -> {
            return Integer.compare(o1.difficultyExtent,o2.difficultyExtent);
        }));
        tasks.add(Tasks.CARRYING_FURNITURE);
        tasks.add(Tasks.PAINTING_WALLS);
        tasks.add(Tasks.SAWING_WOODS);

        Employee employee = new Employee("Alex",30,tasks);
        employee.completeDailyTasks(employee.getManager().giveTasksToSubordinate(employee,tasks));
    }
}
