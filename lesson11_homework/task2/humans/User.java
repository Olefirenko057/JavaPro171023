package org.example.lesson11_homework.task2.humans;

import org.example.lesson11_homework.task2.tickets.GeneratingQueue;
import org.example.lesson11_homework.task2.additionalClasses.Account;
import org.example.lesson11_homework.task2.interfaces.AccountableUser;

public class User extends Person implements AccountableUser,Comparable<User> {
    private int yearOfBirth;
    private Account account;
    private double communalDebt;
    private Banker usersBanker;
    private int id;
    public User(String name, String surname, int yearOfBirth, Account account, double communalDebt) {
        super(name, surname);
        this.yearOfBirth = yearOfBirth;
        this.account = account;
        this.communalDebt = communalDebt;
        this.id = GeneratingQueue.users.size() + 1;
        this.usersBanker = Banker.getBankerInstance();
        if(GeneratingQueue.users.add(this)) {
            GeneratingQueue.ticketsArchive.add(GeneratingQueue.printTicketForUser(this));
            GeneratingQueue.activeTickets.add(GeneratingQueue.ticketsArchive.last());;
        }
    }

    @Override
    public double checkCardBalance() throws Exception {
        if(this.account == null) {
            throw new Exception("No card was found");
        }
        return this.account.getBalance();
    }

    @Override
    public int checkCardId() throws Exception {
        if(this.account == null) {
            throw new Exception("No card was found");
        }
        return this.account.getCardId();
    }

    @Override
    public double checkCommunalDebts() {
        return this.communalDebt;
    }

    @Override
    public void requestConsultation() throws Exception {
        this.usersBanker.consultUser();
    }

    @Override
    public void requestMoneyWithdrawal(double sum) throws Exception {
        this.usersBanker.withdrawMoneyForUser(sum);
    }

    @Override
    public void requestMoneyDeposit(double sum) throws Exception {
        this.usersBanker.depositMoneyForUser(sum);
    }

    @Override
    public void requestOpeningADepositAccount() throws Exception {
        this.usersBanker.openDepositAccountForUser();
    }

    @Override
    public void makeCommunalPayment() throws Exception {
        if(this.checkCardBalance() - this.checkCommunalDebts() >= 0) {
            this.getAccount().setBalance(this.checkCardBalance() - this.checkCommunalDebts());
            this.setCommunalDebt(0);
        } else {
            this.setCommunalDebt(this.checkCommunalDebts() - this.checkCardBalance());
            this.getAccount().setBalance(0);
        }
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Account getAccount() {
        return account;
    }

    public double getCommunalDebt() {
        return communalDebt;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCommunalDebt(double communalDebt) {
        this.communalDebt = communalDebt;
    }

    public Banker getUsersBanker() {
        return usersBanker;
    }

    protected void setUsersBanker(Banker usersBanker) {
        this.usersBanker = usersBanker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (getYearOfBirth() != user.getYearOfBirth()) return false;
        if (Double.compare(user.getCommunalDebt(), getCommunalDebt()) != 0) return false;
        if (!getAccount().equals(user.getAccount())) return false;
        return getUsersBanker().equals(user.getUsersBanker());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getYearOfBirth();
        result = 31 * result + getAccount().hashCode();
        temp = Double.doubleToLongBits(getCommunalDebt());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getUsersBanker().hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "User{" +
                "yearOfBirth=" + yearOfBirth +
                ", account=" + account +
                ", communalDebt=" + communalDebt +
                ", usersBanker=" + usersBanker +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.id,o.id);
    }
}
