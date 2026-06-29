package com.neelbundela.job_portal_api.service;

import com.neelbundela.job_portal_api.dto.CompanyRequest;
import com.neelbundela.job_portal_api.entity.Company;

public interface RecruiterService {

    Company createCompany(String email, CompanyRequest  companyRequest);
    Company getCompany(String email);
    Company updateCompany(String email, CompanyRequest  companyRequest);

}
