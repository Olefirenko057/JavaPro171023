package org.example.de.telran.lesson1.homework.task2;

import org.example.de.telran.lesson1.homework.task1.Person;

public class Phone {
   // 2.Класс Phone.
    //Создайте класс Phone, который содержит переменные number, model и weight.
    //Создайте три экземпляра этого класса.
    //Выведите на консоль значения их переменных.
    //Добавить в класс Phone методы: receiveCall, имеет один параметр – имя звонящего.
    //Выводит на консоль сообщение “Звонит {name}”. Метод getNumber – возвращает номер телефона.
    //Вызвать эти методы для каждого из объектов.

    private String number;
    private String model;
    private double weight;


    public void receiveCall(String callerName ) {
        System.out.println(callerName + " is calling");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
          if(Character.isDigit(number.charAt(i))) {

          } else {
              number = number.substring(0, i) + '0' + number.substring(i + 1);
          }
        }
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight <= 0 || weight >= 5)
            this.weight = 2;
         else
            this.weight = weight;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }
}
