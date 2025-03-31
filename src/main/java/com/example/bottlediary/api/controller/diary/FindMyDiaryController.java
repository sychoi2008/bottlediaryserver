package com.example.bottlediary.api.controller.diary;

import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryResponse;
import com.example.bottlediary.api.service.diary.FindMyDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bottlediary")
@RequiredArgsConstructor
@ResponseBody
public class FindMyDiaryController {

    private final FindMyDiaryService findMyDiaryService;

    @GetMapping("/mydiary")
    public FindMyDiaryResponse execute(@RequestParam("diaryId") Long diaryId) {
        return findMyDiaryService.findMyDiary(diaryId);
    }
}
