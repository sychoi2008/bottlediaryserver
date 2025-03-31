package com.example.bottlediary.api.service.diary;

import com.example.bottlediary.api.controller.diary.dto.FindDiaryResponse;
import com.example.bottlediary.domain.diary.Diary;
import com.example.bottlediary.domain.diary.DiaryRepository;
import com.example.bottlediary.domain.emotion.Emotion;
import com.example.bottlediary.domain.emotion.EmotionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class FindDiaryServiceTest {

    // 실제 DB에 접근하지 않는 가짜 객체
    @Mock
    private DiaryRepository diaryRepository;

    @InjectMocks
    private FindDiaryService findDiaryService;

    @DisplayName("감정에 따라 랜덤으로 일기 1개 가져오기")
    @Test
    void findRandomDiary() {
        //given
        Long emotionId = 1L;

        Emotion emotion = new Emotion(1L, "기뻐요");

        Diary diary = Diary.builder()
                .content("오늘은 엄마랑 같이 산책한 날! 날씨가 엄청 이상했는데 재밌었다.")
                .emotion(emotion)
                .userId("guest01")
                .build();

        when(diaryRepository.findOneRandomDiaryByEmotionId(emotionId)).thenReturn(diary);

        //when
        FindDiaryResponse response = findDiaryService.findRandomDiary(emotionId);

        //then
        assertThat(response).isNotNull();
        assertThat(response.getEmotionName()).isEqualTo("기뻐요");

        // 정확히 한 번만 호출되었어야 한다(times(1))
        verify(diaryRepository, times(1)).findOneRandomDiaryByEmotionId(emotionId);

     }

}