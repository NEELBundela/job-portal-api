package com.neelbundela.job_portal_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String website;

    @Column(length = 2000)
    private String description;

    private String location;

    @OneToOne
    @JoinColumn(name="recruiter_id",unique = true)
    private User recruiter;
}
