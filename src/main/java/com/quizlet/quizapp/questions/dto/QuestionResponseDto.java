package com.quizlet.quizapp.questions.dto;

import lombok.Builder;

import java.io.Serializable;
import java.util.UUID;

@Builder
public record QuestionResponseDto(UUID id, String questionTitle, String option1, String option2, String option3, String option4,
                                  String rightAnswer, String difficultyLevel, String category) implements Serializable {
}