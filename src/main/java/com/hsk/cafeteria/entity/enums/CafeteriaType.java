package com.hsk.cafeteria.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CafeteriaType {
    STUDENT,    // 학생식당
    STAFF,      // 교직원식당
    DORM        // 기숙사식당
}
