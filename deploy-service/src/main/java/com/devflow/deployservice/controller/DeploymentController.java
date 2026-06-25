package com.devflow.deployservice.controller;

import com.devflow.deployservice.entity.DeploymentEntity;
import com.devflow.deployservice.service.DeploymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deployments")
@RequiredArgsConstructor
public class DeploymentController {

    private final DeploymentService deploymentService;

    @PostMapping("/deploy/{buildId}")
    public DeploymentEntity deploy(
            @PathVariable Long buildId) {

        return deploymentService.deploy(buildId);
    }

    @GetMapping("/{deploymentId}")
    public DeploymentEntity getDeployment(
            @PathVariable Long deploymentId) {

        return deploymentService.getDeployment(deploymentId);
    }

    @GetMapping("/history/{buildId}")
    public List<DeploymentEntity> getHistory(
            @PathVariable Long buildId) {

        return deploymentService.getDeploymentHistory(buildId);
    }
}