package org.example.homeworks.lesson19_homework.task2;

import org.example.homeworks.lesson19_homework.task1.Client;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client
                (3920l,"busy",400l,"Steve","Bardy","steve@gmail.com","new street 4","+49392202");
        Client client2 = new Client
                (3911l,"busy",312l,"Mark","Tven","mark@gmail.com","museum street 4","+4483824");
        Client client3 = new Client
                (8192l,"free",450l,"Eva","Watson","eva@gmail.com","sport street 20","+4829102");
        Client client4 = new Client
                (5392l,"busy",400l,"Steve","Bardy","steve@gmail.com","new street 4","+49392202");

        List<Client> clients = List.of(client1,client2,client3,client4);

        try {
            ClientsListFile.writeClients(clients);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(ClientsListFile.readClients());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
