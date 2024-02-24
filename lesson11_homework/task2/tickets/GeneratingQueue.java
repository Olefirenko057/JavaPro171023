package org.example.lesson11_homework.task2.tickets;


import org.example.lesson11_homework.task2.additionalClasses.OperationTypes;
import org.example.lesson11_homework.task2.humans.Banker;
import org.example.lesson11_homework.task2.humans.User;

import java.util.*;

public class GeneratingQueue {

    public static SortedSet<Ticket> ticketsArchive = new TreeSet<>();
    public static SortedSet<Ticket> activeTickets = new TreeSet<>();
    public static Set<User> users = new TreeSet<>();

    public static Ticket printTicketForUser(User user) {
        System.out.println("Hi, " + user.getName() + "! What is your request?");
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - consultation, 2 - money withdrawal, 3 - money deposit, 4 - open deposit,5 - communal payment");
        int result = sc.nextInt();
        if (result == 1) {
            return new Ticket(user, OperationTypes.CONSULTATION);
        } else if (result == 2) {
            return new Ticket(user, OperationTypes.MONEY_WITHDRAWAL);
        } else if (result == 3) {
            return new Ticket(user, OperationTypes.MONEY_DEPOSIT);
        } else if (result == 4) {
            return new Ticket(user, OperationTypes.OPENING_A_DEPOSIT);
        } else if (result == 5) {
            return new Ticket(user, OperationTypes.COMMUNAL_PAYMENTS);
        } else {
            throw new RuntimeException();
        }
    }


    public static void processQueue() throws Exception {
        Scanner sc = new Scanner(System.in);
        int result;
        Iterator<Ticket> ticketIterator = activeTickets.iterator();
        while (ticketIterator.hasNext()) {
            Ticket currentTicket = ticketIterator.next();
            Banker.getBankerInstance().setUserForService(currentTicket.getUser());
            System.out.println("Hi, " + currentTicket.getUser().getName());
            if (currentTicket.getOperationType() == OperationTypes.CONSULTATION) {
                currentTicket.getUser().requestConsultation();
            } else if (currentTicket.getOperationType() == OperationTypes.MONEY_WITHDRAWAL) {
                System.out.println("How much would you like to withdraw?(MAX - " + currentTicket.getUser().checkCardBalance() + ")");
                result = sc.nextInt();
                currentTicket.getUser().requestMoneyWithdrawal(result);
            } else if(currentTicket.getOperationType() == OperationTypes.MONEY_DEPOSIT) {
                System.out.println("How much would you like to deposit?");
                result = sc.nextInt();
                currentTicket.getUser().requestMoneyDeposit(result);
            } else if(currentTicket.getOperationType() == OperationTypes.OPENING_A_DEPOSIT) {
                currentTicket.getUser().requestOpeningADepositAccount();
            } else {
                currentTicket.getUser().requestConsultation();
            }
            ticketIterator.remove();
        }
//        for (Ticket ticket : activeTickets) {
//            Banker.getBankerInstance().setUserForService(ticket.getUser());
//            System.out.println("Hi, " + ticket.getUser().getName());
//            if (ticket.getOperationType() == OperationTypes.CONSULTATION) {
//                ticket.getUser().requestConsultation();
//            } else if (ticket.getOperationType() == OperationTypes.MONEY_WITHDRAWAL) {
//                System.out.println("How much would you like to withdraw?(MAX - " + ticket.getUser().checkCardBalance() + ")");
//                result = sc.nextInt();
//                ticket.getUser().requestMoneyWithdrawal(result);
//            } else if(ticket.getOperationType() == OperationTypes.MONEY_DEPOSIT) {
//                System.out.println("How much would you like to deposit?");
//                result = sc.nextInt();
//                ticket.getUser().requestMoneyDeposit(result);
//            } else if(ticket.getOperationType() == OperationTypes.OPENING_A_DEPOSIT) {
//                ticket.getUser().requestOpeningADepositAccount();
//            } else {
//                ticket.getUser().requestConsultation();
//            }
//            activeTickets.remove(ticket);
//        }
        System.out.println("All the clients have been served");

//    public static Set<User> getUsers() {
//        return users;
//    }
//
//    public static void setUsers(Set<User> users) {
//        GeneratingQueue.users = users;
//    }
    }
}