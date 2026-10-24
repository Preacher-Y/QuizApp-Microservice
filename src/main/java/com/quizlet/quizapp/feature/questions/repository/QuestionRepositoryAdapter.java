package com.quizlet.quizapp.feature.questions.repository;

import com.quizlet.quizapp.feature.questions.domain.Question;
import com.quizlet.quizapp.feature.questions.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class QuestionRepositoryAdapter implements QuestionRepositoryPort{

    private final QuestionsRepository repo;
    private final QuestionMapper mapper;

    @Override
    public Optional<Question> findById(UUID id) {
        return repo.findById(id).map(mapper::toDomain);
    }

    @Override
    public Question save(Question question) {
        return mapper.toDomain(repo.save(mapper.toEntity(question)));
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::toDomain);
    }

}
