package com.example.bottlediary.api.controller.emotion.dto;

import com.example.bottlediary.domain.emotion.Emotion;
import lombok.Builder;

import java.util.List;

@Builder
public record FindEmotionResponse(List<FindEmotionResult> results) {
    public static FindEmotionResponse of(List<Emotion> emotions) { // Entity를 dto로 변환하는 메서드
        return new FindEmotionResponse(
                emotions.stream()
                        .map(FindEmotionResult::of) // emotions을 하나씩 꺼내면서 바꿔주기
                        .toList()
        );
    }

    public record FindEmotionResult( // 각 감정 항목의 데이터 구조
            Long emotionId,
            String emotionName
    ) {
        public static FindEmotionResult of(Emotion emotion) {
            return new FindEmotionResult(
                    emotion.getId(),
                    emotion.getEmotionName()
            );
        }
    }
}
