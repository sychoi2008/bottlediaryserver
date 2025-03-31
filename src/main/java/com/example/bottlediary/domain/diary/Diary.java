package com.example.bottlediary.domain.diary;

import com.example.bottlediary.domain.BaseEntity;
import com.example.bottlediary.domain.comment.Comment;
import com.example.bottlediary.domain.emotion.Emotion;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Emotion emotion;

    private String userId;

    // 실제 컬럼을 생성하지 않음
    // 일기가 사라지면 그 댓글도 사라지게 하는 것
//    @OneToMany(mappedBy = "diary", cascade = CascadeType.ALL)
//    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Diary(String title, String content, Emotion emotion, String userId) {
        this.title = title;
        this.content = content;
        this.emotion = emotion;
        this.userId = userId;
    }
}
