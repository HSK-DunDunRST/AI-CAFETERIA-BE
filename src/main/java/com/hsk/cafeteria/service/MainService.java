package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.res.MainRes;
import com.hsk.cafeteria.entity.enums.CafeteriaType;

import java.time.LocalDate;

public interface MainService {

    MainRes getData(LocalDate date);

}
