package com.neelbundela.job_portal_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 3000)
    private String description;

    private String location;

    private Double salary;

    private Integer experienceRequired;

    private String jobType;

    private LocalDateTime postedDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
