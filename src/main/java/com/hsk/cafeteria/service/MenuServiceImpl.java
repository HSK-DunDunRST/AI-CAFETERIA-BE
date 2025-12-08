package com.hsk.cafeteria.service;

import com.hsk.cafeteria.converter.MenuConverter;
import com.hsk.cafeteria.dto.res.MenuRes;
import com.hsk.cafeteria.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {
    
    private final MenuRepository menuRepository;
    
    public List<MenuRes> getMenusByCafeteriaAndDate(Long cafeteriaId, LocalDate date) {
        return menuRepository.findByCafeteriaIdAndMenuDateOrderByMealType(cafeteriaId, date)
                .stream()
                .map(MenuConverter::from)
                .collect(Collectors.toList());
    }
    
    public List<MenuRes> getMenusByDate(LocalDate date) {
        return menuRepository.findAllByDateWithCafeteria(date)
                .stream()
                .map(MenuConverter::from)
                .collect(Collectors.toList());
    }
    
    public List<MenuRes> getMenusByCafeteria(Long cafeteriaId) {
        return menuRepository.findByCafeteriaIdOrderByMenuDateDescMealTypeAsc(cafeteriaId)
                .stream()
                .map(MenuConverter::from)
                .collect(Collectors.toList());
    }
}
