package org.example.lesson3_homework.task1;

public class Words {
    private final String[] english;
    private final String[] german;
    private final String[] ukrainian;
    private final String[] russian;

    public Words() {
        this.english = new String[]{"sun","book","lamp","cup","cat","task","virus"};
        this.german = new String[]{"sonne","buch","lampe","tasse","katze","aufgabe","virus"};
        this.ukrainian = new String[]{"сонце","книга","лампа","чашка","кіт","завдання","вірус"};
        this.russian = new String[]{"солнце","книга","лампа","чашка","кот","задание","вирус"};
    }

    public String[] getEnglish() {
        return english;
    }

    public String[] getGerman() {
        return german;
    }

    public String[] getUkrainian() {
        return ukrainian;
    }

    public String[] getRussian() {
        return russian;
    }
}
