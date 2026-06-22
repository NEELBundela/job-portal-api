package com.neelbundela.job_portal_api.dto;

import com.neelbundela.job_portal_api.entity.Role;
import lombok.Data;

@Data
public class RegistrationRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
