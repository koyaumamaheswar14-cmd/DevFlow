package com.devflow.deployservice.repository;

import com.devflow.deployservice.entity.DeploymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeploymentRepository
        extends JpaRepository<DeploymentEntity, Long> {

    List<DeploymentEntity> findByBuildId(Long buildId);
}