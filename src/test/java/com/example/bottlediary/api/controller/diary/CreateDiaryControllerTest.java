package com.example.bottlediary.api.controller.diary;

import com.example.bottlediary.api.controller.diary.dto.CreateDiaryRequest;
import com.example.bottlediary.api.service.diary.CreateDiaryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//WebMvcTest : 테스트할 컨트롤러 클래스
// 이때 Controller, RequestMapping, JSON 변환 만 포함한다 -> 서비스, 리포지토리는 자동으로 로드되지 않음
// 컨트롤러는 spring mvc의 기능을 사용하고 있기 때문에 테스트에도 스프링이 있어야 함
// 컨트롤러와 관련된 애노테이션만 스캔에서 스프링 컨테이너에 빈으로 등록함!!!! -> 나머지는 직접 등록해줘야 함
@WebMvcTest(CreateDiaryController.class)
class CreateDiaryControllerTest {

    // 가짜 HTTP 요청(즉, 네트워크를 사용하지 않고 컨트롤러를 직접 호출하는 것)을 보내고 결과를 검증하는 도구
    @Autowired
    private MockMvc mockMvc;


    // @MockBean이 deprecated 되었기 때문에 사용
    // @WebMvcTest는 Service 빈을 만들지 않기 때문에
    // 스프링 컨테이너에 가짜 빈으로 등록되는 것(@Mock이랑 다름)
    // MockitoBean은 스프링이 주입(Mock은 직접 InjectMocks로 주입됨)
    // 스프링 부트 테스트 환경임(서비스 테스트는 스프링을 띄우지 않음)
    @MockitoBean
    private CreateDiaryService createDiaryService;

    @DisplayName("일기 작성 api 성공")
    @Test
    void createDiaryController() throws Exception{
        //given
        String requestBody = """
                {
                    "title": "오늘 날씨는 맑음",
                    "content": "오늘 햇살이 따뜻했어요. 아침에 산책하다가 발견한 기쁨",
                    "emotionId": 1,
                    "userId": "user123",
                    "password": "1234"
                }
                """;

        //when
        // 실제 서버 없이 가짜 요청 보내기 -> 내부에서 컨트롤러 메서드가 호출됨
        // perform().andExpect()
        mockMvc.perform(post("/bottlediary/todaydiary")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("일기 저장 성공"));

        //then
        // 서비스 객체 안에 있는 execute 메서드가 실행이 되었는가?
        verify(createDiaryService).execute(any(CreateDiaryRequest.class));

     }

}