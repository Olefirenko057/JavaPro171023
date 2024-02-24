package org.example.lesson11_homework.task2.additionalClasses;

public class Account {
    private int cardId;
    private double balance;

    public Account(double balance) {
        this.cardId = this.hashCode();
        this.balance = balance;
    }

    public Account() {
    }

    public int getCardId() {
        return cardId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;

        if (cardId != account.cardId) return false;
        return Double.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = cardId;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardId=" + cardId +
                ", balance=" + balance +
                '}';
    }
}
