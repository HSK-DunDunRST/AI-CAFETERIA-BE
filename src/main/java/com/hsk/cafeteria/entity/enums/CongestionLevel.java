package com.hsk.cafeteria.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CongestionLevel {
    LOW,      // 여유
    MEDIUM,   // 보통
    HIGH      // 혼잡
}
