package com.devflow.deployservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "deployments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeploymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long buildId;

    private String deploymentUrl;

    @Enumerated(EnumType.STRING)
    private DeploymentStatus status;

    private LocalDateTime deployedAt;
}