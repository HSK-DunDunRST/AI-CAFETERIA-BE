package com.hsk.cafeteria.converter;

import com.hsk.cafeteria.dto.res.CongestionRes;
import com.hsk.cafeteria.entity.CongestionEntity;

public class CongestionConverter {
    public static CongestionRes from(CongestionEntity congestionEntity) {
        return CongestionRes.builder()
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
