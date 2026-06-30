package com.neelbundela.job_portal_api.dto;

import lombok.Data;

@Data
public class CandidateProfileRequest {
    private String phone;

    private String skills;

    private String experience;

    private String education;

    private Boolean active;
}
