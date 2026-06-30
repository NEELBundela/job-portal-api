package com.neelbundela.job_portal_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private long totalUsers;
    private long totalRecruiters;
    private long totalCandidates;
    private long totalJobs;
    private long totalApplications;
}
