package com.hsk.cafeteria.repository;

import com.hsk.cafeteria.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    
    List<MenuEntity> findByCafeteriaIdAndMenuDateOrderByMealType(Long cafeteriaId, LocalDate menuDate);
    
    List<MenuEntity> findByMenuDateOrderByCafeteriaIdAscMealTypeAsc(LocalDate menuDate);
    
    @Query("SELECT menuEntity FROM MenuEntity menuEntity JOIN FETCH menuEntity.cafeteria WHERE menuEntity.menuDate = :date ORDER BY menuEntity.cafeteriaType, menuEntity.cafeteria.name, menuEntity.mealType")
    List<MenuEntity> findAllByDateWithCafeteria(@Param("date") LocalDate date);
    
    List<MenuEntity> findByCafeteriaIdOrderByMenuDateDescMealTypeAsc(Long cafeteriaId);
}
