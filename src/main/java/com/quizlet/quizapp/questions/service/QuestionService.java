package com.quizlet.quizapp.questions.service;

import com.quizlet.quizapp.utils.PageResponseDto;
import com.quizlet.quizapp.utils.exception.BadRequestException;
import com.quizlet.quizapp.questions.domain.Question;
import com.quizlet.quizapp.questions.dto.QuestionRequestDto;
import com.quizlet.quizapp.questions.dto.QuestionResponseDto;
import com.quizlet.quizapp.questions.exception.QuestionNotFoundException;
import com.quizlet.quizapp.questions.exception.QuestionsBadRequestException;
import com.quizlet.quizapp.questions.mapper.QuestionMapper;
import com.quizlet.quizapp.questions.repository.QuestionRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepositoryAdapter repo;
    private final QuestionMapper mapper;

    public PageResponseDto<QuestionResponseDto> getAllQuestions(int limit, int page) throws BadRequestException {
        if (page<=0 || limit <=0 ){
            throw new QuestionsBadRequestException();
        }

        var pagination = PageRequest.of(page-1, limit,Sort.by("difficultyLevel"));
        var pageData = repo.findAll(pagination);

        return new PageResponseDto<>(
                pageData.getContent().stream().map(mapper::toDto).toList(),
                pageData.getNumber() + 1,
                pageData.getTotalPages(),
                pageData.getTotalElements()
        );


    }

    public Question getQuestionById(UUID id) throws BadRequestException {
        if (id == null){
            throw new QuestionsBadRequestException();
        }
        Optional<Question> qn =  repo.findById(id);
        if (qn.isEmpty()){
            throw new QuestionNotFoundException(id);
        }
        return qn.get();
    }

    public Question saveNewQuestion(QuestionRequestDto req) {
        var domain = mapper.toDomainFromCreate(req);
        return repo.save(domain);
    }
}
