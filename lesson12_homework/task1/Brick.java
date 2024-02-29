package org.example.lesson12_homework.task1;

public class Brick {
    private final String colour = "White";
    private final double weight = 10;

    public String getColour() {
        return colour;
    }
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Brick{" +
                "colour='" + colour + '\'' +
                ", weight=" + weight +
                '}';
    }
}
