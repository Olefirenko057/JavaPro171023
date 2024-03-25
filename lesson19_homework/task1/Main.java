package org.example.homeworks.lesson19_homework.task1;

import org.example.homeworks.lesson19_homework.task1.Client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Client client = new Client
                (438293l,"Pending",320l,"Tom","Johnson","tom@gmail.com","+304300","49393");
        try {
            ClientFileWriterAndReader.writeClient(client);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ClientFileWriterAndReader.readClient(client);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
