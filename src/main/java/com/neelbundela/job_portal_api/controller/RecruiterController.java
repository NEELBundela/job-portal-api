package com.neelbundela.job_portal_api.controller;

import com.neelbundela.job_portal_api.dto.CompanyRequest;
import com.neelbundela.job_portal_api.entity.Company;
import com.neelbundela.job_portal_api.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/recruiter")
public class RecruiterController {

    private final RecruiterService recruiterService;

    @PostMapping("/company")
    public Company createCompany(String email, @RequestBody CompanyRequest companyRequest) {
        return recruiterService.createCompany(email, companyRequest);
    }

    @GetMapping("/company")
    public Company getCompany(String email) {
        return recruiterService.getCompany(email);
    }

    @PutMapping("/company")
    public Company updateCompany(String email, @RequestBody CompanyRequest companyRequest) {
        return recruiterService.updateCompany(email, companyRequest);
    }
}