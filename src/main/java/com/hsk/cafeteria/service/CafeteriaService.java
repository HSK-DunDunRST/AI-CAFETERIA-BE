package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.res.CafeteriaRes;

import java.util.List;

public interface CafeteriaService {
    List<CafeteriaRes> getAllCafeterias();
    CafeteriaRes getCafeteriaById(Long id);
}
