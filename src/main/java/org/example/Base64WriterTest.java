package org.example;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

public class Base64WriterTest {

    public static void main(String[] args) throws IOException {
        String testInput = "Polyfon zwitschernd aßen Mäxchens Vögel Rüben...";


        byte[] inputBytes = testInput.getBytes(StandardCharsets.UTF_8);
        String expectedBase64 = Base64.getEncoder().encodeToString(inputBytes);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (Base64Writer writer = new Base64Writer(baos)) {
            writer.write(testInput);
            writer.flush();
        }

        String actualBase64 = baos.toString(StandardCharsets.UTF_8);

        System.out.println("Test Eingabe: " + testInput);
        System.out.println("Erwartet: " + expectedBase64);
        System.out.println("Erhalten: " + actualBase64);

        if (expectedBase64.equals(actualBase64)) {
            System.out.println("TEST BESTANDEN");
        } else {
            System.err.println("TEST FEHLGESCHLAGEN");
        }
    }
}

