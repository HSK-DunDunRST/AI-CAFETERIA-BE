package com.hsk.cafeteria.service;

import com.hsk.cafeteria.apiPayload.code.exception.BaseException;
import com.hsk.cafeteria.apiPayload.code.status.ErrorType;
import com.hsk.cafeteria.converter.CafeteriaConverter;
import com.hsk.cafeteria.dto.res.CafeteriaRes;
import com.hsk.cafeteria.entity.CafeteriaEntity;
import com.hsk.cafeteria.repository.CafeteriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CafeteriaServicelmpl implements CafeteriaService {
    
    private final CafeteriaRepository cafeteriaRepository;

    public List<CafeteriaRes> getAllCafeterias() {
        return cafeteriaRepository.findAllByOrderByTypeAscNameAsc().stream()
                .map(CafeteriaConverter::from)
                .toList();
    }
    
    public CafeteriaRes getCafeteriaById(Long id) {
        CafeteriaEntity cafeteriaEntity = cafeteriaRepository.findById(id)
                .orElseThrow(() -> new BaseException(ErrorType.NOT_FOUND_CAFETERIA_DATA));
        return CafeteriaConverter.from(cafeteriaEntity);
    }
}
