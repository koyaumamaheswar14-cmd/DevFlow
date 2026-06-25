package com.devflow.reposervice.controller;

import com.devflow.reposervice.dto.RepoRequest;
import com.devflow.reposervice.dto.RepoResponse;
import com.devflow.reposervice.service.RepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repos")
@RequiredArgsConstructor
public class RepoController {

    private final RepoService repoService;

    @PostMapping
    public RepoResponse createRepo(@RequestBody RepoRequest request) {
        return repoService.createRepo(request);
    }
    @GetMapping
    public List<RepoResponse> getAllRepos() {
        return repoService.getAllRepos();
    }
    @GetMapping("/{id}")
    public RepoResponse getRepoById(@PathVariable Long id) {
        return repoService.getRepoById(id);
    }
    @PutMapping("/{id}")
    public RepoResponse updateRepo(
            @PathVariable Long id,
            @RequestBody RepoRequest request) {

        return repoService.updateRepo(id, request);
    }
    @DeleteMapping("/{id}")
    public String deleteRepo(@PathVariable Long id) {

        repoService.deleteRepo(id);

        return "Repository deleted successfully";
    }
}