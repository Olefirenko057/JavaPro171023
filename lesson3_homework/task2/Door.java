package org.example.lesson3_homework.task2;

public class Door {
    private String colour;
    private double length;
    private double width;

    public Door(String colour, double length) {
        this.colour = colour;
        this.length = length;
        this.width = length/3;
    }

    public String getColour() {
        return colour;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
