package com.neelbundela.job_portal_api.dto;

import lombok.Data;

@Data
public class CompanyRequest {
    private String companyName;
    private String website;
    private String description;
    private String location;
}
