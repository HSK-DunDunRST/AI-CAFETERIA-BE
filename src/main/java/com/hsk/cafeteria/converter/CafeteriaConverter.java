package com.hsk.cafeteria.converter;

import com.hsk.cafeteria.dto.res.CafeteriaRes;
import com.hsk.cafeteria.entity.CafeteriaEntity;

public class CafeteriaConverter {
    public static CafeteriaRes from(CafeteriaEntity cafeteriaEntity) {
        return CafeteriaRes.builder()
                .id(cafeteriaEntity.getId())
                .name(cafeteriaEntity.getName())
                .type(cafeteriaEntity.getType().toString())
                .location(cafeteriaEntity.getLocation())
                .openingHours(cafeteriaEntity.getOpeningHours())
                .build();
    }
}
