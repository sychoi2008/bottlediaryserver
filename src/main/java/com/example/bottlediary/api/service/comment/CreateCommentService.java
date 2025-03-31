package com.example.bottlediary.api.service.comment;

import com.example.bottlediary.api.controller.comment.dto.CreateCommentRequest;
import com.example.bottlediary.domain.comment.Comment;
import com.example.bottlediary.domain.comment.CommentRepository;
import com.example.bottlediary.domain.diary.Diary;
import com.example.bottlediary.domain.diary.DiaryRepository;
import com.example.bottlediary.domain.diary.exception.DiaryNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateCommentService {
    private final DiaryRepository diaryRepository;
    private final CommentRepository commentRepository;

    public void execute(CreateCommentRequest request) {
        //일기 찾기
        Diary diary = diaryRepository.findById(request.getDiaryId())
                .orElseThrow(() -> new DiaryNotFoundException(request.getDiaryId()));

        commentRepository.save(
                Comment.builder()
                        .content(request.getContent())
                        .diary(diary)
                        .build()
        );
    }
}
