package com.neelbundela.job_portal_api.repository;

import com.neelbundela.job_portal_api.entity.Company;
import com.neelbundela.job_portal_api.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {

    List<Job> findByCompany(Company company);

    List<Job> findByTitleContainingIgnoreCase(String keyword);
}
