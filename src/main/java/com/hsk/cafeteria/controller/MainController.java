package com.hsk.cafeteria.controller;

import com.hsk.cafeteria.apiPayload.ApiResponse;
import com.hsk.cafeteria.dto.res.MainRes;
import com.hsk.cafeteria.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
@CrossOrigin(origins = {
        "https://cafeteria.dundunhsk.dev",
        "http://localhost:5173"
})
public class MainController {
    
    private final MainService allDataService;

    @GetMapping
    public ApiResponse<MainRes> getAllData(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ApiResponse.onSuccess(allDataService.getData(date != null ? date : LocalDate.now()));
    }
}
