package org.example.lesson3_homework.task1;

import java.util.Random;

public abstract class Translator {
    //: 1) Есть абстрактный класс Переводчик, который имеет характеристики имя, возраст, пол и умеет переводить с одного языка на другой.
    //Реализовать данный класс и создать несколько классов различных переводчиков с одного языка на другой.
    //Например с английского на русский, с русского на немецки и т.п.
    //Продумайте какова архитектура наследования будет в данном приложении.
    private String name;
    private int age;
    private String gender;
    private Words words = new Words();

    public Translator(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String translate(String languageOriginal[], String languageToTranslate[]) {
        System.out.println(name + " is translating the words");
        Random random = new Random();
        int index = random.nextInt(languageOriginal.length);
        String wordToTranslate = languageOriginal[index];
        System.out.println("The word " + wordToTranslate.toUpperCase() + " needs to be translated");
        String translatedWord = languageToTranslate[index];
        return "It's " + translatedWord.toUpperCase();
    };

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Words getWords() {
        return words;
    }
}
