package com.example.bottlediary.api.service.diary;

import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryListResponse;
import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryWithUserIdRequest;
import com.example.bottlediary.domain.diary.DiaryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class FindMyDiaryListServiceTest {

    @Mock
    private DiaryRepository diaryRepository;

    @InjectMocks
    private FindMyDiaryListService findMyDiaryListService;

    @DisplayName("내 일기 목록 확인하기")
    @Test
    void findMyDiaryList() {
        //given
        // 클라이언트에서 날라오는 값들
        String nickname = "guest01";

        // 서비스에 파라미터로 전달되어진 값
        FindMyDiaryWithUserIdRequest request = new FindMyDiaryWithUserIdRequest(nickname);
        PageRequest pageable = PageRequest.of(0, 3);

        // 리포지토리에서 가져온 값
        List<FindMyDiaryListResponse> diaryList = List.of(
                new FindMyDiaryListResponse(1L, "title1", "기뻐요", LocalDateTime.now())
        );

        Page<FindMyDiaryListResponse> expectedResponse = new PageImpl<>(diaryList);
        when(diaryRepository.findAllMyDiaryList(nickname, pageable)).thenReturn(expectedResponse);
        Page<FindMyDiaryListResponse> actual = findMyDiaryListService.findMyDiaryList(request.getUserId(), pageable);

        //then
        verify(diaryRepository, times(1)).findAllMyDiaryList(nickname, pageable);
        assertThat(actual.getContent()).isEqualTo(diaryList);
     }

}