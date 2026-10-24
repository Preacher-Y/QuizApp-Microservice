package com.quizlet.quizapp.utils.exception;

import org.jspecify.annotations.NonNull;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
