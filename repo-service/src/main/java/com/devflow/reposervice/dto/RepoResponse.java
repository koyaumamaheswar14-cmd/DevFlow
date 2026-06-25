package com.devflow.reposervice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepoResponse {

    private Long id;

    private String repoName;

    private String githubUrl;

    private String owner;

    private String description;

    private String language;

    private Integer stars;

    private Integer forks;
}