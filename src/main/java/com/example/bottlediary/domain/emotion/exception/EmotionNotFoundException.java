package com.example.bottlediary.domain.emotion.exception;

import com.example.bottlediary.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class EmotionNotFoundException extends BusinessException {
    public EmotionNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "없는 감정입니다. ID : %d".formatted(id));
    }
}
