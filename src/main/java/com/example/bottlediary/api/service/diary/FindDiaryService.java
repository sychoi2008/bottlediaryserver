package com.example.bottlediary.api.service.diary;

import com.example.bottlediary.api.controller.diary.dto.FindDiaryResponse;
import com.example.bottlediary.domain.diary.Diary;
import com.example.bottlediary.domain.diary.DiaryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class FindDiaryService {
    private final DiaryRepository diaryRepository;

    public FindDiaryResponse findRandomDiary(Long emotionId) {
        Diary findDiary = diaryRepository.findOneRandomDiaryByEmotionId(emotionId);
        return FindDiaryResponse.of(findDiary);
    }

}
