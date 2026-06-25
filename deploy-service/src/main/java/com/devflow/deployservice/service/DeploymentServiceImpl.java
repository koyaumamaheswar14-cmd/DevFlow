package com.devflow.deployservice.service;

import com.devflow.deployservice.dto.BuildDto;
import com.devflow.deployservice.entity.DeploymentEntity;
import com.devflow.deployservice.entity.DeploymentStatus;
import com.devflow.deployservice.feign.BuildClient;
import com.devflow.deployservice.repository.DeploymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeploymentServiceImpl implements DeploymentService {

    private final DeploymentRepository deploymentRepository;
    private final BuildClient buildClient;

    @Override
    public DeploymentEntity deploy(Long buildId) {

        BuildDto build = buildClient.getBuild(buildId);

        DeploymentEntity deployment = DeploymentEntity.builder()
                .buildId(build.getId())
                .deploymentUrl("https://devflow-app-" + buildId + ".com")
                .status(DeploymentStatus.DEPLOYED)
                .deployedAt(LocalDateTime.now())
                .build();

        return deploymentRepository.save(deployment);
    }

    @Override
    public DeploymentEntity getDeployment(Long deploymentId) {

        return deploymentRepository.findById(deploymentId)
                .orElseThrow(() ->
                        new RuntimeException("Deployment not found"));
    }

    @Override
    public List<DeploymentEntity> getDeploymentHistory(Long buildId) {

        return deploymentRepository.findByBuildId(buildId);
    }
}