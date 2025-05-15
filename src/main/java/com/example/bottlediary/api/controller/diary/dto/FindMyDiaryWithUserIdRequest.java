package com.example.bottlediary.api.controller.diary.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMyDiaryWithUserIdRequest {
    @NotBlank(message = "로그인은 필수입니다")
    String userId;
}
