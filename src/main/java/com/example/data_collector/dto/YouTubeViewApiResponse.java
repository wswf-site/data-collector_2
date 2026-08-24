package com.example.data_collector.dto;

import lombok.Data;

import java.util.List;

@Data
public class YouTubeViewApiResponse {
    private List<Item> items;

    @Data
    public static class Item {
        private String id;
        private Statistics statistics;
    }
    @Data
    public static class Statistics {
        private Long viewCount;
        private Long commentCount;
    }
}
