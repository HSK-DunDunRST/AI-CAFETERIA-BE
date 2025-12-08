package com.hsk.cafeteria.dto.res;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllDataRes {

    private CafeteriaRes cafeteria;
    private MenuRes menu;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CafeteriaRes {
        private Long id;
        private String name;
        private String type;
        private String location;
        private String openingHours;
        private LocalDateTime createdAt;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MenuRes {
        private Long id;
        private Long cafeteriaId;
        private String cafeteriaName;
        private String cafeteriaType;
        private String mealType;
        private LocalDate menuDate;
        private String menuDish;
        private Integer price;
        private LocalDateTime createdAt;
    }

}
