package com.neelbundela.job_portal_api.controller;


import com.neelbundela.job_portal_api.dto.JobRequest;
import com.neelbundela.job_portal_api.entity.Job;
import com.neelbundela.job_portal_api.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public Job createJob(Authentication authentication, @RequestBody JobRequest request){
        return jobService.createJob(authentication.getName(),request);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id,Authentication authentication,@RequestBody JobRequest request){
        return jobService.updateJob(id,authentication.getName(),request);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id,Authentication authentication){
        jobService.deleteJob(id,authentication.getName());

        return "job deleted successfully";
    }

    @GetMapping
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    @GetMapping("/search")
    public List<Job> searchJobs(@RequestParam String keyword){
        return jobService.findByTitleContainingIgnoreCase(keyword);
    }

    @GetMapping("/recruiter")
    public List<Job> getRecruiterJobs(Authentication authentication){
        return jobService.getRecruiterJobs(authentication.getName());
    }
}
