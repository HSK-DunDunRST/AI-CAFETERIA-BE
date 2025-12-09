package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.res.MenuRes;
import com.hsk.cafeteria.entity.enums.CafeteriaType;

import java.time.LocalDate;
import java.util.List;

public interface MenuService {
    List<MenuRes> getStudentCateria(CafeteriaType cafeteriaType);
    List<MenuRes> getCafeteriaTypeAndDate(CafeteriaType cafeteriaType, LocalDate date);

}
