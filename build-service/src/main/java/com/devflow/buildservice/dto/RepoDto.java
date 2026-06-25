package com.devflow.buildservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepoDto {

    private Long id;
    private String repoName;
    private String repoUrl;
    private String branch;
}