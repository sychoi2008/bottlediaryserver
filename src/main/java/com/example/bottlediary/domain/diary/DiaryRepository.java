package com.example.bottlediary.domain.diary;

import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryListResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    // 감정에 따른 랜덤 일기 1개 받기
    @Query(value = "select * from diary d where d.emotion_id = :emotionId order by rand() limit 1", nativeQuery = true)
    Diary findOneRandomDiaryByEmotionId(@Param("emotionId") Long emotionId);

    // 내 일기 목록을 보기
    @Query("select new com.example.bottlediary.api.controller.diary.dto.FindMyDiaryListResponse(d.id, d.title, d.emotion.emotionName, d.createdDateTime)" +
    "from Diary d join d.emotion e where d.userId = :userId")
    List<FindMyDiaryListResponse> findAllMyDiaryList(@Param("userId") String userId, Pageable pageable);

}
