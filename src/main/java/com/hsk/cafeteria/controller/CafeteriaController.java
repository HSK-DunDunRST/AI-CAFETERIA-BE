package com.hsk.cafeteria.controller;

import com.hsk.cafeteria.apiPayload.ApiResponse;
import com.hsk.cafeteria.dto.res.CafeteriaRes;
import com.hsk.cafeteria.service.CafeteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cafeterias")
@RequiredArgsConstructor
@CrossOrigin(origins = {
        "https://cafeteria.dundunhsk.dev",
        "http://localhost:5173"
})
public class CafeteriaController {
    
    private final CafeteriaService cafeteriaService;
    
    @GetMapping
    public ApiResponse<List<CafeteriaRes>> getAllCafeterias() {
        return ApiResponse.onSuccess(cafeteriaService.getAllCafeterias());
    }
    
    @GetMapping("/{id}")
    public ApiResponse<CafeteriaRes> getCafeteriaById(@PathVariable Long id) {
        return ApiResponse.onSuccess(cafeteriaService.getCafeteriaById(id));
    }
}
