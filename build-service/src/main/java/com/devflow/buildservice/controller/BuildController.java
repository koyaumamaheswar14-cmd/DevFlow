package com.devflow.buildservice.controller;

import com.devflow.buildservice.entity.BuildEntity;
import com.devflow.buildservice.service.BuildService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/builds")
@RequiredArgsConstructor
public class BuildController {

    private final BuildService buildService;

    @PostMapping("/start/{repoId}")
    public BuildEntity startBuild(@PathVariable Long repoId) {
        return buildService.startBuild(repoId);
    }

    @GetMapping("/{buildId}")
    public BuildEntity getBuild(@PathVariable Long buildId) {
        return buildService.getBuild(buildId);
    }

    @GetMapping("/history/{repoId}")
    public List<BuildEntity> getHistory(@PathVariable Long repoId) {
        return buildService.getBuildHistory(repoId);
    }
    @GetMapping("/test")
    public String test() {
        return "Build Service Working";
    }
}