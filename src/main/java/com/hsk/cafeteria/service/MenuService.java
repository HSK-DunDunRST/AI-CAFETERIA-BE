package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.res.MenuResponse;

import java.time.LocalDate;
import java.util.List;

public interface MenuService {
    List<MenuResponse> getMenusByCafeteriaAndDate(Long cafeteriaId, LocalDate date);
    List<MenuResponse> getMenusByDate(LocalDate date);
    List<MenuResponse> getMenusByCafeteria(Long cafeteriaId);
}
