package com.example.bottlediary.api.service.diary;

import com.example.bottlediary.api.controller.diary.dto.CreateDiaryRequest;
import com.example.bottlediary.domain.diary.Diary;
import com.example.bottlediary.domain.diary.DiaryRepository;
import com.example.bottlediary.domain.emotion.Emotion;
import com.example.bottlediary.domain.emotion.EmotionRepository;
import com.example.bottlediary.domain.emotion.exception.EmotionNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateDiaryService {
    private final EmotionRepository emotionRepository;
    private final DiaryRepository diaryRepository;

    public void execute(CreateDiaryRequest request) {
        Emotion emotion = emotionRepository.findById(request.getEmotionId())
                .orElseThrow(() -> new EmotionNotFoundException(request.getEmotionId()));

        String temp = request.getUserId()+request.getPassword();
        String userId = encrypt(temp);

        diaryRepository.save(
                Diary.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .emotion(emotion)
                        .userId(userId)
                        .build()
        );
    }


    private String encrypt(String userId) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) { // 체크 예외 -> 런타임 에러로 수정
            throw new IllegalArgumentException(e);
        }
        md.update(userId.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(md.digest());
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
