package com.hsk.cafeteria.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuResponse {
    
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
