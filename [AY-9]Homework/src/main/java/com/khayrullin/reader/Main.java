package com.khayrullin.reader;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader is = new LowerToUpperAndUpperToLowerReader(new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("file.txt")));
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println("");
    }

}
