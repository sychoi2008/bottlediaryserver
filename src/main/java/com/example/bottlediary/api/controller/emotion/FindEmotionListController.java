package com.example.bottlediary.api.controller.emotion;

import com.example.bottlediary.api.controller.emotion.dto.FindEmotionResponse;
import com.example.bottlediary.domain.emotion.Emotion;
import com.example.bottlediary.domain.emotion.EmotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bottlediary")
@RequiredArgsConstructor
public class FindEmotionListController {

    private final EmotionRepository emotionRepository;

    @GetMapping("/emotions")
    public FindEmotionResponse findAllEmotion() {
        List<Emotion> allEmotions = emotionRepository.findAll();
        return FindEmotionResponse.of(allEmotions);
    }
}
