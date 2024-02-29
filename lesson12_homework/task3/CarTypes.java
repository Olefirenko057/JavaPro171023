package org.example.lesson12_homework.task3;

public enum CarTypes {
    AMBULANCE(1),
    BUS(2),
    TECHNOLOGICAL_TRANSPORT(2),
    PASSENGER_CAR(2);

    int priorityExtent;

    CarTypes(int priorityExtent) {
        this.priorityExtent = priorityExtent;
    }

    public int getPriorityExtent() {
        return priorityExtent;
    }

    public void setPriorityExtent(int priorityExtent) {
        this.priorityExtent = priorityExtent;
    }
}
