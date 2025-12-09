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

    @Override
    public List<MenuRes> getStudentCateria(CafeteriaType cafeteriaType) {
        return menuRepository.findByCafeteriaType(cafeteriaType)
                .stream()
                .map(MenuConverter::from)
                .toList();
    }

    @Override
    public List<MenuRes> getCafeteriaTypeAndDate(CafeteriaType cafeteriaType, LocalDate date) {
        return menuRepository.findByCafeteriaTypeAndMenuDate(cafeteriaType, date)
                .stream()
                .map(MenuConverter::from)
                .toList();
    }
}
