package com.example.data_collector.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.example.data_collector.util.TimeUtils.KST;

@Component
@Slf4j
public class AppShutdownScheduler {

//    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
//
//    @Autowired
//    private ApplicationContext context;
//
//    @PostConstruct
//    public void scheduleShutdown() {
//        ZonedDateTime shutdownTime = ZonedDateTime.of(2025, 7, 3, 0, 28, 0, 0, KST);
//        ZonedDateTime now = ZonedDateTime.now(KST);
//
//        long delaySeconds = Duration.between(now, shutdownTime).getSeconds();
//
//        if (delaySeconds <= 0) {
//            log.info("[WARN] 종료 시각이 이미 지났습니다. 즉시 종료합니다.");
//            gracefulShutdown();
//            return;
//        }
//
//        log.info("[INFO] 종료 예약됨: " + shutdownTime + " (남은 시간: " + delaySeconds + "초)");
//
//        scheduler.schedule(this::gracefulShutdown, delaySeconds, TimeUnit.SECONDS);
//    }
//
//    private void gracefulShutdown() {
//        log.info("[INFO] 종료 시각 도달. Spring 애플리케이션 종료 중...");
//        int exitCode = SpringApplication.exit(context, () -> 0); // 종료 코드 0
//        System.exit(exitCode); // exit(0) 호출
//    }
}
