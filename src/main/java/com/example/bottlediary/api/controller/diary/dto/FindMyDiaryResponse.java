package com.example.bottlediary.api.controller.diary.dto;

import com.example.bottlediary.domain.comment.Comment;
import com.example.bottlediary.domain.diary.Diary;
import lombok.Builder;

import java.util.List;

@Builder
public record FindMyDiaryResponse(
        Long id,
        String title,
        String content,
        String emotionName,
        List<CommentResponse> comments
) {
    public static FindMyDiaryResponse of(Diary diary, List<Comment> comments) {
        return new FindMyDiaryResponse(
                diary.getId(),
                diary.getTitle(),
                diary.getContent(),
                diary.getEmotion().getEmotionName(),
                comments.stream()
                        .map(CommentResponse::of)
                        .toList()

        );
    }

    public record CommentResponse(
            Long id,
            String content
    ) {
        public static CommentResponse of(Comment comment) {
            return new CommentResponse(
                    comment.getId(),
                    comment.getContent()
            );
        }
    }

}
