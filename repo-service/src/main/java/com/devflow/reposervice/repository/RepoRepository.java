package com.devflow.reposervice.repository;

import com.devflow.reposervice.entity.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRepository
        extends JpaRepository<RepositoryEntity, Long> {
}