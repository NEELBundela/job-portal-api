package com.neelbundela.job_portal_api.service;

import com.neelbundela.job_portal_api.dto.RegistrationRequest;

public interface AuthService {
    String register(RegistrationRequest registrationRequest);
}
