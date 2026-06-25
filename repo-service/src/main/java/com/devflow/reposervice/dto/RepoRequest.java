package com.devflow.reposervice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepoRequest {

    private String repoName;

    private String githubUrl;

    private String owner;

    private String description;
}