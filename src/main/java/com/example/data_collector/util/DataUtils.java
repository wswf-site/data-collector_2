package com.example.data_collector.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class DataUtils {
    public static final Map<String, String> VIDEO_ID_TO_TEAM = Map.of(
            "IkycozfF8J8", "kooyoung back",
            "TwWXTxFbwiE", "BADA",
            "anws5m0M6CU", "BABYZOO",
            "sUi42HACiwY", "KASPER"
    );
    public static final String UNKNOWN_TEAM = "unknown";
}
