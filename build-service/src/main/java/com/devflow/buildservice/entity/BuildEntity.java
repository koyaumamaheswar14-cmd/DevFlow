package com.devflow.buildservice.entity;

import com.devflow.buildservice.entity.BuildStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "builds")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long repoId;

    @Enumerated(EnumType.STRING)
    private BuildStatus status;

    @Column(columnDefinition = "TEXT")
    private String logs;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;
}