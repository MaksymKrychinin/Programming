package com.OP14;

import java.io.*;
import java.util.Locale;

public class Copy {
    void copyToUpperCase(String source, String destination) throws IOException {
        File file = new File(source);
        if (file.exists()) {
            try (FileReader fileReader = new FileReader(source);
                 BufferedReader bufferedReader = new BufferedReader(fileReader);
                 FileWriter fileWriter = new FileWriter(destination, true)) {
                String a = bufferedReader.readLine();
                while (a != null) {
                    fileWriter.write(a.toUpperCase(Locale.ROOT));
                    a = bufferedReader.readLine();
                    if (a != null) {
                        fileWriter.write('\n');
                    }
                }
            }
        } else {
            throw new FileNotFoundException("Не найден файл по указаному пути");
        }
    }

    void unsplit(String sourcePrefix, String destination) throws IOException {
        int fileIndex = 0;
        byte [] b;
        String fileName = sourcePrefix + "." + String.format("%03d", fileIndex);
        while (new File(fileName).exists()) {
            File file = new File(fileName);
            try (FileOutputStream fileOutputStream = new FileOutputStream(destination, true);
            FileInputStream fileInputStream = new FileInputStream(file)) {
                b = new byte[(int) file.length()];
                fileInputStream.read(b);
                fileOutputStream.write(b);
                fileOutputStream.write(10);
            }
            fileIndex++;
            fileName = sourcePrefix + "." + String.format("%03d", fileIndex);
        }
    }
}