package com.example.bottlediary.api.controller.diary.dto;

import com.example.bottlediary.domain.diary.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindDiaryResponse{
    Long id;
    String content;
    String emotionName;

    public static FindDiaryResponse of(Diary diary) {
        return FindDiaryResponse.builder()
                .id(diary.getId())
                .content(diary.getContent())
                .emotionName(diary.getEmotion().getEmotionName())
                .build();
    }
}
