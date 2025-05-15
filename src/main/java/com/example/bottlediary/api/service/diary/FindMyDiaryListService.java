package com.example.bottlediary.api.service.diary;

import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryListResponse;
import com.example.bottlediary.domain.diary.DiaryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FindMyDiaryListService {
    private final DiaryRepository diaryRepository;


    public Page<FindMyDiaryListResponse> findMyDiaryList(String userId, Pageable pageable) {
        return diaryRepository.findAllMyDiaryList(userId, pageable);
    }

}
