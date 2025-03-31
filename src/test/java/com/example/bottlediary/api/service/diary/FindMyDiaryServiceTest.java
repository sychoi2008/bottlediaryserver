package com.example.bottlediary.api.service.diary;

import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryResponse;
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

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class FindMyDiaryServiceTest {
    @Mock
    private DiaryRepository diaryRepository;

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private FindMyDiaryService findMyDiaryService;

    @DisplayName("일기 상세 페이지 및 댓글도 같이 가져오기")
    @Test
    void findMyDiary() {
        //given
        Long diaryId = 1L;

        Emotion emotion = new Emotion(1L, "기뻐요");

        Diary diary = Diary.builder()
                .content("오늘은 엄마랑 같이 산책한 날! 날씨가 엄청 이상했는데 재밌었다.")
                .emotion(emotion)
                .userId("guest01")
                .build();

        when(diaryRepository.findById(diaryId)).thenReturn(Optional.of(diary));
        when(commentRepository.findAllByDiaryId(diaryId)).thenReturn(List.of(
                new Comment("저도 행복하네요", diary),
                new Comment("와 행복해져요", diary)
        ));

        //when : 실제 서비스 메서드 돌려보기
        FindMyDiaryResponse response = findMyDiaryService.findMyDiary(diaryId);

        //then
        assertThat(response).isNotNull();
        assertThat(response.comments().size()).isEqualTo(2);

        verify(diaryRepository, times(1)).findById(diaryId);
        verify(commentRepository, times(1)).findAllByDiaryId(diaryId);

     }

}