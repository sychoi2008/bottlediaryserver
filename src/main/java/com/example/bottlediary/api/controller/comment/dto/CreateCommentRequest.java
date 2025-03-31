package com.example.bottlediary.api.controller.comment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {
    @NotBlank(message = "댓글 본문은 필수입니다.")
    String content;

    Long diaryId;
}
