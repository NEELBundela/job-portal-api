package com.neelbundela.job_portal_api.service.implementation;

import com.neelbundela.job_portal_api.dto.DashboardResponse;
import com.neelbundela.job_portal_api.entity.Job;
import com.neelbundela.job_portal_api.entity.Role;
import com.neelbundela.job_portal_api.entity.User;
import com.neelbundela.job_portal_api.exception.ResourceNotFoundException;
import com.neelbundela.job_portal_api.repository.ApplicationRepository;
import com.neelbundela.job_portal_api.repository.JobRepository;
import com.neelbundela.job_portal_api.repository.UserRepository;
import com.neelbundela.job_portal_api.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    public DashboardResponse getDashboard() {
        return DashboardResponse.builder()
                .totalUsers(userRepository.count())
                .totalRecruiters(
                        userRepository.findAll()
                                .stream()
                                .filter(u ->
                                        u.getRole()== Role.RECRUITER)
                                .count()
                )
                .totalCandidates(
                        userRepository.findAll()
                                .stream()
                                .filter(
                                        u ->
                                                u.getRole()==Role.CANDIDATE
                                )
                                .count()
                )
                .totalJobs(jobRepository.count())
                .totalApplications(
                        applicationRepository.count()
                ).build();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserStatus(Long userId, Boolean active) {

        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("UserNot Found"));

        user.setIs_active(active);
        return userRepository.save(user);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void deleteJob(Long jobId) {
            if(!jobRepository.existsById(jobId)){
                throw new ResourceNotFoundException("Job not found");
            }
            jobRepository.deleteById(jobId);
    }
}
