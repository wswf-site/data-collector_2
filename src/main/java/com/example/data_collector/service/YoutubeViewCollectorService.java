package com.example.data_collector.service;

import com.example.data_collector.dto.YouTubeViewApiResponse;
import com.example.data_collector.entity.YoutubeView;
import com.example.data_collector.repository.YoutubeViewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

import static com.example.data_collector.util.TimeUtils.nowKST;
import static com.example.data_collector.util.DataUtils.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class YoutubeViewCollectorService {
    private final YoutubeViewRepository youtubeViewRepository;
    private final RestTemplate restTemplate;

    @Value("${youtube.view.base-url}")
    private String baseUrl;
    @Value("${youtube.view.video-ids}")
    private String videoIds;
    @Value("${youtube.view.api-key}")
    private String apiKey;

//    @Scheduled(cron = "0 */5 * * * *")  // 5분마다
    @Scheduled(cron = "*/10 * * * * *")  // 10초마다
    public void collectViews() {
        String url = String.format("%s&id=%s&key=%s", baseUrl, videoIds, apiKey);

        var response = restTemplate.getForObject(url, YouTubeViewApiResponse.class);

        if (response == null || response.getItems() == null) {
            log.warn("조회수 API 응답이 비어 있습니다. URL: {}", url);
            return;
        }

        for (YouTubeViewApiResponse.Item item : response.getItems()) {
            try {
                String videoId = item.getId();
                String teamName = VIDEO_ID_TO_TEAM.getOrDefault(videoId, UNKNOWN_TEAM);

                YoutubeView view = YoutubeView.builder()
                        .videoId(videoId)
                        .teamName(teamName)
                        .viewCount(item.getStatistics().getViewCount())
                        .commentCount(item.getStatistics().getCommentCount())
                        .collectedAt(Instant.now())
                        .build();

                youtubeViewRepository.save(view);
            } catch (Exception e) {
                log.warn("조회수 저장 실패 - videoId: {}, error: {}", item.getId(), e.getMessage());
            }
        }
        log.info("조회수 데이터 저장 완료: {}", nowKST());
    }

}
