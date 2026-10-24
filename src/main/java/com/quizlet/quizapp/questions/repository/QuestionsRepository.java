package com.quizlet.quizapp.questions.repository;

import com.quizlet.quizapp.questions.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionsRepository extends JpaRepository<QuestionEntity, UUID> {
}
