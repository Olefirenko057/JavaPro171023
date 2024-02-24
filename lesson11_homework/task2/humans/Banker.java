package org.example.lesson11_homework.task2.humans;

import org.example.lesson11_homework.task2.additionalClasses.Account;
import org.example.lesson11_homework.task2.interfaces.AccountableBanker;

import java.util.Scanner;

public class Banker extends Person implements AccountableBanker {
    private User userForService;
    private static volatile Banker bankerInstance;

    private Banker(String name, String lastName) {
        super(name, lastName);
    }

    public static Banker getBankerInstance() {
        if(bankerInstance == null){
            synchronized (Banker.class) {
                if(bankerInstance == null) {
                    bankerInstance = new Banker("Ivan","Sydorenko");
                }
            }
        }
        return bankerInstance;
    }

    @Override
    public double checkCardBalance() throws Exception {
        if(this.userForService == null) {
            throw new Exception("No user to be served found");
        } else if (this.userForService.getAccount() == null) {
            throw new Exception("No user's card found");
        } else {
            return this.userForService.getAccount().getBalance();
        }
    }
    @Override
    public int checkCardId() throws Exception {
        if(this.userForService == null) {
            throw new Exception("No user to be served found");
        } else if (this.userForService.getAccount() == null) {
            throw new Exception("No user's card found");
        }
        return this.userForService.getAccount().getCardId();
    }
    @Override
    public double checkCommunalDebts() throws Exception {
        if(this.userForService == null) {
            throw new Exception("No user to be served found");
        }
        return this.userForService.getCommunalDebt();
    }
    @Override
    public void consultUser() throws Exception {
        if(this.userForService == null) {
            throw new Exception("No user to be served found");
        }
        System.out.println("Our banker is consulting a customer " + this.userForService.getName() + " " + this.userForService.getLastName());
        remindOfCommunalPayments();
    }
    @Override
    public void withdrawMoneyForUser(double sum) throws Exception {
        if(this.userForService == null) {
            throw new Exception("No user to be served found");
        } else if (this.userForService.getAccount() == null) {
            throw new Exception("No user's card found");
        }

        if(sum <= this.userForService.getAccount().getBalance() && sum > 0) {
            this.userForService.getAccount().setBalance(this.userForService.getAccount().getBalance() - sum);
            System.out.println(sum + "$ has been withdrawn from the account.Current balance is " + this.checkCardBalance() + "$.");
            remindOfCommunalPayments();
        } else {
            System.out.println("Not enough funds or wrong value");
        }
    }
    @Override
    public void depositMoneyForUser(double sum) throws Exception {
        if(this.userForService == null) {
            throw new Exception("No user to be served found");
        } else if (this.userForService.getAccount() == null) {
            throw new Exception("No user's card found");
        }

        if(sum > 0 && sum <= 10_000) {
            this.userForService.getAccount().setBalance(sum);
            System.out.println("Deposit has been made succesfully. Current balance is " + this.checkCardBalance() + "$.");
        }
        remindOfCommunalPayments();
    }
    @Override
    public void openDepositAccountForUser() throws Exception {
        if(this.userForService == null) {
            throw new Exception("No user to be served found");
        } else if(this.userForService.getAccount() != null) {
            System.out.println("Bank account already exists");
        } else {
            this.userForService.setAccount(new Account(0));
            System.out.println("The account has been set up");
        }
        remindOfCommunalPayments();
    }
    @Override
    public void remindOfCommunalPayments() throws Exception {
        if(this.checkCommunalDebts() > 0 && this.checkCardBalance() > 0) {
            System.out.println("Dear customer. Don't forget to pay " + checkCommunalDebts() + "$ of communal debts!");
            Scanner sc = new Scanner(System.in);
            System.out.println("0 - pay now, 1 - pay later");
            int result = sc.nextInt();
            if(result == 0) {
                this.userForService.makeCommunalPayment();
                System.out.println("The communal payment has been done successfully. Your balance is " + this.checkCardBalance());
            }
        }
    }
    public User getUserForService() {
        return userForService;
    }

    public void setUserForService(User userForService) {
        this.userForService = userForService;
    }
}
