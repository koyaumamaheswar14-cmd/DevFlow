package com.devflow.buildservice.service;

import com.devflow.buildservice.dto.BuildResponseDto;
import com.devflow.buildservice.dto.RepoDto;
import com.devflow.buildservice.entity.BuildEntity;
import com.devflow.buildservice.entity.BuildStatus;
import com.devflow.buildservice.exception.ResourceNotFoundException;
import com.devflow.buildservice.feign.RepoClient;
import com.devflow.buildservice.repository.BuildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildServiceImpl implements BuildService {

    private final BuildRepository buildRepository;
    private final RepoClient repoClient;

    @Override
    public BuildEntity startBuild(Long repoId) {

        RepoDto repo = repoClient.getRepo(repoId);

        BuildEntity build = BuildEntity.builder()
                .repoId(repo.getId())
                .status(BuildStatus.SUCCESS)
                .logs("Build completed for " + repo.getRepoName())
                .startedAt(LocalDateTime.now())
                .completedAt(LocalDateTime.now())
                .build();

        return buildRepository.save(build);
    }

    @Override
    public BuildEntity getBuild(Long buildId) {
        return buildRepository.findById(buildId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Build not found"));
    }

    @Override
    public List<BuildEntity> getBuildHistory(Long repoId) {
        return buildRepository.findByRepoId(repoId);
    }

    private BuildResponseDto map(BuildEntity build) {

        return BuildResponseDto.builder()
                .id(build.getId())
                .repoId(build.getRepoId())
                .status(build.getStatus())
                .logs(build.getLogs())
                .startedAt(build.getStartedAt())
                .completedAt(build.getCompletedAt())
                .build();
    }
}