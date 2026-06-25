package com.devflow.buildservice.repository;

import com.devflow.buildservice.entity.BuildEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface BuildRepository extends JpaRepository<BuildEntity, Long> {
    List<BuildEntity> findByRepoId(Long repoId);
}