package com.quizlet.quizapp.questions.controller;

import com.quizlet.quizapp.utils.PageResponseDto;
import com.quizlet.quizapp.questions.dto.QuestionRequestDto;
import com.quizlet.quizapp.questions.dto.QuestionResponseDto;
import com.quizlet.quizapp.questions.mapper.QuestionMapper;
import com.quizlet.quizapp.questions.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    @GetMapping
    public ResponseEntity<PageResponseDto<QuestionResponseDto>> getAllQuestions(
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "1") int page
    ) {
        return ResponseEntity.ok(questionService.getAllQuestions(limit, page));
    }

    @GetMapping("{id}")
    public ResponseEntity<QuestionResponseDto> getQuestionById(@PathVariable UUID id) {
        return ResponseEntity.ok(questionMapper
                .toDto(
                        questionService.getQuestionById(id)));
    }

    @PostMapping
    public ResponseEntity<QuestionResponseDto> addNewQuestions(
            @RequestBody QuestionRequestDto req
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(questionMapper
                        .toDto(
                                questionService.saveNewQuestion(req)));
    }
}
