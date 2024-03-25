package org.example.homeworks.lesson19_homework.task2;

import org.example.homeworks.lesson19_homework.task1.Client;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClientsListFile {
    public static void writeClients(List<Client> clients) throws IOException {
        Path path = Paths.get("/Users/temaolefirenko/Desktop/JavaPro/JavaPro171023/src/main/java/org/example/homeworks/lesson19_homework/task2/users.txt");
        if(!Files.exists(path)) {
            try(
                    ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path));
                    ) {
                for (Client client : clients) {
                    outputStream.writeObject(client);
                }
            }
        }
    }

    public static List<Client> readClients() throws IOException, ClassNotFoundException {
        List<Client> clientList = new ArrayList<>();
        Path path = Paths.get("/Users/temaolefirenko/Desktop/JavaPro/JavaPro171023/src/main/java/org/example/homeworks/lesson19_homework/task2/users.txt");
        if(Files.exists(path)) {
            try (
                    ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path));
                    ){
                    Client currentClient = (Client) inputStream.readObject();
                    try {
                        while (currentClient != null) {
                            clientList.add(currentClient);
                            currentClient = (Client) inputStream.readObject();
                        }
                    } catch (EOFException ignore) {
                        //ignore exception
                    }
            }
        }
        return clientList;
    }
}
