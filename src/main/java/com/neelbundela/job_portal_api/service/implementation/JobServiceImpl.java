package com.neelbundela.job_portal_api.service.implementation;


import com.neelbundela.job_portal_api.dto.JobRequest;
import com.neelbundela.job_portal_api.entity.Company;
import com.neelbundela.job_portal_api.entity.Job;
import com.neelbundela.job_portal_api.entity.User;
import com.neelbundela.job_portal_api.repository.CompanyRepository;
import com.neelbundela.job_portal_api.repository.JobRepository;
import com.neelbundela.job_portal_api.repository.UserRepository;
import com.neelbundela.job_portal_api.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    @Override
    public Job createJob( String email, JobRequest request) {

        User recruiter = userRepository.findByEmail(email).orElseThrow();

        Company company = companyRepository.findByRecruiter(recruiter)
                .orElseThrow(()-> new RuntimeException("Create Company first"));

        Job job = Job.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .location(request.getLocation())
                .salary(request.getSalary())
                .experienceRequired(request.getExperienceRequired())
                .jobType(request.getJobType())
                .postedDate(LocalDateTime.now())
                .company(company)
                .build();
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long jobId, String email, JobRequest request) {
        Job job = jobRepository.findById(jobId).orElseThrow();

        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setSalary(request.getSalary());
        job.setExperienceRequired(request.getExperienceRequired());
        job.setJobType(request.getJobType());

        return jobRepository.save(job);
    }

    @Override
    public void deleteJob(Long jobId, String email) {

        jobRepository.deleteById(jobId);
    }

    @Override
    public List<Job> getRecruiterJobs(String email) {

        User recruiter = userRepository.findByEmail(email).orElseThrow();

        Company company = companyRepository.findByRecruiter(recruiter).orElseThrow();
        return jobRepository.findByCompany(company);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long jobsId) {
        return jobRepository.findById(jobsId).orElseThrow();
    }

    @Override
    public List<Job> findByTitleContainingIgnoreCase(String Keyword) {
        return jobRepository.findByTitleContainingIgnoreCase(Keyword);
    }
}
