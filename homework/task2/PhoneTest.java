package org.example.de.telran.lesson1.homework.task2;

import org.example.de.telran.lesson1.homework.task1.Person;

public class PhoneTest {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();
        phone1.setNumber("543AA3A");
        phone2.setNumber("3291011");
        phone3.setNumber("4359229");

        phone1.setWeight(13);
        phone2.setWeight(2.3);
        phone3.setWeight(1.5);

        phone1.setModel("Samsung");
        phone2.setModel("Iphone");
        phone3.setModel("Huawei");

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);

        phone1.receiveCall("Lillo");
        phone2.receiveCall("Kiko");
        phone3.receiveCall("Mino");


    }
}
