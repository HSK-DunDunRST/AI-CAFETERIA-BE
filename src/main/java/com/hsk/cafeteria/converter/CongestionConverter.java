package com.hsk.cafeteria.converter;

import com.hsk.cafeteria.dto.res.CongestionResponse;
import com.hsk.cafeteria.entity.CongestionEntity;

public class CongestionConverter {
    public static CongestionResponse from(CongestionEntity congestionEntity) {
        return CongestionResponse.builder()
                .id(congestionEntity.getId())
                .cafeteriaId(congestionEntity.getCafeteria().getId())
                .cafeteriaName(congestionEntity.getCafeteria().getName())
                .cafeteriaType(congestionEntity.getCafeteria().getType().name().toLowerCase())
                .congestionLevel(congestionEntity.getCongestionLevel().name().toLowerCase())
                .peopleCount(congestionEntity.getPeopleCount())
                .recordedAt(congestionEntity.getCreatedAt())
                .build();
    }
}
