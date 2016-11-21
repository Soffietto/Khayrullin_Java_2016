package com.khayrullin.reader;

import java.io.*;

public class LowerToUpperAndUpperToLowerReader extends FilterReader {

    protected LowerToUpperAndUpperToLowerReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if (c <= 90 && c >= 65) {
            return Character.toLowerCase(c);
        } else if (c <= 122 && c >= 97) {
            return Character.toUpperCase(c);
        }
        return c;
    }
}
