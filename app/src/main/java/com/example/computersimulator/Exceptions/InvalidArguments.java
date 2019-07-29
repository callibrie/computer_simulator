package com.example.computersimulator.Exceptions;

public class InvalidArguments extends Exception {
    private String message = null;

    public InvalidArguments(String message) {
        super(message);
        this.message = message;
    }
    public InvalidArguments(Throwable cause) {
        super(cause);
    }
    @Override
    public String toString() {
        return message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
