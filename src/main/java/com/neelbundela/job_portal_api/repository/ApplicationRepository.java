package com.neelbundela.job_portal_api.repository;

import com.neelbundela.job_portal_api.entity.Application;
import com.neelbundela.job_portal_api.entity.Job;
import com.neelbundela.job_portal_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application,Long> {

    List<Application> findByCandidate(User candidate);

    List<Application> findByJob(Job job);

    Optional<Application> findByCandidateAndJob(User candidate,Job job);
}
