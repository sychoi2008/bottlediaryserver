package com.example.bottlediary.api.controller.emotion;

import com.example.bottlediary.domain.emotion.Emotion;
import com.example.bottlediary.domain.emotion.EmotionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FindEmotionListController.class)
class FindEmotionListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmotionRepository emotionRepository;

    @DisplayName("감정 전체 보기")
    @Test
    void findAllEmotion() throws Exception {
        //given
        Emotion emotion1 = new Emotion(1L, "기뻐요");
        Emotion emotion2 = new Emotion(2L, "슬퍼요");
        Emotion emotion3 = new Emotion(3L, "화나요");

        List<Emotion> emotions = List.of(emotion1, emotion2, emotion3);

        when(emotionRepository.findAll()).thenReturn(emotions);

        //when & then
        mockMvc.perform(get("/bottlediary/emotions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results[0].emotionName").value("기뻐요"))
                .andExpect(jsonPath("$.results.length()").value(3));
     }

}