package org.example.lesson11_homework.task2;

import org.example.lesson11_homework.task2.additionalClasses.Account;
import org.example.lesson11_homework.task2.humans.User;
import org.example.lesson11_homework.task2.tickets.GeneratingQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User("Nikola","Ju",2000,new Account(2000),50);
        User user2 = new User("Mila","Li",1990,new Account(5000),500);
        User user3 = new User("Milana","Li",1991,new Account(5000),500);
        System.out.println(GeneratingQueue.ticketsArchive);
        GeneratingQueue.processQueue();
    }
}
