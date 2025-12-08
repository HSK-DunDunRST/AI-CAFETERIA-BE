package com.hsk.cafeteria.service;

import com.hsk.cafeteria.dto.req.CongestionReq;
import com.hsk.cafeteria.dto.res.CongestionRes;

import java.util.List;

public interface CongestionService {
    List<CongestionRes> getLatestCongestions();
    CongestionRes getLatestCongestionByCafeteria(Long cafeteriaId);
    CongestionRes updateCongestion(Long cafeteriaId, CongestionReq request);

}
