package com.neelbundela.job_portal_api.controller;

import com.neelbundela.job_portal_api.dto.ApplicationRequest;
import com.neelbundela.job_portal_api.entity.Application;
import com.neelbundela.job_portal_api.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping("/apply/{jobId}")
    public Application applyJob(@PathVariable Long jobId, Authentication authentication){
        return applicationService.applyJob(
                jobId,authentication.getName()
        );
    }

    @GetMapping("/my")
    public List<Application> myApplications(Authentication authentication){
        return applicationService.getMyApplications(authentication.getName());
    }

    @GetMapping("/job/{jobId}")
    public List<Application> applicants(@PathVariable Long jobId,Authentication authentication){
        return applicationService.getApplicants(jobId,authentication.getName());
    }

    @PutMapping("/{applicationId}/status")
    public Application updateStatus(@PathVariable Long applicationId,
                                    @RequestBody ApplicationRequest request,
                                    Authentication authentication){
        return applicationService.updateStatus(applicationId,authentication.getName(),request.getStatus().name());
    }
}
