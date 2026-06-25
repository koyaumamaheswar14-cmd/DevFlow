package com.devflow.reposervice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "repositories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepositoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String repoName;
    private String githubUrl;
    private String owner;
    private String description;
    private String language;
    private Integer stars;
    private Integer forks;
}