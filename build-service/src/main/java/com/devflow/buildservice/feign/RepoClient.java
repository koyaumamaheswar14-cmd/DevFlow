package com.devflow.buildservice.feign;

import com.devflow.buildservice.dto.RepoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "repo-service",
        url = "http://localhost:8081"
)
public interface RepoClient {

    @GetMapping("/api/repos/{id}")
    RepoDto getRepo(@PathVariable Long id);
}