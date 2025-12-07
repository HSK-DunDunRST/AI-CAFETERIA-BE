package com.hsk.cafeteria.converter;

import com.hsk.cafeteria.dto.res.MenuResponse;
import com.hsk.cafeteria.entity.MenuEntity;

public class MenuConverter {
    public static MenuResponse from(MenuEntity menuEntity) {
        return MenuResponse.builder()
                .id(menuEntity.getId())
                .cafeteriaId(menuEntity.getCafeteria().getId())
                .cafeteriaName(menuEntity.getCafeteria().getName())
                .cafeteriaType(menuEntity.getCafeteria().getType().name().toLowerCase())
                .mealType(menuEntity.getMealType().name().toLowerCase())
                .menuDate(menuEntity.getMenuDate())
                .menuDish(menuEntity.getMenuDish())
                .price(menuEntity.getMenuPrice())
                .createdAt(menuEntity.getCreatedAt())
                .build();
    }
}
