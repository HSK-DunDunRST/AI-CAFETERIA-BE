package com.hsk.cafeteria.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CafeteriaResponse {
    
    private Long id;
    private String name;
    private String type;
    private String location;
    private String openingHours;
    private LocalDateTime createdAt;
}
