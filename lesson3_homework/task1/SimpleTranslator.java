package org.example.lesson3_homework.task1;

public class SimpleTranslator {
    public static void main(String[] args) {
        Translator alex = new Alex("Alex",30,"male");
        Translator kate = new Kate("Kate",22,"female");
        Translator john = new Alex("John",35,"male");

        System.out.println(alex.translate(alex.getWords().getEnglish(), alex.getWords().getUkrainian()));
        System.out.println();
        System.out.println(kate.translate(kate.getWords().getUkrainian(), kate.getWords().getGerman()));
        System.out.println();
        System.out.println(john.translate(john.getWords().getGerman(), john.getWords().getRussian()));

    }
}
