package com.hsk.cafeteria.controller;

import com.hsk.cafeteria.apiPayload.ApiResponse;
import com.hsk.cafeteria.dto.req.CongestionReq;
import com.hsk.cafeteria.dto.res.CongestionRes;
import com.hsk.cafeteria.service.CongestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/congestion")
@RequiredArgsConstructor
@CrossOrigin(origins = {
        "https://cafeteria.dundunhsk.dev",
        "http://localhost:5173"
})
public class CongestionController {
    
    private final CongestionService congestionService;
    
    @GetMapping
    public ApiResponse<List<CongestionRes>> getLatestCongestions() {
        return ApiResponse.onSuccess(congestionService.getLatestCongestions());
    }
    
    @GetMapping("/{cafeteriaId}")
    public ApiResponse<CongestionRes> getLatestCongestionByCafeteria(@PathVariable Long cafeteriaId) {
        return ApiResponse.onSuccess(congestionService.getLatestCongestionByCafeteria(cafeteriaId));
    }
    
    @PostMapping("/{cafeteriaId}")
    public ApiResponse<CongestionRes> updateCongestion(
            @PathVariable Long cafeteriaId,
            @Valid @RequestBody CongestionReq request) {
        return ApiResponse.onSuccess(congestionService.updateCongestion(cafeteriaId, request));
    }
}
