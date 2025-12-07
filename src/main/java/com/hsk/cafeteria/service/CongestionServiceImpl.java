package com.hsk.cafeteria.service;

import com.hsk.cafeteria.converter.CongestionConverter;
import com.hsk.cafeteria.dto.req.CongestionRequest;
import com.hsk.cafeteria.dto.res.CongestionResponse;
import com.hsk.cafeteria.entity.CafeteriaEntity;
import com.hsk.cafeteria.entity.CongestionEntity;
import com.hsk.cafeteria.entity.enums.CongestionLevel;
import com.hsk.cafeteria.repository.CafeteriaRepository;
import com.hsk.cafeteria.repository.CongestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CongestionServiceImpl implements CongestionService {
    
    private final CongestionRepository congestionRepository;
    private final CafeteriaRepository cafeteriaRepository;
    
    public List<CongestionResponse> getLatestCongestions() {
        return congestionRepository.findLatestForAllCafeterias()
                .stream()
                .map(CongestionConverter::from)
                .collect(Collectors.toList());
    }
    
    public CongestionResponse getLatestCongestionByCafeteria(Long cafeteriaId) {
        CongestionEntity congestionEntity = congestionRepository
                .findFirstByCafeteriaIdOrderByCreatedAtDesc(cafeteriaId)
                .orElseThrow(() -> new RuntimeException("No congestion data found for cafeteria: " + cafeteriaId));
        return CongestionConverter.from(congestionEntity);
    }
    
    @Transactional
    public CongestionResponse updateCongestion(Long cafeteriaId, CongestionRequest request) {
        CafeteriaEntity cafeteria = cafeteriaRepository.findById(cafeteriaId)
                .orElseThrow(() -> new RuntimeException("Cafeteria not found with id: " + cafeteriaId));

        CongestionLevel level = CongestionLevel.valueOf(
                request.getCongestionLevel().toUpperCase()
        );

        CongestionEntity congestion = CongestionEntity.builder()
                .cafeteria(cafeteria)
                .congestionLevel(level)
                .peopleCount(request.getPeopleCount())
                .build();

        CongestionEntity saved = congestionRepository.save(congestion);
        return CongestionConverter.from(saved);
    }
}
