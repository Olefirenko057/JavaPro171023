package org.example.lesson3_homework.task2;

public class Resident {
    private String fullName;
    private int flatNumber;

    public Resident(String fullName, int flatNumber) {
        this.fullName = fullName;
        this.flatNumber = flatNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public int getFlatNumber() {
        return flatNumber;
    }
}
