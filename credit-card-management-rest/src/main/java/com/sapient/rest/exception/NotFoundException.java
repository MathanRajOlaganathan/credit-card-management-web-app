package com.sapient.rest.exception;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/07/2021
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
