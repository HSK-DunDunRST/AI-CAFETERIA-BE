package com.hsk.cafeteria.controller;

import com.hsk.cafeteria.apiPayload.ApiResponse;
import com.hsk.cafeteria.dto.res.MenuRes;
import com.hsk.cafeteria.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
@CrossOrigin(origins = {
        "https://cafeteria.dundunhsk.dev",
        "http://localhost:5173"
})
public class MenuController {
    
    private final MenuService menuService;
    
    @GetMapping
    public ApiResponse<List<MenuRes>> getMenus(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ApiResponse.onSuccess(menuService.getMenusByDate(date != null ? date : LocalDate.now()));
    }
    
    @GetMapping("/{cafeteriaId}")
    public ApiResponse<List<MenuRes>> getMenusByCafeteria(@PathVariable Long cafeteriaId,
                                                          @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<MenuRes> menus;
        if (date != null) {
            menus = menuService.getMenusByCafeteriaAndDate(cafeteriaId, date);
        } else {
            menus = menuService.getMenusByCafeteria(cafeteriaId);
        }
        return ApiResponse.onSuccess(menus);
    }
}
