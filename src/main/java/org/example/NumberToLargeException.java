package org.example;

import java.io.IOException;

public class NumberToLargeException extends IOException {
    public NumberToLargeException(String message) {
        super(message);
    }
}
