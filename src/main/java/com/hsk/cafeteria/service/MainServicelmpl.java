package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.res.CafeteriaRes;
import com.hsk.cafeteria.dto.res.MainRes;
import com.hsk.cafeteria.dto.res.MenuRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainServicelmpl implements MainService {

    private final CafeteriaService cafeteriaService;
    private final MenuService menuService;

    @Override
    public MainRes getAllData(LocalDate date) {

        List<CafeteriaRes> getCafeteriaInfo = cafeteriaService.getAllCafeterias();
        List<MenuRes> getMenusInfo = menuService.getMenusByDate(date);


        return MainRes.builder()
                .cafeteria(getCafeteriaInfo)
                .menu(getMenusInfo)
                .build();
    }
}
