package com.neelbundela.job_portal_api.service;

import com.neelbundela.job_portal_api.dto.JobRequest;
import com.neelbundela.job_portal_api.entity.Job;

import java.util.List;

public interface JobService {

    Job createJob( String email, JobRequest request);

    Job updateJob(Long JobId,String email,JobRequest request);

    void deleteJob(Long jobId,String email);

    List<Job> getRecruiterJobs(String email);

    List<Job> getAllJobs();

    Job getJobById(Long jobsId);

    List<Job> findByTitleContainingIgnoreCase(String Keyword);
}
