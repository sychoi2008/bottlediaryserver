package com.example.bottlediary.api.service.diary;

import com.example.bottlediary.api.controller.diary.dto.CreateDiaryRequest;
import com.example.bottlediary.domain.diary.Diary;
import com.example.bottlediary.domain.diary.DiaryRepository;
import com.example.bottlediary.domain.emotion.Emotion;
import com.example.bottlediary.domain.emotion.EmotionRepository;
import com.example.bottlediary.domain.emotion.exception.EmotionNotFoundException;
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

/**
 * 테스트의 목적
 * 1. 정상적으로 일기가 저장되는가?
 * 2. 감정 아이디가 잘못 되어 예외가 발생하는가?
 * 우리는 테스트를 통해 그저 호출이 되었다! 이것만 확인하려는 것이다(데이터가 전달되고 그런 것은 신경X)
 * 테스트 대상(Service, Controller 등)의 로직이 원하는 대로 흘러가고 있는지를 확인하는 거지,
 * 의존 객체(Repository 등)가 실제로 동작하는 걸 보려는 게 아님
 */

@ActiveProfiles("test")
// 이 테스트 클래스는 Mockito 기능을 사용할 거야(@Mock, @InjectMocks)을 사용하려면 반드시 필요
@ExtendWith(MockitoExtension.class)
class CreateDiaryServiceTest {
    // @Mock : 이 객체는 진짜가 아니라 가짜야! -> 실제 객체를 쓰면 느림, 의존성 객체에만 사용
    // 가짜 객체인데 어떻게 작동해? -> when()으로 시나리오를 설정해서 연기하는 것
    // 서비스 계층은 순수한 자바 코드로 작성해야 하기 때문에 스프링을 사용하지 않는 @Mock을 사용
    @Mock
    private DiaryRepository diaryRepository;

    @Mock
    private EmotionRepository emotionRepository;

    // @InjectMocks을 사용하면 위에 @Mock 객체가 자동으로 주입된다, 이 애노테이션은 테스트 대상 클래스에 사용
    // CreateDiaryService는 진짜 객체
    @InjectMocks
    private CreateDiaryService createDiaryService;

    @DisplayName("일기 정상 저장")
    @Test
    void execute() {
        //given
        // 가짜 감정 객체
        Emotion emotion = new Emotion(1L, "기뻐요");

        // when? 이 Mock 객체는 이런 요청이 오면, 이렇게 대답해줘!라고 세팅함
        // when을 하지 않고 Mock을 써버리면 null 또는 예외가 발생할 수 있음
        when(emotionRepository.findById(1L)).thenReturn(Optional.of(emotion));

        // 요청 객체
        CreateDiaryRequest request = new CreateDiaryRequest(
                "오늘 날씨는 맑음",
                "오늘은 정말 행복한 하루였습니다. 날도 좋고요 봄이 오나봐요.",
                1L,
                "user123",
                "1234");

        //when
        createDiaryService.execute(request);

        //then
        // verify: 이 Mock 객체의 메서드가 정말 호출이 되었는지 확인해줘!
        // 즉, 서비스가 리포지토리를 정말로 호출했니?를 검증한다
        // any: 어떤 다이어리든 호출되기만 하면 됨
        verify(diaryRepository).save(any(Diary.class));

     }

     @DisplayName("감정 id가 없으면 예외 발생")
     @Test
     void emotionNotFoundException() {
         //given
         when(emotionRepository.findById(999L)).thenReturn(Optional.empty());


         //when
         CreateDiaryRequest request = new CreateDiaryRequest(
                 "가짜 제목",
                 "메롱~",
                 999L,
                 "user123",
                 "1234");

         //then
         assertThrows(EmotionNotFoundException.class, () -> {
             createDiaryService.execute(request);
         });

      }




}