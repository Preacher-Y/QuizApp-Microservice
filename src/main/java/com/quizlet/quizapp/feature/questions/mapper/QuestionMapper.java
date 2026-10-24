package com.quizlet.quizapp.feature.questions.mapper;

import com.quizlet.quizapp.feature.questions.domain.Question;
import com.quizlet.quizapp.feature.questions.dto.QuestionRequestDto;
import com.quizlet.quizapp.feature.questions.dto.QuestionResponseDto;
import com.quizlet.quizapp.feature.questions.entity.QuestionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    Question toDomain(QuestionEntity entity);
    QuestionEntity toEntity(Question domain);
    QuestionResponseDto toDto(Question question);
    Question toDomainFromCreate(QuestionRequestDto request);
}
