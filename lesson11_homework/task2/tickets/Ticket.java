package org.example.lesson11_homework.task2.tickets;

import org.example.lesson11_homework.task2.additionalClasses.OperationTypes;
import org.example.lesson11_homework.task2.humans.User;

public class Ticket implements Comparable<Ticket> {
    //2* Реализуйте задачу 1 из прошлого ДЗ, используя интерфейс Comparable.
    //Напомню задание:
    //Вы пришли в отделение банка, в котором обслуживание ведется строго по талончикам, который Вы получаете в автомате при входе.
    //При регистрации, Вы обязательно указываете ФИО, год рождения, тип операции который Вам необходимо выполнить в отделении (например
    //Консультация, Получение денежных средств, Вложение средств, Открытие депозита, Коммунальные платежи).
    //После регистрации - вы получаете номер талончика.
    //Обслуживание в банке ведется строго по номеру талончика в порядке их возрастания.
    //Создать множество, которое будет обслуживать класс Ticket.
    //Сымитируйте работу отделения банка.
    private User user;
    private OperationTypes operationType;
    private int ticketId;

    public Ticket(User user, OperationTypes operationType) {
        this.user = user;
        this.operationType = operationType;
        this.ticketId = user.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;

        if (ticketId != ticket.ticketId) return false;
        if (!user.equals(ticket.user)) return false;
        return operationType == ticket.operationType;
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + operationType.hashCode();
        result = 31 * result + ticketId;
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "user=" + user +
                ", operationType=" + operationType +
                ", ticketId=" + ticketId +
                '}';
    }

    @Override
    public int compareTo(Ticket o) {
        return Integer.compare(this.ticketId,o.ticketId);
    }

    public User getUser() {
        return user;
    }

    public OperationTypes getOperationType() {
        return operationType;
    }

    public int getTicketId() {
        return ticketId;
    }
}
