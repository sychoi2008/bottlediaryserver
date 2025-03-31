package com.example.bottlediary.api.controller.comment;

import com.example.bottlediary.api.controller.comment.dto.CreateCommentRequest;
import com.example.bottlediary.api.service.comment.CreateCommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreateCommentController.class)
class CreateCommentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CreateCommentService createCommentService;

    @DisplayName("댓글 저장 성공")
    @Test
    void test() throws Exception {
        //given
        String requestBody = """
                {
                    "content": "저도 오늘 참 행복했습니다. 마음의 그늘이 조금 사라지는 느낌",
                    "diaryId": 1
                }
                """;

        //when
        mockMvc.perform(post("/bottlediary/todaycomment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("댓글 저장 성공"));

        //then
        verify(createCommentService).execute(any(CreateCommentRequest.class));

     }

}