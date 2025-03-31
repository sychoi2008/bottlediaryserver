package com.example.bottlediary.domain.comment;

import com.example.bottlediary.domain.BaseEntity;
import com.example.bottlediary.domain.diary.Diary;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Diary diary;

    @Builder
    public Comment(String content, Diary diary) {
        this.content = content;
        this.diary = diary;
    }
}
