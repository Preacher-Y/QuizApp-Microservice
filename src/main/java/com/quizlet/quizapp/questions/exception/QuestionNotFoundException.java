package com.quizlet.quizapp.questions.exception;

import com.quizlet.quizapp.utils.exception.NotFoundException;

import java.util.UUID;

public class QuestionNotFoundException extends NotFoundException {
    public QuestionNotFoundException(UUID id) {
        super("Question with ID: "+id.toString()+" not found");
    }
}
