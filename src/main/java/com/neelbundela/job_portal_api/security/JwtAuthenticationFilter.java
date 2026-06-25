package com.neelbundela.job_portal_api.security;

import com.neelbundela.job_portal_api.service.implementation.CustomUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailService userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final  String authHeader =
                request.getHeader("Authorization");

        //check header exists
        if(authHeader == null ||
        !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        String jwt = authHeader.substring(7);
        String email = jwtService.extractEmail(jwt);

        //check USer Not Already Authenticated
        if(email != null &&
                SecurityContextHolder.getContext()
                        .getAuthentication()==null){

            UserDetails userDetails = userDetailService.loadUserByUsername(email);

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(userDetails,
                            null,userDetails.getAuthorities()
                    );

            //add request details
            authToken.setDetails(
                    new WebAuthenticationDetailsSource()
                            .buildDetails(request)
            );

            //Store Authentication
            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authToken);
        }
        filterChain.doFilter(request,response);
    }
}
