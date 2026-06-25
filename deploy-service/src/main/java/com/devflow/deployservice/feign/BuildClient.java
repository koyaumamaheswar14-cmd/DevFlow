package com.devflow.deployservice.feign;

import com.devflow.deployservice.dto.BuildDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "build-service",
        url = "http://localhost:8083"
)
public interface BuildClient {

    @GetMapping("/api/builds/{id}")
    BuildDto getBuild(@PathVariable Long id);
}