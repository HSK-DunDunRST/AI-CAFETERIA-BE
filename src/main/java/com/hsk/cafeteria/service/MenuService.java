package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.res.MenuRes;

import java.time.LocalDate;
import java.util.List;

public interface MenuService {
    List<MenuRes> getMenusByCafeteriaAndDate(Long cafeteriaId, LocalDate date);
    List<MenuRes> getMenusByDate(LocalDate date);
    List<MenuRes> getMenusByCafeteria(Long cafeteriaId);
}
