package com.quizlet.quizapp.questions.repository;

import com.quizlet.quizapp.questions.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface QuestionRepositoryPort {
    Optional<Question> findById(UUID id);
    Question save(Question question);
    Page<Question> findAll(Pageable pageable);
}
