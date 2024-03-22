package org.example.homeworks.lesson17_homework;

import java.util.Date;
import java.util.regex.Pattern;

public class Task1 {
    // 1 уровень сложности: Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
    //
    //
    //Login:
    //1) Длина login должна быть меньше 20 символов и начинаться с латинской буквы.
    //2*) Login должен содержать только латинские буквы, цифры и знак подчеркивания.
    //Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
    //
    //
    //Password:
    //1) Длина password должна быть меньше 20 символов.
    //2*) Должен содержать только латинские буквы, цифры.
    //Также password и confirmPassword должны быть равны.
    //Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
    //
    //
    //
    //WrongPasswordException и WrongLoginException - пользовательские классы исключения с  конструкторами:
    //1) один по умолчанию;
    //2*) второй принимает сообщение исключения и передает его в конструктор класса Exception.
    //
    //
    //Метод возвращает true, если значения верны или false в другом случае.
    //Обработка исключений проводится в вызывающем методе.

    public static void main(String[] args) {
        try {
            System.out.println(tryingToLogIn("J32Q","11112","1111"));
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean tryingToLogIn(String login,String password,String confirmPassword) throws WrongLoginException,WrongPasswordException {
        // Pattern pattern = Pattern.compile("^[A-Za-z].*");
        if(!loginChecker(login)) {
            throw new WrongLoginException("Wrong login");
        }
        if(!passwordChecker(password,confirmPassword)) {
            throw new WrongPasswordException("Wrong password");
        }
       return true;
    }

    public static boolean loginChecker(String login) {
        if (login.length() < 20) {
            Pattern pattern = Pattern.compile("^[A-Za-z].*");
            if (pattern.matcher(login).matches()) {
                pattern = Pattern.compile("^[A-Za-z0-9_]*$");
                if (pattern.matcher(login).matches()) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean passwordChecker(String password,String confirmPassword) {
        if(password.length() < 20) {
            Pattern pattern = Pattern.compile("[A-Za-z0-9]*$");
            if(pattern.matcher(password).matches()) {
                if(password.equals(confirmPassword)) {
                    return true;
                }
            }
        }
        return false;
    }
}
    class WrongPasswordException extends Exception {
        public WrongPasswordException() {
        }

        public WrongPasswordException(String message) {
            super(message);
        }
    }
    class WrongLoginException extends Exception {
        public WrongLoginException() {
        }

        public WrongLoginException(String message) {
            super(message);
        }
    }

