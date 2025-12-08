package com.hsk.cafeteria.entity;

import com.hsk.cafeteria.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "notice_data")
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notice_title", nullable = false)
    private String noticeTitle;

    @Column(name = "notice_content", nullable = false)
    private String noticeContent;
}