package com.neelbundela.job_portal_api.controller;

import com.neelbundela.job_portal_api.dto.CandidateProfileRequest;
import com.neelbundela.job_portal_api.entity.CandidateProfile;
import com.neelbundela.job_portal_api.service.CanidateService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final CanidateService canidateService;

    @PostMapping("/profile")
    public CandidateProfile createProfile(Authentication authentication,
                                          @RequestBody CandidateProfileRequest request){
        return canidateService.createProfile(authentication.getName(),request);
    }

    @GetMapping("/profile")
    public CandidateProfile getProfile(Authentication authentication){
        return canidateService.getProfile(authentication.getName());
    }

    @PutMapping("/profile")
    public CandidateProfile updateProfile(Authentication authentication,
                                          @RequestBody CandidateProfileRequest request){
        return canidateService.UpdateProfile(authentication.getName(),request);
    }
}
