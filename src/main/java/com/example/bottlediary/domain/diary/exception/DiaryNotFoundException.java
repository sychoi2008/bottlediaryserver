package com.example.bottlediary.domain.diary.exception;

import com.example.bottlediary.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DiaryNotFoundException extends BusinessException {
    public DiaryNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "없는 일기입니다. ID : %d".formatted(id));
    }
}
