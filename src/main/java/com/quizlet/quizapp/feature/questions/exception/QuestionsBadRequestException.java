package com.quizlet.quizapp.feature.questions.exception;

import com.quizlet.quizapp.common.utils.exception.BadRequestException;

public class QuestionsBadRequestException extends BadRequestException {
    public QuestionsBadRequestException() {
        super("Invalid Request !!!");
    }
}
