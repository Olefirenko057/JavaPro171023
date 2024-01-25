package org.example.lesson3_homework.task2;

//Есть класс Дом и в нем живет много объектов типа Житель.
//У Дома так же есть объекты Крыша, Стены, Окна, Двери.
//Создайте класс для сущности Дом и ассоциированные с ним объекты, входящий в него.
//Подумайте какие из них агрегируются с домом, а какие связаны отношением Композиция.

public class House {
    Resident[] residents = new Resident[30];//агрегация
    Roof roof = new Roof("black",70,70);//композиция
    Wall[] walls = new Wall[15];//композиция
    Window[] windows = new Window[18];//композиция
    Door[] doors = new Door[residents.length];//композиция
}
