package com.devflow.buildservice.service;

import com.devflow.buildservice.entity.BuildEntity;

import java.util.List;

public interface BuildService {

    BuildEntity startBuild(Long repoId);

    BuildEntity getBuild(Long buildId);

    List<BuildEntity> getBuildHistory(Long repoId);
}