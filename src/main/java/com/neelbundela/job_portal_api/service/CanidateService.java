package com.neelbundela.job_portal_api.service;

import com.neelbundela.job_portal_api.dto.CandidateProfileRequest;
import com.neelbundela.job_portal_api.entity.CandidateProfile;

public interface CanidateService {

    CandidateProfile createProfile(String email, CandidateProfileRequest candidateProfileRequest);

    CandidateProfile getProfile(String email);

    CandidateProfile UpdateProfile(String email, CandidateProfileRequest candidateProfileRequest);


}
