package com.hsk.cafeteria.repository;

import com.hsk.cafeteria.entity.MenuEntity;
import com.hsk.cafeteria.entity.enums.CafeteriaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

    List<MenuEntity> findByCafeteriaType(CafeteriaType cafeteriaType);

    List<MenuEntity> findByCafeteriaTypeAndMenuDate(CafeteriaType cafeteriaType, LocalDate date);
}
