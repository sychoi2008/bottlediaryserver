package com.example.bottlediary.api.service.diary;

import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryResponse;
import com.example.bottlediary.domain.comment.Comment;
import com.example.bottlediary.domain.comment.CommentRepository;
import com.example.bottlediary.domain.diary.Diary;
import com.example.bottlediary.domain.diary.DiaryRepository;
import com.example.bottlediary.domain.diary.exception.DiaryNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FindMyDiaryService {
    private final DiaryRepository diaryRepository;
    private final CommentRepository commentRepository;

    public FindMyDiaryResponse findMyDiary(Long diaryId) {
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> new DiaryNotFoundException(diaryId));

        List<Comment> comments = commentRepository.findAllByDiaryId(diaryId);

        return FindMyDiaryResponse.of(diary, comments);
    }

}
