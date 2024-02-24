package org.example.lesson11_homework.task2.interfaces;

import org.example.lesson11_homework.task2.interfaces.Accountable;

public interface AccountableUser extends Accountable {
    void requestConsultation() throws Exception;
    void requestMoneyWithdrawal(double sum) throws Exception;
    void requestMoneyDeposit(double sum) throws Exception;
    void requestOpeningADepositAccount() throws Exception;
    void makeCommunalPayment() throws Exception;
}
