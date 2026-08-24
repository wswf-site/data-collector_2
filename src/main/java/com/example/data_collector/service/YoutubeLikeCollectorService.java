package com.example.data_collector.service;

import com.example.data_collector.dto.YoutubeLikeApiResponse;
import com.example.data_collector.entity.YoutubeLike;
import com.example.data_collector.repository.YoutubeLikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

import static com.example.data_collector.util.DataUtils.*;
import static com.example.data_collector.util.TimeUtils.nowKST;

@Slf4j
@Service
@RequiredArgsConstructor
public class YoutubeLikeCollectorService {
    private final YoutubeLikeRepository youtubeLikeRepository;
    private final RestTemplate restTemplate;

    @Value("${youtube.like.base-url}")
    private String baseUrl;

//        @Scheduled(cron = "0 0,30 * * * *")  // 30분마다
//    @Scheduled(cron = "*/30 * * * * *")  // 30초마다
    @Scheduled(cron = "0 */5 * * * *")  // 5분마다
    public void collectLikes() {
        for (String videoId : VIDEO_ID_TO_TEAM.keySet()) {
            try {
                String url = String.format("%s?videoId=%s", baseUrl, videoId);

                var response = restTemplate.getForObject(url, YoutubeLikeApiResponse.class);

                if (response == null || response.getDateCreated() == null) {
                    log.warn("좋아요 API 응답이 비어 있습니다. URL: {}", url);
                    return;
                }

                YoutubeLike like = YoutubeLike.builder()
                        .videoId(videoId)
                        .teamName(VIDEO_ID_TO_TEAM.getOrDefault(videoId, UNKNOWN_TEAM))
                        .likes(response.getLikes())
                        .dislikes(response.getDislikes())
                        .rawLikes(response.getRawLikes()*200)
                        .rawDislikes(response.getRawDislikes()*100)
                        .viewCount(response.getViewCount())
                        .dateCreated(Instant.parse(response.getDateCreated()))
                        .collectedAt(Instant.now())
                        .build();

                youtubeLikeRepository.save(like);
            } catch (Exception e) {
                log.warn("좋아요 저장 실패 - videoId: {}, error: {}", videoId, e.getMessage());
            }
        }
        log.info("좋아요 데이터 저장 완료: {}", nowKST());
    }
}
