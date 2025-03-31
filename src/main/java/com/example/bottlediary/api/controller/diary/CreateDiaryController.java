package com.example.bottlediary.api.controller.diary;


import com.example.bottlediary.api.controller.diary.dto.CreateDiaryRequest;
import com.example.bottlediary.api.service.diary.CreateDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bottlediary")
@RequiredArgsConstructor
public class CreateDiaryController {
    private final CreateDiaryService createDiaryService;

    @PostMapping("/todaydiary")
    public ResponseEntity<String> createDiary(@RequestBody CreateDiaryRequest request) {
        createDiaryService.execute(request);
        return new ResponseEntity<>("일기 저장 성공", HttpStatus.CREATED);
    }
}
