package com.nisum.demo.application.Exceptions;

public class PhoneFieldNullException extends RuntimeException {
    public PhoneFieldNullException(String fieldName) {
        super("Field '" + fieldName + "' in phone cannot be null.");
    }
}
