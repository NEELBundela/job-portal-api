package com.neelbundela.job_portal_api.controller;


import com.neelbundela.job_portal_api.dto.DashboardResponse;
import com.neelbundela.job_portal_api.entity.Job;
import com.neelbundela.job_portal_api.entity.User;
import com.neelbundela.job_portal_api.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/dashboard")
    public DashboardResponse dashboard(){
        return adminService.getDashboard();
    }

    @GetMapping("/users")
    public List<User> users() {
        return adminService.getAllUsers();
    }

    @PutMapping("/users/{id}")
    public User updateStatus(
            @PathVariable Long id,
            @RequestBody Boolean active) {

        return adminService
                .updateUserStatus(id, active);
    }
    @GetMapping("/jobs")
    public List<Job> jobs() {
        return adminService.getAllJobs();
    }
    @DeleteMapping("/jobs/{id}")
    public String deleteJob(
            @PathVariable Long id) {

        adminService.deleteJob(id);

        return "Job deleted successfully";
    }
}
