package org.example.lesson6_homework.task3;

public class Concert <T extends Artist> {
    //Вы владелец концертного зала со сценой. Вы нанимаете артистов различного жанра, которые развлекают зрителей,
    // используя свои таланты. Реализуйте класс Концерт, в котором разные артисты будут выходить на сцену и развлекать зрителей используя свои умения и талант.
    // Подумайте, можно для класса Концерт применить Generiс подход к реализации?
    T artist;

    public Concert(T artist) {
        this.artist = artist;
    }
}
