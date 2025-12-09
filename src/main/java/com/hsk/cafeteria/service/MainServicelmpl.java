package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.res.CafeteriaRes;
import com.hsk.cafeteria.dto.res.MainRes;
import com.hsk.cafeteria.dto.res.MenuRes;
import com.hsk.cafeteria.entity.enums.CafeteriaType;
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
    public MainRes getData(LocalDate date) {

        List<CafeteriaRes> getCafeteriaInfo = cafeteriaService.getAllCafeterias();
        List<MenuRes> getStduentMenu = menuService.getStudentCateria(CafeteriaType.STUDENT);
        List<MenuRes> getStaffMenu = menuService.getCafeteriaTypeAndDate(CafeteriaType.STAFF, date);
        List<MenuRes> getHappyDormMenu = menuService.getCafeteriaTypeAndDate(CafeteriaType.HAPPY_DORM, date);
        List<MenuRes> getHoseoDormMenu = menuService.getCafeteriaTypeAndDate(CafeteriaType.HOSEO_DORM, date);

        return MainRes.builder()
                .cafeteria(getCafeteriaInfo)
                .student(getStduentMenu)
                .staff(getStaffMenu)
                .happyDorm(getHappyDormMenu)
                .hoseoDorm(getHoseoDormMenu)
                .build();
    }
}
