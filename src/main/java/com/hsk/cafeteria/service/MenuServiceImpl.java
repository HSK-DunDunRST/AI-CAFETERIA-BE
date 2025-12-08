package com.hsk.cafeteria.service;

import com.hsk.cafeteria.converter.MenuConverter;
import com.hsk.cafeteria.dto.res.MenuRes;
import com.hsk.cafeteria.entity.enums.CafeteriaType;
import com.hsk.cafeteria.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {
    
    private final MenuRepository menuRepository;
    
    public List<MenuRes> getStudentMenus() {
        return menuRepository.findByCafeteriaType(CafeteriaType.STUDENT)
                .stream()
                .map(MenuConverter::from)
                .toList();
    }
    
    public List<MenuRes> getMenusByDate(LocalDate date) {
        return menuRepository.findAllByDateWithCafeteria(date)
                .stream()
                .map(MenuConverter::from)
                .toList();

    }
    
}
