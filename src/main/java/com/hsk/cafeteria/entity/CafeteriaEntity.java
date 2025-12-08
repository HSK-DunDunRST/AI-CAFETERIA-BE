package com.hsk.cafeteria.entity;

import com.hsk.cafeteria.entity.common.BaseTimeEntity;
import com.hsk.cafeteria.entity.enums.CafeteriaType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cafeteria_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CafeteriaEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CafeteriaType type;

    @Column(name = "opening_hours", nullable = false)
    private String openingHours;

    @OneToMany(mappedBy = "cafeteria", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<MenuEntity> menuEntities = new ArrayList<>();

    @OneToMany(mappedBy = "cafeteria", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<CongestionEntity> congestions = new ArrayList<>();

}
