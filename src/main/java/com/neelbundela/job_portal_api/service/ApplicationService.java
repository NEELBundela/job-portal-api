package com.neelbundela.job_portal_api.service;

import com.neelbundela.job_portal_api.entity.Application;

import java.util.List;

public interface ApplicationService {
    Application applyJob(Long jobId,String email);

    List<Application> getMyApplications(String email);

    List<Application> getApplicants(Long jobId,String recruiterEmail);

    Application updateStatus(Long applicationId,String recruiterEmail,String status);
}
