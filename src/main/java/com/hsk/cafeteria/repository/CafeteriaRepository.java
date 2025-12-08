package com.hsk.cafeteria.repository;

import com.hsk.cafeteria.entity.CafeteriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeteriaRepository extends JpaRepository<CafeteriaEntity, Long> {

    List<CafeteriaEntity> findAllByOrderByIdAsc();
}
