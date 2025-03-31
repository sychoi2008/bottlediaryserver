package com.example.bottlediary.api.controller.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMyDiaryListResponse {
    private Long id;

    private String title;

    private String emotionName;

    private LocalDateTime createdAt;
}
