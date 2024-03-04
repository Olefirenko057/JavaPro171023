package org.example.lesson14_homework.task3;

public enum Tasks implements Comparable<Tasks> {
    WALL_DEMOLITION(3,2),
    CARRYING_FURNITURE(2,1),
    PAINTING_WALLS(1,1),
    SAWING_WOODS(2,1);

    int difficultyExtent;
    int hoursForCompletion;

    Tasks(int difficultyExtent, int hoursForCompletion) {
        this.difficultyExtent = difficultyExtent;
        this.hoursForCompletion = hoursForCompletion;
    }


    public int getHoursForCompletion() {
        return hoursForCompletion;
    }

    public int getDifficultyExtent() {
        return difficultyExtent;
    }
}
