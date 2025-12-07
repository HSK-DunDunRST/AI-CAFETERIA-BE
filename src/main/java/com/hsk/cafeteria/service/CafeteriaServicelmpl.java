package com.hsk.cafeteria.service;

import com.hsk.cafeteria.converter.CafeteriaConverter;
import com.hsk.cafeteria.dto.res.CafeteriaResponse;
import com.hsk.cafeteria.entity.CafeteriaEntity;
import com.hsk.cafeteria.repository.CafeteriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CafeteriaServicelmpl implements CafeteriaService {
    
    private final CafeteriaRepository cafeteriaRepository;
    
    public List<CafeteriaResponse> getAllCafeterias() {
        return cafeteriaRepository.findAllByOrderByTypeAscNameAsc()
                .stream()
                .map(CafeteriaConverter::from)
                .collect(Collectors.toList());
    }
    
    public CafeteriaResponse getCafeteriaById(Long id) {
        CafeteriaEntity cafeteriaEntity = cafeteriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cafeteria not found with id: " + id));
        return CafeteriaConverter.from(cafeteriaEntity);
    }
}
