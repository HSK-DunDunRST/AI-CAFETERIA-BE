package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.res.MainRes;

import java.time.LocalDate;

public interface MainService {

    MainRes getAllData(LocalDate date);

}
