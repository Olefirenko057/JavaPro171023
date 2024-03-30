package org.example.homeworks.lesson20_homework.task2;

import java.util.regex.Pattern;

public class PasswordChecker {
    //2.* Написать регулярное выражение для проверки корректности нового пароля,
    //который соответствует определенным критериям:
    //
    //
    //состоять минимум из 8 символов;
    //
    //должен обязательно включать хотя бы одну маленькую букву;
    //
    //должен обязательно включать хотя бы одну большую букву;
    //
    //должен обязательно включать хотя бы одну цифру;
    //
    //должен обязательно включать хотя бы один спецсимвол (пример: !@#$%^&_+-=);

    public static void main(String[] args) {

        String string = "pasA1+!10";
            System.out.println(checkPasswordCorrectness(string));
    }

    public static boolean checkPasswordCorrectness(String password) {
        String test = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!#$%^&_+\\-=]+).{8,}$";
        return Pattern.matches(test,password);
    }

}
