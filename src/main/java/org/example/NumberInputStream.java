package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class NumberInputStream extends InputStream {
    private Reader reader;

    public NumberInputStream(Reader in) {
        this.reader = in;
    }

    @Override
    public int read() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1 && Character.isWhitespace(c)) {
            // weiterlesen
        }
        if (c == -1) {
            return -1;
        }
        do {
            if (Character.isDigit(c)) {
                sb.append((char) c);
            } else {

                break;
            }
        } while ((c = reader.read()) != -1 && !Character.isWhitespace(c));

        if (sb.length() > 0) {
            try {
                int number = Integer.parseInt(sb.toString());
                if (number > 255) {
                    throw new NumberToLargeException("Zahl " + number + " ist größer als 255.");
                }
                return number;
            } catch (NumberFormatException e) {
                throw new IOException("Ungültiges Zahlenformat: " + sb.toString(), e);
            }
        }

        return -1;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
