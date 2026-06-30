package com.neelbundela.job_portal_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/jobs")
    public String jobs() {
        return "jobs";
    }

    @GetMapping("/job-details")
    public String jobDetails() {
        return "job-details";
    }

    @GetMapping("/candidate/dashboard")
    public String candidateDashboard() {
        return "candidate/dashboard";
    }

    @GetMapping("/candidate/profile")
    public String profile() {
        return "candidate/profile";
    }

    @GetMapping("/candidate/applications")
    public String applications() {
        return "candidate/applications";
    }

    @GetMapping("/candidate/search-jobs")
    public String searchJobs() {
        return "candidate/search-jobs";
    }

    @GetMapping("/recruiter/dashboard")
    public String recruiterDashboard() {
        return "recruiter/dashboard";
    }

    @GetMapping("/recruiter/company")
    public String company() {
        return "recruiter/company";
    }

    @GetMapping("/recruiter/jobs")
    public String recruiterJobs() {
        return "recruiter/jobs";
    }

    @GetMapping("/recruiter/post-job")
    public String postJob() {
        return "recruiter/post-job";
    }

    @GetMapping("/recruiter/applicants")
    public String applicants() {
        return "recruiter/applicants";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/admin/users")
    public String users() {
        return "admin/users";
    }

    @GetMapping("/admin/jobs")
    public String adminJobs() {
        return "admin/jobs";
    }
}
