package com.example.bottlediary.api.controller.diary.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDiaryRequest {
    @NotBlank(message = "일기 제목은 필수값입니다.")
    String title;

    @NotBlank(message = "일기 본문은 필수값입니다.")
    String content;

    Long emotionId;

    String userId;

    String password;
}
