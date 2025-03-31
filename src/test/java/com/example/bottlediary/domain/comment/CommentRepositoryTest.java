package com.example.bottlediary.domain.comment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @DisplayName("일기 id로 댓글 찾기")
    @Test
    void findAllByDiaryId() {
        //given
        Long diaryId = 1L;

        //when
        List<Comment> comments = commentRepository.findAllByDiaryId(diaryId);

        //then
        assertThat(comments).isNotNull();
        assertThat(comments.get(0).getDiary().getId()).isEqualTo(diaryId);

     }
}