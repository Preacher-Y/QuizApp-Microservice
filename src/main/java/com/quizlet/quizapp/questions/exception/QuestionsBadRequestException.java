package com.quizlet.quizapp.questions.exception;

import com.quizlet.quizapp.utils.exception.BadRequestException;

public class QuestionsBadRequestException extends BadRequestException {
    public QuestionsBadRequestException() {
        super("Invalid Request !!!");
    }
}
