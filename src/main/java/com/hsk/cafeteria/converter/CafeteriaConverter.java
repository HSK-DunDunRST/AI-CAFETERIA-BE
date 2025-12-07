package com.hsk.cafeteria.converter;

import com.hsk.cafeteria.dto.res.CafeteriaResponse;
import com.hsk.cafeteria.entity.CafeteriaEntity;

public class CafeteriaConverter {
    public static CafeteriaResponse from(CafeteriaEntity cafeteriaEntity) {
        return CafeteriaResponse.builder()
                .id(cafeteriaEntity.getId())
                .name(cafeteriaEntity.getName())
                .type(cafeteriaEntity.getType().toString())
                .location(cafeteriaEntity.getLocation())
                .openingHours(cafeteriaEntity.getOpeningHours())
                .build();
    }
}
