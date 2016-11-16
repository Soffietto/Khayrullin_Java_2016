package com.khayrullin.ReaderHW;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/khayrullin/ReaderHW/file.txt");
        Reader is = new LowerToUpperAndUppertToLowerReader(new FileReader(file));
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println("");
    }

}
