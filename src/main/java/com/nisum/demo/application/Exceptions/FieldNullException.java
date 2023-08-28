package com.nisum.demo.application.Exceptions;

public class FieldNullException extends RuntimeException {
    public FieldNullException(String fieldName) {
        super(fieldName + " cannot be null.");
    }
}