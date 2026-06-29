package com.neelbundela.job_portal_api.dto;

import com.neelbundela.job_portal_api.entity.ApplicationStatus;
import lombok.Data;

@Data
public class ApplicationRequest {

    private ApplicationStatus status;
}
