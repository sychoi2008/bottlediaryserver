package com.example.bottlediary.api.controller.diary;

import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryResponse;
import com.example.bottlediary.api.service.diary.FindMyDiaryService;
import com.example.bottlediary.domain.comment.Comment;
import com.example.bottlediary.domain.diary.Diary;
import com.example.bottlediary.domain.emotion.Emotion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FindMyDiaryController.class)
class FindMyDiaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FindMyDiaryService findMyDiaryService;

    @DisplayName("일기 상세 내용과 댓글 반환")
    @Test
    void execute() throws Exception{
        //given
        Long diaryId = 1L;

        Emotion emotion = new Emotion(1L, "기뻐요");
        Diary diary = Diary.builder()
                .title("오늘 날씨는 맑음")
                .content("오늘 햇살은 따수워요")
                .emotion(emotion)
                .userId("guest01")
                .build();

        List<Comment> comments = List.of(
                Comment.builder()
                        .content("오늘은 날씨가 좋아요")
                        .diary(diary)
                        .build(),
                Comment.builder()
                        .content("오늘은 날씨가 좋아요")
                        .diary(diary)
                        .build()
        );

        FindMyDiaryResponse response = FindMyDiaryResponse.of(diary, comments);
        when(findMyDiaryService.findMyDiary(diaryId)).thenReturn(response);

        //when
        mockMvc.perform(get("/bottlediary/mydiary")
                .param("diaryId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("오늘 날씨는 맑음"))
                .andExpect(jsonPath("$.emotionName").value("기뻐요"))
                .andExpect(jsonPath("$.comments").isArray())
                .andExpect(jsonPath("$.comments.length()").value(2));

        //then

     }

}