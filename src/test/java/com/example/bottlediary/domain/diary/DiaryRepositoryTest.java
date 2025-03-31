package com.example.bottlediary.domain.diary;

import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryListResponse;
import com.example.bottlediary.domain.emotion.EmotionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 실제 쿼리가 동작하는지 확인하는 테스트 = 리포지토리 테스트
 * H2 DB를 사용해서 테스트
 */

@DataJpaTest // jpa 관련 컴포넌트만 로드
@ActiveProfiles("test")
class DiaryRepositoryTest {

    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private EmotionRepository emotionRepository;

    @DisplayName("감정을 선택하면 1개의 랜덤 일기를 보여준다.")
    @Test
    void findOneRandomDiaryByEmotionId() {
        //given
        Long emotionId = 1L; // happy

        //when
        Diary randomDiary = diaryRepository.findOneRandomDiaryByEmotionId(emotionId);

        //then
        assertThat(randomDiary).isNotNull(); // 일기 하나는 무조건 반환된다
        assertThat(randomDiary.getEmotion().getId()).isEqualTo(emotionId); // 반환된 감정은 given 값이어야 한다.
     }

     @DisplayName("내 일기 목록 확인하기")
     @Test
     void findAllMyDiaryList() {
         //given
         String userId = "guest01";
         PageRequest pageable = PageRequest.of(0, 3);

         //when
         List<FindMyDiaryListResponse> myDiaryList = diaryRepository.findAllMyDiaryList(userId, pageable);

         //then
         assertThat(myDiaryList).isNotNull();
         assertThat(myDiaryList.size()).isLessThanOrEqualTo(3);

      }


}