package org.example.homeworks.lesson18_homework.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyDirectoryAndContent {
    public static void main(String[] args) {
        File dirSource = new File("/Users/temaolefirenko/Desktop/JavaPro/JavaPro171023/homework18");
        File dirDestination = new File("/Users/temaolefirenko/Desktop/JavaPro/JavaPro171023/destinationDirec");
        try {
            copyContent(dirSource,dirDestination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyContent(File srcDir,File destDir) throws IOException {
        if(!destDir.exists()) {
            destDir.mkdirs();
        }
        File[] files = srcDir.listFiles();
        if(files != null) {
            for (File file : files) {
                File destFile = new File(destDir,file.getName());
                if(file.isDirectory()) {
                    copyContent(file,destFile);
                } else {
                    Files.copy(file.toPath(),destFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }
}
