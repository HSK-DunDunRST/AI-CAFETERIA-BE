package com.hsk.cafeteria.service;

import com.hsk.cafeteria.apiPayload.code.exception.BaseException;
import com.hsk.cafeteria.apiPayload.code.status.ErrorType;
import com.hsk.cafeteria.converter.CongestionConverter;
import com.hsk.cafeteria.dto.req.CongestionReq;
import com.hsk.cafeteria.dto.res.CongestionRes;
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
    
    public List<CongestionRes> getLatestCongestions() {
        return congestionRepository.findLatestForAllCafeterias().stream()
                .map(CongestionConverter::from)
                .toList();
    }
    
    public CongestionRes getLatestCongestionByCafeteria(Long cafeteriaId) {
        CongestionEntity congestionEntity = congestionRepository
                .findFirstByCafeteriaIdOrderByCreatedAtDesc(cafeteriaId)
                .orElseThrow(() -> new BaseException(ErrorType.NOT_FOUND_CONGESTION_DATA));
        return CongestionConverter.from(congestionEntity);
    }
    
    @Transactional
    public CongestionRes updateCongestion(Long cafeteriaId, CongestionReq request) {
        CafeteriaEntity cafeteria = cafeteriaRepository.findById(cafeteriaId)
                .orElseThrow(() -> new BaseException(ErrorType.NOT_FOUND_CAFETERIA_DATA));

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
