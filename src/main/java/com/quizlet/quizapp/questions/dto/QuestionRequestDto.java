package com.quizlet.quizapp.questions.dto;

import java.io.Serializable;

public record QuestionRequestDto(String questionTitle, String option1, String option2, String option3, String option4,
                                 String rightAnswer, String difficultyLevel, String category) implements Serializable {
}