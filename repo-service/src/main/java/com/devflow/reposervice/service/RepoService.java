package com.devflow.reposervice.service;

import com.devflow.reposervice.dto.RepoRequest;
import com.devflow.reposervice.dto.RepoResponse;

import java.util.List;

public interface RepoService {

    RepoResponse createRepo(RepoRequest request);

    RepoResponse getRepoById(Long id);

    List<RepoResponse> getAllRepos();

    RepoResponse updateRepo(Long id, RepoRequest request);

    void deleteRepo(Long id);
}