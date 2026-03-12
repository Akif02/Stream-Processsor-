package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Writer extends OutputStreamWriter {
    private final OutputStream out;
    private final StringBuilder buffer;

    public Base64Writer(OutputStream out) {
        super(out);
        this.out = out;
        this.buffer = new StringBuilder();
    }

    @Override
    public void write(int c) throws IOException {
        buffer.append((char) c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        buffer.append(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        buffer.append(str, off, len);
    }

    @Override
    public void flush() throws IOException {
        if (buffer.length() > 0) {
            byte[] inputBytes = buffer.toString().getBytes(StandardCharsets.UTF_8);
            byte[] encodedBytes = Base64.getEncoder().encode(inputBytes);
            out.write(encodedBytes);
            buffer.setLength(0);
        }
        out.flush();
    }

    @Override
    public void close() throws IOException {
        flush();
        out.close();
    }
}
