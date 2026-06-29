package com.neelbundela.job_portal_api.controller;

import com.neelbundela.job_portal_api.dto.CompanyRequest;
import com.neelbundela.job_portal_api.entity.Company;
import com.neelbundela.job_portal_api.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/recruiter")
public class RecruiterController {

    private final RecruiterService recruiterService;

    @PostMapping("/company")
    public Company createCompany(Authentication authentication, @RequestBody CompanyRequest companyRequest) {
        String email=authentication.getName();
        return recruiterService.createCompany(email, companyRequest);
    }

    @GetMapping("/company")
    public Company getCompany(Authentication authentication) {
        return recruiterService.getCompany(authentication.getName());
    }

    @PutMapping("/company")
    public Company updateCompany(Authentication authentication, @RequestBody CompanyRequest companyRequest) {
        return recruiterService.updateCompany(authentication.getName(), companyRequest);
    }
}