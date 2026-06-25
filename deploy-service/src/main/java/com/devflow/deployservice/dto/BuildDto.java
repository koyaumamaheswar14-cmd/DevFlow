package com.devflow.deployservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildDto {

    private Long id;
    private Long repoId;
    private String status;
    private String logs;
}