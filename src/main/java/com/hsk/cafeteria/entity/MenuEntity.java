package com.hsk.cafeteria.entity;

import com.hsk.cafeteria.entity.common.BaseTimeEntity;
import com.hsk.cafeteria.entity.enums.CafeteriaType;
import com.hsk.cafeteria.entity.enums.MealType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "menu_data", indexes = {
    @Index(name = "idx_cafeteria_date", columnList = "cafeteria_id, menu_date")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafeteria_id", nullable = false)
    private CafeteriaEntity cafeteria;

    @Enumerated(EnumType.STRING)
    @Column(name = "meal_type", nullable = false)
    private MealType mealType;

    @Enumerated(EnumType.STRING)
    @Column(name = "cafeteria_type", nullable = false)
    private CafeteriaType cafeteriaType;

    @Column(name = "menu_date")
    private LocalDate menuDate;

    @Column(name = "menu_dish", columnDefinition = "TEXT", nullable = false)
    private String menuDish;

    @Column(name = "menu_price")
    private Integer menuPrice;  // 학식당 & 교직원식당만 사용

}
