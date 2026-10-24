package com.quizlet.quizapp.utils;

import java.util.List;

public record PageResponseDto<T>(
        List<T> data,
        Integer page,
        Integer totalPages,
        Long totalElements
) {
}
