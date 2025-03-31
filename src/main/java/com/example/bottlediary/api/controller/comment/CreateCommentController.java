package com.example.bottlediary.api.controller.comment;

import com.example.bottlediary.api.controller.comment.dto.CreateCommentRequest;
import com.example.bottlediary.api.service.comment.CreateCommentService;
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
public class CreateCommentController {
    private final CreateCommentService createCommentService;

    @PostMapping("/todaycomment")
    public ResponseEntity<String> createComment(@RequestBody CreateCommentRequest request) {
        createCommentService.execute(request);
        return new ResponseEntity<>("댓글 저장 성공", HttpStatus.CREATED);
    }
}
