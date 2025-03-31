package com.example.bottlediary.api.controller.diary;

import com.example.bottlediary.api.controller.diary.dto.FindDiaryResponse;
import com.example.bottlediary.api.service.diary.FindDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bottlediary")
@RequiredArgsConstructor
@ResponseBody
public class FindDiaryController {
    private final FindDiaryService findDiaryService;

    @GetMapping
    public FindDiaryResponse findRandomDiary(@RequestParam("emotionId") Long emotionId) {
        return findDiaryService.findRandomDiary(emotionId);
    }
}
