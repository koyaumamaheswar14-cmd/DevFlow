package com.devflow.deployservice.service;

import com.devflow.deployservice.entity.DeploymentEntity;

import java.util.List;

public interface DeploymentService {

    DeploymentEntity deploy(Long buildId);

    DeploymentEntity getDeployment(Long deploymentId);

    List<DeploymentEntity> getDeploymentHistory(Long buildId);
}