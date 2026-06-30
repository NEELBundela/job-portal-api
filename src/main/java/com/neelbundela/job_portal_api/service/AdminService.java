package com.neelbundela.job_portal_api.service;

import com.neelbundela.job_portal_api.dto.DashboardResponse;
import com.neelbundela.job_portal_api.entity.Job;
import com.neelbundela.job_portal_api.entity.User;

import java.util.List;

public interface AdminService {

    DashboardResponse getDashboard();

    List<User> getAllUsers();

    User updateUserStatus(
            Long userId,
            boolean active
    );

    List<Job> getAllJobs();

    void deleteJob(Long jobId);
}
