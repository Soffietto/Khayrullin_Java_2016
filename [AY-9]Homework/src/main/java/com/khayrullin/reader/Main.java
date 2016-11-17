package com.khayrullin.reader;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("[AY-9]Homework/src/main/java/com/khayrullin/reader/file.txt");
        Reader is = new LowerToUpperAndUpperToLowerReader(new FileReader(file));
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println("");
    }

}
