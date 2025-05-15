package com.example.bottlediary.api.controller.diary;

import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryListResponse;
import com.example.bottlediary.api.service.diary.FindMyDiaryListService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(FindMyDiaryListController.class)
class FindMyDiaryListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FindMyDiaryListService findMyDiaryListService;

    @DisplayName("내가 쓴 일기 목록")
    @Test
    void findAllMyDiaryList() throws Exception {
        // given
        String requestBody = """
            {
                "userId": "guest01",
                "userPwd": "1234"
            }
            """;

        List<FindMyDiaryListResponse> diaryList = List.of(
                new FindMyDiaryListResponse(1L, "title1", "기뻐요", LocalDateTime.now())
        );

        Page<FindMyDiaryListResponse> expectedResponse = new PageImpl<>(diaryList);

        when(findMyDiaryListService.findMyDiaryList(any(), any())).thenReturn(expectedResponse);

        // when & then
        mockMvc.perform(post("/bottlediary/mydiary")
                        .param("page", "1")
                        .param("size", "3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title").value("title1"))
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1));
    }


}