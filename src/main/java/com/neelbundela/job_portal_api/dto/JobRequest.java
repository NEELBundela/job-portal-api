package com.neelbundela.job_portal_api.dto;

import lombok.Data;

@Data
public class JobRequest {

    private String title;
    private String description;
    private String location;
    private Double salary;
    private Integer experienceRequired;
    private String jobType;
}
