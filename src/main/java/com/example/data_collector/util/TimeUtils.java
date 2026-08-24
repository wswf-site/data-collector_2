package com.example.data_collector.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeUtils {
    public static final ZoneId KST = ZoneId.of("Asia/Seoul");

    public static LocalDateTime nowKST() {
        return LocalDateTime.now(KST);
    }

}
