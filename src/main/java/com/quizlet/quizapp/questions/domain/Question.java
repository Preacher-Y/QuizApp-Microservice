package com.quizlet.quizapp.questions.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Question {
    private UUID id;

    private String questionTitle;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String rightAnswer;

    private String difficultyLevel;

    private String category;
}
