package org.example.lesson6_homework.task3;

public class Main {
    public static void main(String[] args) {
        Concert<Magician> magicianConcert = new Concert<>(new Magician("Dobby"));
        magicianConcert.artist.showTalent();

        Concert<Singer> singerConcert = new Concert<>(new Singer("Tom"));
        singerConcert.artist.showTalent();
    }
}
