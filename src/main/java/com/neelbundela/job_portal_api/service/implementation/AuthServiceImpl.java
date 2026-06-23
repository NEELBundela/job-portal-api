package com.neelbundela.job_portal_api.service.implementation;

import com.neelbundela.job_portal_api.dto.LoginRequest;
import com.neelbundela.job_portal_api.dto.LoginResponse;
import com.neelbundela.job_portal_api.dto.RegistrationRequest;
import com.neelbundela.job_portal_api.entity.User;
import com.neelbundela.job_portal_api.repository.UserRepository;
import com.neelbundela.job_portal_api.security.JwtService;
import com.neelbundela.job_portal_api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public String register(RegistrationRequest registrationRequest) {

        if(userRepository.findByEmail(registrationRequest.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .name(registrationRequest.getName())
                .email(registrationRequest.getEmail())
                .password(
                        passwordEncoder.encode(
                                registrationRequest.getPassword()
                        )
                )
                .role(registrationRequest.getRole())
                .build();

        userRepository.save(user);
        return "User Registered Successfully";
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()-> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid Credentials");
        }

        String token=jwtService.generateToken(user);

        return new LoginResponse(token,"Login successful");
    }
}
