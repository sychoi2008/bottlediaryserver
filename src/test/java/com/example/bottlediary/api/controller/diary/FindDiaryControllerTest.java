package com.example.bottlediary.api.controller.diary;

import com.example.bottlediary.api.controller.diary.dto.FindDiaryResponse;
import com.example.bottlediary.api.service.diary.FindDiaryService;
import com.example.bottlediary.domain.diary.Diary;
import com.example.bottlediary.domain.emotion.Emotion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(FindDiaryController.class)
class FindDiaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FindDiaryService findDiaryService;

    @DisplayName("감정에 따라 랜덤 일기 값 1개 가져오기")
    @Test
    void findRandomDiary() throws Exception {
        //given
        Emotion emotion = new Emotion(1L, "기뻐요");

        Diary diary = Diary.builder()
                .title("오늘 날씨는 맑음")
                .content("오늘 햇살은 따수워요")
                .emotion(emotion)
                .userId("guest01")
                .build();
        FindDiaryResponse response = FindDiaryResponse.of(diary);


        when(findDiaryService.findRandomDiary(1L)).thenReturn(response);


        //when
        mockMvc.perform(get("/bottlediary")
                .param("emotionId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("오늘 햇살은 따수워요"))
                .andExpect(jsonPath("$.emotionName").value("기뻐요"));

        //then

     }
}