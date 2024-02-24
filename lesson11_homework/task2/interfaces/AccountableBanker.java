package org.example.lesson11_homework.task2.interfaces;

import org.example.lesson11_homework.task2.interfaces.Accountable;

public interface AccountableBanker extends Accountable {
    void consultUser() throws Exception;
    void withdrawMoneyForUser(double sum) throws Exception;
    void depositMoneyForUser(double sum) throws Exception;
    void openDepositAccountForUser() throws Exception;
    void remindOfCommunalPayments() throws Exception;
}
