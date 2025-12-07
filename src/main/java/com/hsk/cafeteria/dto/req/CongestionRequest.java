package com.hsk.cafeteria.dto.req;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CongestionRequest {
    
    @NotNull(message = "Congestion level is required")
    @Pattern(regexp = "^(low|medium|high)$", message = "Congestion level must be low, medium, or high")
    private String congestionLevel;
    
    private Integer peopleCount;
}
