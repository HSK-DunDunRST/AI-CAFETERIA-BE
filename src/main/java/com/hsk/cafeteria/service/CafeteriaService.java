package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.res.CafeteriaResponse;

import java.util.List;

public interface CafeteriaService {
    List<CafeteriaResponse> getAllCafeterias();
    CafeteriaResponse getCafeteriaById(Long id);
}
