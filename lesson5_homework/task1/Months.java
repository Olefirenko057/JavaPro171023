package org.example.lesson5_homework.task1;

public enum Months {
//  : 1) Создайте класса Enum для хранения перечня  месяцев в году.
//Кроме костантных значений, в нем должен также сохраняться русское наименование месяца.
//Напишите метод, который будет рекомендовать вам режим питания, в зависимости от текущего месяца и сезона года.
    JANUARY("Январь"),
    FEBRUARY("Февраль"),
    MARCH("Март"),
    APRIL("Апрель"),
    MAY("Май"),
    JUNE("Июнь"),
    JULY("Июль"),
    AUGUST("Август"),
    SEPTEMBER("Сентябрь"),
    OCTOBER("Октябрь"),
    NOVEMBER("Ноябрь"),
    DECEMBER("Декабрь");

    private String russianName;

    Months(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}
