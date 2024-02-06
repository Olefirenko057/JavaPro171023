package org.example.lesson6_homework.task1;

public interface Calculator<F extends Number,S extends Number>{
//Создайте обобщенный интерфейс для калькулятора, в котором будут объявлен перечень операций, которые умеет делать ваш калькулятор add, sub, multi и div и реализуйте классы, которые будут включать данный интерфейс для работы с различными типами данных аргументов
    void add(F firstArg,S secondArg);
    void sub(F firstArg,S secondArg);
    void multi(F firstArg,S secondArg);
    void div(F firstArg,S secondArg);

}
