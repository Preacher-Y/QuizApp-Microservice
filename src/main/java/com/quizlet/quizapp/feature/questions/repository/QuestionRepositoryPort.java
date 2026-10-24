package com.quizlet.quizapp.feature.questions.repository;

import com.quizlet.quizapp.feature.questions.domain.Question;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuestionRepositoryPort {
    Optional<Question> findById(UUID id);
    Question save(Question question);
    List<Question> findAll(Pageable pageable);
}
