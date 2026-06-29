package com.neelbundela.job_portal_api.service.implementation;

import com.neelbundela.job_portal_api.dto.CompanyRequest;
import com.neelbundela.job_portal_api.entity.Company;
import com.neelbundela.job_portal_api.entity.User;
import com.neelbundela.job_portal_api.repository.CompanyRepository;
import com.neelbundela.job_portal_api.repository.UserRepository;
import com.neelbundela.job_portal_api.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruiterServiceImpl implements RecruiterService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    @Override
    public Company createCompany(String email, CompanyRequest companyRequest) {
        User recruiter=userRepository.findByEmail(email).orElseThrow();

        if(companyRepository.findByRecruiter(recruiter).isPresent()){
            throw  new RuntimeException("Company already Exists");

        }
        Company company = Company.builder()
                .companyName(companyRequest.getCompanyName())
                .website(companyRequest.getWebsite())
                .description(companyRequest.getDescription())
                .location(companyRequest.getLocation())
                .recruiter(recruiter)
                .build();

        return companyRepository.save(company);
    }

    @Override
    public Company getCompany(String email) {
        User recruiter=userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Recruiter Doesn't Exists"));
        return companyRepository.findByRecruiter(recruiter).orElseThrow(()->
                new RuntimeException("Company Doesn't Exists!!"));
    }

    @Override
    public Company updateCompany(String email, CompanyRequest companyRequest) {
        User recruiter=userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Recruiter Doesn't Exists"));
        Company company = companyRepository.findByRecruiter(recruiter).orElseThrow(()->
                new RuntimeException("Company Doesn't Exists!!"));

        company.setCompanyName(companyRequest.getCompanyName());
        company.setWebsite(companyRequest.getWebsite());
        company.setDescription(companyRequest.getDescription());
        company.setLocation(companyRequest.getLocation());
        return companyRepository.save(company);
    }
}
