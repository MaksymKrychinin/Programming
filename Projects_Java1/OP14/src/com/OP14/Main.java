package com.OP14;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //4
        new Copy().copyToUpperCase("file.txt", "fileToCopy.txt");
        //11
        new Copy().unsplit("index", "indexAll.txt");
    }
}
