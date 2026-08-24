package com.example.data_collector.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class DataUtils {
    public static final Map<String, String> VIDEO_ID_TO_TEAM = Map.of(
            "Eq12SwjR25s", "MOTIV",
            "8ZpL_uXnYGQ", "BUMSUP",
            "da68UOXfQ_s", "AGSQUAD",
            "-DYg4IjGLUk", "OSAKA_OjoGang"
    );
    public static final String UNKNOWN_TEAM = "unknown";
}
