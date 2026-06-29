package com.neelbundela.job_portal_api.service.implementation;

import com.neelbundela.job_portal_api.entity.*;
import com.neelbundela.job_portal_api.repository.ApplicationRepository;
import com.neelbundela.job_portal_api.repository.CompanyRepository;
import com.neelbundela.job_portal_api.repository.JobRepository;
import com.neelbundela.job_portal_api.repository.UserRepository;
import com.neelbundela.job_portal_api.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    @Override
    public Application applyJob(Long jobId, String email) {
        User candidate = userRepository.findByEmail(email).orElseThrow();

        Job job = jobRepository.findById(jobId).orElseThrow();

        if(applicationRepository.findByCandidateAndJob(candidate,job).isPresent()){
            throw new RuntimeException("Already Applied");
        }
        Application application=Application.builder()
                .candidate(candidate)
                .job(job)
                .appliedDate(LocalDateTime.now())
                .status(ApplicationStatus.APPLIED)
                .build();
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getMyApplications(String email) {
        User candidate = userRepository.findByEmail(email).orElseThrow();
        return applicationRepository.findByCandidate(candidate);
    }

    @Override
    public List<Application> getApplicants(Long jobId, String recruiterEmail) {

        User recruiter = userRepository.findByEmail(recruiterEmail).orElseThrow();

        Company company = companyRepository.findByRecruiter(recruiter).orElseThrow();

        Job job = jobRepository.findById(jobId).orElseThrow();

        if(!job.getCompany().getId().equals(company.getId())){
            throw new RuntimeException("Unauthorized");
        }
        return applicationRepository.findByJob(job);
    }

    @Override
    public Application updateStatus(Long applicationId, String recruiterEmail, String status) {

        Application application=applicationRepository.findById(applicationId).orElseThrow();

        User recruiter = userRepository.findByEmail(recruiterEmail).orElseThrow();

        Company company=companyRepository.findByRecruiter(recruiter).orElseThrow();

        if(!application.getJob().getCompany().getId().equals(company.getId())){
            throw new RuntimeException("Unauthorized");
        }

        application.setStatus(ApplicationStatus.valueOf(status));
        return applicationRepository.save(application);
    }
}
