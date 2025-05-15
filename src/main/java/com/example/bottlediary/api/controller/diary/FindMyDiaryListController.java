package com.example.bottlediary.api.controller.diary;

import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryListResponse;
import com.example.bottlediary.api.controller.diary.dto.FindMyDiaryWithUserIdRequest;
import com.example.bottlediary.api.service.diary.FindMyDiaryListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bottlediary")
@RequiredArgsConstructor
@ResponseBody
public class FindMyDiaryListController {
    private final FindMyDiaryListService findMyDiaryListService;


    @PostMapping("/mydiary")
    public Page<FindMyDiaryListResponse> findAllMyDiaryList(@RequestParam(defaultValue = "1") Integer page,
                                                            @RequestParam(defaultValue = "5") Integer size,
                                                            @Valid @RequestBody FindMyDiaryWithUserIdRequest request
                                                            ) {
        return findMyDiaryListService.findMyDiaryList(request.getUserId(),
                PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "createdDateTime")));

    }

}
