package org.example.lesson6_homework.task2;

public class Item<H extends Number,L extends Number,W extends Number> implements VolumeCounter<H,L,W> {

    private String name;
    private H height;
    private L length;
    private W width;

    public Item(String name,H height, L length, W width) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public H getHeight() {
        return height;
    }

    public L getLength() {
        return length;
    }

    public W getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
