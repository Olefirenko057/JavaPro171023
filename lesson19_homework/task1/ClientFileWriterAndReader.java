package org.example.homeworks.lesson19_homework.task1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ClientFileWriterAndReader {

    //: 1) Реализуйте механизм сохранения и чтения объекта POJO класса Client в файл.
    public static void writeClient(Client client) throws IOException {
        Path path = Paths.get("src/main/java/org/example/homeworks/lesson19_homework/task1/users/"+client.getId()+".txt");
        if(!Files.exists(path)) {
            try (
                    ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path))
                    ) {
                outputStream.writeObject(client);
            }
        }
    }
    public static void readClient(Client client) throws IOException, ClassNotFoundException {
        Path path = Paths.get("src/main/java/org/example/homeworks/lesson19_homework/task1/users/"+client.getId()+".txt");
        if(Files.exists(path)) {
            try (
                    ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path));
                    ){
                System.out.println(inputStream.readObject());
            }
        }
    }
}
