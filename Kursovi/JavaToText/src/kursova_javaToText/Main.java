package kursova_javaToText;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final File folder = new File("D:\\KPI\\proj_Java\\JavaToText\\src\\files");
        FileToRead fileRead = new FileToRead();
        fileRead.listFilesForFolder(folder);
    }
}

class FileToRead {
    public void listFilesForFolder(final File folder) throws IOException {
        try (FileWriter fileWriter = new FileWriter("return.txt", true)) {
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    listFilesForFolder(fileEntry);
                } else {
                    FileReader fileRead = new FileReader(fileEntry);
                    BufferedReader bufferedReader = new BufferedReader(fileRead);
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        fileWriter.write(line);
                        line = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                    fileRead.close();
                }
            }
        }
    }
}