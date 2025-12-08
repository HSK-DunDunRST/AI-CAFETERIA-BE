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
public class CongestionRes {
    
    private Long id;
    private Long cafeteriaId;
    private String cafeteriaName;
    private String cafeteriaType;
    private String congestionLevel;
    private Integer peopleCount;
    private LocalDateTime recordedAt;
}
