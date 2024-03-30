package org.example.homeworks.lesson20_homework.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail {
    // 1 уровень сложности: 1. Написать регулярное выражение для проверка email (например my_25@domen-38.de).
    public static void main(String[] args) {
        System.out.println(checkEmailCorrectness("my_25@domen-38.de"));
    }

    public static boolean checkEmailCorrectness(String email) {
        String regex = "^[a-z]\\w+@[a-z]{3,5}[^a-z]*\\.[a-z]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
