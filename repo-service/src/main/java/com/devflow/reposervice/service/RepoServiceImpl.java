package com.devflow.reposervice.service;

import com.devflow.reposervice.dto.RepoRequest;
import com.devflow.reposervice.dto.RepoResponse;
import com.devflow.reposervice.entity.RepositoryEntity;
import com.devflow.reposervice.exception.ResourceNotFoundException;
import com.devflow.reposervice.repository.RepoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepoServiceImpl implements RepoService {

    private final RepoRepository repoRepository;

    @Override
    public RepoResponse createRepo(RepoRequest request) {

        RepositoryEntity repo = RepositoryEntity.builder()
                .repoName(request.getRepoName())
                .githubUrl(request.getGithubUrl())
                .owner(request.getOwner())
                .description(request.getDescription())
                .build();

        RepositoryEntity savedRepo =
                repoRepository.save(repo);

        return RepoResponse.builder()
                .id(savedRepo.getId())
                .repoName(savedRepo.getRepoName())
                .githubUrl(savedRepo.getGithubUrl())
                .owner(savedRepo.getOwner())
                .description(savedRepo.getDescription())
                .language(savedRepo.getLanguage())
                .stars(savedRepo.getStars())
                .forks(savedRepo.getForks())
                .build();
    }

    @Override
    public RepoResponse getRepoById(Long id) {

        RepositoryEntity repo = repoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Repository not found with id: " + id));

        return RepoResponse.builder()
                .id(repo.getId())
                .repoName(repo.getRepoName())
                .githubUrl(repo.getGithubUrl())
                .owner(repo.getOwner())
                .description(repo.getDescription())
                .language(repo.getLanguage())
                .stars(repo.getStars())
                .forks(repo.getForks())
                .build();
    }
    @Override
    public List<RepoResponse> getAllRepos() {

        return repoRepository.findAll()
                .stream()
                .map(repo -> RepoResponse.builder()
                        .id(repo.getId())
                        .repoName(repo.getRepoName())
                        .githubUrl(repo.getGithubUrl())
                        .owner(repo.getOwner())
                        .description(repo.getDescription())
                        .language(repo.getLanguage())
                        .stars(repo.getStars())
                        .forks(repo.getForks())
                        .build())
                .toList();
    }

    @Override
    public RepoResponse updateRepo(Long id, RepoRequest request) {

        RepositoryEntity repo = repoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Repository not found with id: " + id));

        repo.setRepoName(request.getRepoName());
        repo.setGithubUrl(request.getGithubUrl());
        repo.setOwner(request.getOwner());
        repo.setDescription(request.getDescription());

        RepositoryEntity updatedRepo =
                repoRepository.save(repo);

        return RepoResponse.builder()
                .id(updatedRepo.getId())
                .repoName(updatedRepo.getRepoName())
                .githubUrl(updatedRepo.getGithubUrl())
                .owner(updatedRepo.getOwner())
                .description(updatedRepo.getDescription())
                .language(updatedRepo.getLanguage())
                .stars(updatedRepo.getStars())
                .forks(updatedRepo.getForks())
                .build();
    }

    @Override
    public void deleteRepo(Long id) {

        RepositoryEntity repo = repoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Repository not found with id: " + id));

        repoRepository.delete(repo);
    }
}