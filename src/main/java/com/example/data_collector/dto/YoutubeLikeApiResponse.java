package com.example.data_collector.dto;

import lombok.Data;

@Data
public class YoutubeLikeApiResponse {
    private String id;
    private String dateCreated; // ISO-8601 형식이므로 Instant.parse()로 변환 가능
    private Long likes;
    private Long rawDislikes;
    private Long rawLikes;
    private Long dislikes;
    private Long viewCount;
}
