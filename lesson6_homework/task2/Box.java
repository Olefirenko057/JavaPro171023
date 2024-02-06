package org.example.lesson6_homework.task2;

public class Box<H extends Number, L extends Number, W extends Number> implements VolumeCounter<H,L,W>{
    //У вас есть на почте коробка, у которой есть 3 характеристики: высота, длина и ширина. В коробку вы можете положить любой объект (главное чтобы он влез по габаритам) и его отправить по почте или получить по почте.
    //Как Вы думаете, можем ли мы использовать для создания данного класса Generic подход? Если да, попробуйте реализовать данный класс.
    private Item<H,L,W> item;
    private H height;
    private L length;
    private W width;

    public Box(H height, L length, W width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public void putAnItem(Item<H,L,W> item) {
        Double boxVolume = (Double) this.countVolume(height,length,width);
        Double itemVolume = (Double) item.countVolume(item.getHeight(), item.getLength(), item.getWidth());
        if(boxVolume > itemVolume) {
            this.item = item;
            System.out.println(item.getName() + " has been succesfully put into the box");
        } else {
            System.out.println(item.getName() + " wasn't put into the box because it is too big");
        }
    }

    public String sendAnItem() {
        if(this.item != null) {
            return item.getName() + " has been sent to a receiver";
        } else {
            return "no items in the box, nothing to send";
        }
    }

}
