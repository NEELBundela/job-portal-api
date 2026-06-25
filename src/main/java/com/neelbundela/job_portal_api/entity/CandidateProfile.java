package com.neelbundela.job_portal_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String phone;

    private String skills;

    private String experience;

    private String education;

    private String resumeurl;

    @OneToOne
    @JoinColumn(name="User_id",unique = true)
    private User user;

}
