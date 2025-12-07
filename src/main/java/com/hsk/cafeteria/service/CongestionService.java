package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.req.CongestionRequest;
import com.hsk.cafeteria.dto.res.CongestionResponse;

import java.util.List;

public interface CongestionService {
    List<CongestionResponse> getLatestCongestions();
    CongestionResponse getLatestCongestionByCafeteria(Long cafeteriaId);
    CongestionResponse updateCongestion(Long cafeteriaId, CongestionRequest request);

}
