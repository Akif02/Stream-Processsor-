package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Verwendung: java org.example.Main <dateiname1> [dateiname2 ...]");
            System.exit(1);
        }

        for (String filename : args) {
            System.out.println("--- Lese Datei: " + filename + " ---");
            try (NumberInputStream nis = new NumberInputStream(new BufferedReader(new FileReader(filename)))) {
                int number;
                while ((number = nis.read()) != -1) {
                    System.out.println(number);
                }
            } catch (NumberToLargeException e) {
                System.err.println("Fehler in " + filename + ": " + e.getMessage());
            } catch (IOException e) {
                System.err.println("IO-Fehler beim Lesen von " + filename + ": " + e.getMessage());
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}