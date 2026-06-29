package com.neelbundela.job_portal_api.repository;

import com.neelbundela.job_portal_api.entity.Company;
import com.neelbundela.job_portal_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findByRecruiter(User recruiter);
}
