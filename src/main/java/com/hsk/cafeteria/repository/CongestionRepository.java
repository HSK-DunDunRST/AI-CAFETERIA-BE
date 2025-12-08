package com.hsk.cafeteria.repository;

import com.hsk.cafeteria.entity.CongestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CongestionRepository extends JpaRepository<CongestionEntity, Long> {

    @Query("SELECT c FROM CongestionEntity c WHERE c.id IN " +
           "(SELECT MAX(c2.id) FROM CongestionEntity c2 GROUP BY c2.cafeteria.id) " +
           "ORDER BY c.cafeteria.type, c.cafeteria.name")
    List<CongestionEntity> findLatestForAllCafeterias();

    Optional<CongestionEntity> findFirstByCafeteriaIdOrderByCreatedAtDesc(Long cafeteriaId);

    List<CongestionEntity> findByCafeteriaIdOrderByCreatedAtDesc(Long cafeteriaId);
}
