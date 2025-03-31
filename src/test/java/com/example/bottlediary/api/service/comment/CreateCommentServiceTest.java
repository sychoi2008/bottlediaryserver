package com.example.bottlediary.api.service.comment;

import com.example.bottlediary.api.controller.comment.dto.CreateCommentRequest;
import com.example.bottlediary.domain.comment.Comment;
import com.example.bottlediary.domain.comment.CommentRepository;
import com.example.bottlediary.domain.diary.Diary;
import com.example.bottlediary.domain.diary.DiaryRepository;
import com.example.bottlediary.domain.emotion.Emotion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class CreateCommentServiceTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private DiaryRepository diaryRepository;

    @InjectMocks
    private CreateCommentService createCommentService;

    @DisplayName("댓글 정상 저장")
    @Test
    void execute() {
        //given
        Emotion emotion = new Emotion(1L, "기뻐요");
        Diary diary = Diary.builder()
                .title("title1")
                .content("content1")
                .emotion(emotion)
                .userId("guest01")
                .build();

        //when
        when(diaryRepository.findById(1L)).thenReturn(Optional.of(diary));
        CreateCommentRequest request = new CreateCommentRequest(
                "저도 오늘 날씨가 좋아서 기분이 좋았습니다. 산책최고",
                1L
        );
        createCommentService.execute(request);

        //then
        verify(commentRepository).save(any(Comment.class));

     }

}