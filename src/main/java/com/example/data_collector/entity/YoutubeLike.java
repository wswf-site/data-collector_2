package com.example.data_collector.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "likes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YoutubeLike {
    @Id
    private String id;
    private String videoId;
    private String teamName;
    private Long likes;
    private Long dislikes;
    private Long rawLikes;
    private Long rawDislikes;
    private Long viewCount;
    private Instant dateCreated;  // API 제공 시각
    private Instant collectedAt;// 실제 수집한 시각
}
