package com.example.data_collector.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "views")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YoutubeView {
    @Id
    private String id;
    private String videoId;
    private String teamName;
    private Long viewCount;
    private Long commentCount;
    private Instant collectedAt;
}
