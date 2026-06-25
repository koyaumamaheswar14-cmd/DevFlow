package com.devflow.buildservice.dto;

import com.devflow.buildservice.entity.BuildStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuildResponseDto {

    private Long id;
    private Long repoId;
    private BuildStatus status;
    private String logs;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
}