package org.example.homeworks.lesson18_homework.task1;

import java.io.*;

public class CopyFile {
    //1 уровень сложности: 1. Написать приложение, которое будет копировать информацию из файла в другой файл.
    //Путь к существующему файлу и имя нового файла нужно вводить с клавиатуры.
    public static void main(String[] args) {
        File sourceFile = new File("/Users/temaolefirenko/Desktop/JavaPro/JavaPro171023/src/main/java/org/example/homeworks/lesson18_homework/task1/history.txt");
        File destFile = new File("/Users/temaolefirenko/Desktop/JavaPro/JavaPro171023/src/main/java/org/example/homeworks/lesson18_homework/task1/newFile.txt");
        copyFromTo(sourceFile,destFile);
    }

    public static void copyFromTo(File src,File dest) {
        try(
                FileInputStream inputStream = new FileInputStream(src);
                FileWriter fileWriter = new FileWriter(dest);
                ) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                bufferedWriter.write(currentLine);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                currentLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
