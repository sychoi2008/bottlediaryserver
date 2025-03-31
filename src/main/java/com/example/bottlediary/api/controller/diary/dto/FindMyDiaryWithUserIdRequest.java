package com.example.bottlediary.api.controller.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMyDiaryWithUserIdRequest {
    String userId;
}
