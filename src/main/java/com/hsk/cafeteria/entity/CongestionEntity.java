package com.hsk.cafeteria.entity;

import com.hsk.cafeteria.entity.common.BaseTimeEntity;
import com.hsk.cafeteria.entity.enums.CongestionLevel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "congestion_data", indexes = {
    @Index(name = "idx_cafeteria_created_at", columnList = "cafeteria_id, created_at")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CongestionEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafeteria_id", nullable = false)
    private CafeteriaEntity cafeteria;

    @Enumerated(EnumType.STRING)
    @Column(name = "congestion_level", nullable = false)
    private CongestionLevel congestionLevel;

    @Column(name = "people_count")
    private Integer peopleCount;

}
